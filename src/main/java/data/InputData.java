package data;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InputData {
    public static String googleSearchText = "EPAM";
    public static String baseURL = "http://google.com";
    public static String userName = RandomStringUtils.random(10,true,false) +"@gmail.com";;
    public static String password = RandomStringUtils.random(8,true,true);


    private static final String PATH_NAME = "src/test/resources/config.properties";

    public static Properties getPropertyObject() {
        Properties prop = new Properties();
        String path = new File(PATH_NAME).getAbsolutePath();
        try (FileInputStream fp = new FileInputStream(path)){
            prop.load(fp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    public static String getApiKeyFromProperties() {
        return getPropertyObject().getProperty("API_KEY");
    }

    public static String getProjectNameFromProperties() {
        return getPropertyObject().getProperty("PROJECT_NAME");
    }


}
