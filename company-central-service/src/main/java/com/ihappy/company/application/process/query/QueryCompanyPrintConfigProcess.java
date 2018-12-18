package com.ihappy.company.application.process.query;

import com.ihappy.common.util.DateUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.enumtype.BillTypeEnum;
import com.ihappy.company.common.enumtype.company.CompanyBarCodePrintSizeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyPrintConfig;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigInfoRespDTO;
import com.ihappy.company.domain.model.factory.BaseinfoCompanyFactory;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:02
 */
public class QueryCompanyPrintConfigProcess extends DefaultQueryProcess<CompanyPrintConfigInfoQueryReqDTO, CompanyPrintConfigInfoRespDTO> {

    @Autowired
    private CompanyPrintConfigService companyPrintConfigService;

    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Override
    public void process(Context<CompanyPrintConfigInfoQueryReqDTO, CompanyPrintConfigInfoRespDTO> context) {
        CompanyPrintConfigInfoQueryReqDTO param = context.getParam();
        BaseinfoCompanyPrintConfig queryParam = new BaseinfoCompanyPrintConfig();
        BeanUtils.copyProperties(param, queryParam);
        if (param.getLoginCompId() != null) {
            queryParam.setCompId(Integer.valueOf(param.getLoginCompId() + ""));
        }
        CompanyPrintConfigModel printConfigModel = companyPrintConfigService.queryPrintConfigInfo(queryParam);

        // 没查到打印配置, 创建一条打印配置
        if (printConfigModel == null || printConfigModel.getDO() == null) {
            BaseinfoCompanyPrintConfig printConfig = new BaseinfoCompanyPrintConfig();
            printConfig.setBillType(param.getBillType());
            printConfig.setBillTypeCode(param.getBillTypeCode());
            printConfig.setCompId(param.getCompId());
            if (param.getLoginCompId() != null) {
                printConfig.setCompId(Integer.valueOf(param.getLoginCompId() + ""));
            }
            printConfig.setConfigId(DistributedPrimaryKeyFactory.generateCompanyPrintConfigId(param.getLoginCompId()));
            printConfig.setBillTypeName(BillTypeEnum.getBillTypeNameByTypeCode(param.getBillType(), param.getBillTypeCode()));
            printConfig.setBillName(BillTypeEnum.getBillTypeNameByTypeCode(param.getBillType(), param.getBillTypeCode()));
            printConfig.setPrintSize(CompanyBarCodePrintSizeEnum.SELF_EMPLOY.getValue());
            printConfig.setCreatedAt(DateUtil.getCurrentDate());
            printConfig.setCreatedPersonId(0l);
            printConfig.setUpdatedAt(DateUtil.getCurrentDate());
            printConfig.setUpdatedPersonId(0l);
            printConfig.setPrintBill(false);
            if ((param.getBillTypeCode().equals(BillTypeEnum.SALE_BILL.getBillTypeCode())
                    && param.getBillType().equals(BillTypeEnum.SALE_BILL.getBillType()))
                    || param.getBillTypeCode().equals(BillTypeEnum.RETAIL_BILL.getBillTypeCode())
                    && param.getBillType().equals(BillTypeEnum.RETAIL_BILL.getBillType())
                    || param.getBillTypeCode().equals(BillTypeEnum.RETAIL_PREORDER_BILL.getBillTypeCode())
                    && param.getBillType().equals(BillTypeEnum.RETAIL_PREORDER_BILL.getBillType())
                    || param.getBillTypeCode().equals(BillTypeEnum.RETAIL_ADDITIONAL_BILL.getBillTypeCode())
                    && param.getBillType().equals(BillTypeEnum.RETAIL_ADDITIONAL_BILL.getBillType())) {
                printConfig.setImmediatelyPrint(1);
            } else {
                printConfig.setImmediatelyPrint(0);
            }
            if (param.getBillType().equals(BillTypeEnum.BAR_CODE.getBillType())
                    &&param.getBillTypeCode().equals(BillTypeEnum.BAR_CODE.getBillTypeCode())){
                printConfig.setPrintSize(CompanyBarCodePrintSizeEnum.BAR_58MM_40MM.getKey());
                printConfig.setFirstPrintFlag(0);
                printConfig.setBarCodeTemplateType(0);
            }
            printConfig.setPrintNum(1);
            printConfig.setPrintWarn(CompanyConstant.DEFAULT_PRINT_WARN);
            try {
                int count = companyTransactionTemplate.execute(new TransactionCallback<Integer>() {
                    @Override
                    public Integer doInTransaction(TransactionStatus transactionStatus) {
                        return companyPrintConfigService.addPrintConfig(printConfig);
                    }
                });

                if (count <= 0) {
                    context.setResultSuccess(false);
                    context.setResultModule(null);
                } else {
                    context.setResultSuccess(true);
                    CompanyPrintConfigInfoRespDTO respDTO =
                            BaseinfoCompanyFactory.companyPrintConfigModelToCompanyPrintConfigInfoRespDTO(new CompanyPrintConfigModel(printConfig));
                    context.setResultModule(respDTO);
                }
                return;

            } catch (DuplicateKeyException e) {  // 唯一键约束冲突, 重新查询一次
                printConfigModel = companyPrintConfigService.queryPrintConfigInfo(queryParam);
                if (printConfigModel == null || printConfigModel.getDO() == null) {  //  还是没查到
                    context.setResultSuccess(false);
                    context.setResultModule(null);
                    return;
                }
            }
        }

        // 查到打印配置, 直接返回
        CompanyPrintConfigInfoRespDTO respDTO = BaseinfoCompanyFactory.companyPrintConfigModelToCompanyPrintConfigInfoRespDTO(printConfigModel);

        context.setResultSuccess(true);
        context.setResultModule(respDTO);
    }
}
