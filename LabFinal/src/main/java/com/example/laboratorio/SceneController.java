package com.example.laboratorio;

import com.example.laboratorio.controllers.ModelFactoryController;
import com.example.laboratorio.services.SceneService;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController implements SceneService {
    private Stage stage;
    private Scene scene;
    private Parent root;

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    public void switchScene(ActionEvent e, String resource) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(resource)));
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 450);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToStudentScene(ActionEvent e) throws IOException {
        switchScene(e,"hello-view.fxml");
    }

    public void switchToElementScene(ActionEvent e) throws IOException {
        switchScene(e,"element-view.fxml");

    }
    public void switchToLoanScene(ActionEvent e) throws IOException{
        switchScene(e,"loan-view.fxml");
    }

    public void switchToInformationScene(ActionEvent e) throws IOException {
        switchScene(e,"information-view.fxml");
    }
}
