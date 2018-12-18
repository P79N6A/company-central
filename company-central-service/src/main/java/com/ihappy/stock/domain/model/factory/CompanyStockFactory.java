package com.ihappy.stock.domain.model.factory;

import com.ihappy.communal.infrastructure.util.CompanyDateUtil;
import com.ihappy.communal.infrastructure.util.DistributedPrimaryKeyFactory;
import com.ihappy.stock.domain.bo.stock.StockInfoByPersonRoleDO;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.request.stock.StockAddReqDTO;
import com.ihappy.stock.domain.dto.request.stock.StockQueryReqDTO;
import com.ihappy.stock.domain.dto.request.stock.StockStatusReqDTO;
import com.ihappy.stock.domain.dto.request.stock.StockUpdateReqDTO;
import com.ihappy.stock.domain.dto.response.stock.StockRespDTO;
import com.ihappy.stock.domain.model.model.CompanyStockModel;
import com.ihappy.store.domain.bo.store.QueryStoreListByCompIdAndStoreIdsBO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunjd on 2018/4/16.
 */
public class CompanyStockFactory {
    public static List<StockRespDTO> modelListToStockRespDTOList(List<CompanyStockModel> companyStockModels){
        List<StockRespDTO> stockRespDTOS = new ArrayList<StockRespDTO>();
        for (CompanyStockModel obj : companyStockModels){
            StockRespDTO stockRespDTO = new StockRespDTO();
            BeanUtils.copyProperties(obj.getDO(),stockRespDTO);
            stockRespDTOS.add(stockRespDTO);
        }
        return stockRespDTOS;
    }

    public static CompanyStockModel stockAddReqDTOToModel(StockAddReqDTO dto){
        if (dto == null){
            return null;
        }
        BaseinfoCompanyStock obj = new BaseinfoCompanyStock();
        BeanUtils.copyProperties(dto,obj);
        obj.setCreatedAt(CompanyDateUtil.getDate14Long(dto.getUpdateTime()));
        obj.setUpdatedAt(CompanyDateUtil.getDate14Long(dto.getUpdateTime()));
        obj.setCreatedPersonId(dto.personId());
        obj.setCompId(Integer.parseInt(dto.userCompId().toString()));
        obj.setStockId(DistributedPrimaryKeyFactory.generateCompanyStockId(dto.userCompId()));
        obj.setIsDefault(dto.getIsDefault());
        //storeId为0表示公共仓库
        if(dto.getStoreId() == 0){
            obj.setStoreId(null);
            obj.setIsPublic(1);
        }
        return new CompanyStockModel(obj);
    }

    public static CompanyStockModel stockUpdateReqDTOToModel(StockUpdateReqDTO dto){
        if (dto == null){
            return null;
        }
        BaseinfoCompanyStock obj = new BaseinfoCompanyStock();
        BeanUtils.copyProperties(dto,obj);
        if (dto.getStoreId() != null){
            obj.setStoreId(Long.valueOf(dto.getStoreId()));
        }
        obj.setUpdatedAt(CompanyDateUtil.getDate14Long(dto.getUpdateTime()));
        obj.setUpdatedPersonId(dto.personId());
        obj.setCompId(Integer.parseInt(dto.userCompId().toString()));
        //storeId为0表示公共仓库
        if(dto.getStoreId() != null && dto.getStoreId() == 0){
            obj.setStoreId(0L);
            obj.setIsPublic(1);
        }
        if(dto.getStoreId() != null && dto.getStoreId() != 0){
            obj.setIsPublic(0);
        }
        return new CompanyStockModel(obj);
    }

    public static CompanyStockModel stockStatusReqDTOToModel(StockStatusReqDTO dto){
        if (dto == null){
            return null;
        }
        BaseinfoCompanyStock obj = new BaseinfoCompanyStock();
        obj.setStockId(dto.getStockId());
        obj.setForbidden(dto.getForbidden());

        obj.setUpdatedAt(CompanyDateUtil.getDate14Long(dto.getUpdateTime()));
        obj.setUpdatedPersonId(dto.personId());
        obj.setCompId(Integer.parseInt(dto.userCompId().toString()));

        return new CompanyStockModel(obj);
    }

    public static CompanyStockModel stockQueryReqDTOToModel(StockQueryReqDTO dto){
        if (dto == null){
            return null;
        }
        BaseinfoCompanyStock obj = new BaseinfoCompanyStock();
        obj.setStockId(dto.getStockId());
        obj.setCompId(Integer.parseInt(dto.userCompId().toString()));
        return new CompanyStockModel(obj);
    }

    public static StockRespDTO modelToStockRespDTO(CompanyStockModel model,String storeName){
        if (model == null){
            return null;
        }
        StockRespDTO dto = new StockRespDTO();
        BeanUtils.copyProperties(model.getDO(),dto);
        dto.setStoreName(storeName);
        return dto;
    }
    public static StockRespDTO modelToStockRespDTO(CompanyStockModel model){
        if (model == null){
            return null;
        }
        StockRespDTO dto = new StockRespDTO();
        BeanUtils.copyProperties(model.getDO(),dto);
        return dto;
    }
    public static StockRespDTO baseinfoCompanyStock2StockRespDTO(BaseinfoCompanyStock stock){
        StockRespDTO respDTO = new StockRespDTO();
        BeanUtils.copyProperties(stock,respDTO);
        return respDTO;
    }
    public static StockRespDTO baseinfoCompanyStock2StockRespDTO(BaseinfoCompanyStock stock,String storeName){
        StockRespDTO respDTO = new StockRespDTO();
        BeanUtils.copyProperties(stock,respDTO);
        respDTO.setStoreName(storeName);
        return respDTO;
    }
}
