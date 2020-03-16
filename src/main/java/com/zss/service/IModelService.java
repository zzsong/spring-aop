package com.zss.service;

public interface IModelService {

    int getModel();

    void analysis(int reportDate, int batch);

    int runTask(int reportDate);
}
