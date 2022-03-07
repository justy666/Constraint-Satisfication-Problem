
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.ArrayList;
import java.util.Hashtable;

//parent class for constraints
public abstract class constraints extends general_testing {
    ArrayList<String> constraintList = new ArrayList<>();

    public constraints() {

    }

    //will be override for every type of CSP problem constraints.
    //since every CSP problem has different satisfaction level.
    abstract public boolean evaluation_of_constraints(Hashtable<String, String> table);
}
