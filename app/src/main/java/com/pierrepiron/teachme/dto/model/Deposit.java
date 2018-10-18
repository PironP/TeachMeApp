package com.pierrepiron.teachme.dto.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Deposit implements Serializable {

    private int id_stockage;
    private String name;
    private String adresse;
    private Double coordX;
    private Double coordY;
    private String tel;
    private int type;
    private int id_user;
    private ArrayList<Product> productList;

    public Deposit(int id_stockage, String name, String adresse, Double coordX, Double coordY, String tel, int type, int id_user) {
        this.id_stockage = id_stockage;
        this.name = name;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
        this.id_user = id_user;
    }

    public Deposit(int id_stockage, String name, String adresse, Double coordX, Double coordY, String tel, int type) {
        this.id_stockage = id_stockage;
        this.name = name;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
    }

    public Deposit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public int getId_stockage() {
        return id_stockage;
    }

    public void setId_stockage(int id_stockage) {
        this.id_stockage = id_stockage;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getCoordX() {
        return coordX;
    }

    public void setCoordX(Double coordX) {
        this.coordX = coordX;
    }

    public Double getCoordY() {
        return coordY;
    }

    public void setCoordY(Double coordY) {
        this.coordY = coordY;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }




}
