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

    UserDAO userdao=(UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDTO dto){
        session= SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            userdao.setSession(session);
            int id=userdao.save(
                    new User(dto.getId(),
                            dto.getUserName()

                            ,
                            dto.getPassword(),
                            dto.getEmail()
                    )
            );
            transaction.commit();
            session.close();
            if(userdao !=null){
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public UserDTO getUser(int id) throws Exception {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        userdao.setSession(session);
        User user= userdao.getObject(id);
        session.close();
        return new UserDTO(
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getEmail()
        );

    }

    @Override
    public boolean updateUser(UserDTO dto) {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        try{
            userdao.setSession(session);
            userdao.update(new User(
                    dto.getId(),
                    dto.getUserName(),
                    dto.getPassword(),
                    dto.getEmail()
            ));

            transaction.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    @Override
    public List<UserDTO> loadAll() {
        session=SessionFactoryConfig.getInstance().getSession();
        Transaction transaction= session.beginTransaction();

        userdao.setSession(session);
        List<User> users=userdao.loadAll();
        List<UserDTO> userDTOList=new ArrayList<>();

        for(User u:users){
            userDTOList.add(
                    new UserDTO(
                            u.getId(),
                            u.getUserName(),
                            u.getPassword(),
                            u.getEmail()
                    )
            );
        }
        return userDTOList;
    }

}

