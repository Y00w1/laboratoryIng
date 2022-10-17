package com.example.laboratorio.services;

import com.example.laboratorio.model.Element;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import java.io.IOException;

public interface ModelFactoryControllerService {
    void buttonAddE(String name, Integer amount, String material, Double price);
    ObservableList<Element> getObservableListElement ();

    void btnAddStudent(String id, String name, String email, String number, String career, Integer semester);

    void switchScene(ActionEvent e, String resource) throws IOException;
    void switchToStudentScene(ActionEvent e) throws IOException;
    void switchToElementScene(ActionEvent e) throws IOException;
    void switchToLoanScene(ActionEvent e) throws IOException;
}
