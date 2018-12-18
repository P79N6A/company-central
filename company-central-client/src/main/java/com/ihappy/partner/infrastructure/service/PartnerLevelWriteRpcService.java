package com.ihappy.partner.infrastructure.service;

import com.ihappy.company.annotation.Transfer;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelAddReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelDelReqDTO;
import com.ihappy.partner.domain.dto.request.level.PartnerLevelUpdateReqDTO;
import com.ihappy.partner.domain.dto.response.level.PartnerLevelAddRespDTO;
import com.ihappy.unifiedLog.module.Result;

/**
 * Created by sunjd on 2018/4/26.
 */
@Deprecated
@Transfer(value = "com.ihappy.partner.infrastructure.service.PartnerLevelWriteRpcService",memo = "接口迁移注解:value为迁移接口,方法不变")
public interface PartnerLevelWriteRpcService {
    /**
     * 添加会员等级
     * @param reqDTO
     * @return
     */
    Result<PartnerLevelAddRespDTO> addPartnerLevel(PartnerLevelAddReqDTO reqDTO);

    /**
     * 修改会员等级
     * @param reqDTO
     * @return
     */
    Result<String> updatePartnerLevel(PartnerLevelUpdateReqDTO reqDTO);

    /**
     * 删除会员等级
     * @param reqDTO
     * @return
     */
    Result<String> delPartnerLevel(PartnerLevelDelReqDTO reqDTO);
}
