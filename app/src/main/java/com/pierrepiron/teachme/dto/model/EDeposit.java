package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EDeposit {
    @SerializedName("Id_deposit") private int id_stockage;
    @SerializedName("Name") private String name;
    @SerializedName("Adresse") private String adresse;
    @SerializedName("CoordX") private Double coordX;
    @SerializedName("CoordY") private Double coordY;
    @SerializedName("Tel") private String tel;
    @SerializedName("IsAssos") private int type;
    @SerializedName("horaire") private ArrayList<EHoraire> horaire;
    @SerializedName("admin") private int id_user;
    @SerializedName("product") private ArrayList<EProduct> productList;

    public EDeposit(int id_stockage, String name, String adresse, Double coordX, Double coordY, String tel, int type, ArrayList<EProduct> eProducts) {
        this.id_stockage = id_stockage;
        this.name = name;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
    }

    public EDeposit(int id_stockage, String name, String adresse, Double coordX, Double coordY, String tel, int type, int id_user, ArrayList<EProduct> eProducts) {
        this.id_stockage = id_stockage;
        this.name = name;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
        this.id_user = id_user;
    }

    public EDeposit() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public ArrayList<EProduct> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<EProduct> productList) {
        this.productList = productList;
    }

    public ArrayList<EHoraire> getHoraire() {
        return horaire;
    }

    public void setHoraire(ArrayList<EHoraire> horaire) {
        this.horaire = horaire;
    }
}
