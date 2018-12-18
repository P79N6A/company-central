package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.UserInfoBO;

import java.util.List;

/**
 * Created by sunjd on 2018/6/22.
 */
public interface UserInfoService {
    /**
     * 根据用户id和公司id 查询 角色名称
     * @param userInfo
     * @return
     */
    String getUserRole(UserInfoBO userInfo);

    /**
     * 根据用户id和公司id 查询 用户门店列表
     * @param userInfo
     * @return
     */
    List<Long> getUserStoreId(UserInfoBO userInfo);
}
