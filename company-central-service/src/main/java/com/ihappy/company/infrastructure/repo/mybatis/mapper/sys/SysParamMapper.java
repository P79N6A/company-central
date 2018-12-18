package com.ihappy.company.infrastructure.repo.mybatis.mapper.sys;

import com.ihappy.company.domain.bo.sys.SysParamBO;
import com.ihappy.company.domain.dbdo.sys.SysParam;

import java.util.List;

public interface SysParamMapper {
    /**
     * @Author sunjd
     * @Description 根据key查询
     * @Date 15:34 2018/12/4
     * @Param [key]
     * @return com.ihappy.company.domain.dbdo.sys.SysParam
     **/
    SysParam selectByKey(String key);
    /**
     * @Author sunjd
     * @Description  根据条件查询
     * @Date 13:32 2018/12/4
     * @Param [bo]
     * @return List<SysParam>
     **/
    List<SysParam> selectByCondition(SysParamBO bo);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    int insertSelective(SysParam record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    SysParam selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbg.generated Tue Dec 04 11:26:24 CST 2018
     */
    int updateByPrimaryKeySelective(SysParam record);
}