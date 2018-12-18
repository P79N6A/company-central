package com.ihappy.company.domain.model.model;

import com.alibaba.fastjson.JSON;
import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.common.util.CollectionUtil;
import com.ihappy.common.util.StringUtil;
import com.ihappy.company.common.constants.CompanyConstant;
import com.ihappy.company.common.util.CompanyClientUtil;
import com.ihappy.company.common.utils.AttributeUtil;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.company.domain.dbdo.BaseinfoCompany;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfosRespDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/2.
 */
public class CompanyModel extends BaseModel<BaseinfoCompany> {

    private BaseinfoCompany baseinfoCompany;

    public CompanyModel() {
        super(null);
    }

    public CompanyModel(BaseinfoCompany baseinfoCompany) {
        super(baseinfoCompany);
       this.baseinfoCompany = baseinfoCompany;
    }

    public BaseinfoCompany getBaseinfoCompany() {
        return baseinfoCompany;
    }

    public void setBaseinfoCompany(BaseinfoCompany baseinfoCompany) {
        this.baseinfoCompany = baseinfoCompany;
    }

    public Long getAdminPersonId(){
        return baseinfoCompany.getAdminPersonId();
    }

    public Integer getCompId(){
        return baseinfoCompany.getCompId();
    }

    //0:付费;1:永久
    public Integer getExpireStatus(){
        return baseinfoCompany.getExpireStatus();
    }

    public Long getExpireDate(){
        return baseinfoCompany.getExpireDate();
    }

    public void addAttributes(String key,String val){
        baseinfoCompany.getAttributesMap().put(key,val);
    }

    public String getFactoryInfoInAttributes(){
        return baseinfoCompany.getAttributesMap().get(CompanyConstant.FACTORY_INFO_KEY);
    }

    public void addFactoryInfoInAttributes(String factoryInfo){
        baseinfoCompany.getAttributesMap().put(CompanyConstant.FACTORY_INFO_KEY,factoryInfo);
    }

    public void setAttributes(Map<String, String> attributes) {
        if(attributes != null){
            baseinfoCompany.setAttributes(AttributeUtil.toString(attributes));
        }
    }

    public void removeAtrributes(String key){
        baseinfoCompany.getAttributesMap().remove(key);
    }

    public void factoryInfoPutRedis(){
        String factoryInfo = getFactoryInfoInAttributes();
        if(StringUtil.isBlank(factoryInfo)){
            return ;
        }

        CompanyRedisUtil.putFactoryInfoInRedis(factoryInfo,getCompId().toString());
    }


    public List<FactoryInfoRespDTO> getListFactoryInfoRespDTO(){
        String json =  getFactoryInfoInAttributes();
        if(StringUtil.isBlank(json)){
            return CompanyClientUtil.getListFactoryInfoRespDTO();
        }

        List<FactoryInfoRespDTO> list =  JSON.parseArray(json,FactoryInfoRespDTO.class);

        return list;
    }


    public FactoryInfosRespDTO getFactoryInfosRespDTO(){
        List<FactoryInfoRespDTO> list = getListFactoryInfoRespDTO();
        if(CollectionUtil.isEmpty(list)){
            return CompanyClientUtil.getFactoryInfosRespDTO();
        }
        FactoryInfosRespDTO factoryInfosRespDTO =new FactoryInfosRespDTO();

        factoryInfosRespDTO.init(list);

        return factoryInfosRespDTO;

    }

    public String getCompName() {
        return getDO().getCompName();
    }
}
