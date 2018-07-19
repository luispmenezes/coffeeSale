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

public class ContinenteScrapper implements GenericScrapper {

    @Override
    public List<Listing> getListingsDefault() throws IOException {
        return getListings(GlobalConstants.DEFAULT_COFFEE_LIST, DEFAULT_COFFEE_BRAND);
    }

    @Override
    public List<Listing> getListings(List<String> coffeeList, String coffeeBrand) throws IOException {

        List<Listing> listingList = new ArrayList<>();

        for(String coffee : coffeeList){

            Document document = Jsoup.connect(Constants.SEARCH_QUERY_URL+coffee+" "+coffeeBrand).get();
            Elements productList = document.select(Constants.PRODUCT_DIV_QUERY);

            for(Element product: productList){
                String title = product.selectFirst(Constants.PRODUCT_TITLE_QUERY).selectFirst("img").attr("alt");
                String URL = product.selectFirst(Constants.PRODUCT_TITLE_QUERY).attr("href");
                URL = URL.substring(0,URL.indexOf("("));
                float price = getPriceAsFloat(product.selectFirst(Constants.PRODUCT_PRICE_QUERY).text());
                float PPU = getPriceAsFloat(product.selectFirst(Constants.PRODUCT_PPU_QUERY).text());
                boolean onSale = !product.select(Constants.PRODUCT_DISCOUNT_QUERY).isEmpty();

                Listing listing = new Listing(title,price,PPU,Constants.STORE_NAME,URL,onSale);

                listingList.add(listing);
            }
        }


        return listingList;
    }

    private float getPriceAsFloat(String priceStr){
        priceStr = priceStr.substring(2,priceStr.lastIndexOf(" "));
        priceStr = priceStr.replace(",",".");
        return Float.parseFloat(priceStr);
    }


}
