package lk.ijse.D24.bo;

//import lk.ijse.D24.bo.custom.impl.StudentBOImpl;
import lk.ijse.D24.bo.custom.impl.UserBOImpl;

public class BOFactory {


        public static BOFactory boFactory;
        public BOFactory() {
        }

        public BOFactory  getBoFactory(){
            if (boFactory==null){
                boFactory=new BOFactory ();
            }
            return boFactory;
        }

        public enum BOTypes{
            STUDENT,ROOM,USER,RESERVATION
        }

        public static SuperBO getBO(BOTypes boTypes){
            switch (boTypes){
//                case STUDENT:
//                    return (SuperBO) new StudentBOImpl();
                case ROOM:
//                    return new RoomBOImpl ();
                case RESERVATION:
//                    return new RevervationBOImpl ();
                case USER:
                    return new UserBOImpl();
                default:
                    return null;
            }
        }

    }

