package com.ihappy.company.application.process.write;

import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.CompanyLoggerUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.AllCompanyInfoPageQueryReqDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.CompanyInfoService;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import com.ihappy.store.common.enumtype.StoreErrorCodeEnum;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;


/**
 * @author : zhangtengpo
 * @Description :  生成默认信息
 * @create : 2018-05-30 14:24
 */
public class GenerateDefaultInformationProcess extends DefaultProcess<BaseReqDTO, String> {
    private final static Logger logger = CompanyLoggerUtil.getLogger();

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private CompanyStoreService companyStoreService;

    @Autowired
    private CompanyPartnerService companyPartnerService;

    @Autowired
    private TransactionTemplate companyTransactionTemplate;

    @Override
    public void process(Context<BaseReqDTO, String> context) {
        int companyCount  = companyInfoService.queryAllCompanyCouut();
        // 每次处理50个公司
        int limit = 50;
        for(int offset = 0; offset < companyCount; offset += limit){
            AllCompanyInfoPageQueryReqDTO allCompanyInfoPageQueryReqDTO = new AllCompanyInfoPageQueryReqDTO();
            allCompanyInfoPageQueryReqDTO.setOffset(offset);
            allCompanyInfoPageQueryReqDTO.setLimit(limit);
            allCompanyInfoPageQueryReqDTO.setSort("comp_id");
            allCompanyInfoPageQueryReqDTO.setOrder("asc");
            List<CompanyModel> companyModels = companyInfoService.queryCompanyInfoByPage(allCompanyInfoPageQueryReqDTO);
            for(CompanyModel companyModel : companyModels){
                BaseinfoCompany companyInfo = companyModel.getDO();
                //添加默认门店，同时添加默认仓库
                BaseinfoCompanyStore store = new BaseinfoCompanyStore();
                store.setCompId(companyInfo.getCompId());
                store.setAdminPersonId(companyInfo.getAdminPersonId());
                store.setWeshopAddress(companyModel.getDO().getCompAddress());
                store.setWeshopProvince(companyModel.getDO().getProvince());
                store.setWeshopCity(companyModel.getDO().getCity());
                store.setWeshopZone(companyModel.getDO().getZone());
                store.setBusinessCategory(companyModel.getDO().getBusinessCategory());
                store.setWeshopContactType(companyModel.getDO().getAdminPersonMobile());
                store.setWeshopManagerId(companyModel.getDO().getAdminPersonId());
                store.setWeshopManagerName(companyModel.getDO().getAdminPersonName());
                Boolean addStroeFlag = companyStoreService.addDefStore(new CompanyStoreModel(store));
                if (!addStroeFlag){
                    throw new CompanyException(StoreErrorCodeEnum.
                            ADD_DEF_STORE_ERROR.getErrCode(),
                            StoreErrorCodeEnum.ADD_DEF_STORE_ERROR.getErrMsg());
                }

                companyTransactionTemplate.execute(new TransactionCallback<Boolean>() {
                    @Override
                    public Boolean doInTransaction(TransactionStatus transactionStatus) {
                        // 判断并添加默认供应商和客户
                        return companyPartnerService.addDefaultPartner(companyModel);
                    }
                });

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // do nothing
                    logger.error(e.getMessage(),e);
                    Thread.currentThread().interrupt();
                }

            }

        }
        context.setResultSuccess(true);
        context.setResultModule("给所有公司生成默认信息成功");
    }
}
