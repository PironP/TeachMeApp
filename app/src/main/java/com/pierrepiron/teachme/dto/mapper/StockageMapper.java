package com.pierrepiron.teachme.dto.mapper;


import com.pierrepiron.teachme.dto.model.EStockage;
import com.pierrepiron.teachme.dto.model.Stockage;

import java.util.ArrayList;

public class StockageMapper {


    public Stockage map(EStockage eStockage) {
        Stockage stockage = new Stockage();

        stockage.setId_stockage(eStockage.getId_stockage());
        stockage.setAdresse(eStockage.getAdresse());
        stockage.setCoordX(eStockage.getCoordX());
        stockage.setCoordY(eStockage.getCoordY());
        stockage.setTel(eStockage.getTel());
        stockage.setType(eStockage.getType());
        // stockage.setListeObjets(eStockage.ge);

        return stockage;
    }

    public ArrayList<Stockage> map(ArrayList<EStockage> eStockageList) {
        ArrayList<Stockage> stockageList = new ArrayList<>();

        for (EStockage eStockage : eStockageList) {
            stockageList.add(this.map(eStockage));
        }

        return stockageList;
    }
}
