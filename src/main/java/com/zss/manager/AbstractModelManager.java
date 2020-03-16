package com.zss.manager;

import com.zss.service.IModelService;
import org.springframework.aop.framework.AopContext;

public abstract class AbstractModelManager implements IModelService {

    public int runTask(int reportDate){
        System.out.println("-abstract----"+reportDate);
        ((IModelService) AopContext.currentProxy()).analysis(reportDate, 99999);
        return 0;
    }
}
