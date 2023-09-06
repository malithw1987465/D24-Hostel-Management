package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.QueryDAO;
import lk.ijse.D24.entity.Student;

import java.io.IOException;
import java.util.List;

public class ReportsFormController {
    public AnchorPane anchorPane;
    public TableView<Student> tblData;
    public TableColumn colStID;
    public TableColumn colName;
    public TableColumn colNIC;
    public TableColumn colAddress;
    public TableColumn colEmail;
    public TableColumn colContact;

    QueryDAO queryDAO=(QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY);

    public void onMouseClicked(MouseEvent mouseEvent) {
    }

    public void btnFullOnAction(ActionEvent event) {
        loadFullQuery();
        SetData();
    }

    private void SetData() {
        colStID.setCellValueFactory (new PropertyValueFactory<>("id"));
        colName.setCellValueFactory (new PropertyValueFactory<> ("name"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colAddress.setCellValueFactory (new PropertyValueFactory<> ("address"));
        colContact.setCellValueFactory (new PropertyValueFactory<> ("contact"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    private void loadFullQuery() {
        try {
            List<Student> allStudent = queryDAO.loadFullStudents();
            System.out.println("checked1");
            ObservableList<Student> stList = FXCollections.observableArrayList ();

            for (Student dto : allStudent) {
                stList.add(new Student(
                        dto.getId(),
                        dto.getName(),
                        dto.getNic(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getDob(),
                        dto.getEmail(),
                        dto.getGender()
                ));
            }

            tblData.setItems (stList);

            System.out.println (stList);


        } catch (Exception e) {
            System.out.println (e);
            System.out.println("unsuccessful");
        }
    }

    public void btnNotOnAction(ActionEvent event) {
        loadNotPaid();
        SetData();
    }

    private void loadNotPaid() {
        try {
            List<Student> allStudent = queryDAO.loadNotPaidStudents();
            System.out.println("checked1");
            ObservableList<Student> stList = FXCollections.observableArrayList ();

            for (Student dto : allStudent) {
                stList.add(new Student(
                        dto.getId(),
                        dto.getName(),
                        dto.getNic(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getDob(),
                        dto.getEmail(),
                        dto.getGender()
                ));
            }

            tblData.setItems (stList);

            System.out.println (stList);


        } catch (Exception e) {
            System.out.println (e);
            System.out.println("unsuccessful");
        }
    }

    public void btnPaidOnAction(ActionEvent event) {
        loadPaid();
        SetData();
    }

    private void loadPaid() {
        try {
            List<Student> allStudent = queryDAO.loadPaidStudents();
            System.out.println("checked1");
            ObservableList<Student> stList = FXCollections.observableArrayList ();

            for (Student dto : allStudent) {
                stList.add(new Student(
                        dto.getId(),
                        dto.getName(),
                        dto.getNic(),
                        dto.getAddress(),
                        dto.getContact(),
                        dto.getDob(),
                        dto.getEmail(),
                        dto.getGender()
                ));
            }

            tblData.setItems (stList);

            System.out.println (stList);


        } catch (Exception e) {
            System.out.println (e);
            System.out.println("unsuccessful");
        }
    }

    public void btnBackOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/resources/view/MainForm.fxml"))));
        stage.setTitle("MainForm");
        stage.centerOnScreen();
        stage.show();
    }
}
