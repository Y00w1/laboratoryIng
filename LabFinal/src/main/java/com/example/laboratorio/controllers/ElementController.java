package com.example.laboratorio.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.laboratorio.model.Element;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ElementController implements Initializable {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addElement;

    @FXML
    private TextField amountElement;

    @FXML
    private TextField materialElement;

    @FXML
    private TextField nameElement;

    @FXML
    private TextField priceElement;

    @FXML
    private TableColumn<Element, Integer> tableAmountElement;

    @FXML
    private TableColumn<Element, String> tableMaterialElement;

    @FXML
    private TableColumn<Element, String> tableNameElement;
    @FXML
    public TableColumn <Element, Double> tablePriceElement;

    @FXML
    private TableView<Element> tblElement;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tableAmountElement.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableMaterialElement.setCellValueFactory(new PropertyValueFactory<>("material"));
        tableNameElement.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablePriceElement.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    @FXML
    void buttonAddE(ActionEvent event) {
        mfc.buttonAddE(nameElement.getText(),Integer.parseInt(amountElement.getText()),materialElement.getText(),Double.parseDouble(priceElement.getText()));
        tblElement.setItems(mfc.laboratorio.getElementService().getObservableListElement());
        tblElement.refresh();
    }

    @FXML
    void loanChange(ActionEvent event) throws IOException {
        mfc.switchToLoanScene(event);
    }

    @FXML
    void studentChange(ActionEvent event) throws IOException {
        mfc.switchToStudentScene(event);
    }
}



