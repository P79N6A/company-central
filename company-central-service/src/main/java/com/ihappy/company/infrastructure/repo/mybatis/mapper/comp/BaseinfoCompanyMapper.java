package com.ihappy.company.infrastructure.repo.mybatis.mapper.comp;

import com.ihappy.company.domain.bo.*;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.request.AllCompanyInfoPageQueryReqDTO;

import java.util.List;

public interface BaseinfoCompanyMapper {
    /**
     * 询公司到期及缴费情况分页列表
     * @param bo
     * @return
     */
    List<BaseinfoCompany> selectCompanyServiceStatus(CompanyInfoBO bo);
    /**
     * 询公司到期及缴费情况分页列表  计数
     * @param bo
     * @return
     */
    int selectCompanyServiceStatusCount(CompanyInfoBO bo);
    /**
     * 根据id 选择性修改字段，加乐观锁
     * @param record
     * @return
     */
    int updateByPrimaryKeySelectiveWithVersion(BaseinfoCompany record);
    /**
     * 根据条件查询
     * @param baseinfoCompany
     * @return
     */
    List<BaseinfoCompany> selectByCondition(BaseinfoCompany baseinfoCompany);
    /**
     *
     * @param companyBO
     * @return
     */
    List<BaseinfoCompany> selectByBaseinfoCompanyReqDTO(BaseinfoCompanyBO companyBO );

    /**
     *
     * @param companyBO
     * @return
     */
    Integer selectByBaseinfoCompanyReqDTOCount(BaseinfoCompanyBO companyBO);

    /**
     * 修改公司状态
     * @param baseinfoCompany
     * @return
     */
    Integer updateCompanyStatus(BaseinfoCompany baseinfoCompany);

    /**
     * 查询公司信息
     * @param baseinfoCompany
     * @return
     */
    BaseinfoCompany selectCompanyInfo(BaseinfoCompany baseinfoCompany);
    /**
     * 根据公司id和业务分类id查询公司信息
     * @param baseinfoCompanyBO
     * @return
     */
    BaseinfoCompany  selectCompanyInfoByCompIdAndCtIds( BaseinfoCompanyBO baseinfoCompanyBO);


    /**
     * 修改公司信息
     * @param baseinfoCompany
     * @return
     */
    Integer updateCompanyInfo(BaseinfoCompany baseinfoCompany);

    /**
     * 修改公司信息 为null项不修改
     * @param baseinfoCompany
     * @return
     */
    Integer updateCompanyInfoSelective(BaseinfoCompany baseinfoCompany);


    /**
     * 修改公司业务类型
     * @param baseinfoCompany
     * @return
     */
    Integer updateCompanyCtName(BaseinfoCompany baseinfoCompany);

    /**
     * 根据企业id列表 查询企业列表
     * @param compIds
     * @return
     */
    List<BaseinfoCompany> selectCompanyInfoListByIds(List<Integer> compIds);

    /**
     *根据名称查询公司
     * @param compName
     * @return
     */
    List<BaseinfoCompany> selectByCompName(String compName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    int deleteByPrimaryKey(Integer compId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    int insert(BaseinfoCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    Integer insertSelective(BaseinfoCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    BaseinfoCompany selectByPrimaryKey(Integer compId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    int updateByPrimaryKeySelective(BaseinfoCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    int updateByPrimaryKeyWithBLOBs(BaseinfoCompany record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table baseinfo_company
     *
     * @mbg.generated Thu Mar 29 10:50:33 CST 2018
     */
    int updateByPrimaryKey(BaseinfoCompany record);

     /**
       * @Decription: 查询所有未删除的公司数量 
       * @Param:  
       * @return:  
       * @Author: zhangtengpo 
       * @Date: 2018/5/30
       */
    int selectAllCompanyCount();

    /**
     * 分页查询公司信息
     * @param allCompanyInfoPageQueryReqDTO
     * @return
     */
    List<BaseinfoCompany> selectCompanyInfoByPage(AllCompanyInfoPageQueryReqDTO allCompanyInfoPageQueryReqDTO);

    /**
     * 更新企业信息
     * @param companyExpireStatusBO
     * @return
     */
    int updateCompanyExpireStatus(CompanyExpireStatusBO companyExpireStatusBO);

    int updateCompanyInfoAttributes(BaseinfoCompany record);

    /**
     * 修改打印模式
     * @param companyPrintModeBO
     * @return
     */
    int updateCompanyPrintMode(CompanyPrintModeBO companyPrintModeBO);


}