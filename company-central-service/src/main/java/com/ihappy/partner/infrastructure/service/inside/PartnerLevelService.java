package com.ihappy.partner.infrastructure.service.inside;


import com.ihappy.partner.domain.bo.level.CheckPartnerLevelBOByName;
import com.ihappy.partner.domain.model.model.PartnerLevelModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/5/2.
 */
public interface PartnerLevelService {
    /**
     * 根据条件查询
     * @param model
     * @return
     */
    List<PartnerLevelModel> selectByCondition(PartnerLevelModel model);

    /**
     * 查询伙伴分级名称是否重复
     * @param checkPartnerLevelBOByName
     * @return
     */
    List<PartnerLevelModel> checkPartnerLevelName(CheckPartnerLevelBOByName checkPartnerLevelBOByName);
    /**
     * 添加等级
     * @param model
     * @return
     */
    Long addPartnerLevel(PartnerLevelModel model);

    /**
     * 修改等级
     * @param model
     * @return
     */
    Integer updatePartnerLevel(PartnerLevelModel model);

    /**
     * 删除等级
     * @param model
     * @return
     */
    Integer delPartnerLevel(PartnerLevelModel model);

    /**
     * 根据id查询
     * @param model
     * @return
     */
    PartnerLevelModel selectById(PartnerLevelModel model);

    /**
     * 根据公司id查询列表
     * @param model
     * @return
     */
    List<PartnerLevelModel> selectPartnerLevelList(PartnerLevelModel model);

    /**
     * 修改引用计数
     * @param paramMap
     * @return
     */
    Integer updateReferenceCount(Map<String,Object> paramMap);

    Long addDefaultPartnerLevel(Integer compId);
}