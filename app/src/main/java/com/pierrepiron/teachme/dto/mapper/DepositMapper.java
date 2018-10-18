package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.Deposit;
import com.pierrepiron.teachme.dto.model.EDeposit;

import java.util.ArrayList;

public class DepositMapper {


    public Deposit map(EDeposit eDeposit) {
        Deposit deposit= new Deposit();

        deposit.setId_stockage(eDeposit.getId_stockage());
        deposit.setName(eDeposit.getName());
        deposit.setAdresse(eDeposit.getAdresse());
        deposit.setCoordX(eDeposit.getCoordX());
        deposit.setCoordY(eDeposit.getCoordY());
        deposit.setTel(eDeposit.getTel());
        deposit.setType(eDeposit.getType());
        if (eDeposit.getProductList() != null) {
            ProductMapper productMapper = new ProductMapper();
            deposit.setProductList(productMapper.map(eDeposit.getProductList()));
        }

        return deposit;
    }

    public ArrayList<Deposit> map(ArrayList<EDeposit> eStockageList) {
        ArrayList<Deposit> stockageList = new ArrayList<>();

        for (EDeposit eDeposit: eStockageList) {
            stockageList.add(this.map(eDeposit));
        }

        return stockageList;
    }
}
