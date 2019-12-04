package daos;

import models.Cars;

import java.util.List;

public interface Dao<T> {

    public T findCarsById(int id);
    public List findAll();
    public T update(Cars dto);
    public T create(Cars dto);
    public T delete(int id);

}
