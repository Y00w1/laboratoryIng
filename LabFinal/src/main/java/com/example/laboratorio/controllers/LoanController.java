package com.example.laboratorio.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoanController {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Button addLoan;

    @FXML
    private Button addLoanElement;

    @FXML
    private TextField idElement;

    @FXML
    private TextField loanStudent;

    @FXML
    private TableColumn<?, ?> tableAmountLoan;

    @FXML
    private TableColumn<?, ?> tableElementLoan;

    @FXML
    private TableColumn<?, ?> tableMonitorLoan;

    @FXML
    private TableColumn<?, ?> tableStudentLoan;

    @FXML
    void elementChange(ActionEvent event) throws IOException {
        mfc.switchToElementScene(event);
    }

    @FXML
    void studentChange(ActionEvent event) throws IOException {
        mfc.switchToStudentScene(event);
    }

}

