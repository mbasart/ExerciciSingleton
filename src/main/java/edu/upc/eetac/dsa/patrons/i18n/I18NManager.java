package edu.upc.eetac.dsa.patrons.i18n;

import java.util.HashMap;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;

//Esto es un singleton
public class I18NManager {

    //mostra informacio amb log4j
    final Logger log = Logger.getLogger(I18NManager.class);

    private static I18NManager instance;//atributos

    private HashMap<String, ResourceBundle> data; // resourcebundle es el contenedor

    private I18NManager (){//constructor inicializa

        this.data = new HashMap<String, ResourceBundle>();//inicializa data
    }

    public static I18NManager getInstance()//devuelve la instacia de I18
    {
        if (instance==null) instance=new I18NManager();
        return instance;

    }
    public String getText(String language, String key){
        log.info("language "+language+ "key: "+key);
        ResourceBundle rb = data.get(language); //resourceBandle quan volem agafar coses del resource
        String ret = null; //inicialitzem la paraula que retornara
        if(rb == null){
            log.info("Classloader:: language "+language+ "key: "+key);
            try {
                rb=ResourceBundle.getBundle("edu.upc.eetac.dsa.patrons.i18n."+language); //agafar el que conte el resource
                data.put(language, rb); //un cop agafat ho tirem dins la cache i aixi en propers cops no haurem de tornar a fer el proces d'agafar i tirar
            }
            catch (Throwable t) {
                log.error("!!!!"+t.getMessage()); //si no troba el nom del fitxer al resource, llença una excepcio
            }
        }
        else log.info ("Cache::"); //ja ho agafa directament de la cache

        if (rb!=null) ret = rb.getString(key); //guarda la paraula
        log.info("text: "+ ret); //ensenya la paraula
        return ret;
    }

    public static void main(String[]args){
        String value = I18NManager.getInstance().getText("ca", "t2");
        value = I18NManager.getInstance().getText("ca","t2");
        value = I18NManager.getInstance().getText("en","t1");
        value = I18NManager.getInstance().getText("ru","t1");

    }


}
