package org.example.dao;
import org.example.CarDto;
import org.example.Config;
import org.example.antity.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class CarDaoJdbc implements CarDao{
    public void createCarTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS Car(id int primary key auto_increment, mark varchar(40), " +
                    "model varchar(40), state_number varchar(11), year int )");
            System.out.println("Нам удалось создать таблицу с машинами");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void dropCarTable() {
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS Car");
            System.out.println("Удалось удалить таблицу с машинами");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void cleanCarTable() {
        final String DELETE_ALL_CARS = "DELETE FROM Car";
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALL_CARS)) {
            int rez = preparedStatement.executeUpdate();
            if (rez != 0) {
                System.out.println("Нам удалось удалить " + rez + " машины");
            } else {
                System.out.println("Таблица была пуста");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void saveCar(String mark, String model, String state_number, int year) {
        final String INSERT_NEW_CAR = "INSERT INTO Car(mark, model, state_number, year)"
                + " VALUES(?,?,?,?)";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_NEW_CAR)) {
            statement.setString(1, mark);
            statement.setString(2, model);
            statement.setString(3, state_number);
            statement.setInt(4, year);
            statement.execute();
            System.out.println("Удалось создать машину:" + mark + " ," + model + " , с гос. номером: " + state_number + " ," + year+ " года выпуска");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void removeCarById(long id) {
        final String DELETE_CAR = "DELETE FROM Car WHERE id = ?";
        try (Connection connection = Config.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CAR)) {
            statement.setLong(1, id);
            statement.execute();
            System.out.println("Удалось удалить автомобиль:" + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Car getCarById(long id) {
        final String GET_CAR = "SELECT * FROM Car WHERE id = ?";
        Car car = null;
        try (Connection connection = Config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CAR)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String mark = resultSet.getString("mark");
                String model = resultSet.getString("model");
                String state_number = resultSet.getString("state_number");
                int year = resultSet.getInt("year");
                car = new Car(id, mark, model, state_number, year);
            }
            return car;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Car> getAllCars() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = Config.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Car");
            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                String mark = resultSet.getString("mark");
                String model = resultSet.getString("model");
                String state_number = resultSet.getString("state_number");
                int year = resultSet.getInt("year");
                Car car = new Car(id, mark, model, state_number, year);
                cars.add(car);
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
