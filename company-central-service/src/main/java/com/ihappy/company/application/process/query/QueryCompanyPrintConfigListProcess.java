package com.ihappy.company.application.process.query;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.company.CompanyBarCodePrintSizeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyPrintConfig;
import com.ihappy.company.domain.dbdo.CompanyModePrintBill;
import com.ihappy.company.domain.dbdo.SysCompanyTypePrintBill;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigListQueryReqDTO;
import com.ihappy.company.domain.dto.response.CompanyPrintConfigListRespDTO;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-04 14:20
 */
public class QueryCompanyPrintConfigListProcess extends DefaultQueryProcess<CompanyPrintConfigListQueryReqDTO, List<CompanyPrintConfigListRespDTO>> {

    @Autowired
    private CompanyPrintConfigService companyPrintConfigService;

    @Override
    public void process(Context<CompanyPrintConfigListQueryReqDTO, List<CompanyPrintConfigListRespDTO>> context) {
        CompanyPrintConfigListQueryReqDTO param = context.getParam();
        //返回list
        List<CompanyPrintConfigListRespDTO> printConfigList = new ArrayList<>();

        CompanyModePrintBill companyModePrintBill =
                companyPrintConfigService.queryCompanyModePrintBillByCompId(param.getCompId().intValue(), param.getStoreId());

        List<SysCompanyTypePrintBill> printBillModels = new ArrayList<>();

        CompanyPrintConfigListRespDTO printMode = new CompanyPrintConfigListRespDTO();
        printMode.setPrintMode(companyModePrintBill.getPrintMode());
        printConfigList.add(0,printMode);

        if (companyModePrintBill != null) {
           printBillModels = companyModePrintBill.getSysCompanyTypePrintBillList();
            for(SysCompanyTypePrintBill printBill : printBillModels){
                CompanyPrintConfigListRespDTO respDTO = new CompanyPrintConfigListRespDTO();
                respDTO.setBillType(printBill.getBillType());
                respDTO.setBillTypeCode(printBill.getBillTypeCode());
                respDTO.setBillTypeName(printBill.getBillTypeName());
                //查打印尺寸和份数
                BaseinfoCompanyPrintConfig queryParam = new BaseinfoCompanyPrintConfig();
                queryParam.setCompId(param.getCompId().intValue());
                queryParam.setBillType(printBill.getBillType());
                queryParam.setBillTypeCode(printBill.getBillTypeCode());
                CompanyPrintConfigModel printConfigModel = companyPrintConfigService.queryPrintConfigInfo(queryParam);

                if (printConfigModel != null){
                    respDTO.setPrintSizeAndNum(getPrintSizeAndNum(CompanyBarCodePrintSizeEnum.getEnumByValue(printConfigModel.getDO().getPrintSize()).getKey(),printConfigModel.getDO().getPrintNum(),companyModePrintBill.getPrintMode()));
                }else if (printBill.getBillType()==2&& printBill.getBillTypeCode()==2){
                    respDTO.setPrintSizeAndNum(getPrintSizeAndNum(CompanyBarCodePrintSizeEnum.getEnumByValue("58mm*40mm").getKey(),1,companyModePrintBill.getPrintMode()));
                }else {
                    respDTO.setPrintSizeAndNum(getPrintSizeAndNum(CompanyBarCodePrintSizeEnum.getEnumByValue("MM_110").getKey(),1,companyModePrintBill.getPrintMode()));
                }
                printConfigList.add(respDTO);
            }
        }

        context.setResultSuccess(true);
        context.setResultModule(printConfigList);
    }
    private String getPrintSizeAndNum(String printSize,Integer printNum,Integer printMode){
        if (printMode != null && printMode == 1){
            return printNum+"份";
        }else {
            return printSize+","+printNum+"份";
        }
    }
}
