
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.ArrayList;

public class variables {
    ArrayList<String> variablesList = new ArrayList<>();

    public variables(){}

    //add variables inside of the
    public void add_variables(String item){
        variablesList.add(item);
    }

    public ArrayList<String> get_variablesList(){
        return variablesList;
    }


}
