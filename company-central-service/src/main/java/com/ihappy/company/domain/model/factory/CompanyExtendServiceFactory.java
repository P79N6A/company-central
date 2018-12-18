package com.ihappy.company.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyExtendServiceJournal;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyExtendServiceAddReqDTO;
import com.ihappy.company.domain.model.model.CompanyExtendServiceJournalModel;
import org.springframework.beans.BeanUtils;

/**
 * Created by sunjd on 2018/6/28.
 */
public class CompanyExtendServiceFactory {
    public static CompanyExtendServiceJournalModel companyExtendServiceAddReqDTOToModel(CompanyExtendServiceAddReqDTO reqDTO){
        BaseinfoCompanyExtendServiceJournal obj = new BaseinfoCompanyExtendServiceJournal();
        BeanUtils.copyProperties(reqDTO,obj);
        obj.setCreatedAt(CompanyDateUtil.getDate14Long(reqDTO.getCreateTime()));
        obj.setUpdatedAt(CompanyDateUtil.getDate14Long(reqDTO.getUpdateTime()));
        return new CompanyExtendServiceJournalModel(obj);
    }
}
