package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.BaseinfoCompanyBO;
import com.ihappy.company.domain.bo.CompanyExpireStatusBO;
import com.ihappy.company.domain.dto.request.AllCompanyInfoPageQueryReqDTO;
import com.ihappy.company.domain.dto.request.companyinfo.CompanyInfoByCompIdQuery;
import com.ihappy.company.domain.model.model.CompanyModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/2.
 */
public interface CompanyInfoService {
    List<CompanyModel> queryCompanyInfoListByIds(List<Integer> compIds);
     /**
       * @Description: 查询所有公司的数量
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/5/30
       */
    int queryAllCompanyCouut();
    
     /**
       * @Description: 分页查询公司信息, 根据
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/5/30
       */
    List<CompanyModel> queryCompanyInfoByPage(AllCompanyInfoPageQueryReqDTO allCompanyInfoPageQueryReqDTO);

    /**
     * 通过id获取名称
     * @param compIds
     * @Author: liuhc
     * @Date: 2018/6/30
     * @return
     */
    Map<String,CompanyModel> getCompNameById(List<Integer> compIds);
    /**
     * 根据业务分类id 获取业务分类命 均以逗号隔开
     * @param ctIds
     * @return
     */
    String getCtNamesByCtIds(String ctIds);

    /**
     * 根据经营类目id获取 经营类目名 均以逗号隔开
     * @param businessCategoryIds
     * @return
     */
    String getBusinessCategoryStrByIds(String businessCategoryIds);

    /**
     * 查询公司信息
     * @param companyInfoByCompIdQuery
     * @return
     */
    CompanyModel selectCompanyInfo( CompanyInfoByCompIdQuery companyInfoByCompIdQuery);

    /**
     * 根据公司id和业务分类id查询公司信息
     * @param baseinfoCompanyBO
     * @return
     */
    CompanyModel selectCompanyInfoByCompIdAndCtIds( BaseinfoCompanyBO baseinfoCompanyBO);


    /**
     * 更新公司状态
     * @param companyExpireStatusBO
     * @return
     */
    int updateCompanyExpireStatus(CompanyExpireStatusBO companyExpireStatusBO);


    int updateFactoryInfo(CompanyModel companyModel);

}
