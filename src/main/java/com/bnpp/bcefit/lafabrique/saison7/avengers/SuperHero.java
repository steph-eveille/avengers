package com.bnpp.bcefit.lafabrique.saison7.avengers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperHero extends Humanoid {

    private String nomSuperHero;
    private List powers;

    private String ajouteDeco(String nom) {
        return nom;
    }


    public String getNomSuperHero() {
        return nomSuperHero;
    }

    public SuperHero(Humanoid humanoid, String nomSuperHero, List<String> powers) {
        super(humanoid.getName(), humanoid.getAge());
        this.nomSuperHero = nomSuperHero;
        this.powers = powers;
    }

    public List getPowers() {
        return Collections.unmodifiableList(powers);
    }
}

