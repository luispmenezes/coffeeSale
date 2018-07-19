package com.luispmenezes.coffeesale.scrapper.continente;

public class Constants {

    public static final String STORE_NAME = "Continente";

    public static final String BASE_URL = "https://www.continente.pt";
    public static final String SEARCH_QUERY_URL = BASE_URL + "/pt-pt/public/Pages/searchresults.aspx?k=";

    public static final String PRODUCT_DIV_QUERY = ".productBoxTop";
    public static final String PRODUCT_TITLE_QUERY = ".ecsf_QuerySuggestions";
    public static final String PRODUCT_PRICE_QUERY = ".priceFirstRow";
    public static final String PRODUCT_PPU_QUERY = ".priceSecondRow";
    public static final String PRODUCT_DISCOUNT_QUERY = ".priceWasRows";

}
