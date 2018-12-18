package com.ihappy.stock.infrastructure.service.inside;

import com.ihappy.stock.domain.bo.stock.StockBO;
import com.ihappy.stock.domain.bo.stock.StockInfoByPersonRoleDO;
import com.ihappy.stock.domain.dbdo.BaseinfoCompanyStock;
import com.ihappy.stock.domain.dto.response.stock.StockBasicInfoRespDTO;
import com.ihappy.stock.domain.model.model.CompanyStockModel;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/16.
 */
public interface StockService {
    /**
     * 添加仓库
     * @param stock
     * @return
     */
    int addStock(BaseinfoCompanyStock stock);

    /**
     * 添加默认仓库,和默认公共仓库
     * compId
     * storeId
     * @param model
     * @return
     */
    Boolean addDefStockAndPublicDefStock(CompanyStockModel model);
    /**
     * 添加默认仓库
     * 参数
     * compId
     * storeId
     * @param model
     * @return
     */
    Boolean addDefStock(CompanyStockModel model);

    /**
     * 添加公共仓库
     * @param model
     * @return
     */
    Boolean addPublicStock(CompanyStockModel model);
    /**
     * compId 公司id
     * isPublic 是否公共仓库  1：公共仓库  0：非公共仓库  null:全部
     * forbidden 禁用 1 禁用 0未禁用  null:全部
     * storeIds 门店id列表
     * stockIds 仓库id列表
     * @param map
     * @return
     */
    List<CompanyStockModel> findStockListByConditon(Map<String,Object> map);

    List<CompanyStockModel> findStockListByConditonWithStoreInfo(Map<String,Object> map);

    List<CompanyStockModel> findStockListByStoreIdList(Map<String,Object> map);

    List<CompanyStockModel> findNotPublicStockListByCompIdAndStoreIds(Integer compId,List<Long> storeIds,String stockName,Integer forbidden);

    List<CompanyStockModel> findNotPublicStockListByCompId(Integer compId,String stockName,Integer forbidden);

    List<CompanyStockModel> findPublicStockListByCompId(Integer compId,String stockName,Integer forbidden);

    List<CompanyStockModel> findStockListByIds(List<Long> stockIds);

    Integer updateStockInventorying(StockBO stockBO);

    Integer clearStockInventorying(StockBO stockBO);

    /**
     * 根据用户身份获取管辖下的仓库
     * @param stockInfoByPersonRoleDO
     * @return
     */
    List<StockBasicInfoRespDTO> getStockListByPersonRole(StockInfoByPersonRoleDO stockInfoByPersonRoleDO);

    List<CompanyStockModel> findByConditionSelective(CompanyStockModel condition);
}
