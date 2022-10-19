package com.example.laboratorio.controllers;

import com.example.laboratorio.model.Student;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class

StudentController implements Initializable {

    @FXML
    private TextField searchTxt;
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

    @FXML
    public void addStudentBtn(ActionEvent actionEvent) {
        mfc.btnAddStudent(idStudent.getText(), nameStudent.getText(), emailStudent.getText(), numberStudent.getText(), comboxCareer.getSelectionModel().getSelectedItem(), Integer.parseInt(semesterStudent.getText()));
        tbStudent.setItems(mfc.getObservableListStudent());
        tbStudent.refresh();
        idStudent.setText("");
        nameStudent.setText("");
        emailStudent.setText("");
        numberStudent.setText("");
        comboxCareer.setValue("");
        semesterStudent.setText("");
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

    @FXML
    public void deleteStudentBtn(ActionEvent actionEvent) {
        Student stu = tbStudent.getSelectionModel().getSelectedItem();
        mfc.btnDeleteStudent(stu);
        tbStudent.setItems(mfc.getObservableListStudent());
        tbStudent.refresh();
        idStudent.setText("");
        nameStudent.setText("");
        emailStudent.setText("");
        numberStudent.setText("");
        comboxCareer.setValue("");
        semesterStudent.setText("");
    }
    @FXML
    public void editStudentBrn(ActionEvent actionEvent) {
        Student stu = new Student(idStudent.getText(), nameStudent.getText(), emailStudent.getText(), numberStudent.getText(), comboxCareer.getSelectionModel().getSelectedItem(), Integer.parseInt(semesterStudent.getText()));
        Integer indx = tbStudent.getSelectionModel().getSelectedIndex();
        mfc.btnEditStudent(indx, stu);
        tbStudent.setItems(mfc.getObservableListStudent());
        tbStudent.refresh();
        idStudent.setText("");
        nameStudent.setText("");
        emailStudent.setText("");
        numberStudent.setText("");
        comboxCareer.setValue("");
        semesterStudent.setText("");
    }
    @FXML
    public void selectStudent(MouseEvent mouseEvent) {
        Student stu = tbStudent.getSelectionModel().getSelectedItem();
        idStudent.setText(stu.getId());
        nameStudent.setText(stu.getName());
        emailStudent.setText(stu.getEmail());
        numberStudent.setText(stu.getNumber());
        comboxCareer.setValue(stu.getCareer());
        semesterStudent.setText(stu.getSemester().toString());
    }
    @FXML
    public void searchTable(MouseEvent mouseEvent) {
        FilteredList<Student> filteredData = new FilteredList<>(mfc.getObservableListStudent(), p->true);
        tbStudent.setItems(filteredData);
        mfc.searchStudent(filteredData, searchTxt);
    }
}
