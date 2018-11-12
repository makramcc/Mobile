package com.setting.thailandmetromap.project_mobile_app;

class Data_Car {

    private int id_car;




    private int image;
    private String city,car_model,car_brand,car_detail;


    Data_Car(int id_car, int image,String city, String model, String brand,String detail) {
        this.id_car = id_car;
        this.city = city;
        this.car_model = model;
        this.car_brand = brand;
        this.car_detail = detail;
        this.image=image;
    }

    public int getCar_id() {
        return id_car;
    }

    public void setCar_id(int car_id) {
        this.id_car = car_id;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrand() {
        return car_brand;
    }

    public void setBrand(String brand) {
        this.car_brand = brand;
    }

    public String getModel() {
        return car_model;
    }

    public void setModel(String model) {
        this.car_model = model;
    }

    public String getDetail() {
        return car_detail;
    }

    public void setDetail(String detail) {
        this.car_detail = detail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
