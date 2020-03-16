package com.zss.router;

import com.zss.service.IModelService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ModelRouter implements InitializingBean {

    private final Map<Integer, IModelService> modelServiceMap = new ConcurrentHashMap<>();

    @Autowired
    private List<IModelService> serviceList;

    @Override
    public void afterPropertiesSet() throws Exception {
        for (IModelService service : serviceList){
            modelServiceMap.put(service.getModel(), service);
        }
    }

    public IModelService queryService(int model){
        return modelServiceMap.get(model);
    }
}
