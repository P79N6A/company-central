package com.ihappy.communal.application.process.write;

import com.ihappy.common.domain.dto.BaseReqDTO;
import com.ihappy.communal.application.Context;
import com.ihappy.communal.application.process.DefaultProcess;
import com.ihappy.company.common.utils.CompanyRedisUtil;
import com.ihappy.myredis.MyRedis;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : zhangtengpo
 * @Description :
 * @create : 18-10-19 上午11:14
 */
public class DeleteRedisProcess extends DefaultProcess<BaseReqDTO, String> {
    @Autowired
    private MyRedis myRedis;

    @Override
    public void process(Context<BaseReqDTO, String> context) {
        // 删除打印设置
        myRedis.del(CompanyRedisUtil.COMPANY_TYPE_PRINT_BILL_PREFIX + 1);
        myRedis.del(CompanyRedisUtil.COMPANY_TYPE_PRINT_BILL_PREFIX + 2);
        myRedis.del(CompanyRedisUtil.COMPANY_TYPE_PRINT_BILL_PREFIX + 3);
    }
}
