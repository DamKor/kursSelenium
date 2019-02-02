package configuration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesLoader {

    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    //W klasie znajduje się tylko jedna metoda. Służy ona do odczytywania właściwości z zadanego pliku properties
    public Properties getPropertiesFromFile(String propertiesFileName){

        //Tworzymy obiekt InputStream, który posłuży nam  do odczytania pliku properties
        InputStream inputStream = null;

        //Obiekt Properties będzie przechowywał właściwości
        Properties properties = new Properties();
        try {
            logger.info("Trying to load properties with file name " + propertiesFileName);

            //Odczytujemy plik properties i inicjalizujemy obiekt inputStream
             inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if (inputStream != null) {
                //Ładujemy properties w formie InputStream do właściwego obiektu typu Properties
                properties.load(inputStream);

                logger.info("properties załadowane !!!");
            } else {
                throw new RuntimeException("Property file " + propertiesFileName + " not found in the classpath");
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Na sam koniec zamykamy InputStream wywołując prywatną metodę closeResource
            closeResource(inputStream);
        }
        return properties;
        }

        private void closeResource(InputStream inputStream){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
