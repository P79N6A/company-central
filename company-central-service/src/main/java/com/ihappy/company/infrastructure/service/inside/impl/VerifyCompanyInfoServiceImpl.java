package com.ihappy.company.infrastructure.service.inside.impl;

import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.enumtype.company.CompanyVerifiedStatusEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyVerifiedHistory;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.CompanyVerifiedHistoryModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyVerifiedHistoryMapper;
import com.ihappy.company.infrastructure.service.inside.VerifyCompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by sunjd on 2018/6/6.
 */
public class VerifyCompanyInfoServiceImpl implements VerifyCompanyInfoService {
    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Autowired
    private BaseinfoCompanyVerifiedHistoryMapper baseinfoCompanyVerifiedHistoryMapper;

    @Override
    public CompanyModel queryVerifyCompanyInfo(CompanyModel companyModel) {
        if (companyModel == null || companyModel.getDO() == null || companyModel.getDO().getCompId() == null){
            return null;
        }
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(companyModel.getDO().getCompId());
        if (company == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        //审核通过 或 为认证 直接使用 BaseinfoCompany 的信息
        if (CompanyVerifiedStatusEnum.VERIFIED.getKey().equals(company.getIsVerified()) || CompanyVerifiedStatusEnum.UNVERIFIED.getKey().equals(company.getIsVerified())){
            return new CompanyModel(company);
        }
        //审核不通过 或 待审核 使用历史表的信息
        if (CompanyVerifiedStatusEnum.VERIFING.getKey().equals(company.getIsVerified()) || CompanyVerifiedStatusEnum.VERIFY_NOT_PASS.getKey().equals(company.getIsVerified())){
            BaseinfoCompanyVerifiedHistory param = new BaseinfoCompanyVerifiedHistory();
            param.setCompId(companyModel.getDO().getCompId());
            CompanyVerifiedHistoryModel history = queryLatestOne(new CompanyVerifiedHistoryModel(param));
            if (history != null){
                company.setCompShortName(history.getDO().getCompShortName());
                company.setNature(history.getDO().getNature());
                company.setLegalMan(history.getDO().getLegalMan());
                company.setCardFrontUrl(history.getDO().getCardFrontUrl());
                company.setCardBackUrl(history.getDO().getCardBackUrl());
                company.setLicense(history.getDO().getLicense());
                company.setLicensePicurl(history.getDO().getLicensePicurl());
                company.setVerifiedReason(history.getDO().getVerifiedReason());
            }
            return new CompanyModel(company);
        }
        return new CompanyModel(company);
    }

    @Override
    public CompanyVerifiedHistoryModel queryLatestOne(CompanyVerifiedHistoryModel companyVerifiedHistoryModel) {
        if (companyVerifiedHistoryModel == null || companyVerifiedHistoryModel.getDO() == null || companyVerifiedHistoryModel.getDO().getCompId() == null){
            return null;
        }
        BaseinfoCompanyVerifiedHistory condition = new BaseinfoCompanyVerifiedHistory();
        condition.setCompId(companyVerifiedHistoryModel.getDO().getCompId());
        condition.setIsDeleted(0);
        BaseinfoCompanyVerifiedHistory history = baseinfoCompanyVerifiedHistoryMapper.selectOneByCondition(condition);
        if (history == null){
            return null;
        }
        return new CompanyVerifiedHistoryModel(history);
    }

    @Override
    public CompanyVerifiedHistoryModel addVerifyCompanyInfo(CompanyVerifiedHistoryModel companyVerifiedHistoryModel) {
        if (companyVerifiedHistoryModel == null || companyVerifiedHistoryModel.getDO() == null || companyVerifiedHistoryModel.getDO().getCompId() == null){
            return null;
        }
        Integer compId = companyVerifiedHistoryModel.getDO().getCompId();
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if (company == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        if (CompanyVerifiedStatusEnum.VERIFIED.equals(company.getIsVerified())){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_VERIFIED.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_VERIFIED.getErrMsg());
        }
        companyVerifiedHistoryModel.getDO().setIsVerified(CompanyVerifiedStatusEnum.VERIFING.getKey());
        Integer insertNum = baseinfoCompanyVerifiedHistoryMapper.insertSelective(companyVerifiedHistoryModel.getDO());
        if (insertNum != 1){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ADD_COMPANY_VERIFIED_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.ADD_COMPANY_VERIFIED_ERROR.getErrMsg());
        }

        //修改公司认证状态
        BaseinfoCompany companyParam = new BaseinfoCompany();
        companyParam.setCompId(compId);
        companyParam.setIsVerified(CompanyVerifiedStatusEnum.VERIFING.getKey());
        baseinfoCompanyMapper.updateCompanyInfo(companyParam);
        return companyVerifiedHistoryModel;
    }

