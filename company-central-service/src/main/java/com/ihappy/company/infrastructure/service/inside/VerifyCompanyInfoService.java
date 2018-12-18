package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.CompanyVerifiedHistoryModel;

/**
 * Created by sunjd on 2018/6/6.
 * 企业认证审核service
 */
public interface VerifyCompanyInfoService {
    /**
     * 查询企业认证信息
     * 根据企业id查询
     * @param companyModel
     * @return
     */
    CompanyModel queryVerifyCompanyInfo(CompanyModel companyModel);

    /**
     * 查询最近一条数据
     * 根据compId
     * @param companyVerifiedHistoryModel
     * @return
     */
    CompanyVerifiedHistoryModel queryLatestOne(CompanyVerifiedHistoryModel companyVerifiedHistoryModel);

    /**
     * 添加企业认证信息
     * @param companyVerifiedHistoryModel
     * @return
     */
    CompanyVerifiedHistoryModel addVerifyCompanyInfo(CompanyVerifiedHistoryModel companyVerifiedHistoryModel);

    /**
     * 审核企业认证信息
     * @param companyVerifiedHistoryModel
     * @return
     */
    CompanyVerifiedHistoryModel verifyCompanyInfo(CompanyVerifiedHistoryModel companyVerifiedHistoryModel);
}
