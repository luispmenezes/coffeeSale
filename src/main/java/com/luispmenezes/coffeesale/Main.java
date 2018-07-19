package com.luispmenezes.coffeesale;

import com.luispmenezes.coffeesale.scrapper.continente.ContinenteScrapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ContinenteScrapper continenteScrapper = new ContinenteScrapper();
        try {
            System.out.println(continenteScrapper.getListingsDefault());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
