package com.ihappy.partner.application.process.write.partner;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.partner.common.enumtype.PartnerErrorCodeEnum;
import com.ihappy.partner.domain.dbdo.BaseinfoCompanyPartner;
import com.ihappy.partner.domain.dto.request.partner.PartnerQueryOrAddReqDTO;
import com.ihappy.partner.domain.dto.response.partner.PartnerInfoQueryRespDTO;
import com.ihappy.partner.domain.model.factory.BaseInfoCompanyPartnerFactory;
import com.ihappy.partner.domain.model.model.CompanyPartnerModel;
import com.ihappy.partner.exception.PartnerException;
import com.ihappy.partner.infrastructure.service.inside.CompanyPartnerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: company-central
 * @description: ${description}
 * @author: wangzheng
 * @create: 2018-11-01 20:06
 **/
public class PartnerQueryOrAddProcess extends DefaultProcess<PartnerQueryOrAddReqDTO, PartnerInfoQueryRespDTO> {

    @Autowired
    CompanyPartnerService companyPartnerService;
    @Override
    public void process(Context<PartnerQueryOrAddReqDTO, PartnerInfoQueryRespDTO> context) {
        PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO = context.getParam();
        Integer type = partnerQueryOrAddReqDTO.getType();
        BaseinfoCompanyPartner baseinfoCompanyPartner;
        if(type != null && type == 1){
            baseinfoCompanyPartner = queryOrAddPartnerTypeUp(partnerQueryOrAddReqDTO);
        } else if(type != null && type == 2){
            baseinfoCompanyPartner = queryOrAddPartnerTypeDown(partnerQueryOrAddReqDTO);
        }
        else {
            throw new PartnerException(PartnerErrorCodeEnum.ILLGAL_ARGUMENT);
        }
        PartnerInfoQueryRespDTO partnerInfoQueryRespDTO = BaseInfoCompanyPartnerFactory.partner2PartnerInfoQueryRespDTO(baseinfoCompanyPartner);
        context.setResultModule(partnerInfoQueryRespDTO);

    }
    private List<BaseinfoCompanyPartner> queryPartnerByPartnerCompId(Integer partnerType,Integer compId, Integer partnerCompId,String mobile){
        BaseinfoCompanyPartner partnerQueryDTO = new BaseinfoCompanyPartner();
        partnerQueryDTO.setCompId(compId);
        partnerQueryDTO.setPartnerCompId(partnerCompId);
        partnerQueryDTO.setPartnerType(partnerType);
        partnerQueryDTO.setMobile(mobile);
        return companyPartnerService.selectPartner(partnerQueryDTO);
    }

    private BaseinfoCompanyPartner addAndQueryPartner(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO){
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setPartnerType(partnerQueryOrAddReqDTO.getPartnerType());
        baseinfoCompanyPartner.setMobile(partnerQueryOrAddReqDTO.getMobile());
        baseinfoCompanyPartner.setCompId(partnerQueryOrAddReqDTO.getCompId().intValue());
        baseinfoCompanyPartner.setPartnerCompId(partnerQueryOrAddReqDTO.getPartnerCompId().intValue());
        CompanyPartnerModel companyPartnerModel = new CompanyPartnerModel(baseinfoCompanyPartner);
        companyPartnerService.addPartner(companyPartnerModel);
        return companyPartnerModel.getDO();
    }

