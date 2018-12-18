package com.ihappy.company.domain.dto.response.companyinfo;

import com.ihappy.common.domain.dto.BaseRespDTO;
import com.ihappy.company.common.enumtype.company.FactoryInfoFieldEnum;
import com.ihappy.gateway.dto.ICallResponseBaseDTO;

import java.util.List;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class FactoryInfosRespDTO extends BaseRespDTO {

    private static final long serialVersionUID = 441358212022261676L;
    //裁床数 cutbed_number
    private FactoryInfoRespDTO cutbedNumber;

    //后道数
    private FactoryInfoRespDTO backendNumber;

    //车间数
    private FactoryInfoRespDTO workshopNumber;


    //待入库数
    private FactoryInfoRespDTO onthewayNumber;



    public FactoryInfoRespDTO getCutbedNumber() {
        return cutbedNumber;
    }

    public void setCutbedNumber(FactoryInfoRespDTO cutbedNumber) {
        this.cutbedNumber = cutbedNumber;
    }

    public FactoryInfoRespDTO getBackendNumber() {
        return backendNumber;
    }

    public void setBackendNumber(FactoryInfoRespDTO backendNumber) {
        this.backendNumber = backendNumber;
    }

    public FactoryInfoRespDTO getWorkshopNumber() {
        return workshopNumber;
    }

    public void setWorkshopNumber(FactoryInfoRespDTO workshopNumber) {
        this.workshopNumber = workshopNumber;
    }

    public FactoryInfoRespDTO getOnthewayNumber() {
        return onthewayNumber;
    }

    public void setOnthewayNumber(FactoryInfoRespDTO onthewayNumber) {
        this.onthewayNumber = onthewayNumber;
    }


    public void init(List<FactoryInfoRespDTO> list){
        for(FactoryInfoRespDTO factoryInfoRespDTO : list ){
            if(factoryInfoRespDTO.getFiledCode().equals(FactoryInfoFieldEnum.CUTBED_BUMBER.getFieldCode())){
                cutbedNumber=factoryInfoRespDTO;
            }
            if(factoryInfoRespDTO.getFiledCode().equals(FactoryInfoFieldEnum.BACK_NUMBER.getFieldCode())){
                backendNumber=factoryInfoRespDTO;
            }
            if(factoryInfoRespDTO.getFiledCode().equals(FactoryInfoFieldEnum.ONTHEWAY_NUMBER.getFieldCode())){
                onthewayNumber=factoryInfoRespDTO;
            }
            if(factoryInfoRespDTO.getFiledCode().equals(FactoryInfoFieldEnum.WORKSHOP_NUMBER.getFieldCode())){
                workshopNumber=factoryInfoRespDTO;
            }
        }

    }


}
