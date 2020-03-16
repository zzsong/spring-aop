package com.zss.service.impl;

import com.zss.service.IModelService;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

@Service
public class ThirdModelServiceImpl implements IModelService {
    @Override
    public int getModel() {
        return 3;
    }

    @Override
    public void analysis(int reportDate, int batch) {
        int model = getModel();
        System.out.println("=====third===analysis==>"+model);
    }

    @Override
    public int runTask(int reportDate) {
        System.out.println("==========third=====runTask=======");
        ((IModelService)AopContext.currentProxy()).analysis(reportDate, 1);
        return 3;
    }
}
