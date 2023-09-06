package lk.ijse.D24.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
//import lk.ijse.D24.util.Navigation;
//import lk.ijse.D24.util.Routes;

import java.io.IOException;

public class MainFormController {

    public Button settingId;
    public Button stManageId;
    public Button dashboardId;
    public Button roomId;
    public Button resId;
    public AnchorPane anchorPane;
    public AnchorPane root;



    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/LoginForm.fxml"))));
        stage.setTitle("MainForm");
        stage.centerOnScreen();
        stage.show();


    }



    public void BtnonActionReservation(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/ReservationForm.fxml"))));
        stage.setTitle("Reservation");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnOnActionRoom(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/RoomForm.fxml"))));
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.show();


    }

    public void btnActionStudent(ActionEvent actionEvent) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/StudentForm.fxml"))));
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.show();

    }



    public void btnOnActionPlans(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/PlansForm.fxml"))));
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.show();
    }


    public void btnOnActionReports(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/Reports.fxml"))));
        stage.setTitle("Student");
        stage.centerOnScreen();
        stage.show();
    }
}
