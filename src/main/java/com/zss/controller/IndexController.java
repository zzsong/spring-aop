package com.zss.controller;

import com.zss.router.ModelRouter;
import com.zss.service.IModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private ModelRouter modelRouter;

    @Autowired
    @Qualifier("thirdModelServiceImpl")
    private IModelService thirdModelService;

    @RequestMapping(value = {"","/index"})
    public String index(){
//        modelRouter.queryService(1).analysis(20200316,1);
//        modelRouter.queryService(2).analysis(20200316,1);
        System.out.println("=====controller====");
        modelRouter.queryService(2).runTask(20200101);

//        thirdModelService.runTask(20200301);
        return "ok";
    }



}
