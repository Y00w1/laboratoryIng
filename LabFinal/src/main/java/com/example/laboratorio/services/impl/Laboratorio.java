package com.example.laboratorio.services.impl;

import com.example.laboratorio.SceneController;
import com.example.laboratorio.services.ElementService;
import com.example.laboratorio.services.SceneService;
import com.example.laboratorio.services.UserService;

public class Laboratorio {
    private final ElementService elementService;
    private final UserService userService;
    private final SceneService sceneService;

    public Laboratorio(){
        elementService = new ElementServiceImpl();
        sceneService = new SceneController();
        userService = new StudentServiceImpl();
    }
    public UserService getUserService() {return userService;}
    public ElementService getElementService() {return elementService;}
    public SceneService getSceneService() {return sceneService;}

}
