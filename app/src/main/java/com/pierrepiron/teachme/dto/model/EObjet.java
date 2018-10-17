package com.pierrepiron.teachme.dto.model;

import com.google.gson.annotations.SerializedName;

public class EObjet {
    @SerializedName("id_objet") private int id_objet;
    @SerializedName("photo") private String photo;
    @SerializedName("description") private String description;
    @SerializedName("id_stockage") private int id_stockage;

    public EObjet() {
    }

    public EObjet(int id_objet, String photo, String description, int id_stockage) {
        this.id_objet = id_objet;
        this.photo = photo;
        this.description = description;
        this.id_stockage = id_stockage;
    }

    public int getId_objet() {
        return id_objet;
    }

    public void setId_objet(int id_objet) {
        this.id_objet = id_objet;
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
}
