package com.ihappy.company.application.process.write;

import com.alibaba.fastjson.JSON;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.infrastructure.util.StrUtil;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.domain.dto.request.CompanyBrandsDelReqDTO;
import com.ihappy.company.domain.model.factory.CompanyBrandFactory;
import com.ihappy.company.domain.model.model.CompanyBrandModel;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.company.infrastructure.repo.mybatis.mapper.comp.BaseinfoCompanyBrandMapper;
import com.ihappy.item.domain.dto.request.goods.ItemGoodsListConditionQueryDTO;
import com.ihappy.item.domain.dto.response.goods.ItemGoodsInfoListConditionRespDTO;
import com.ihappy.item.infrastructure.service.ItemGoodsInfoRpcService;
import com.ihappy.unifiedLog.module.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunjd on 2018/4/16.
 */
public class DelCompanyBrandsProcess extends DefaultProcess<CompanyBrandsDelReqDTO, String> {
    @Autowired
    private BaseinfoCompanyBrandMapper baseinfoCompanyBrandMapper;
    @Autowired
    private ItemGoodsInfoRpcService itemGoodsInfoRpcServiceClient;

    @Override
    public void process(Context<CompanyBrandsDelReqDTO, String> context) {
        CompanyBrandsDelReqDTO companyBrandsDelReqDTO = context.getParam();
        if (StringUtils.isEmpty(companyBrandsDelReqDTO.getBrandIds())){
            throw new CompanyException(CompanyErrorCodeEnum.
                    NO_COMPANY_BRAND_SELECT_ERROR.getErrCode(),
                    CompanyErrorCodeEnum.NO_COMPANY_BRAND_SELECT_ERROR.getErrMsg());
        }

        CompanyBrandModel companyBrandModel = CompanyBrandFactory.companyBrandsDelReqDTODTOToModel(companyBrandsDelReqDTO);

        ItemGoodsListConditionQueryDTO itemGoodsListConditionQueryDTO = new ItemGoodsListConditionQueryDTO();
        itemGoodsListConditionQueryDTO.setBrandIds(companyBrandsDelReqDTO.getBrandIds());
        itemGoodsListConditionQueryDTO.setCompId(Long.parseLong(companyBrandModel.getDO().getCompId().toString()));

        //过滤掉已被商品使用的品牌
        Result<List<ItemGoodsInfoListConditionRespDTO>> goods = itemGoodsInfoRpcServiceClient.findGoodsInfoListByCondition(itemGoodsListConditionQueryDTO);
        String brandIdsStr = companyBrandsDelReqDTO.getBrandIds();
        if (goods != null && goods.getModule() != null && goods.getModule().size() > 0){
            for (ItemGoodsInfoListConditionRespDTO obj : goods.getModule()){
                brandIdsStr = StrUtil.replaceInSet(brandIdsStr,obj.getBrandId().toString(),",");
            }
        }

        List<String> brandIdsStrList =  java.util.Arrays.asList(brandIdsStr.split(","));
        List<Integer> brandIds = new ArrayList<Integer>();

        for(String str : brandIdsStrList) if(!str.equals("")) brandIds.add(Integer.parseInt(str));
        Integer res = 0;
        if (brandIds.size() > 0){
            res = baseinfoCompanyBrandMapper.updateDeletedByBrandIds(companyBrandModel.getDO(),brandIds);
            if(res < 1){
                throw new CompanyException(CompanyErrorCodeEnum.
                        DELETE_COMPANY_BRAND_ERROR.getErrCode(),
                        CompanyErrorCodeEnum.DELETE_COMPANY_BRAND_ERROR.getErrMsg());
            }
        }
        if(goods != null && goods.getModule() != null && goods.getModule().size() > 0){
            throw new CompanyException(CompanyErrorCodeEnum.
                    CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS.getErrCode(),
                    CompanyErrorCodeEnum.CAN_NOT_DELETE_COMPANY_BRAND_USE_BY_GOODS.getErrMsg());
        }else{
            context.getResult().setModule("删除成功");
        }
    }

    public static void main(String[] args) {
        List<Integer> goods = new ArrayList<Integer>(Arrays.asList(1,3,5,6,12,11));

        String brandIdsStr = "1,2,3,4,5,6,7,8,9,10,11,12";
        if (goods != null && goods.size() > 0){
            for (Integer obj : goods){
                brandIdsStr = brandIdsStr.replace(obj.toString(),"");
            }
        }
        List<String> brandIdsStrList =  java.util.Arrays.asList(brandIdsStr.split(","));
        List<Integer> brandIds = new ArrayList<Integer>();
        for(String str : brandIdsStrList) if(!str.equals("")) brandIds.add(Integer.parseInt(str));
        System.out.println(JSON.toJSONString(brandIdsStrList));

        System.out.println("1,2,3,4,5,6,7,8,9,10,11,12".replace("1",""));
    }
}
