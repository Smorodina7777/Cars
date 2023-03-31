package org.example.dao;

import org.example.antity.Car;
import java.util.List;


public interface CarDao {
    public void createCarTable();

    public void dropCarTable();

    public void saveCar(String mark, String model, String stateNumber, int year);

    public void removeCarById(long id);

    public List<Car> getAllCars();

    public void cleanCarTable();
}
