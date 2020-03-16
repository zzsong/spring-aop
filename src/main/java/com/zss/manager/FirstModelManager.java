package com.zss.manager;


import org.springframework.stereotype.Component;

@Component
public class FirstModelManager extends  AbstractModelManager {
    @Override
    public int getModel() {
        return 1;
    }

    @Override
    public void analysis(int reportDate, int batch) {
        int model = getModel();
        System.out.println("===first==analysis=>"+model);
    }
}
