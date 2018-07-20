package com.luispmenezes.coffeesale.scrapper;

import java.util.Arrays;
import java.util.List;

public class GlobalConstants {

    public static final List<String> DEFAULT_COFFEE_LIST = Arrays.asList(new String[]{"Nicola Rossio","Nicola Quenia"," L'or Ristretto","Torrie Angola"});
    public static final String DEFAULT_COFFEE_BRAND = "Nesspreso";
    public static final List<String> DEFAULT_STORE_LIST = Arrays.asList(new String[]{"Continente"});

    public static final String CONF_DIR_PATH = "./conf";
    public static final String BIN_DIR_PATH = "./conf";
    public static final String PROPERTIES_PATH = CONF_DIR_PATH + "/config.properties";
    public static final String MAILER_PROPERTIES_PATH = CONF_DIR_PATH + "/mailer.properties";

}
