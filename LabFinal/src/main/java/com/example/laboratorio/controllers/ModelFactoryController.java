package com.example.laboratorio.controllers;
import com.example.laboratorio.model.Element;
import com.example.laboratorio.services.ModelFactoryControllerService;
import com.example.laboratorio.services.impl.Laboratorio;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

public class ModelFactoryController implements ModelFactoryControllerService {

    Laboratorio laboratorio;

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        laboratorio = new Laboratorio();
    }
    //Cambios de escena

    @Override
    public void switchScene(ActionEvent e, String resource) throws IOException {

        laboratorio.getSceneService().switchScene(e,resource);

    }

    @Override
    public void switchToLoanScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToLoanScene(e);

    }

    @Override
    public void switchToElementScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToElementScene(e);

    }

    @Override
    public void switchToStudentScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToStudentScene(e);
    }

    //Funcion Elementos
    @Override
    public void buttonAddE(String name,Integer amount,String material,Double price){
        laboratorio.getElementService().buttonAddE(name,amount,material,price);
    }
    @Override
    public ObservableList<Element> getObservableListElement (){
        return laboratorio.getElementService().getObservableListElement();
    }

    //Funcion Student
    @Override
    public void btnAddStudent(String id, String name, String email, String number, String career, Integer semester){
        laboratorio.getUserService().addStudent(id, name, email, number,  career, semester);
    }
}
