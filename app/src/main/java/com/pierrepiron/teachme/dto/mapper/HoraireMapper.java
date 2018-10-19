package com.pierrepiron.teachme.dto.mapper;

import com.pierrepiron.teachme.dto.model.EHoraire;
import com.pierrepiron.teachme.dto.model.Horaire;

import java.util.ArrayList;

public class HoraireMapper {


    public Horaire map(EHoraire eHoraire) {
        Horaire horaire = new Horaire();

        horaire.setId_horaire(eHoraire.getId_horaire());
        horaire.setMonday(eHoraire.getMonday());
        horaire.setTuesday(eHoraire.getTuesday());
        horaire.setWednesday(eHoraire.getWednesday());
        horaire.setThursday(eHoraire.getThursday());
        horaire.setFriday(eHoraire.getFriday());
        horaire.setSaturday(eHoraire.getSaturday());
        horaire.setSunday(eHoraire.getSunday());

        return horaire;
    }

    public ArrayList<Horaire> map(ArrayList<EHoraire> eHoraireList) {
        ArrayList<Horaire> horaireList = new ArrayList<>();

        for (EHoraire eHoraire: eHoraireList) {
            horaireList.add(this.map(eHoraire));
        }

        return horaireList;
    }
}
