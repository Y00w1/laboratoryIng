package com.example.laboratorio.controllers;

import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoanController implements Initializable {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Label resultsElements;
    @FXML
    private TextField searchLoanTxt;
    @FXML
    private TextField loanStudent;

    @FXML
    private TextField loanAmount;

    @FXML
    private TextField loanElement;

    @FXML
    private TableView <Loan> tbLoan;

    @FXML
    private TableColumn<Loan, Integer> tableAmountLoan;

    @FXML
    private TableColumn<Loan, Integer> tableIDLoan;

    @FXML
    private TableColumn<Loan, String> tableElementLoan;

    @FXML
    private TableColumn<Loan, String> tableMonitorLoan;

    @FXML
    private TableColumn<Loan, String> tableStudentLoan;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        tbLoan.setItems(mfc.getObservableListLoan());
        tableAmountLoan.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableElementLoan.setCellValueFactory(new PropertyValueFactory<>("element"));
        tableIDLoan.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableMonitorLoan.setCellValueFactory(new PropertyValueFactory<>("monitor"));
        tableStudentLoan.setCellValueFactory(new PropertyValueFactory<>("student"));
    }

    @FXML
    void elementChange(ActionEvent event) throws IOException {
        mfc.switchToElementScene(event);
    }

    @FXML
    void studentChange(ActionEvent event) throws IOException {
        mfc.switchToStudentScene(event);
    }

    public void addLoan(ActionEvent actionEvent) {
        Boolean valid = mfc.addLoan(loanElement.getText(),loanStudent.getText(),Integer.parseInt(loanAmount.getText()),mfc.laboratorio.getLoanService().getCodeGenerator()+100);
        if (valid){
            mfc.reduceAmountElement(mfc.validateElement(loanElement.getText()),Integer.parseInt(loanAmount.getText()));
            mfc.addLoanStudent(mfc.validateStudent(loanStudent.getText()));
            mfc.addLoanElement(mfc.validateElement(loanElement.getText()));
            mfc.editLoansMonitor();
            System.out.println(mfc.laboratorio.getMonitorService().getMonitor().getLoans());
        }
        tbLoan.setItems(mfc.getObservableListLoan());
        tbLoan.refresh();
        loanAmount.setText("");
        loanElement.setText("");
        loanStudent.setText("");
    }

    @FXML
    public void searchLoan(MouseEvent mouseEvent) {
        FilteredList<Loan> loanFilteredList = new FilteredList<>(mfc.getObservableListLoan(), p->true);
        tbLoan.setItems(loanFilteredList);
        mfc.searchLoan(loanFilteredList, searchLoanTxt);
        resultsElements.setText(mfc.validateElement(searchLoanTxt.getText()).getLoans()+" Results found");
    }

    @FXML
    public void selectedLoan(MouseEvent mouseEvent) {
        Loan loan = tbLoan.getSelectionModel().getSelectedItem();
        loanStudent.setText(loan.getStudent());
        loanElement.setText(loan.getElement());
        loanAmount.setText(loan.getAmount().toString());
    }
}

