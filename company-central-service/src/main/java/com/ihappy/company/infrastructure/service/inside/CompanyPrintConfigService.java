package com.ihappy.company.infrastructure.service.inside;

import com.ihappy.company.domain.bo.CompanyPrintModeBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyPrintConfig;
import com.ihappy.company.domain.dbdo.CompanyModePrintBill;
import com.ihappy.company.domain.dbdo.SysCompanyTypePrintBill;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;

import java.util.List;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:19
 */
public interface CompanyPrintConfigService {
    /**
       * @Description: 查询打印配置详情 
       * @Param:  
       * @return:  
       * @Author: zhangtengpo 
       * @Date: 2018/6/1
       */
    CompanyPrintConfigModel queryPrintConfigInfo(BaseinfoCompanyPrintConfig baseinfoCompanyPrintConfig);

     /**
       * @Description: 根据公司id查询打印设置列表
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/6/1
       */
    List<SysCompanyTypePrintBill> queryPrintConfigListByCompId(Integer compId, Long storeId);

    /**
     * @Description: 根据公司id查询打印设置列表加打印模式
     * @Param:
     * @return:
     * @Author: cy
     * @Date: 2018/6/1
     */
    CompanyModePrintBill queryCompanyModePrintBillByCompId(Integer compId, Long storeId);

    /**
       * @Description: 更新打印配置
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/6/1
       */
    int updatePrintConfigInfo(CompanyPrintConfigModel companyPrintConfigModel);

     /**
       * @Description: 创建打印配置
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/6/4
       */
    int addPrintConfig(BaseinfoCompanyPrintConfig printConfig);

    /**
     * 修改打印模式
     * @param companyPrintModeBO
     * @return
     */
    int updateCompanyPrintMode(CompanyPrintModeBO companyPrintModeBO);



}
