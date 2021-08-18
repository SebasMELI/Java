package demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class MyFactory {

    private Properties properties;

    public MyFactory(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("src/MyFactory.properties")));
            this.properties = properties;
        }catch (Exception ex){
            System.out.println("Archivo no encontrado");
        }
    }

    public Object getInstance(String objName){
        return this.properties.getProperty(objName);
    }
}
