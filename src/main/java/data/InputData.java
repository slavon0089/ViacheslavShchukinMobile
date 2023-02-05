package data;

import org.apache.commons.lang3.RandomStringUtils;

public class InputData {
    public static String googleSearchText = "EPAM";
    public static String baseURL = "http://google.com";
    public static String userName = RandomStringUtils.random(10,true,false) +"@gmail.com";;
    public static String password = RandomStringUtils.random(8,true,true);;
}
