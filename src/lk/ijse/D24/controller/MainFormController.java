package lk.ijse.D24.controller;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.bo.custom.RoomBO;
import lk.ijse.D24.bo.custom.StudentBO;
//import lk.ijse.D24.util.Navigation;
//import lk.ijse.D24.util.Routes;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {


    public AnchorPane anchorPane;
    public AnchorPane root;
    public Label lblStudents;
    public Label lblRooms;
    public Label lblReservations;

    RoomBO roomBO = (RoomBO) BOFactory.getBO (BOFactory.BOTypes.ROOM);
    StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);
    ReservationBO reservationBO = (ReservationBO) BOFactory.getBO (BOFactory.BOTypes.RESERVATION);





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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblStudents.setText (String.valueOf (studentBO.loadAll ().size ()));
        lblRooms.setText(String.valueOf(roomBO.loadAll().size()));
        lblReservations.setText(String.valueOf(reservationBO.loadAll().size()));
    }
}
