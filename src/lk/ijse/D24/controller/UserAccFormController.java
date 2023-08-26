package lk.ijse.D24.controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.D24.bo.BOFactory;
import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dto.UserDTO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserAccFormController  implements Initializable {
    public TextField txtUsername;
    public TextField txtEmail;
    public PasswordField txtPassword;
    public PasswordField txtConfirmPassword;
    public TextField txtUserId;
    private UserBO userBO = (UserBO) BOFactory.getBO (BOFactory.BOTypes.USER);
    private Object SendMail;

    public void btnCreateOnAction(ActionEvent event) {

        String password=txtPassword.getText ();
        String rePasssword=txtConfirmPassword.getText ();
        String username = txtUsername.getText ();
        int userId = 0;
        String email=txtEmail.getText ();

        /*List <UserDTO>allRoom = userBO.loadAll ();

        for (UserDTO u : allRoom) {
            if (!(u.getUserId ().equals (userId))){
                if (pass.equals (rePass)){
                    userBO.saveUser (new UserDTO (
                            userId,
                            userName,
                            pass
                    ));
                    new Alert (Alert.AlertType.CONFIRMATION, "USER ACCOUNT CREATED SUCCUSS").show ();

                }else {
                    new Alert (Alert.AlertType.ERROR, "Check your Password and Try Again").show ();
                }
            }else{
                new Alert (Alert.AlertType.ERROR, "THIS USER ID ALREADY GET").show ();
            }
        }
        */

        if (checkDuplidate ()){
            if (checkValidation ()){
                if(password.equals (rePasssword)){
                    userBO.saveUser (new UserDTO(
                            userId,
                            username,
                            password,
                            email
                    ));
                    new Alert (Alert.AlertType.CONFIRMATION, "USER ACCOUNT CREATED SUCCUSS").show ();
//                   SendMail.outMail ("YOU ARE USER IN D24HOSTEL SYSTEM",email,"D24HOSTEL");
                    clearFeilds ();
                    setUserId ();
                }else {
                    new Alert (Alert.AlertType.ERROR, "Check your Password and Try Again").show ();
                }
            }
        }else{
            new Alert (Alert.AlertType.ERROR, "THIS USER ID ALREADY GET").show ();
            clearFeilds ();
        }




    }

    public boolean checkDuplidate(){
        String userId=txtUsername.getText ();
        List<UserDTO> allRoom = userBO.loadAll ();
        for (UserDTO u : allRoom) {
            if (userId.equals (u.getUsername ())){
                return false;
            }
        }
        return  true;
    }

    public void clearFeilds(){
        txtConfirmPassword.clear ();
        txtEmail.clear ();
        txtPassword.clear ();
        txtUsername.clear ();
    }
    public String nextUserID() {
        Session session = SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction = session.beginTransaction ();

        Query query = session.createQuery ("select username from User order by username desc");

        String nextId = "U001";

        if (query.list ().size () == 0) {
            return nextId;
        } else {
            String id = (String) query.list ().get (0);

            String[] SUs = id.split ("U00");

            for (String a : SUs) {
                id = a;
            }

            int idNum = Integer.valueOf (id);

            id = "U00" + (idNum + 1);

            transaction.commit ();
            session.close ();

            return id;
        }
    }

    public void setUserId(){
        String userID=nextUserID ();
        txtUsername.setText (String.valueOf(txtUsername));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setUserId ();
    }
    private boolean checkValidation() {
        String email=txtEmail.getText ();

        if (!email.matches("^([a-z0-9]{2,})([@])([a-z]{2,9})([.])([a-z]{2,})$")) {
            new Alert(Alert.AlertType.ERROR, "INVALID EMAIL ADDRESS").show ();
            txtEmail.requestFocus ();
            return false;
        } else {
            return true;
        }



    }


}

