package com.example.laboratorio.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class InformationController {
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private TextArea textView;

    @FXML
    void elementChange(ActionEvent event) throws IOException {
        mfc.switchToElementScene(event);
    }
    @FXML
    void loanChange(ActionEvent event)throws IOException{
        mfc.switchToLoanScene(event);
    }

    @FXML
    void studentChange(ActionEvent event) throws IOException{
        mfc.switchToStudentScene(event);
    }

    @FXML
    void monitorInfo(ActionEvent event) {
        textView.setText("Nombre: " + mfc.monitorInformation().getName()+
                "  Id: "+mfc.monitorInformation().getId()+
                "  Loans: "+mfc.monitorInformation().getLoans());
    }

    @FXML
    void studentMaxLoan(ActionEvent event) {
        textView.setText("El estudiante con mas prestamos es: "+mfc.studentMaxLoans().getName()+
                " con "+mfc.studentMaxLoans().getLoans()+" prestamos");
    }

    @FXML
    void elementMaxLoan(ActionEvent event) {
        textView.setText("El elemento mas prestado es: "+mfc.elementMaxLoans().getName()+
                " con "+mfc.elementMaxLoans().getLoans()+" prestamos");
    }
}

