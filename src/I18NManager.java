import java.util.HashMap;
import java.util.ResourceBundle;
//Esto es un singleton
public class I18NManager {

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
        ResourceBundle rb = data.get(language);
        rb= ResourceBundle.getBundle(language);
        if(rb == null){
            log.info("");
                    rb=ResourceBundle.getBundle("edu.upc.eetac.dsa.`patrons.i18n."+language);
                            data.put(language, rb);
        }
        return rb.getString(key);

    }

    public static void main(String[]args){
        String value = I18NManager.getInstance().getText("ca", "t2");
        value = I18NManager.getInstance().getText("ca","t2");
        value = I18NManager.getInstance().getText("en","t1");

    }


}
