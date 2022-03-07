
import java.util.ArrayList;
import java.util.Hashtable;

//subclass for map_problem
public class map_problem extends constraints{
    String location1;
    String location2;

    public map_problem(String one, String two){
        super();
    super.constraintList.add(one);
    super.constraintList.add(two);
    this.location1 = one;
    this.location2 = two;
    }

    @Override
    public boolean evaluation_of_constraints(Hashtable<String, String> table ){
        if (!table.containsKey(location1) || !table.containsKey(location2)){
            return true;
        }
        //check whether the two assignment is equal and returns the value.
        //Logic of the constraint-->
        return !table.get(location1).equals(table.get(location2));
    }

}
