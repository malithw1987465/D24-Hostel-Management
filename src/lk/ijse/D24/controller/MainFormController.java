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
import lk.ijse.D24.util.Navigation;
import lk.ijse.D24.util.Routes;

import java.io.IOException;

public class MainFormController {

    public Button settingId;
    public Button stManageId;
    public Button dashboardId;
    public Button roomId;
    public Button resId;
    public AnchorPane root;
    public AnchorPane contextPane;

    public void onActionLogOut(ActionEvent actionEvent) throws IOException {
       /* FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/lk/ijse/hostel/view/LoginForm.fxml"));
        Parent parent=fxmlLoader.load();
        Stage stage=new Stage();
        stage.setScene(new Scene (parent));
        stage.show();*/


    }

    public void onActionDashboard(ActionEvent actionEvent) throws IOException {
//        Navigation.navigate(Routes.PLANS,root);
//        slideButton (dashboardId);

    }

    public void onActionRervation(ActionEvent actionEvent) throws IOException {
//        Navigation.navigate(Routes.RESERVATION,root);
//        slideButton (resId);
    }

    public void onActionRoom(ActionEvent actionEvent) throws IOException {
//        Navigation.navigate(Routes.ROOM,root);
//        slideButton (roomId);
    }

    public void onActionStudent(ActionEvent actionEvent) throws IOException {
//        Navigation.navigate(Routes.STUDENT,root);
//        slideButton (stManageId);
    }

    public void onActionSetting(ActionEvent actionEvent) throws IOException {
//        Navigation.navigate(Routes.SETTING,root);
//        slideButton (settingId);
    }

    public void slideButton(Node node){
//        TranslateTransition slider = new TranslateTransition();
//        slider.setDuration(Duration.seconds(0.4));
//        slider.setNode(node);
//
//        slider.setToX(28);
//        slider.play();
//        slider.setToX (0);
//        slider.play();
    }
}
