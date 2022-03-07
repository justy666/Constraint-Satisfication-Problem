
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.ArrayList;
import java.util.Hashtable;

public class domains {
    Hashtable<String, ArrayList<String>> domainsDictionary = new Hashtable<String, ArrayList<String>>();

    public domains(){

    }

    public void set_domains(String var, ArrayList<String> domainList){
        domainsDictionary.put(var, domainList);
    }

    //get the domains dictionary which contains the domains corresponding to each variable.
    public Hashtable<String, ArrayList<String>> get_domainsDictionary(){
        return domainsDictionary;
    }

}
