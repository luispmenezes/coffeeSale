package com.luispmenezes.coffeesale.scrapper;

import com.luispmenezes.coffeesale.scrapper.model.Listing;

import java.io.IOException;
import java.util.List;

public interface GenericScrapper {

    List<Listing> getListingsDefault() throws IOException;
    List<Listing> getListings(List<String> coffeeList, String coffeeBrand) throws IOException;

}
