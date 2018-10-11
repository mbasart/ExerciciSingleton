package edu.upc.eetac.dsa.patrons.i18n;

import org.junit.Assert;
import org.junit.Test;

public class I18NManagerTest {
    //aqui farem el test del singleton
    // sóc la noe jo tb he fet cosetes

    @Test
    public void testGetText(){
        String s = I18NManager.getInstance().getText("ca","t1");
        Assert.assertEquals("Hola",s);

        String s2 = I18NManager.getInstance().getText("en","t1");
        Assert.assertEquals("Hello",s2);

        String s3 = I18NManager.getInstance().getText("ca","t2");
        Assert.assertEquals("Adeu",s3);

        String s4 = I18NManager.getInstance().getText("en","t2");
        Assert.assertEquals("Bye",s4);
    }


}
