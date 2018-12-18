package com.ihappy.partner.infrastructure.service.inside;

import com.ihappy.company.domain.model.model.CompanyModel;
import com.ihappy.partner.domain.bo.partner.PartnerBO;
import com.ihappy.partner.domain.bo.partner.PartnerMobileIsRepetitionBO;
import com.ihappy.partner.domain.bo.partner.QueryPartnerBO;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.ProviderInfoInsideQueryReqDTO;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.trade.domain.mq.OrderBaseMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by sunjd on 2018/4/3.
 */
public interface CompanyPartnerService {
    /**
     * 添加合作伙伴 初始化欠款流水
     * 必需入参 compId、partnerType
     * @param companyPartnerModel
     * @return
     */
    CompanyPartnerModel addPartner(CompanyPartnerModel companyPartnerModel);

    /**
     * 根据partnerId compId修改Partner
     * @param baseinfoCompanyPartner
     * @return
     */
    Integer updatePartner(BaseinfoCompanyPartner baseinfoCompanyPartner);

    Integer updateProvider(BaseinfoCompanyPartner baseinfoCompanyPartner);

    List<BaseinfoCompanyPartner> queryFavorList(BaseinfoCompanyPartner baseinfoCompanyPartner,Integer limit);

    List<BaseinfoCompanyPartner> queryLastContactList(BaseinfoCompanyPartner baseinfoCompanyPartner,Integer limit);

    List<CompanyPartnerModel> queryListByPartnerLevelId(Long partnerLevelId);

    Integer queryCountByPartnerLevelId(Long partnerLevelId);

    /**
     * 查询供应商
     * @param queryReqDTO
     * @return
     */
    CompanyPartnerModel getProviderInfoInsideQuery(ProviderInfoInsideQueryReqDTO queryReqDTO);

    /**
     * 添加零售会员
     * @param partner
     * @return
     */
    Integer addRetailCustomer(CompanyPartnerModel partner);

    /**
     * 编辑零售会员
     * @param partner
     * @return
     */
    Integer updateRetailCustomer(CompanyPartnerModel partner);


    /**
     * 查询单个Partner
     * @param partner
     * @return
     */
    CompanyPartnerModel queryPartner(CompanyPartnerModel partner);

    /**
     * 根据条件查询分页
     * @param partner
     * @return
     */
    List<CompanyPartnerModel> queryPartnerPageByCondition(CompanyPartnerModel partner);

    /**
     * 根据条件查询分页-总记录数
     * @param partner
     * @return
     */
    Integer queryPartnerPageByConditionCount(CompanyPartnerModel partner);
    /**
     * 根据公司id分页查询会员列表
     * @param queryPartnerBO
     * @return
     */
    List<CompanyPartnerModel> queryPartnerPageByCompId(QueryPartnerBO queryPartnerBO);

    /**
     * 根据公司id分页查询会员列表数量
     * @param queryPartnerBO
     * @return
     */
    Integer queryPartnerPageByCompIdCount(QueryPartnerBO queryPartnerBO);

     /**
       * @Description: 判断是否有默认供应商和客户, 没有就添加默认供应商和客户 
       * @Param:
       * @return:
       * @Author: zhangtengpo 
       * @Date: 2018/5/30
       */
    Boolean addDefaultPartner(CompanyModel companyModel);

    /**
     * 判断手机号是否重复
     * 当添加时 入参 mobile、partnerType、operate
     *   修改时 入参 compId、mobile、operate、partnerId、partnerType
     *   注：operate为null按照添加处理
     *       partnerType为null则不按照此类型匹配
     * @return true：重复  false：不重复
     */
    Boolean mobileIsRepetition(PartnerMobileIsRepetitionBO param);

    /**
     * 是否可编辑
     * @param partner
     */
    public void isCanEdit(BaseinfoCompanyPartner partner);

    /**
     * 查询Partner统计数据
     * @param partner
     * @return
     */
    public PartnerBO findPartnerStatistics(BaseinfoCompanyPartner partner);

    /**
     * 查询Partner对账分页列表
     * @param map
     * @return
     */
    public List<BaseinfoCompanyPartner> findPartnerCheckPage(Map<String,Object> map);

    /**
     * 查询Partner对账计数
     * @param map
     * @return
     */
    public Integer findPartnerCheckCount(Map<String,Object> map);

    /**
     * 强制更新Partner 无视 is_can_edit
     * @param partner
     * @return
     */
    public Integer forceUpdatePartner(BaseinfoCompanyPartner partner);

    /**
     * 根据条件查询
     * @param partner
     * @return
     */
    public List<BaseinfoCompanyPartner> selectByCondition(BaseinfoCompanyPartner partner);

    /**
     * @Author sunjd
     * @Description  更新Partner统计数据-入口部分
     * @Date 13:17 2018/9/30
     * @Param [message]
     * @return void
     **/
    public void updatePartnerStatistics(OrderBaseMessage message);
    /**
     * @Author sunjd
     * @Description 更新Partner统计数据-主逻辑
     * @Date 15:55 2018/10/9
     * @Param [requestId, startTime]
     * @return void
     **/
    public void updatePartnerStatistics(String requestId,Long startTime);
    /**
     * @Author sunjd
     * @Description 更新Partner统计数据-调用交易中心接口更新数据
     * @Date 15:56 2018/10/9
     * @Param [partnerId, orderType, compId]
     * @return void
     **/
    public void updatePartnerStatistics(Long partnerId, Integer orderType, Long compId);

    /**
     * 判断公司会员手机号是否重复
     * @param queryPartnerBO
     * @return
     */
    List<CompanyPartnerModel> checkMobileIsOrNotRepeat(QueryPartnerBO queryPartnerBO);

    /**
     *  查询合伙人
     * @param baseinfoCompanyPartner
     * @return
     */
    List<BaseinfoCompanyPartner> selectPartner(BaseinfoCompanyPartner baseinfoCompanyPartner);


}
