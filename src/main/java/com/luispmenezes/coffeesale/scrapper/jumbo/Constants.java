package com.luispmenezes.coffeesale.scrapper.jumbo;

public class Constants {

    public static final String STORE_NAME = "Jumbo";

    public static final String BASE_URL = "https://www.jumbo.pt/Frontoffice";
    public static final String SEARCH_QUERY_URL = BASE_URL + "/search/";

    public static final String PRODUCT_DIV_QUERY = ".product-item-border";
    public static final String PRODUCT_TITLE_QUERY = ".product-item-header>a";
    public static final String PRODUCT_PRICE_QUERY = ".product-item-price";
    public static final String PRODUCT_PPU_QUERY = ".product-item-quantity-price";
    public static final String PRODUCT_DISCOUNT_QUERY = ".priceWasRows";



}
