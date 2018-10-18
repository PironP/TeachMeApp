package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.EProduct;
import com.pierrepiron.teachme.dto.model.Product;

import java.util.ArrayList;

public class ProductMapper {

    public Product map(EProduct eProduct) {
        Product objet = new Product();

        objet.setId_product(eProduct.getId_product());
        objet.setDescription(eProduct.getDescription());
        objet.setPhoto(eProduct.getPhoto());
        objet.setId_stockage(eProduct.getId_stockage());
        objet.setId_categorie(eProduct.getId_categorie());
        objet.setCategorie(eProduct.getCategorie());

        return objet;
    }

    public ArrayList<Product> map(ArrayList<EProduct> eObjetList) {
        ArrayList<Product> objetList = new ArrayList<>();

        for (EProduct eProduct : eObjetList) {
            objetList.add(this.map(eProduct));
        }

        return objetList;
    }
}
