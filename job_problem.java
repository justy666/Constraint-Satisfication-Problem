
//By Frederick Liu, Justin Shen, Amish Fakun
import java.util.Hashtable;

public class job_problem extends constraints {
    String job1;
    String job2;

    public job_problem(String one, String two) {
        super();
        super.constraintList.add(one);
        super.constraintList.add(two);
        this.job1 = one;
        this.job2 = two;
    }

//    public general_testing parent;

    @Override
    public boolean evaluation_of_constraints(Hashtable<String, String> table) {
        if (!table.containsKey(job1) || !table.containsKey(job2)) {
            return true;
        }

//        System.out.println(constraintList);

        int value_job1 = Integer.parseInt(table.get(job1));
        int value_job2 = Integer.parseInt(table.get(job2));
        //Ti + Di <= Ti+1
        return value_job1 + Integer.parseInt(variable_and_duration_table.get(job1)) <= value_job2;


        //BELOW IS FOR GENERAL TESTING....
//        if (job1.equals("AxelF") && job2.equals("WheelRF")
//                || job1.equals("AxelF") && job2.equals("WheelLF")
//                || job1.equals("AxelB") && job2.equals("WheelRB")
//                || job1.equals("AxelB") && job2.equals("WheelLB")
//                || job1.equals("AxelF") && job2.equals("AxelB")
//                || job1.equals("AxelF") && job2.equals("Inspect")
//                || job1.equals("AxelB") && job2.equals("Inspect")) {
//
//            if (variable_and_duration_table.get(job1) == null){
//                //just for general testing purposes in case where there's nothign to be read
//                return value_job1 + 10 <= value_job2;
//            }
////            return value_job1 + 10 <= value_job2;
//            //get the value from the duration value from the file in general_testing class's hashtable.
//            return value_job1 + Integer.parseInt(variable_and_duration_table.get(job1)) <= value_job2;
//        }
//        if (job1.equals("WheelRF") && job2.equals("NutsRF")
//                || job1.equals("WheelLF") && job2.equals("NutsLF")
//                || job1.equals("WheelRB") && job2.equals("NutsRB")
//                || job1.equals("WheelLB") && job2.equals("NutsLB")
//                || job1.equals("WheelRF") && job2.equals("Inspect")
//                || job1.equals("WheelLF") && job2.equals("Inspect")
//                || job1.equals("WheelRB") && job2.equals("Inspect")
//                || job1.equals("WheelLB") && job2.equals("Inspect")
//                || job1.equals("CapRF") && job2.equals("Inspect")
//                || job1.equals("CapLF") && job2.equals("Inspect")
//                || job1.equals("CapRB") && job2.equals("Inspect")
//                || job1.equals("CapLB") && job2.equals("Inspect")) {
//            //return  return value_job1 + 1 <= value_job2;
//            if (variable_and_duration_table.get(job1) == null){
//                return value_job1 + 1 <= value_job2;
//            }
//
//            return value_job1 + Integer.parseInt(variable_and_duration_table.get(job1))  <= value_job2;
//        }
//        if (job1.equals("NutsRF") && job2.equals("CapRF")
//                || job1.equals("NutsLF") && job2.equals("CapLF")
//                || job1.equals("NutsLB") && job2.equals("CapLB")
//                || job1.equals("NutsRF") && job2.equals("Inspect")
//                || job1.equals("NutsLF") && job2.equals("Inspect")
//                || job1.equals("NutsRB") && job2.equals("Inspect")
//                || job1.equals("NutsLB") && job2.equals("Inspect")
//                || job1.equals("NutsRB") && job2.equals("CapRB")) {
//            //return  return value_job1 + 2 <= value_job2;
//            if (variable_and_duration_table.get(job1) == null){
//                return value_job1 + 2 <= value_job2;
//            }
//            return value_job1 + Integer.parseInt(variable_and_duration_table.get(job1)) <= value_job2;
//        }
//        return true;
    }

}
