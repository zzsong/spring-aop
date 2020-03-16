package com.zss.manager;

import org.springframework.stereotype.Component;

@Component
public class SecondModelManager extends AbstractModelManager {
    @Override
    public int getModel() {
        return 2;
    }

    @Override
    public void analysis(int reportDate, int batch) {
        int model = getModel();
        System.out.println("=====second==analysis=>"+model);
    }
}
