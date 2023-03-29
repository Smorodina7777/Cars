package org.example;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CarDao carDao = new CarDao();
        carDao.createCarTable();
        carDao.saveCar("Lada", "Granta", "У456КЕ154RU", 2020);
        carDao.saveCar("Toyota", "Raum", "Ф363МЕ154RU", 2000);
        carDao.saveCar("Toyota", "Harrier", "У369РО154RU", 2001);
        carDao.saveCar("Nissan", "Infinity", "О001ОО154RU", 2023);
        System.out.println(carDao.getAllCars());
        carDao.deleteCarById(1);
        System.out.println(carDao.getAllCars());
        CarDto carDto = carDao.getCarById(3);
        System.out.println("Попытка найти автомобиль " + 4);
        System.out.println(carDto);
        carDao.cleanCarTable();
        System.out.println(carDao.getAllCars());
        carDao.cleanCarTable();
        carDao.dropCarTable();

    }
}
