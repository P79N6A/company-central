package com.ihappy.company.infrastructure.service.inside.impl;


import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.company.domain.bo.CompanyPrintModeBO;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dbdo.BaseinfoCompanyPrintConfig;
import com.ihappy.company.domain.dbdo.CompanyModePrintBill;
import com.ihappy.company.domain.dbdo.SysCompanyTypePrintBill;
import com.ihappy.company.domain.model.model.CompanyPrintConfigModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyPrintConfigMapper;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.sys.SysCompanyTypePrintBillMapper;
import com.ihappy.company.infrastructure.service.inside.CompanyPrintConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 2018-06-01 16:20
 */
public class CompanyPrintConfigServiceImpl implements CompanyPrintConfigService {
    @Autowired
    private BaseinfoCompanyPrintConfigMapper baseinfoCompanyPrintConfigMapper;

    @Autowired
    private SysCompanyTypePrintBillMapper sysCompanyTypePrintBillMapper;

    @Autowired
    private BaseinfoCompanyMapper baseinfoCompanyMapper;

    @Override
    public CompanyPrintConfigModel queryPrintConfigInfo(BaseinfoCompanyPrintConfig baseinfoCompanyPrintConfig) {
        if(baseinfoCompanyPrintConfig.getConfigId() == null && baseinfoCompanyPrintConfig.getCompId() == null){
            throw new CompanyException(CompanyErrorCodeEnum.TO_MANY_RESULT);
        }
        List<BaseinfoCompanyPrintConfig> results = baseinfoCompanyPrintConfigMapper.selectSelective(baseinfoCompanyPrintConfig);
        if(results == null || results.size() == 0){
            return null;
        }
        if(results.size() > 1){
            throw new CompanyException(CompanyErrorCodeEnum.TO_MANY_RESULT);
        }
        return new CompanyPrintConfigModel(results.get(0));
    }

    @Override
    public List<SysCompanyTypePrintBill> queryPrintConfigListByCompId(Integer compId, Long storeId) {
        if(compId == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
        // 查询公司业务类型
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectByPrimaryKey(compId);

        String[] ctIds = baseinfoCompany.getCtIds().split(",");
        // 使用treeset存放打印列表防止同名的打印单据重复添加
        Set<SysCompanyTypePrintBill> printBills = new TreeSet<>(new Comparator<SysCompanyTypePrintBill>() {
            @Override
            public int compare(SysCompanyTypePrintBill o1, SysCompanyTypePrintBill o2) {
                if(o1.getBillType().equals(o2.getBillType()) && o1.getBillTypeCode().equals(o2.getBillTypeCode())){  // 单据类型和单据详细类型都一致就算相同
                    return 0;
                }
                return 1;
            }
        });

        for(String ctId : ctIds){
            // 根据业务类型查询redis得到对应的要展示的单据类型
            List<SysCompanyTypePrintBill> printBillList = CompanyRedisUtil.getCompanyTypePrintBill(Integer.parseInt(ctId));
            if(printBillList == null || printBillList.size() == 0){
                // 如果redis查不到,从sysdb数据库查, 并将结果写入redis, 设置过期时间
                printBillList = sysCompanyTypePrintBillMapper.selectByCtId(Integer.parseInt(ctId));
                // 将数据放入redis缓存
                CompanyRedisUtil.putCompanyTypePrintBill(Integer.parseInt(ctId), printBillList,
                        CompanyDateUtil.getMillisecondByDayHourMinuteSecond(0,12,0,0) / 1000);  //默认过期时间2天

            }
            printBills.addAll(printBillList);
        }


        return new ArrayList<>(printBills);


    }

    @Override
    public CompanyModePrintBill queryCompanyModePrintBillByCompId(Integer compId, Long storeId) {
        if(compId == null){
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
        CompanyModePrintBill companyModePrintBill = new CompanyModePrintBill();

        // 查询公司业务类型
        BaseinfoCompany baseinfoCompany = baseinfoCompanyMapper.selectByPrimaryKey(compId);

        String[] ctIds = baseinfoCompany.getCtIds().split(",");
        // 使用treeset存放打印列表防止同名的打印单据重复添加
        Set<SysCompanyTypePrintBill> printBills = new TreeSet<>(new Comparator<SysCompanyTypePrintBill>() {
            @Override
            public int compare(SysCompanyTypePrintBill o1, SysCompanyTypePrintBill o2) {
                if(o1.getBillType().equals(o2.getBillType()) && o1.getBillTypeCode().equals(o2.getBillTypeCode())){  // 单据类型和单据详细类型都一致就算相同
                    return 0;
                }
                return 1;
            }
        });

        for(String ctId : ctIds){
            // 根据业务类型查询redis得到对应的要展示的单据类型
            List<SysCompanyTypePrintBill> printBillList = CompanyRedisUtil.getCompanyTypePrintBill(Integer.parseInt(ctId));
            if(printBillList == null || printBillList.size() == 0){
                // 如果redis查不到,从sysdb数据库查, 并将结果写入redis, 设置过期时间
                printBillList = sysCompanyTypePrintBillMapper.selectByCtId(Integer.parseInt(ctId));
                // 将数据放入redis缓存
                CompanyRedisUtil.putCompanyTypePrintBill(Integer.parseInt(ctId), printBillList,
                        CompanyDateUtil.getMillisecondByDayHourMinuteSecond(0,12,0,0) / 1000);  //默认过期时间2天

            }
            printBills.addAll(printBillList);
        }
        companyModePrintBill.setPrintMode(baseinfoCompany.getPrintMode());
        companyModePrintBill.setSysCompanyTypePrintBillList(new ArrayList<>(printBills));

        return companyModePrintBill;
    }

    @Override
    public int updatePrintConfigInfo(CompanyPrintConfigModel companyPrintConfigModel) {
        if (companyPrintConfigModel.getDO().getConfigId() == null) {
            throw new CompanyException(CompanyErrorCodeEnum.CONFIG_ID_IS_NULL);
        }
        return baseinfoCompanyPrintConfigMapper.updateByPrimaryKeySelective(companyPrintConfigModel.getDO());
    }

    @Override
    public int addPrintConfig(BaseinfoCompanyPrintConfig printConfig) {
        if (printConfig.getCompId() == null || printConfig.getCompId().equals(0l)) {
            throw new CompanyException(CompanyErrorCodeEnum.COMPANY_ID_IS_NULL);
        }
        if(printConfig.getBillType() == null){
            throw new CompanyException(CompanyErrorCodeEnum.BILL_TYPE_IS_NULL);
        }
        if(printConfig.getBillTypeCode() == null){
            throw new CompanyException(CompanyErrorCodeEnum.BILL_TYPE_CODE_IS_NULL);
        }
        return baseinfoCompanyPrintConfigMapper.insertSelective(printConfig);
    }

    @Override
    public int updateCompanyPrintMode(CompanyPrintModeBO companyPrintModeBO) {
        return baseinfoCompanyMapper.updateCompanyPrintMode(companyPrintModeBO);
    }
}
