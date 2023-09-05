package lk.ijse.D24.bo.custom.impl;

import lk.ijse.D24.bo.custom.ReservationBO;
import lk.ijse.D24.config.SessionFactoryConfig;
import lk.ijse.D24.dao.DAOFactory;
import lk.ijse.D24.dao.custom.ReservationDAO;
import lk.ijse.D24.dao.custom.RoomDAO;
import lk.ijse.D24.dao.custom.StudentDAO;
import lk.ijse.D24.dto.ReservationDTO;
import lk.ijse.D24.dto.RoomDTO;
import lk.ijse.D24.dto.StudentDTO;
import lk.ijse.D24.entity.Reservation;
import lk.ijse.D24.entity.Rooms;
import lk.ijse.D24.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    private Session session;
    StudentDAO studentDAO=(StudentDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.STUDENT);
    RoomDAO roomDAO=(RoomDAO) DAOFactory.getDaoFactory().getDAO (DAOFactory.DAOTypes.ROOM);
    ReservationDAO reservationDAO=(ReservationDAO) DAOFactory.getDaoFactory ().getDAO (DAOFactory.DAOTypes.RESERVATION);


    @Override
    public List<Integer> getStudentIds() {
        try{
            session= SessionFactoryConfig.getInstance ().getSession ();
            studentDAO.setSession (session);
            return studentDAO.getStIds ();

        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public List<Integer> getRoomIds() {
        try{
            session=SessionFactoryConfig.getInstance ().getSession ();
            roomDAO.setSession (session);
            return roomDAO.roomIds ();
        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public List<Integer> getResIds() {
        try{
            session=SessionFactoryConfig.getInstance ().getSession ();
            reservationDAO.setSession (session);
            return reservationDAO.resIds();
        }catch (Exception e){
            session.close ();
            return null;
        }
    }

    @Override
    public StudentDTO getStudent(int id) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        studentDAO.setSession (session);
        try {
            Student st = studentDAO.getObject (id);
            session.close ();
            return new StudentDTO(
                    st.getId(),
                    st.getName(),
                    st.getNic(),
                    st.getAddress(),
                    st.getContact(),
                    st.getDob(),
                    st.getEmail(),
                    st.getGender()
            );

        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }
    }

    @Override
    public RoomDTO getRoom(int id) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        roomDAO.setSession (session);
        try {
            Rooms room=roomDAO.getObject (id);
            session.close ();
            return new RoomDTO (
                    room.getId(),
                    room.getType(),
                    room.getKeyMoney(),
                    room.getQuantity()
            );

        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }
    }

    @Override
    public Reservation getRes(int resID) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        reservationDAO.setSession (session);
        try {
            Reservation res = reservationDAO.getObject (resID);
            session.close ();
            return new Reservation (
                    res.getId(),
                    res.getDateTime(),
                    new Rooms (
                            res.getRoom ().getId(),
                            res.getRoom ().getType(),
                            res.getRoom ().getKeyMoney(),
                            res.getRoom ().getQuantity()
                    ),
                    new Student (
                            res.getStudent ().getId (),
                            res.getStudent ().getName (),
                            res.getStudent().getNic(),
                            res.getStudent().getAddress(),
                            res.getStudent().getContact(),
                            res.getStudent().getDob(),
                            res.getStudent().getEmail(),
                            res.getStudent().getGender()
                    ),
                    res.getAdvance(),
                    res.getStatus ()
            );


        } catch (Exception e) {
            e.printStackTrace ();
            transaction.rollback ();
            return null;
        }
    }

    @Override
    public boolean updateRoom(RoomDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try {
            roomDAO.setSession (session);
            roomDAO.update (new Rooms (
                    dto.getId(),
                    dto.getType(),
                    dto.getKey_money(),
                    dto.getQuantity()
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
    public List<ReservationDTO> loadAllRes() {
        return null;
    }

    @Override
    public boolean saveReservation(ReservationDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            reservationDAO.setSession (session);
            reservationDAO.save (
                    new Reservation (
                            dto.getId(),
                            dto.getDate_time(),
                            new Rooms (
                                    dto.getRooms().getId(),
                                    dto.getRooms().getType (),
                                    dto.getRooms().getKey_money(),
                                    dto.getRooms().getQuantity()
                            ),
                            new Student (
                                    dto.getStudent().getId(),
                                    dto.getStudent().getName(),
                                    dto.getStudent().getNic(),
                                    dto.getStudent().getAddress(),
                                    dto.getStudent().getContact(),
                                    dto.getStudent().getDob(),
                                    dto.getStudent().getEmail(),
                                    dto.getStudent().getGender()
                            ),
                            dto.getAdvance(),
                            dto.getStatus ()
                    ));
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback ();
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public boolean updateReservation(ReservationDTO dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        try{
            reservationDAO.setSession (session);
            reservationDAO.update (
                    new Reservation (
                            dto.getId(),
                            dto.getDate_time(),
                            new Rooms (
                                    dto.getRooms().getId(),
                                    dto.getRooms().getType(),
                                    dto.getRooms().getKey_money(),
                                    dto.getRooms().getQuantity()
                            ),
                            new Student (
                                    dto.getStudent().getId(),
                                    dto.getStudent().getName(),
                                    dto.getStudent().getNic(),
                                    dto.getStudent().getAddress(),
                                    dto.getStudent().getContact(),
                                    dto.getStudent().getDob (),
                                    dto.getStudent().getEmail(),
                                    dto.getStudent().getGender ()
                            ),
                            dto.getAdvance(),
                            dto.getStatus ()
                    ));
            transaction.commit();
            session.close();
            return true;

        }catch (Exception e){
            transaction.rollback ();
            e.printStackTrace ();
            return false;
        }
    }

    @Override
    public boolean deleteReservation(Reservation dto) {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction= session.beginTransaction();

        try{
            session.delete(dto);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<ReservationDTO> loadAll() {
        session=SessionFactoryConfig.getInstance ().getSession ();
        Transaction transaction=session.beginTransaction ();

        reservationDAO.setSession (session);
        List<Reservation>list= reservationDAO. loadAll ();
        List<ReservationDTO>resList= new ArrayList<>();
        System.out.println ("Check1");

        for (Reservation res :list) {
            resList.add(new ReservationDTO (
                    res.getId(),
                    res.getDateTime(),
                    new RoomDTO (
                            res.getRoom ().getId(),
                            res.getRoom ().getType (),
                            res.getRoom ().getKeyMoney(),
                            res.getRoom ().getQuantity()
                    ),
                    new StudentDTO (
                            res.getStudent().getId(),
                            res.getStudent ().getName(),
                            res.getStudent().getNic(),
                            res.getStudent ().getAddress (),
                            res.getStudent ().getContact (),
                            res.getStudent ().getDob (),
                            res.getStudent().getEmail(),
                            res.getStudent ().getGender ()
                    ),
                    res.getAdvance(),
                    res.getStatus ()
            ));
        }

        System.out.println ("Check2");
        return resList;
    }
}
