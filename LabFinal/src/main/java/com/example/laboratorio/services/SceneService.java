package com.example.laboratorio.services;

import javafx.event.ActionEvent;

import java.io.IOException;

public interface SceneService {
    void switchScene(ActionEvent e, String resource) throws IOException;
    void switchToStudentScene(ActionEvent e) throws IOException;
    void switchToElementScene(ActionEvent e) throws IOException;
    void switchToLoanScene(ActionEvent e) throws IOException;
}
