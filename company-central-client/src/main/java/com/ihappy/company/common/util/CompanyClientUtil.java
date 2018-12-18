package com.ihappy.company.common.util;

import com.ihappy.company.common.enumtype.company.FactoryInfoFieldEnum;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfoRespDTO;
import com.ihappy.company.domain.dto.response.companyinfo.FactoryInfosRespDTO;
import com.sun.naming.internal.FactoryEnumeration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renyueliang on 2018/8/9.
 */
public class CompanyClientUtil {

    private static List<FactoryInfoRespDTO> listFactoryInfoRespDTO=new ArrayList<>();

    private static FactoryInfosRespDTO factoryInfosRespDTO =new FactoryInfosRespDTO();

    static {

        FactoryInfoRespDTO bedCutNumber = new FactoryInfoRespDTO();

        bedCutNumber.setEnable(true);
        bedCutNumber.setFiledCode(FactoryInfoFieldEnum.CUTBED_BUMBER.getFieldCode());
        bedCutNumber.setFiledName(FactoryInfoFieldEnum.CUTBED_BUMBER.getFieldName());

        listFactoryInfoRespDTO.add(bedCutNumber);
        factoryInfosRespDTO.setCutbedNumber(bedCutNumber);


        FactoryInfoRespDTO backendNumber = new FactoryInfoRespDTO();
        backendNumber.setEnable(true);
        backendNumber.setFiledCode(FactoryInfoFieldEnum.BACK_NUMBER.getFieldCode());
        backendNumber.setFiledName(FactoryInfoFieldEnum.BACK_NUMBER.getFieldName());

        listFactoryInfoRespDTO.add(backendNumber);
        factoryInfosRespDTO.setBackendNumber(backendNumber);


        FactoryInfoRespDTO workshopNumber = new FactoryInfoRespDTO();
        workshopNumber.setEnable(true);
        workshopNumber.setFiledCode(FactoryInfoFieldEnum.WORKSHOP_NUMBER.getFieldCode());
        workshopNumber.setFiledName(FactoryInfoFieldEnum.WORKSHOP_NUMBER.getFieldName());

        listFactoryInfoRespDTO.add(workshopNumber);
        factoryInfosRespDTO.setWorkshopNumber(workshopNumber);

        FactoryInfoRespDTO onthewayNumber = new FactoryInfoRespDTO();
        onthewayNumber.setEnable(true);
        onthewayNumber.setFiledCode(FactoryInfoFieldEnum.ONTHEWAY_NUMBER.getFieldCode());
        onthewayNumber.setFiledName(FactoryInfoFieldEnum.ONTHEWAY_NUMBER.getFieldName());

        listFactoryInfoRespDTO.add(onthewayNumber);
        factoryInfosRespDTO.setOnthewayNumber(onthewayNumber);


    }

    public static List<FactoryInfoRespDTO> getListFactoryInfoRespDTO() {
        return listFactoryInfoRespDTO;
    }

    public static FactoryInfosRespDTO getFactoryInfosRespDTO() {
        return factoryInfosRespDTO;
    }
}
