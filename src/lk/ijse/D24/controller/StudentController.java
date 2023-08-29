package lk.ijse.D24.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.StudentBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dto.StudentDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class StudentController implements Initializable {
    public AnchorPane studentPane;
    public TextField txtStudentId;
    public TextField txtStName;
    public TextField txtStAdress;
    public TextField txtStContact;
    public Date txtStDate;
    public TextField txtStNic;
    public TextField txtStEmail;
    public ComboBox cmbStGender;
    public TableColumn colStGender;
    public TableColumn colStDob;
    public TableColumn colStContact;
    public TableColumn colStAddress;
    public TableColumn colStName;
    public TableColumn colStId;
    public TableView tblStudent;
    public TableColumn colStEmail;
    public TableColumn colStNic;

    private Session session;
    private StudentBO studentBO = (StudentBO) BOFactory.getBO (BOFactory.BOTypes.STUDENT);

    public void initialize(URL location, ResourceBundle resources) {
        setGender ();
        setTableStudent ();
        loadAllStudent ();
        setStID ();
    }
    public void setGender() {
        ObservableList<String> data = FXCollections.observableArrayList ("Male", "Female", "Other");
        cmbStGender.setItems (data);
    }
    public void setTableStudent() {
        colStId.setCellValueFactory (new PropertyValueFactory<>("stId"));
        colStName.setCellValueFactory (new PropertyValueFactory<> ("stName"));
        colStAddress.setCellValueFactory (new PropertyValueFactory<> ("address"));
        colStDob.setCellValueFactory (new PropertyValueFactory<> ("dob"));
        colStContact.setCellValueFactory (new PropertyValueFactory<> ("contact"));
        colStGender.setCellValueFactory (new PropertyValueFactory<> ("gender"));
        colStEmail.setCellValueFactory (new PropertyValueFactory<> ("email"));
        colStNic.setCellValueFactory (new PropertyValueFactory<> ("nic"));
    }
    public void loadAllStudent() {

        try {
            List allStudents = studentBO.loadAll ();
            ObservableList observableList = FXCollections.observableArrayList (allStudents);
            tblStudent.setItems (observableList);

        } catch (Exception e) {
            System.out.println (e);
        }
    }
    public String nextStID() {
        Session session = SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();

        Query query = session.createQuery ("select stId from Student order by stId desc");

        String nextId = "S001";

        if (query.list ().size () == 0) {
            return nextId;
        } else {
            String id = (String) query.list ().get (0);

            String[] SUs = id.split ("00");

            for (String a : SUs) {
                id = a;
            }

            int idNum = Integer.valueOf (id);

            id = "S00" + (idNum + 1);

            transaction.commit ();
            session.close ();

            return id;
        }
    }
    public void setStID(){
        String stID=nextStID ();
        txtStudentId.setText (stID);
    }

    public boolean checkDuplicate() {
        List<StudentDTO> allStudents = studentBO.loadAll ();
        for (StudentDTO s : allStudents) {
            if (s.getId ().equals (txtStudentId.getText ())) {
                new Alert (Alert.AlertType.ERROR, "This ID Already Have").show ();
                return false;
            }
        }
        return true;
    }


    public void onActionSave(ActionEvent event) {
        String dob = String.valueOf (txtStDate.getValue ());
        String gender = cmbStGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtStudentId.getText (), txtStName.getText (), txtStAdress.getText (), txtStContact.getText (), dob, gender,txtStEmail.getText(),txtStNic.getText());

        if(checkDuplicate ()){
            boolean isCheckValidate=checkValidation ();
            if(isCheckValidate){
                studentBO.saveStudent (studentDTO);
                new Alert(Alert.AlertType.CONFIRMATION, "Student saved").show ();
                tblStudent.getItems ().clear ();
                clearData ();
                loadAllStudent ();
                setStID ();
            }

        }
    }
    private boolean checkValidation(){
        String nameText = txtStName.getText();
        String addressText = txtStAdress.getText();
        String contactText = txtStContact.getText();

        if (!addressText.matches(".{2,}")) {
            new Alert(Alert.AlertType.ERROR, "Address should be at least 3 characters long").show();
            txtStAdress.requestFocus();
            return false;
            //} else if (!contactText.matches(".*(?:7|0|(?:\\\\\\\\+94))[0-9]{9,10}")) {
        } else if (!contactText.matches("\\d{10}")) {
            new Alert(Alert.AlertType.ERROR, "Invalid Contact").show();
            txtStContact.requestFocus();
            return false;
        }else {
            return true;
        }

    }
    public void clearData() {
        txtStudentId.clear ();
        txtStName.clear ();
        txtStAdress.clear ();
        txtStContact.clear ();
        txtStDate.setValue (null);
        cmbStGender.setValue (null);
        txtStEmail.clear();
        txtStNic.clear();
    }

    public void onActionUpdate(ActionEvent event) {
        String dob = String.valueOf (txtStDate.getValue ());
        String gender = cmbStGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtStudentId.getText (), txtStName.getText (), txtStAdress.getText (), txtStContact.getText (), dob, gender,txtStEmail.getText(),txtStNic.getText());

        boolean isUpdate=studentBO.updateStudent (studentDTO);

        if (isUpdate){
            new Alert (Alert.AlertType.INFORMATION, "Student Update Succuss").show ();
            tblStudent.getItems ().clear ();
            clearData ();
            loadAllStudent ();
            setStID ();
        }else {
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    public void onActionDelete(ActionEvent event) {
        String dob = String.valueOf (txtStDate.getValue ());
        String gender = cmbStGender.getValue ().toString ();
        StudentDTO studentDTO = new StudentDTO (txtStudentId.getText (), txtStName.getText (), txtStAdress.getText (), txtStContact.getText (), dob, gender,txtStEmail.getText(),txtStNic.getText());

        boolean isDeleted=studentBO.deleteStudent (studentDTO);

        if (isDeleted){
            new Alert (Alert.AlertType.INFORMATION, "Student Delete Succuss").show ();
            tblStudent.getItems ().clear ();
            clearData ();
            loadAllStudent ();
            setStID ();
        }else{
            new Alert (Alert.AlertType.ERROR, "Something went Wrong").show ();
        }
    }

    public void OnActionMouseClicked(MouseEvent mouseEvent) {
        int index = tblStudent.getSelectionModel ().getSelectedIndex ();
        String stId = colStId.getCellData (index).toString ();//select Column value

        try {
            StudentDTO dto = studentBO.getStudent (stId);
            txtStudentId.setText (dto.getId ());
            txtStName.setText (dto.getName ());
            txtStAdress.setText (dto.getAddress ());
            txtStContact.setText (dto.getContact ());
            txtStDate.setValue (dto.getDob());
            cmbStGender.setValue (dto.getGender ());
            txtStEmail.setText(dto.getEmail());
            txtStNic.setText(dto.getNic());
        } catch (Exception e) {
            System.out.println (e);
        }
    }
}
