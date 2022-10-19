package com.example.laboratorio.services;

import com.example.laboratorio.model.Student;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TextField;

public interface UserService {
    void addStudent(String id, String name, String email, String number, String career, Integer semester);
    ObservableList<Student> getStudentObservableList();
    void deleteStudent(Student student);
    void editStudent(Integer indx, Student student);
    void searchStudent(FilteredList<Student> filteredlist, TextField textField);
    void addLoanStudent(Student student);
    Student studentMaxLoans();
}