    /**
     *  下游客户新建合伙人
     *  查询partner 根据compId，partnerCompId，partType
     *  无则新建
     *  有匹配手机号，不相同修改为新的手机号。
     *  返回结果
     * @return
     */
    private BaseinfoCompanyPartner queryOrAddPartnerTypeDown(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO){
        List<BaseinfoCompanyPartner> partnerList
                = queryPartnerByPartnerCompId(partnerQueryOrAddReqDTO.getPartnerType(),partnerQueryOrAddReqDTO.getCompId().intValue(),partnerQueryOrAddReqDTO.getPartnerCompId().intValue(),null);
        //不存在合伙人
        if(partnerList == null || partnerList.size() <= 0){
           return addAndQueryPartner(partnerQueryOrAddReqDTO);
        }
        else{
            //取第一条记录
            BaseinfoCompanyPartner baseinfoCompanyPartner = partnerList.get(0);
            if(baseinfoCompanyPartner.getMobile() != null && baseinfoCompanyPartner.getMobile().equals(partnerQueryOrAddReqDTO.getMobile())){
                return baseinfoCompanyPartner;
            }
            //更新手机号
            else {
                boolean result = updatePartner(partnerQueryOrAddReqDTO.getMobile(),baseinfoCompanyPartner.getCompId(),baseinfoCompanyPartner.getPartnerId(),null);
                if(result){
                    baseinfoCompanyPartner.setMobile(baseinfoCompanyPartner.getBankAccountName());
                    return baseinfoCompanyPartner;
                }
                else{
                    throw new PartnerException(PartnerErrorCodeEnum.QUERY_PARTNER_IS_FAIL);
                }
            }
        }
    }

    /**
     * 上游供应商新建客户
     * 查询partner（根据compId,partnerCompId,partnerType）
     * 有（返回）
     * 无；再次查询（根据compId，mobile，partnerType）
     * 无：插入新的记录
     * 有；更新客户（partnerCompId字段）
     *
     * @param partnerQueryOrAddReqDTO
     * @return
     */
    private BaseinfoCompanyPartner queryOrAddPartnerTypeUp(PartnerQueryOrAddReqDTO partnerQueryOrAddReqDTO){
        List<BaseinfoCompanyPartner> partnerList
                = queryPartnerByPartnerCompId(partnerQueryOrAddReqDTO.getPartnerType(),partnerQueryOrAddReqDTO.getCompId().intValue(),partnerQueryOrAddReqDTO.getPartnerCompId().intValue(),null);
        if(partnerList == null || partnerList.size() <= 0){
            partnerList
                    = queryPartnerByPartnerCompId(partnerQueryOrAddReqDTO.getPartnerType(),partnerQueryOrAddReqDTO.getCompId().intValue(),null,partnerQueryOrAddReqDTO.getMobile());
            if(partnerList == null || partnerList.size() <= 0) {
                return addAndQueryPartner(partnerQueryOrAddReqDTO);
            }
            else {
                BaseinfoCompanyPartner baseinfoCompanyPartner = partnerList.get(0);
                boolean result = updatePartner(null,baseinfoCompanyPartner.getCompId(),baseinfoCompanyPartner.getPartnerId(),partnerQueryOrAddReqDTO.getPartnerCompId().intValue());
                if(result){
                    baseinfoCompanyPartner.setPartnerCompId(partnerQueryOrAddReqDTO.getPartnerCompId().intValue());
                    return baseinfoCompanyPartner;
                }
                else{
                    throw new PartnerException(PartnerErrorCodeEnum.QUERY_PARTNER_IS_FAIL);
                }
            }
        }
        else {
            return partnerList.get(0);
        }
    }


    /**
     *   更新合伙人信息
     * @param mobile
     * @param compId
     * @param partnerId
     * @param partnerCompId
     * @return
     */
    private boolean updatePartner(String mobile,Integer compId,Long partnerId,Integer partnerCompId){
        BaseinfoCompanyPartner baseinfoCompanyPartner = new BaseinfoCompanyPartner();
        baseinfoCompanyPartner.setCompId(compId);
        baseinfoCompanyPartner.setPartnerId(partnerId);
        baseinfoCompanyPartner.setPartnerCompId(partnerCompId);
        baseinfoCompanyPartner.setMobile(mobile);
        Integer row = companyPartnerService.updatePartner(baseinfoCompanyPartner);
        if(row == null || row != 1){
            return false;
        }
        else {
            return true;
        }

    }

}