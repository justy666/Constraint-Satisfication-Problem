
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class csp {
    ArrayList<String> myvariablesList = new ArrayList<>();
    Hashtable<String, ArrayList<String>> mydomain_HASHTABLE = new Hashtable<String, ArrayList<String>>();
    Hashtable<String, ArrayList<constraints>> mycontraints_HASHTABLE = new Hashtable<String, ArrayList<constraints>>();

    ArrayList<constraints> EmptyList = new ArrayList<>();
    String variable;

    public csp(ArrayList<String> variables, Hashtable<String, ArrayList<String>> domain_HASHTABLE) {
        this.mydomain_HASHTABLE = domain_HASHTABLE;
        this.myvariablesList = variables;
        for (int i = 0; i < myvariablesList.size(); i++) {
            variable = myvariablesList.get(i);
            this.mycontraints_HASHTABLE.put(variable, EmptyList);
            if (!mydomain_HASHTABLE.containsKey(variable)) {
                System.out.println("Error!");
            }
        }
    }


    public boolean consistent(String val, Hashtable<String, String> Assignment) {
        //mycontraints_HASHTABLE size is 0 for 8-queen, what the fuck?
        for (int i = 0; i < mycontraints_HASHTABLE.get(val).size(); i++) {
//            System.out.println("here?");
//            System.out.println("never here?"); //8-queen never reaches here.? why?
            if (!mycontraints_HASHTABLE.get(val).get(i).evaluation_of_constraints(Assignment)) {

//                System.out.println("here in consistent function");
//                System.out.println("never here.");//8-queen never reaches here.? why?
                return false;
            }
        }
//        System.out.println("here2");
        return true;
    }

    public void add_binary_constraint(constraints con) {
        for (int i = 0; i < con.constraintList.size(); i++) {
            String variable = con.constraintList.get(i);
            if (!myvariablesList.contains(variable)) {
                System.out.println("Not in CSP!");
            } else {
                mycontraints_HASHTABLE.get(variable).add(con);
            }
        }
    }


    ArrayList<String> UnassignedList = new ArrayList<>();

    String original;
    Hashtable<String, String> result = new Hashtable<>();
    Hashtable<String, String> local = new Hashtable<>();
    public Hashtable<String, String> backtracking(Hashtable<String, String> Assignment) {
        if (Assignment.size() == myvariablesList.size()) {  //base case
            return Assignment;
        }

        for (int i = 0; i < myvariablesList.size(); i++) {
            if (!Assignment.contains(myvariablesList.get(i))) {
//                System.out.println("here");
                UnassignedList.add(myvariablesList.get(i));
            }
//            Assignment.remove(myvariablesList.get(i));
        }
        original = UnassignedList.remove(0);
//        System.out.println(UnassignedList);
//        System.out.println(UnassignedList);

        for (String value : mydomain_HASHTABLE.get(original)) {
//            System.out.println("original: " + original + " "  + mydomain_HASHTABLE.get(original));

            local.putAll(Assignment);
//            System.out.println(local);
//         local = copyMap(Assignment);
//            System.out.println(local);
            local.put(original, value);
//            System.out.println(consistent(original, local));
            if (consistent(original, local)) { //for 8 queen, this shit is always true. WHAT THE FUCK?
                result = backtracking(local);
                if (result != null) {

                    return result;
                }
            }
        }
        return null;
    }
//
//    public static <K, V> Hashtable<K, V> copyMap(Hashtable<K, V> original) {
//        Hashtable<K, V> second_Map = new Hashtable<>();
//        for (Map.Entry<K, V> entry : original.entrySet()) {
//            second_Map.put(entry.getKey(),
//                    entry.getValue());
//        }
//        return second_Map;
//    }

}
