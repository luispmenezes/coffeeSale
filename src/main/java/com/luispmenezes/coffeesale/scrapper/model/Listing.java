package com.luispmenezes.coffeesale.scrapper.model;

public class Listing {
    private String name;
    private float price;
    private float pricePerUnit;
    private String storeName;
    private String URL;
    private boolean onSale;

    public Listing(String name, float price, float pricePerUnit, String storeName, String URL, boolean onSale) {
        this.name = name;
        this.price = price;
        this.pricePerUnit = pricePerUnit;
        this.storeName = storeName;
        this.URL = URL;
        this.onSale = onSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(float pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    @Override
    public String toString() {
        return "Listing{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", pricePerUnit=" + pricePerUnit +
                ", storeName='" + storeName + '\'' +
                ", URL='" + URL + '\'' +
                ", onSale=" + onSale +
                '}';
    }
}
