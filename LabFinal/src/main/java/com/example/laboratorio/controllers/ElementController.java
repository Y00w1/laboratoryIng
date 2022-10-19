package com.example.laboratorio.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

import com.example.laboratorio.model.Element;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class ElementController implements Initializable {
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private TextField searchElementTxt;

    @FXML
    private TextField amountElement;

    @FXML
    private TextField idElement;

    @FXML
    private ComboBox<String> typeElement;

    @FXML
    private TextField nameElement;

    @FXML
    private TextField priceElement;

    @FXML
    private TableColumn<Element, Integer> tableAmountElement;

    @FXML
    private TableColumn<Element,String> tableTypeElement;

    @FXML
    private TableColumn<Element, String> tableNameElement;

    @FXML
    private TableColumn<Element,String> tableIDElement;

    @FXML
    public TableColumn <Element, Double> tablePriceElement;

    @FXML
    private TableView<Element> tblElement;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblElement.setItems(mfc.getObservableListElement());
        tableAmountElement.setCellValueFactory(new PropertyValueFactory<>("amount"));
        tableNameElement.setCellValueFactory(new PropertyValueFactory<>("name"));
        tablePriceElement.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableTypeElement.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableIDElement.setCellValueFactory(new PropertyValueFactory<>("id"));
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "FICHAS", "PIEZAS DE METAL", "ESFERAS","RUEDAS");
        typeElement.getItems().addAll(list);
    }

    @FXML
    void buttonAddE(ActionEvent event) {
        mfc.buttonAddE(nameElement.getText(),Integer.parseInt(amountElement.getText()),typeElement.getSelectionModel().getSelectedItem(),Double.parseDouble(priceElement.getText()),idElement.getText());
        tblElement.setItems(mfc.getObservableListElement());
        tblElement.refresh();
        amountElement.setText("");
        typeElement.setValue("");
        nameElement.setText("");
        priceElement.setText("");
        idElement.setText("");
    }

    @FXML
    void loanChange(ActionEvent event) throws IOException {
        mfc.switchToLoanScene(event);
    }

    @FXML
    void studentChange(ActionEvent event) throws IOException {
        mfc.switchToStudentScene(event);
    }
    @FXML
    public void buttonDeleteE(ActionEvent actionEvent) {
        Element elementDelete = tblElement.getSelectionModel().getSelectedItem();
        mfc.buttonDeleteE(elementDelete);
        tblElement.setItems(mfc.getObservableListElement());
        tblElement.refresh();
        amountElement.setText("");
        typeElement.setValue("");
        nameElement.setText("");
        priceElement.setText("");
        idElement.setText("");
    }
    @FXML
    public void buttonEditE(ActionEvent actionEvent) {
        int indx = tblElement.getSelectionModel().getSelectedIndex();
        Element element = new Element(nameElement.getText(),typeElement.getSelectionModel().getSelectedItem(),Integer.parseInt(amountElement.getText()),Double.parseDouble(priceElement.getText()),idElement.getText());
        mfc.editElement(indx,element);
        tblElement.setItems(mfc.getObservableListElement());
        tblElement.refresh();
        amountElement.setText("");
        typeElement.setValue("");
        nameElement.setText("");
        priceElement.setText("");
        idElement.setText("");
    }
    public void selectElement(MouseEvent mouseEvent) {
        Element element = tblElement.getSelectionModel().getSelectedItem();
        nameElement.setText(element.getName());
        typeElement.setValue(element.getType());
        amountElement.setText(element.getAmount().toString());
        priceElement.setText(element.getPrice().toString());
        idElement.setText(element.getId());
    }

    public void searchElement(MouseEvent mouseEvent) {
        FilteredList<Element> filteredData = new FilteredList<>(mfc.getObservableListElement(), p->true);
        tblElement.setItems(filteredData);
        mfc.searchElement(filteredData, searchElementTxt);
    }
}



