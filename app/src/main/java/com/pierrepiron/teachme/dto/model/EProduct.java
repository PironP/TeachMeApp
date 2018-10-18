package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;

public class EProduct {
    @SerializedName("Id_Product") private int id_product;
    @SerializedName("Photo") private String photo;
    @SerializedName("Description") private String description;
    @SerializedName("Id_Stockage") private int id_stockage;
    @SerializedName("Id_Categorie") private int id_categorie;
    @SerializedName("Categorie") private String categorie;

    public EProduct() {
    }

    public EProduct(int id_product, String photo, String description, int id_stockage) {
        this.id_product = id_product;
        this.photo = photo;
        this.description = description;
        this.id_stockage = id_stockage;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_stockage() {
        return id_stockage;
    }

    public void setId_stockage(int id_stockage) {
        this.id_stockage = id_stockage;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
