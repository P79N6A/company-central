package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelListQueryReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelQueryReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelQueryRespDTO;
import com.ihappy.unifiedLog.module.Result;

import java.util.List;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerLevelReadRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface PartnerLevelReadRpcService {
    /**
     * 查询单个会员等级
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelQueryRespDTO> findPartnerLevel(PartnerLevelQueryReqDTO reqDTO);

    /**
     * 查询会员等级列表
     * @param reqDTO
     * @return
     */
    Result<List<PartnerLevelQueryRespDTO>> findPartnerLevelList(PartnerLevelListQueryReqDTO reqDTO);
}
