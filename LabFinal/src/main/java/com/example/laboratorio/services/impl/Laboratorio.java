package com.example.laboratorio.services.impl;

import com.example.laboratorio.SceneController;
import com.example.laboratorio.services.*;

public class Laboratorio {
    private final ElementService elementService;
    private final UserService userService;
    private final SceneService sceneService;
    private final LoanService loanService;
    private final MonitorService monitorService;

    public Laboratorio(){
        elementService = new ElementServiceImpl();
        sceneService = new SceneController();
        userService = new StudentServiceImpl();
        loanService = new LoanServiceImpl();
        monitorService = new MonitorServiceImpl();
    }
    public UserService getUserService() {return userService;}
    public ElementService getElementService() {return elementService;}
    public SceneService getSceneService() {return sceneService;}
    public LoanService getLoanService(){return loanService;}
    public MonitorService getMonitorService(){return monitorService;}
}
