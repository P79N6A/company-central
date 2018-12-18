package com.ihappy.communal.infrastructure.service.outside.user;

import com.ihappy.communal.domain.bo.PersonBO;
import com.ihappy.store.domain.dto.response.user.UserInfoRespDTO;
import com.ihappy.company.domain.dto.request.user.UserInfoReqDTO;
import com.ihappy.user.domain.dto.response.person.CompStoreInfoRespDTO;
import com.ihappy.user.domain.query.person.CompStoreQuery;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/7.
 */
public interface UserInfoOutSideService {
    /**
     * 查询门店下用户列表
     * @param reqDTO
     * @return
     */
    List<UserInfoRespDTO> queryStorePerson(UserInfoReqDTO reqDTO, boolean throwException);

    Map<Long,UserInfoRespDTO> queryStorePersonMap(UserInfoReqDTO reqDTO,boolean throwException);
    /**
     * 查企业门店下是否有用户存在
     * @param compStoreQuery
     * @return
     */
    List<CompStoreInfoRespDTO> queryCompStoreInfo(CompStoreQuery compStoreQuery, boolean throwException);

    /**
     * @Author sunjd
     * @Description 根据门店列表、角色列表 查询用户
     * @Date 16:29 2018/11/1
     * @Param [reqDTO]
     * @return java.util.List<com.ihappy.store.domain.dto.response.user.UserInfoRespDTO>
     **/
    List<UserInfoRespDTO> queryPersonInfoOrgBaseList(UserInfoReqDTO reqDTO, boolean throwException);

    PersonBO queryPersonInfoByMobile(String mobile);
}
