
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class n_queens extends constraints{
    ArrayList<String> column = new ArrayList<>();
//    String[] column;
    public n_queens(ArrayList<String> column){
        super();
        for (int i = 0; i<column.size(); i++){
//            System.out.println(column);
            super.constraintList.add(column.get(i));
        }
        this.column = column;
    }

    @Override
    public boolean evaluation_of_constraints(Hashtable<String, String> table) {
//        System.out.println("reach here?");
        //8queens never even reach here.
//        System.out.println("assignemnt: " + table);//sommethign wrong with the table
        Set<String> queen_test_keys = table.keySet();
//        System.out.println(queen_test_keys);

        for (String key : queen_test_keys) {
            String col = key;
            String row = table.get(key);
//            System.out.println("col: " + col + "row: " + row);
            for (int i = Integer.parseInt(col)+1; i< column.size()+1; i++){
//                System.out.println("ever here?");
//                System.out.println("Q2C"  + i);

                //ALWAYS FALSE HERE: (NO CLUE WHY?)
                if (table.contains(Integer.toString(i))){
                    String row2 = table.get(Integer.toString(i));
                    if (row.equals(row2)){
                        return false;
                    }
                    if (Math.abs(Integer.parseInt(row) - Integer.parseInt(row2)) == Math.abs(Integer.parseInt(col) - i)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
