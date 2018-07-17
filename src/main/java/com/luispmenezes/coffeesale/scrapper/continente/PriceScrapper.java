package com.luispmenezes.coffeesale.scrapper.continente;

import com.luispmenezes.coffeesale.scrapper.GenericScrapper;
import com.luispmenezes.coffeesale.scrapper.GlobalConstants;
import com.luispmenezes.coffeesale.scrapper.model.Listing;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.luispmenezes.coffeesale.scrapper.GlobalConstants.DEFAULT_COFFEE_BRAND;

public class PriceScrapper implements GenericScrapper {

    public List<Listing> getListingsDefault() throws IOException {
        return getListings(GlobalConstants.DEFAULT_COFFEE_LIST, DEFAULT_COFFEE_BRAND);
    }

    public List<Listing> getListings(List<String> coffeeList, String coffeeBrand) throws IOException {

        List<Listing> listingList = new ArrayList<>();

        for(String coffee : coffeeList){

            Document document = Jsoup.connect(Constants.SEARCH_QUERY_URL+coffee+" "+coffeeBrand).get();
            Elements productList = document.select(Constants.PRODUCT_DIV_QUERY);

            for(Element product: productList){
                String title = product.selectFirst(Constants.PRODUCT_TITLE_QUERY).text();
                String URL = product.selectFirst(Constants.PRODUCT_TITLE_QUERY).attr("href");
                float price = Float.parseFloat(product.selectFirst(Constants.PRODUCT_PRICE_QUERY).text().substring(2));
                float PPU = Float.parseFloat(product.selectFirst(Constants.PRODUCT_PPU_QUERY).text().substring(2));

                Listing listing = new Listing(title,price,PPU,Constants.STORE_NAME,URL);

                listingList.add(listing);
            }
        }


        return listingList;
    }

}
