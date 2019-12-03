package daos;

import java.util.List;

public interface DAO {

    public <T> T findById(int id);
    public List findAll();
    public <T> T update(T dto);
    public <T> T create(T dto);
    public void delete(int id);

}
