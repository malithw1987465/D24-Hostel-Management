package lk.ijse.D24.dao;

import lk.ijse.D24.dao.custom.impl.*;


public class DAOFactory {
    public static DAOFactory daoFactory;

    public DAOFactory() {
    }

    public static DAOFactory getDaoFactory(){
        if (daoFactory==null){
            daoFactory=new DAOFactory ();
        }
        return daoFactory;
    }

    public enum DAOTypes{
        STUDENT,ROOM,USER,RESERVATION,QUERY
    }
    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
          case STUDENT:
                return new StudentDAOImpl();
            case ROOM:
                return new RoomDAOImpl();
            case RESERVATION:
                return new ReservationDAOImpl();
            case USER:
                return new UserDAOImpl();
            case QUERY:
                return new QueryDAOImpl();
            default:
                return null;
        }
    }

}
