package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.StudentBO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class StudentFormController implements Initializable {
    public AnchorPane anchorPane;
    public TableView<StudentDTO> tblStudent;
    public TableColumn colID;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colEmail;
    public TableColumn colGender;

    private Session session;
    private StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);

    public void btnSaveOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StudentSaveForm.fxml"))));
        stage.setTitle("STUDENT");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnDeleteOnAction(ActionEvent event) throws Exception {
        int id= tblStudent.getSelectionModel().getSelectedItem().getId();
        Student student=studentBO.getStudent(id);
        studentBO.deleteStudent(student);

        tblStudent.getItems().remove(tblStudent.getSelectionModel().getSelectedItem());
        tblStudent.getSelectionModel().clearSelection();

    }

    public void btnUpdateOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/StudentUpdateForm.fxml"))));
        stage.setTitle("STUDENT");
        stage.centerOnScreen();
        stage.show();
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DashboardForm.fxml"))));
        stage.setTitle("DASHBOARD");
        stage.centerOnScreen();
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable();
        loadStudents();
    }

    private void loadStudents() {
        try {
            List allStudents = studentBO.loadAll ();
            ObservableList observableList = FXCollections.observableArrayList (allStudents);
            tblStudent.setItems (observableList);

        } catch (Exception e) {
            System.out.println (e);
        }
    }

    private void setTable() {
        colID.setCellValueFactory (new PropertyValueFactory<>("id"));
        colName.setCellValueFactory (new PropertyValueFactory<> ("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory (new PropertyValueFactory<> ("address"));
        colDOB.setCellValueFactory (new PropertyValueFactory<> ("dob"));
        colContact.setCellValueFactory (new PropertyValueFactory<> ("contact"));
        colGender.setCellValueFactory (new PropertyValueFactory<> ("gender"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    public void onMouseClicked(MouseEvent mouseEvent) {
//        int index = tblStudent.getSelectionModel ().getSelectedIndex ();
//        int stId = Integer.parseInt(colID.getCellData (index).toString ());//select Column value
//
//        try {
//            StudentDTO dto = studentBO.getStudent (stId);
//        } catch (Exception e) {
//            System.out.println (e);
//        }

    }
}
