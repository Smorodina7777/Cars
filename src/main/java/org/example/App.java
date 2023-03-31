package org.example;

import org.example.antity.Car;
import org.example.dao.CarDao;
import org.example.dao.CarDaoHibernate;
import org.example.dao.CarDaoJdbc;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CarDao carDaoJdbc = new CarDaoHibernate();
        carDaoJdbc.createCarTable();
        carDaoJdbc.saveCar("Lada", "Granta", "У456КЕ154RU", 2020);
        carDaoJdbc.saveCar("Toyota", "Raum", "Ф363МЕ154RU", 2000);
        carDaoJdbc.saveCar("Toyota", "Harrier", "У369РО154RU", 2001);
        carDaoJdbc.saveCar("Nissan", "Infinity", "О001ОО154RU", 2023);
        System.out.println(carDaoJdbc.getAllCars());
        carDaoJdbc.removeCarById(1);
        System.out.println(carDaoJdbc.getAllCars());
        carDaoJdbc.cleanCarTable();
        System.out.println(carDaoJdbc.getAllCars());
        carDaoJdbc.cleanCarTable();
        carDaoJdbc.dropCarTable();

    }
}
