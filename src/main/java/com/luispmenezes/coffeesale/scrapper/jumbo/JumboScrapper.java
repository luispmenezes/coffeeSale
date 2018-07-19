package com.luispmenezes.coffeesale.scrapper.jumbo;

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

public class JumboScrapper implements GenericScrapper {

    @Override
    public List<Listing> getListingsDefault() throws IOException {
        return getListings(GlobalConstants.DEFAULT_COFFEE_LIST, GlobalConstants.DEFAULT_COFFEE_BRAND);
    }

    @Override
    public List<Listing> getListings(List<String> coffeeList, String coffeeBrand) throws IOException {
        List<Listing> listingList = new ArrayList<>();

        for (String coffee : coffeeList) {
            String connectURL = Constants.SEARCH_QUERY_URL + coffee + " " + coffeeBrand;
            connectURL = connectURL.replaceAll("\\s+", "%20");
            Document document = Jsoup.connect(connectURL).get();
            Element product = document.selectFirst(Constants.PRODUCT_DIV_QUERY);

            String title = product.selectFirst(Constants.PRODUCT_TITLE_QUERY).attr("aria-label");
            title = title.substring(title.indexOf(" ",9)+1);
            String URL = Constants.BASE_URL + product.selectFirst(Constants.PRODUCT_TITLE_QUERY).attr("href");
            float price = getPriceAsFloat(product.selectFirst(Constants.PRODUCT_PRICE_QUERY).text());
            float PPU = getPPUAsFloat(product.selectFirst(Constants.PRODUCT_PPU_QUERY).text());
            boolean onSale = false;
            //TODO: Implementar

            Listing listing = new Listing(title, price, PPU, Constants.STORE_NAME, URL, onSale);

            listingList.add(listing);

        }


        return listingList;
    }

    private float getPriceAsFloat(String priceStr){
        priceStr = priceStr.substring(1,priceStr.indexOf(" "));
        priceStr = priceStr.replace(",",".");
        return Float.parseFloat(priceStr);
    }

    private float getPPUAsFloat(String priceStr){
        priceStr = priceStr.substring(2,priceStr.indexOf("/"));
        priceStr = priceStr.replace(",",".");
        return Float.parseFloat(priceStr);
    }
}
