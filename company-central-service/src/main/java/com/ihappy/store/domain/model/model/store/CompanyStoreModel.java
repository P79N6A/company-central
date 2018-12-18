package com.ihappy.store.domain.model.model.store;

import com.ihappy.communal.domain.model.BaseModel;
import com.ihappy.store.domain.dbdo.store.BaseinfoCompanyStore;
import com.ihappy.store.domain.dto.response.BankInfoRespDTO;
import com.ihappy.store.domain.dto.response.store.StoreInfoByLoginQueryRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.user.common.util.AttributeUtil;
import com.yx.eweb.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/10.
 */
public class CompanyStoreModel extends BaseModel<BaseinfoCompanyStore> {
    private BaseinfoCompanyStore baseinfoCompanyStore;
    public CompanyStoreModel(){
        super(null);
    }
    public CompanyStoreModel(BaseinfoCompanyStore dbobj) {
        super(dbobj);
        baseinfoCompanyStore = dbobj;
    }

    public CompanyStoreModel(BaseinfoCompanyStore doObject, BaseinfoCompanyStore baseinfoCompanyStore) {
        super(doObject);
        this.baseinfoCompanyStore = baseinfoCompanyStore;
    }

    public Long getStoreId() {
        return baseinfoCompanyStore.getStoreId();
    }

    public void setAttributes(Map<String, String> attributes) {
        if (attributes != null) {
            this.getDO().setAttributes(AttributeUtil.toString(attributes));
        }
    }

    public void removeAtrributes(String key) {
        Map<String, String> map = AttributeUtil.fromString(this.getDO().getAttributes());
        map.remove(key);
        this.getDO().setAttributes(AttributeUtil.toString(map));
    }

    public String getAtrributes(String key) {
        Map<String, String> map = AttributeUtil.fromString(this.getDO().getAttributes());
        return map.get(key);
    }

    public void addAttributes(String key, String val) {
        Map<String, String> map = AttributeUtil.fromString(this.getDO().getAttributes());
        map.put(key, val);
        this.getDO().setAttributes(AttributeUtil.toString(map));
    }

    public String getWeshopName() {
        if (StringUtil.isBlank(this.getDO().getWeshopName())) {
            return this.getDO().getStoreName();
        } else {
            return this.getDO().getWeshopName();
        }
    }

    public StoreInfoByLoginQueryRespDTO toStoreInfoByLoginQueryRespDTO() {
        return CompanyStoreFactory.toStoreInfoByLoginQueryRespDTO(this.getDO());
    }

    public List<BankInfoRespDTO> getBankInfo(){
        return null;
    }

    public  String getStoreName() {
        return getDO().getStoreName();
    }
}
