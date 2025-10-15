package Lesson3;

public class Car {
    private String country;
    private String model;
    private Integer yearOfManufacture;

    private String printCarInfo(){
        return country + "\n" + model + "\n" + yearOfManufacture;
    }
}
