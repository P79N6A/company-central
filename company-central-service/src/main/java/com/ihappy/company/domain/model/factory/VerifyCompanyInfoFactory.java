package com.ihappy.company.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyNatureEnum;
import com.ihappy.company.common.enumtype.company.CompanyVerifiedStatusEnum;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyVerifiedHistory;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyAddReqDTO;
import com.ihappy.company.domain.dto.request.companyverify.CompanyInfoVerifyReqDTO;
import com.ihappy.company.domain.dto.response.companyverify.CompanyInfoVerifyReadRespDTO;
import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.company.domain.model.model.CompanyVerifiedHistoryModel;
import org.springframework.beans.BeanUtils;

/**
 * Created by sunjd on 2018/6/6.
 */
public class VerifyCompanyInfoFactory {
    public static CompanyInfoVerifyReadRespDTO companyModelToCompanyInfoVerifyReadRespDTO(CompanyModel companyModel){
        CompanyInfoVerifyReadRespDTO respDTO = new CompanyInfoVerifyReadRespDTO();
        BeanUtils.copyProperties(companyModel.getDO(),respDTO);
        respDTO.setNatureStr(CompanyNatureEnum.getTbcpNatureEnum(companyModel.getDO().getNature()).getValue());
        respDTO.setIsVerifiedStr(CompanyVerifiedStatusEnum.getEnumByKey(companyModel.getDO().getIsVerified()).getValue());
        return respDTO;
    }

    public static CompanyVerifiedHistoryModel companyInfoVerifyAddReqDTOToModel(CompanyInfoVerifyAddReqDTO reqDTO){
        BaseinfoCompanyVerifiedHistory baseinfoCompanyVerifiedHistory = new BaseinfoCompanyVerifiedHistory();
        BeanUtils.copyProperties(reqDTO,baseinfoCompanyVerifiedHistory);
        baseinfoCompanyVerifiedHistory.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        baseinfoCompanyVerifiedHistory.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        baseinfoCompanyVerifiedHistory.setUpdatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyVerifiedHistory.setCreatedPersonId(reqDTO.getLoginPersonId());
        return new CompanyVerifiedHistoryModel(baseinfoCompanyVerifiedHistory);
    }

    public static CompanyVerifiedHistoryModel companyInfoVerifyReqDTOToModel(CompanyInfoVerifyReqDTO reqDTO){
        BaseinfoCompanyVerifiedHistory baseinfoCompanyVerifiedHistory = new BaseinfoCompanyVerifiedHistory();
        BeanUtils.copyProperties(reqDTO,baseinfoCompanyVerifiedHistory);
        baseinfoCompanyVerifiedHistory.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        baseinfoCompanyVerifiedHistory.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        baseinfoCompanyVerifiedHistory.setUpdatedPersonId(reqDTO.getLoginPersonId());
        baseinfoCompanyVerifiedHistory.setCreatedPersonId(reqDTO.getLoginPersonId());
        return new CompanyVerifiedHistoryModel(baseinfoCompanyVerifiedHistory);
    }
}
