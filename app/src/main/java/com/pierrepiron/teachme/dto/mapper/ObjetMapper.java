package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.EObjet;
import com.pierrepiron.teachme.dto.model.Objet;

import java.util.ArrayList;

public class ObjetMapper {

    public Objet map(EObjet eObjet) {
        Objet objet = new Objet();

        objet.setId_objet(eObjet.getId_objet());
        objet.setDescription(eObjet.getDescription());
        objet.setPhoto(eObjet.getPhoto());
        objet.setId_stockage(eObjet.getId_stockage());

        return objet;
    }

    public ArrayList<Objet> map(ArrayList<EObjet> eObjetList) {
        ArrayList<Objet> objetList = new ArrayList<>();

        for (EObjet eObjet : eObjetList) {
            objetList.add(this.map(eObjet));
        }

        return objetList;
    }
}
