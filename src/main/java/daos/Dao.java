package daos;

import java.util.List;

public interface Dao<T> {

    public T findCarsById(int id);
    public List findAll();
    public Boolean  update(Object object);
    public Boolean create(Object object);
    public Boolean delete(int id);

}
