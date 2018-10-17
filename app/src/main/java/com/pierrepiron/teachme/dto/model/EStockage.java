package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;
import com.pierrepiron.teachme.dto.mapper.ObjetMapper;

import java.util.ArrayList;

public class EStockage {
    @SerializedName("id_stockage") private int id_stockage;
    @SerializedName("adresse") private String adresse;
    @SerializedName("coordX") private String coordX;
    @SerializedName("coordY") private String coordY;
    @SerializedName("tel") private String tel;
    @SerializedName("type") private Boolean type;
    @SerializedName("id_user") private int id_user;
    @SerializedName("listObject") private ArrayList<EObjet> listeObjets;

    public EStockage(int id_stockage, String adresse, String coordX, String coordY, String tel, Boolean type, ArrayList<EObjet> eObjets) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
    }

    public EStockage(int id_stockage, String adresse, String coordX, String coordY, String tel, Boolean type, int id_user, ArrayList<EObjet> eObjets) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
        this.id_user = id_user;
        // this.listeObjets = ObjetMapper.ma
    }

    public EStockage() {
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

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
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
