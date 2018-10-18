package com.pierrepiron.teachme.dto.model;

import java.util.ArrayList;

public class Stockage {

    private int id_stockage;
    private String adresse;
    private Double coordX;
    private Double coordY;
    private String tel;
    private Boolean type;
    private int id_user;
    private ArrayList<Objet> listeObjets;

    public Stockage(int id_stockage, String adresse, Double coordX, Double coordY, String tel, Boolean type, int id_user) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
        this.id_user = id_user;
    }

    public Stockage(int id_stockage, String adresse, Double coordX, Double coordY, String tel, Boolean type) {
        this.id_stockage = id_stockage;
        this.adresse = adresse;
        this.coordX = coordX;
        this.coordY = coordY;
        this.tel = tel;
        this.type = type;
    }

    public Stockage() {
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

    public ArrayList<Objet> getListeObjets() {
        return listeObjets;
    }

    public void setListeObjets(ArrayList<Objet> listeObjets) {
        this.listeObjets = listeObjets;
    }

}
