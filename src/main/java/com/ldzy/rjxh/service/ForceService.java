package com.ldzy.rjxh.service;

import com.github.pagehelper.PageInfo;
import com.ldzy.rjxh.model.Force;
import org.springframework.stereotype.Service;

/**
 * @Auction:XWD
 * @Data:2022/5/26
 * @Description: ${向文定_测试版本}
 * @version:1.0
 */
@Service
public interface ForceService {

    default Force findForce(Force force){
        return null;
    }

    default void insertForce(Force force){}

    default void updateForce(Force force){}

    default void deleteForce(Force force){
    }

    default PageInfo<Force> findForces(Force force ,int pageNum, int pageSize){
        return null;
    }

    default PageInfo<Force> findForceState(Force force ,int pageNum, int pageSize){
        return null;
    }

}
