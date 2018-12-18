package com.ihappy.company.application.process.query.org;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dbdo.SysOrg;
import com.ihappy.company.domain.dto.request.org.SysOrgBasicInfoByIdQueryRpcReqDTO;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoByIdQueryRpcRespDTO;
import com.ihappy.company.domain.dto.response.org.SysOrgBasicInfoRespDTO;
import com.ihappy.company.domain.model.factory.SysOrgFactory;
import com.ihappy.company.domain.model.model.SysOrgModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.service.inside.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/6/18.
 */
public class QueryAllChildSysOrgByIdProcess extends DefaultQueryProcess<SysOrgBasicInfoByIdQueryRpcReqDTO,SysOrgBasicInfoByIdQueryRpcRespDTO> {
    @Autowired
    private SysOrgService sysOrgService;


    @Override
    public void process(Context<SysOrgBasicInfoByIdQueryRpcReqDTO, SysOrgBasicInfoByIdQueryRpcRespDTO> context) {
        SysOrgBasicInfoByIdQueryRpcReqDTO reqDTO = context.getParam();
        if (reqDTO.getOrgId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.
                    ORG_ID_IS_NULL.getErrCode(),
                    CompanyErrorCodeEnum.ORG_ID_IS_NULL.getErrMsg());
        }
        SysOrgBasicInfoByIdQueryRpcRespDTO respDTO = new SysOrgBasicInfoByIdQueryRpcRespDTO();
        SysOrg queryParam = new SysOrg();
        queryParam.setOrgId(reqDTO.getOrgId());
        SysOrgModel thisOrg = sysOrgService.getSysOrgByOrgId(queryParam);
        List<SysOrg> queryParams = new ArrayList<SysOrg>();
        queryParams.add(queryParam);
        List<SysOrgModel> childrenOrg = sysOrgService.getAllChildSysOrgByOrgId(queryParams);

        if (reqDTO.getDataStructure() == 1){
            List<SysOrgBasicInfoRespDTO> orgList = SysOrgFactory.modelsToSysOrgBasicInfoRespDTOs(childrenOrg);
            orgList.add(SysOrgFactory.modelToSysOrgBasicInfoRespDTO(thisOrg));
            respDTO.setOrgList(orgList);
        }else if (reqDTO.getDataStructure() == 2){

        }
        context.getResult().setModule(respDTO);
    }
}
