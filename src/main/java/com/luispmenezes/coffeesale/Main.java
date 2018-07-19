package com.luispmenezes.coffeesale;

import com.luispmenezes.coffeesale.scrapper.continente.ContinenteScrapper;
import com.luispmenezes.coffeesale.scrapper.jumbo.JumboScrapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        ContinenteScrapper continenteScrapper = new ContinenteScrapper();
        JumboScrapper jumboScrapper = new JumboScrapper();
        try {
            System.out.println(continenteScrapper.getListingsDefault());
            System.out.println(jumboScrapper.getListingsDefault());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
