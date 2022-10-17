package com.example.laboratorio.controllers;

import com.example.laboratorio.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class StudentController implements Initializable {

    @FXML
    private TableView<Student> tbStudent;
    @FXML
    private TableColumn<Student, String> careerColStu;
    @FXML
    private TableColumn<Student, String> emailColStu;
    @FXML
    private TableColumn<Student, Integer> semesterColStu;
    @FXML
    private TableColumn<Student, Integer> loanColStu;
    @FXML
    private TableColumn<Student, String> nameColStu;
    @FXML
    private TableColumn<Student, String> idColStu;
    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Button addStudent;

    @FXML
    private TextField emailStudent;

    @FXML
    private TextField idStudent;

    @FXML
    private TextField nameStudent;

    @FXML
    private TextField numberStudent;

    @FXML
    private ComboBox<String> comboxCareer;

    @FXML
    private TextField semesterStudent;

    @FXML
    void elementChange(ActionEvent event) throws IOException {
        mfc.switchToElementScene(event);
    }

    @FXML
    void loanChange(ActionEvent event) throws IOException {
        mfc.switchToLoanScene(event);
    }

    public void addStudentBtn(ActionEvent actionEvent) {
        mfc.btnAddStudent(idStudent.getText(), nameStudent.getText(), emailStudent.getText(), numberStudent.getText(), comboxCareer.getSelectionModel().getSelectedItem(), Integer.parseInt(semesterStudent.getText()));
        tbStudent.setItems(mfc.laboratorio.getUserService().getStudentObservableList());
        tbStudent.refresh();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tbStudent.setItems(mfc.laboratorio.getUserService().getStudentObservableList());
        idColStu.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColStu.setCellValueFactory(new PropertyValueFactory<>("name"));
        emailColStu.setCellValueFactory(new PropertyValueFactory<>("email"));
        careerColStu.setCellValueFactory(new PropertyValueFactory<>("career"));
        semesterColStu.setCellValueFactory(new PropertyValueFactory<>("semester"));
        loanColStu.setCellValueFactory(new PropertyValueFactory<>("loans"));
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "Software", "Industrial", "civil");
        comboxCareer.getItems().addAll(list);
    }
}
