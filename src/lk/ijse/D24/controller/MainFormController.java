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
    public AnchorPane anchorPane2;



    public void onActionLogOut(ActionEvent actionEvent) throws IOException {
       /* FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/ijse/hostel/view/LoginForm.fxml"));
        Parent parent=fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene (parent));
        stage.show();*/


    }



    public void BtnonActionReservation(ActionEvent actionEvent) throws IOException {

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

    public void btnOnActionSetting(ActionEvent actionEvent) throws IOException {

    }

    public void btnOnActionPlans(ActionEvent event) {
    }


}
