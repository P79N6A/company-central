package com.ihappy.company.application.process.write;

import com.ihappy.common.util.DateUtil;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.enumtype.company.CompanyBarCodePrintSizeEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyPrintConfig;
import com.ihappy.company.domain.dto.request.CompanyPrintConfigInfoUpdateReqDTO;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:03
 */
public class UpdateCompanyPrintConfigProcess extends DefaultProcess<CompanyPrintConfigInfoUpdateReqDTO, String> {

    @Autowired
    private CompanyPrintConfigService companyPrintConfigService;

    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Override
    public void process(Context<CompanyPrintConfigInfoUpdateReqDTO, String> context) {
        CompanyPrintConfigInfoUpdateReqDTO param = context.getParam();
        BaseinfoCompanyPrintConfig updateInfo = new BaseinfoCompanyPrintConfig();  // 要更新的信息
        BeanUtils.copyProperties(param, updateInfo);
        updateInfo.setPrintSize(CompanyBarCodePrintSizeEnum.getEnumByKey(param.getPrintSize()).getValue());
        updateInfo.setUpdatedAt(DateUtil.getCurrentDate());
        updateInfo.setUpdatedPersonId(param.getLoginPersonId());
        // 查出版本号
        BaseinfoCompanyPrintConfig queryParam = new BaseinfoCompanyPrintConfig();
        queryParam.setConfigId(updateInfo.getConfigId());

        CompanyPrintConfigModel currentVersionModel = companyPrintConfigService.queryPrintConfigInfo(queryParam);
        updateInfo.setVersion(currentVersionModel.getDO().getVersion());

        int count = companyTransactionTemplate.execute(new TransactionCallback<Integer>() {
            @Override
            public Integer doInTransaction(TransactionStatus transactionStatus) {
                return companyPrintConfigService.updatePrintConfigInfo(new CompanyPrintConfigModel(updateInfo));
            }
        });

        if(count < 1){
            context.setResultSuccess(false);
            context.setResultModule("更新打印设置失败");
        }
        context.setResultSuccess(true);
        context.setResultModule("更新打印设置成功");
    }
}
