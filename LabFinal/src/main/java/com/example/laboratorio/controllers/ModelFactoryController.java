package com.example.laboratorio.controllers;
import com.example.laboratorio.model.Element;
import com.example.laboratorio.model.Loan;
import com.example.laboratorio.model.Monitor;
import com.example.laboratorio.model.Student;
import com.example.laboratorio.services.ModelFactoryControllerService;
import com.example.laboratorio.services.impl.Laboratorio;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ModelFactoryController implements ModelFactoryControllerService {
    //singleton
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
    public void switchToInformationScene(ActionEvent e) throws IOException {
        laboratorio.getSceneService().switchToInformationScene(e);
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
    public void buttonAddE(String name, Integer amount, String type, Double price,String id){
        laboratorio.getElementService().buttonAddE(name,amount, type,price,id);
    }

    @Override
    public void buttonDeleteE(Element elementDelete) {
        laboratorio.getElementService().buttonDeleteE(elementDelete);
    }

    @Override
    public void editElement(int indx,Element element){
        laboratorio.getElementService().editElement(indx,element);
    }

    @Override
    public void searchElement(FilteredList<Element> filteredlist, TextField textField) {
        laboratorio.getElementService().searchElement(filteredlist, textField);
    }

    @Override
    public ObservableList<Element> getObservableListElement (){
        return laboratorio.getElementService().getObservableListElement();
    }

    @Override
    public void reduceAmountElement(Element element,Integer amount){
        laboratorio.getElementService().reduceAmount (element,amount);
    }

    @Override
    public Element validateElement(String element){
        return laboratorio.getLoanService().validateElement(getObservableListElement(),element);
    }

    @Override
    public void addLoanElement(Element element){
        laboratorio.getElementService().addLoanElement(element);
    }

    //Function Student
    @Override
    public void btnAddStudent(String id, String name, String email, String number, String career, Integer semester){
        laboratorio.getUserService().addStudent(id, name, email, number,  career, semester);
    }

    @Override
    public void btnDeleteStudent(Student student) {
        laboratorio.getUserService().deleteStudent(student);
    }

    @Override
    public void btnEditStudent(Integer indx, Student student) {
        laboratorio.getUserService().editStudent(indx, student);
    }

    @Override
    public void searchStudent(FilteredList<Student> filteredlist, TextField textField) {
        laboratorio.getUserService().searchStudent(filteredlist, textField);
    }

    @Override
    public ObservableList<Student> getObservableListStudent() {
        return laboratorio.getUserService().getStudentObservableList();
    }

    @Override
    public void addLoanStudent(Student student){
        laboratorio.getUserService().addLoanStudent(student);
    }

    @Override
    public Student validateStudent(String student) {
        return laboratorio.getLoanService().validateStudent(getObservableListStudent(), student);
    }

    //Funcion Loan
    @Override
    public Boolean addLoan(String element, String student, Integer amount, Integer id){
        return laboratorio.getLoanService().addLoan(element,student,amount,id, laboratorio.getElementService().getObservableListElement(), laboratorio.getUserService().getStudentObservableList());
    }
    @Override
    public ObservableList<Loan> getObservableListLoan(){
        return laboratorio.getLoanService().getLoanObservableList();
    }
    @Override
    public Monitor getMonitor(){
        return laboratorio.getMonitorService().getMonitor();
    }

    @Override
    public void searchLoan(FilteredList<Loan> loanFilteredList, TextField textField) {
        laboratorio.getLoanService().searchLoan(loanFilteredList, textField);
    }
    //Monitor
    @Override
    public void editLoansMonitor(){
        laboratorio.getMonitorService().editLoans();
    }
}
