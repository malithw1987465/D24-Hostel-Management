package lk.ijse.D24.bo.custom.impl;


import lk.ijse.D24.bo.custom.UserBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.UserDAO;
import lk.ijse.D24.dto.UserDTO;
import lk.ijse.D24.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserBOImpl implements UserBO {

    private Session session;
    UserDAO userDAO=(UserDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.USER);
    @Override
    public boolean saveUser(UserDTO dto) {
        session= SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            userDAO.setSession (session);
            int id=userDAO.save (new User(
                    dto.getId(),
                    dto.getUsername(),
                    dto.getEmail(),
                    dto.getPassword ()));
            transaction.commit ();
            session.close ();
            if (userDAO!=null){
                return true;
            }
        }catch (Exception e){
            transaction.rollback ();
        }
        return false;
    }

    @Override
    public UserDTO getUser(int id) throws Exception {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        userDAO.setSession (session);
        User u=userDAO.getObject (id);
        session.close ();
        return new UserDTO (
                u.getId(),
                u.getUsername(),
                u.getEmail(),
                u.getPassword()
        );
    }

    @Override
    public boolean updateUser(UserDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try {
            userDAO.setSession (session);
            userDAO.update (new User (
                    dto.getId(),
                    dto.getUsername(),
                    dto.getEmail(),
                    dto.getPassword()
            ));

            transaction.commit ();
            session.close ();
            return true;
        }catch (Exception e){
            transaction.rollback ();;
        }
        return false;
    }

    @Override
    public List<UserDTO> loadAll() {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        userDAO.setSession (session);
        List<User>list= userDAO.loadAll ();
        List<UserDTO>userList= new ArrayList<> ();

        for (User u:list) {
            userList.add(
                    new UserDTO (
                            u.getId(),
                            u.getUsername(),
                            u.getEmail(),
                            u.getPassword ()
                    ));
        }

        return userList;

    }
}