    @Override
    public CompanyVerifiedHistoryModel verifyCompanyInfo(CompanyVerifiedHistoryModel companyVerifiedHistoryModel) {
        if (companyVerifiedHistoryModel == null || companyVerifiedHistoryModel.getDO() == null || companyVerifiedHistoryModel.getDO().getCompId() == null){
            return null;
        }
        Integer compId = companyVerifiedHistoryModel.getDO().getCompId();
        BaseinfoCompany company = baseinfoCompanyMapper.selectByPrimaryKey(compId);
        if (company == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    COMPANY_IS_EMPTY.getErrCode(),
                    CompanyErrorCodeEnum.COMPANY_IS_EMPTY.getErrMsg());
        }
        //判断公司名称重复
        BaseinfoCompany companyParam = new BaseinfoCompany();
        companyParam.setCompName(company.getCompShortName());
        companyParam.setIsDeleted(0);
        List<BaseinfoCompany> companyList = baseinfoCompanyMapper.selectByCondition(companyParam);
        for (BaseinfoCompany obj : companyList){
            if (!obj.getCompId().equals(compId)){
                throw new CompanyException(CompanyErrorCodeEnum.
                        COMPANY_NAME_REPEAT.getErrCode(),
                        CompanyErrorCodeEnum.COMPANY_NAME_REPEAT.getErrMsg());
            }
        }

        Integer isVerified = companyVerifiedHistoryModel.getDO().getIsVerified();
        //最后一条认证记录
        BaseinfoCompanyVerifiedHistory param = new BaseinfoCompanyVerifiedHistory();
        param.setCompId(compId);
        CompanyVerifiedHistoryModel history = queryLatestOne(new CompanyVerifiedHistoryModel(param));
        //审核通过
        if (CompanyVerifiedStatusEnum.VERIFIED.getKey().equals(isVerified)){
            //修改企业信息
            BaseinfoCompany updateCompanyParam = new BaseinfoCompany();
            updateCompanyParam.setCompName(company.getCompShortName());
            updateCompanyParam.setCompId(compId);
            updateCompanyParam.setIsVerified(isVerified);
            updateCompanyParam.setVerifiedReason(companyVerifiedHistoryModel.getDO().getVerifiedReason());
            updateCompanyParam.setLegalMan(history.getDO().getLegalMan());
            updateCompanyParam.setCardFrontUrl(history.getDO().getCardFrontUrl());
            updateCompanyParam.setCardBackUrl(history.getDO().getCardBackUrl());
            updateCompanyParam.setLicense(history.getDO().getLicense());
            updateCompanyParam.setLicensePicurl(history.getDO().getLicensePicurl());
            baseinfoCompanyMapper.updateCompanyInfo(updateCompanyParam);

            //修改历史记录信息
            history.getDO().setIsVerified(isVerified);
            history.getDO().setVerifiedReason(companyVerifiedHistoryModel.getDO().getVerifiedReason());
            Integer updateHistoryNum = baseinfoCompanyVerifiedHistoryMapper.updateByPrimaryKeySelective(history.getDO());
        }
        if (CompanyVerifiedStatusEnum.VERIFY_NOT_PASS.getKey().equals(isVerified)){
            //修改企业信息
            BaseinfoCompany updateCompanyParam = new BaseinfoCompany();
            updateCompanyParam.setCompId(compId);
            updateCompanyParam.setIsVerified(isVerified);
            updateCompanyParam.setVerifiedReason(companyVerifiedHistoryModel.getDO().getVerifiedReason());
            baseinfoCompanyMapper.updateCompanyInfo(updateCompanyParam);

            //修改历史记录信息
            history.getDO().setIsVerified(isVerified);
            history.getDO().setVerifiedReason(companyVerifiedHistoryModel.getDO().getVerifiedReason());
            Integer updateHistoryNum = baseinfoCompanyVerifiedHistoryMapper.updateByPrimaryKeySelective(history.getDO());
        }

        return history;
    }
}
