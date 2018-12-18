package com.ihappy.store.application.process.write.store;

import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.communal.application.process.DefaultQueryProcess;
import com.ihappy.communal.application.process.IProcess;
import com.ihappy.company.common.enumtype.CompanyErrorCodeEnum;
import com.ihappy.company.exception.CompanyException;
import com.ihappy.store.domain.dto.request.store.EnableStoreReqDTO;
import com.ihappy.store.domain.dto.response.store.DisableStoreRespDTO;
import com.ihappy.store.domain.dto.response.store.EnableStoreRespDTO;
import com.ihappy.store.domain.model.factory.store.CompanyStoreFactory;
import com.ihappy.store.domain.model.model.store.CompanyStoreModel;
import com.ihappy.store.infrastructure.service.inside.CompanyStoreService;
import javafx.beans.DefaultProperty;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * *@created by zhangmengdan
 * *@created at 2018/10/16 13:13
 * *@content启用门店
 **/
public class EnableStoreProcess extends DefaultProcess<EnableStoreReqDTO, EnableStoreRespDTO> {
    @Autowired
    private CompanyStoreService companyStoreService;
    @Override
    public void process(Context<EnableStoreReqDTO, EnableStoreRespDTO> context) {
        EnableStoreReqDTO enableStoreReqDTO=context.getParam();
        //根据公司id和门店id查询门店信息
        CompanyStoreModel companyStoreModel=companyStoreService.findByStoreIdAndCompId(CompanyStoreFactory.enableStoreReqDTOToCompanyStoreModel(enableStoreReqDTO));
        //判断门店是否存在或已被删除
        if (companyStoreModel == null){
            throw new CompanyException(CompanyErrorCodeEnum.STORE_IS_NOT_EXIT_OR_DELETED);
        }
        //判断门店已是否被禁用
        if (companyStoreModel.getDO().getForbidden() == 1){
            //将门店启用
            int disableStore=companyStoreService.modifyStoreState(CompanyStoreFactory.enableStoreReqDTOToStoreInfoBO(enableStoreReqDTO));
        }
        EnableStoreRespDTO enableStoreRespDTO=new EnableStoreRespDTO();
        enableStoreRespDTO.setMessage("启用成功");
        context.getResult().setModule(enableStoreRespDTO);
    }
}
