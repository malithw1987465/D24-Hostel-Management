package lk.ijse.D24.dao;

import java.util.List;

public interface CrudDAO<T> extends SuperDAO {
    List<T> loadAll();
    String save(T t);
    void update(T t);
    void delete(T t);
    T getObject(String id) throws Exception;
}
