package daos;

import com.sun.jdi.connect.Connector;
import models.Cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsDAO implements Dao {


    public Cars findCarsById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM cars WHERE CarID=%d", id));

            if (rs.next()) {
                extractCarsFromResultSet(rs);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Cars extractCarsFromResultSet(ResultSet rs) throws SQLException {
        Cars cars = new Cars();
        cars.setId(rs.getInt("id"));
        cars.setMake(rs.getString("make"));
        cars.setModel(rs.getString("model"));
        cars.setColor(rs.getString("color"));
        cars.setYear(rs.getInt("year"));
        cars.setVin(rs.getString("vin"));
        return cars;
    }


    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cars");
            List carsList = new ArrayList<Cars>();
            while (rs.next()) {
                Cars car = extractCarsFromResultSet(rs);
                carsList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Cars cars) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE cars SET make=?, model=?, year=?, color=?, vin=?, WHERE id=?);


            ps.setString(1, cars.getMake());
            ps.setString(2, cars.getModel());
            ps.setString(3, cars.getYear());
            ps.setString(4, cars.getColor());
            ps.setString(5, cars.getVin());
            ps.setInt(6, cars.getId());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        return false;
    }

    public Boolean create(Cars cars) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO cars VALUES(?, ?, ?, ?, ?, ?);

                    ps.setInt(1, cars.getId()));
            ps.setString(2, cars.getMake());
            ps.setString(3, cars.getModel());
            ps.setString(4, cars.getYear());
            ps.setString(5, cars.getColor());
            ps.setString(6, cars.getVin());
            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    public Boolean delete(int id) {
        return null;
    }
}

