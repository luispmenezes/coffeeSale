package com.luispmenezes.coffeesale;

import com.luispmenezes.coffeesale.email.NotificationManager;
import com.luispmenezes.coffeesale.scrapper.GlobalConstants;
import com.luispmenezes.coffeesale.scrapper.continente.ContinenteScrapper;
import com.luispmenezes.coffeesale.scrapper.jumbo.JumboScrapper;
import com.luispmenezes.coffeesale.scrapper.model.Listing;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Main {

    private static Properties properties;

    public static void main(String[] args) {
        try {
            properties = new Properties();
            InputStream inputStream = new FileInputStream(GlobalConstants.PROPERTIES_PATH);
            properties.load(inputStream);

            ContinenteScrapper continenteScrapper = new ContinenteScrapper();
            JumboScrapper jumboScrapper = new JumboScrapper();

            List<Listing> listingContinente = continenteScrapper.getListingsDefault();
            List<Listing> listingJumbo = jumboScrapper.getListingsDefault();

            NotificationManager.sendMail("Coffee Sale Report", listingContinente+"/n"+listingJumbo);

            System.out.println(listingContinente);
            System.out.println(listingJumbo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
