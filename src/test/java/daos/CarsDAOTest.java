package daos;

import com.sun.jdi.connect.Connector;
import com.sun.org.apache.xpath.internal.operations.Bool;
import models.Cars;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CarsDAOTest<T> {


    CarsDAO<T> carsDAO;
    Cars car;


    @Before
    public void setup() {
        carsDAO = new CarsDAO();
        car = new Cars();

    }

    @Test
    public void findCarsByIdTest() {
        car = carsDAO.findCarsById(4);
        Assert.assertEquals("Highlander", car.getModel());
    }

    @Test
    public void findAll() {
        List<Cars> carList = new ArrayList<Cars>();
        carList = carsDAO.findAll();
        Assert.assertEquals(5, carList.size());
    }

    @Test
    public void update() {
        car = carsDAO.findCarsById(5);
        car.setColor("Red");
        carsDAO.update(car);
        car = carsDAO.findCarsById(5);
        Assert.assertTrue(car.getColor().equals("Red"));
    }

    @Test
    public void create() {
        Cars cars = new Cars(7, "Volvo", "S10", "2030", "Blue", "13423425235");
        carsDAO.create(cars);
        car = carsDAO.findCarsById(7);
        Assert.assertTrue(car.getModel().equals("S10"));
    }

    @Test
    public void delete() {
        Boolean cardelete =  carsDAO.delete(7);
        Assert.assertTrue(cardelete);
    }
}
