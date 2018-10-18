package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;
import com.pierrepiron.teachme.dto.mapper.ObjetMapper;

import java.util.ArrayList;

public class EDeposit {
    @SerializedName("id_stockage") private int id_stockage;
    @SerializedName("adresse") private String adresse;
    @SerializedName("coordX") private Double coordX;
    @SerializedName("coordY") private Double coordY;
    @SerializedName("tel") private String tel;
    @SerializedName("type") private Boolean type;
    @SerializedName("id_user") private int id_user;
    @SerializedName("listObject") private ArrayList<EProduct> productList;

    public EDeposit(int id_stockage, String adresse, Double coordX, Double coordY, String tel, Boolean type, ArrayList<EProduct> eProducts) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
    }

    public EDeposit(int id_stockage, String adresse, Double coordX, Double coordY, String tel, Boolean type, int id_user, ArrayList<EProduct> eProducts) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
        this.id_user = id_user;
        // this.listeObjets = ObjetMapper.ma
    }

    public EDeposit() {
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

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
