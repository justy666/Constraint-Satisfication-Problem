//By Frederick Liu, Justin Shen, Amish Fakun
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class general_testing {
    public static Hashtable<String, String> variable_and_duration_table = new Hashtable<>(); //so that we can access it in job_problem.java
    public static Hashtable<String, String>job_constraints_hashtable = new Hashtable<>(); //so that we can access it in job_problem.java
    int Tmax = 0;

//   public  Hashtable<String, String>  getVDT(){
//       return variable_and_duration_table;
//   }
//
//   public  Hashtable<String, String> getJCH(){
//       return job_constraints_hashtable;
//   }



    public general_testing(){
    }

    public void print_test_cases(){

        //****************MAP*****************//
        variables variables = new variables();
        variables.add_variables("WA");
        variables.add_variables("NT");
        variables.add_variables("SA");
        variables.add_variables("Q");
        variables.add_variables("NSW");
        variables.add_variables("V");
        variables.add_variables("T");

        domains domains = new domains();

        //Unary Constraint Comes Here
        ArrayList<String> WA_domainList_WithConstraint = new ArrayList<>();
        WA_domainList_WithConstraint.add("red"); //Since WA = r
        domains.set_domains("WA", WA_domainList_WithConstraint);

        ArrayList<String> SA_domainList_WithConstraint = new ArrayList<>();
        SA_domainList_WithConstraint.add("red");
        SA_domainList_WithConstraint.add("blue"); //Since SA != g
        domains.set_domains("SA", SA_domainList_WithConstraint);

        //Normal Domains
        ArrayList<String> domainList = new ArrayList<>();
        domainList.add("red");
        domainList.add("green");
        domainList.add("blue");
        domains.set_domains("NT", domainList);
        domains.set_domains("Q", domainList);
        domains.set_domains("NSW", domainList);
        domains.set_domains("V", domainList);
        domains.set_domains("T", domainList);

//        System.out.println(domains.domainsDictionary);

        csp csp = new csp(variables.get_variablesList(), domains.get_domainsDictionary());
        csp.add_binary_constraint(new map_problem("SA", "WA"));
        csp.add_binary_constraint(new map_problem("SA", "NT"));
        csp.add_binary_constraint(new map_problem("SA", "Q"));
        csp.add_binary_constraint(new map_problem("SA", "NSW"));
        csp.add_binary_constraint(new map_problem("SA", "V"));
        csp.add_binary_constraint(new map_problem("V", "NSW"));
        csp.add_binary_constraint(new map_problem("NT", "WA"));
        csp.add_binary_constraint(new map_problem("NSW", "Q"));
//        System.out.println(csp.mycontraintsDictionary);
        Hashtable<String, String> test = new Hashtable<String, String>();
        if (csp.backtracking(test) == null) {
            System.out.println("CSP not solvable!");
        }
        System.out.println(csp.backtracking(test));
        //****************MAP*****************//


        //****************SCHEDULE*****************//
        variables schedule_variables = new variables();
        schedule_variables.add_variables("AxelF");
        schedule_variables.add_variables("AxelB");
        schedule_variables.add_variables("WheelRF");
        schedule_variables.add_variables("WheelLF");
        schedule_variables.add_variables("WheelRB");
        schedule_variables.add_variables("WheelLB");
        schedule_variables.add_variables("NutsRF");
        schedule_variables.add_variables("NutsLF");
        schedule_variables.add_variables("NutsRB");
        schedule_variables.add_variables("NutsLB");
        schedule_variables.add_variables("CapRF");
        schedule_variables.add_variables("CapLF");
        schedule_variables.add_variables("CapRB");
        schedule_variables.add_variables("CapLB");
        schedule_variables.add_variables("Inspect");

        domains sched_domains = new domains();

        ArrayList<String> schedule_domainList = new ArrayList<>();
        for (int i = 0; i < 31; i++) {
            schedule_domainList.add(String.valueOf(i));
        }

        sched_domains.set_domains("AxelF", schedule_domainList);
        sched_domains.set_domains("AxelB", schedule_domainList);
        sched_domains.set_domains("WheelRF", schedule_domainList);
        sched_domains.set_domains("WheelLF", schedule_domainList);
        sched_domains.set_domains("WheelRB", schedule_domainList);
        sched_domains.set_domains("WheelLB", schedule_domainList);
        sched_domains.set_domains("NutsRF", schedule_domainList);
        sched_domains.set_domains("NutsLF", schedule_domainList);
        sched_domains.set_domains("NutsRB", schedule_domainList);
        sched_domains.set_domains("NutsLB", schedule_domainList);
        sched_domains.set_domains("CapRF", schedule_domainList);
        sched_domains.set_domains("CapLF", schedule_domainList);
        sched_domains.set_domains("CapRB", schedule_domainList);
        sched_domains.set_domains("CapLB", schedule_domainList);
        sched_domains.set_domains("Inspect", schedule_domainList);

//        System.out.println(sched_domains.domainsDictionary);

        csp csp2 = new csp(schedule_variables.get_variablesList(), sched_domains.get_domainsDictionary());
        csp2.add_binary_constraint(new job_problem("AxelF", "WheelRF"));
        csp2.add_binary_constraint(new job_problem("AxelF", "WheelLF"));
        csp2.add_binary_constraint(new job_problem("AxelB", "WheelRB"));
        csp2.add_binary_constraint(new job_problem("AxelB", "WheelRB"));
        csp2.add_binary_constraint(new job_problem("AxelB", "WheelLB"));
        csp2.add_binary_constraint(new job_problem("WheelRF", "NutsRF"));
        csp2.add_binary_constraint(new job_problem("NutsRF", "CapRF"));
        csp2.add_binary_constraint(new job_problem("WheelLF", "NutsLF"));
        csp2.add_binary_constraint(new job_problem("NutsLF", "CapLF"));
        csp2.add_binary_constraint(new job_problem("WheelRB", "NutsRB"));
        csp2.add_binary_constraint(new job_problem("NutsRB", "CapRB"));
        csp2.add_binary_constraint(new job_problem("WheelLB", "NutsLB"));
        csp2.add_binary_constraint(new job_problem("NutsLB", "CapLB"));
        csp2.add_binary_constraint(new job_problem("AxelF", "AxelB"));
        csp2.add_binary_constraint(new job_problem("AxelF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("AxelB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("WheelRF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("WheelLF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("WheelRB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("WheelLB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("NutsRF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("NutsLF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("NutsRB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("NutsLB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("CapRF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("CapLF", "Inspect"));
        csp2.add_binary_constraint(new job_problem("CapRB", "Inspect"));
        csp2.add_binary_constraint(new job_problem("CapLB", "Inspect"));

        Hashtable<String, String> test2 = new Hashtable<String, String>();
        if (csp2.backtracking(test2) == null) {
            System.out.println("CSP not solvable!");
        }
        System.out.println(csp2.backtracking(test2));
    }

    public void test_map_from_file(String fileName) throws FileNotFoundException {
        Path path = Paths.get(fileName);
        fileName = path.toAbsolutePath().toString();
        //MAKE SURE TO CHANGE THIS SHIT FILENAME BACK...!!!!
//        File file = new File("/Users/frederickliu/Desktop/Introduction to Artificial Intelligence/project2/src/com/company/map.txt");
        File file = new File(fileName);
        Scanner map = new Scanner(file);
        map.nextLine(); //skip the first line
        //set variables
        String map_variable = map.nextLine();
        String stored_varible = map_variable;
        Scanner variable_scanner = new Scanner(map_variable);
        variables map_variables = new variables();
        while (variable_scanner.hasNext()) {
            String tokens = variable_scanner.next();
            map_variables.add_variables(tokens);
        }
        //read in constraints
        ArrayList<ArrayList> constraint_arraylist = new ArrayList();
        while (map.hasNextLine()) {
            String constraint = map.nextLine();
            if (constraint.contains("-")) {
                break;
            }
            Scanner constraint_scanner = new Scanner(constraint);
            ArrayList<String> temp = new ArrayList<>();
            while (constraint_scanner.hasNext()) {
                String tokens = constraint_scanner.next();
                temp.add(tokens);
            }
            constraint_arraylist.add(temp);
        }
//        System.out.println(constraint_arraylist);

        //set domains
        String map_domains = map.nextLine();
        Scanner domains_scanner = new Scanner(map_domains);

        ArrayList<String> domainList = new ArrayList<>();
        while (domains_scanner.hasNext()) {
            String tokens = domains_scanner.next();
            domainList.add(tokens);
        }


        domains map_domain = new domains();
        Scanner stored_var_scan = new Scanner(stored_varible);
        while (stored_var_scan.hasNext()) {
            String tokens = stored_var_scan.next();
            map_domain.set_domains(tokens, domainList);
        }
//        System.out.println(map_domain.domainsDictionary);

        //set constraints
        Hashtable<String, ArrayList<String>> tempConstraintHashset = new Hashtable<>();


        csp map_csp = new csp(map_variables.get_variablesList(), map_domain.get_domainsDictionary());
        for (int i = 0; i < constraint_arraylist.size(); i++) {
            ArrayList<String> temp = constraint_arraylist.get(i);
//            System.out.println(temp);
            ArrayList<String> Constraint_Values = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                if (temp.size() == 1) {
                    break;
                }
                String dummy = temp.get(j);
//                System.out.println(dummy);
                if (!temp.get(0).equals(dummy)) {
                    Constraint_Values.add(dummy);
                }

            }
            tempConstraintHashset.put(temp.get(0), Constraint_Values);
//            System.out.println("---");
        }
//        System.out.println("Before cleaning: " + tempConstraintHashset);

        for (int i = 0; i < constraint_arraylist.size(); i++) {
            ArrayList<String> temp = constraint_arraylist.get(i);
//            System.out.println(temp);
            ArrayList<String> Constraint_Values = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                if (temp.size() == 1) {
                    break;
                }
                String dummy = temp.get(j);
//                System.out.println(dummy);
                if (!temp.get(0).equals(dummy)) {
//                    Constraint_Values.add(dummy);
                    if (tempConstraintHashset.get(temp.get(0)).contains(dummy) && tempConstraintHashset.get(dummy).contains(temp.get(0))) {
                        tempConstraintHashset.get(temp.get(0)).remove(dummy);//clean up the hashtable
//                        tempConstraintHashset.remove(temp.get(0));
                    }
                }

            }
//            tempConstraintHashset.put(temp.get(0), Constraint_Values);
//            System.out.println("---");
        }
//        System.out.println("After cleaning: " + tempConstraintHashset);
        tempConstraintHashset.entrySet().removeIf(e -> e.getValue().isEmpty());
//        System.out.println("After After cleaning: " + tempConstraintHashset);

        ///need to work on this...
        Set<String> keyset = tempConstraintHashset.keySet();
        for (String key : keyset) {
//            System.out.println(key);
            for (int i = 0; i < tempConstraintHashset.get(key).size(); i++) {
//                    System.out.println("value: " + tempConstraintHashset.get(key).get(i));
                map_csp.add_binary_constraint(new map_problem(key, tempConstraintHashset.get(key).get(i)));
//                if (tempConstraintHashset.get(key).get(i))
            }

        }

//  /      System.out.println(map_csp.mycontraints_HASHTABLE);


//        System.out.println(map_csp.mydomain_HASHTABLE);
        while (map.hasNextLine()) {
            String unaryconstraint = map.nextLine();
            Scanner unaryscanner = new Scanner(unaryconstraint);
            String dmanvar = unaryscanner.next();
            String operator = unaryscanner.next();
            String domain = unaryscanner.next();
            if (operator.equals("=")) {
                map_domain.domainsDictionary.remove(dmanvar);
                ArrayList<String> temp2 = new ArrayList<>();
                temp2.add(domain);
                map_domain.domainsDictionary.put(dmanvar, temp2);
            }
//            System.out.println(map_domain.domainsDictionary);
            else if (operator.equals("!=")) {
                map_domain.domainsDictionary.remove(dmanvar);
//                System.out.println(map_domain.domainsDictionary.remove(dmanvar));
                ArrayList<String> temp = new ArrayList<>(domainList);
                temp.remove(domain);
                map_domain.domainsDictionary.put(dmanvar, temp);
            }
        }
//        System.out.println(map_domain.domainsDictionary);

        Hashtable<String, String> map_result = new Hashtable<String, String>();
        if (map_csp.backtracking(map_result) == null) {
            System.out.println("CSP not solvable!");
        }
//        System.out.println(map_csp.backtracking(map_result));
        Hashtable<String, String> out = new Hashtable<String, String>();
        out.putAll(map_csp.backtracking(map_result));
        //printing the result:
        Set<String> out_print = out.keySet();
        for (String key : out_print) {
            System.out.println("Region: " + key + "\t Color: " + out.get(key));
        }

    }


    domains job_domain = new domains();
    public void test_job_from_file(String fileName) throws FileNotFoundException {
        Path path = Paths.get(fileName);
        fileName = path.toAbsolutePath().toString();
        //MAKE SURE TO CHANGE THIS SHIT FILENAME BACK...!!!!
//        File file = new File("/Users/frederickliu/Desktop/Introduction to Artificial Intelligence/project2/src/com/company/job.txt");
        File file = new File(fileName);
        Scanner map = new Scanner(file);
        map.nextLine(); //skip the first line
        //set variables
        String map_variable = map.nextLine();
        String stored_varible = map_variable;
        Scanner variable_scanner = new Scanner(map_variable);
        variables map_variables = new variables();
        while (variable_scanner.hasNext()) {
            String tokens = variable_scanner.next();
            map_variables.add_variables(tokens);
        }
//        System.out.println(map_variables.variablesList);

//        Hashtable<String, String> variable_and_duration_table = new Hashtable<>();
        while (map.hasNextLine()){
            String variable = map.nextLine();
            if (variable.contains("-")){
                break;
            }
            String[] split = variable.split(" ");
            variable_and_duration_table.put(split[0], split[1]);
        }

        Tmax = Integer.parseInt(map.nextLine());

        ArrayList<String> job_domainlist = new ArrayList<>();
        for (int i = 0; i < Tmax+1; i++) {
            job_domainlist.add(String.valueOf(i));
        }

        for (int i = 0; i< map_variables.variablesList.size(); i++){
            job_domain.set_domains(map_variables.variablesList.get(i), job_domainlist);
        }

        map.nextLine();
        csp job_csp = new csp(map_variables.get_variablesList(), job_domain.get_domainsDictionary());
//        Set<String> job_con_set = job_constraints_hashtable.keySet();
//        for (String key : job_con_set) {
//            job_csp.add_binary_constraint(new job_problem(key, job_constraints_hashtable.get(key)));
//        }

//        System.out.println(job_csp.mycontraints_HASHTABLE);

        while (map.hasNextLine()){
            String variable = map.nextLine();
            String[] split = variable.split(" ");
            job_constraints_hashtable.put(split[0], split[2]);
            job_csp.add_binary_constraint(new job_problem(split[0], split[2]));
        }


        Hashtable<String, String> map_result = new Hashtable<String, String>();
        if (job_csp.backtracking(map_result) == null) {
            System.out.println("CSP not solvable!");
        }
//        System.out.println(map_csp.backtracking(map_result));
        Hashtable<String, String> out = new Hashtable<String, String>();
        out.putAll(job_csp.backtracking(map_result));
        //printing the result:
        Set<String> out_print = out.keySet();
        for (String key : out_print) {
            System.out.println("Job: " + key + "\t Time: " + out.get(key));
        }

    }


    ArrayList<String> domainsListqueens = new ArrayList<>();
    public void test_n_queens_bonus(int n){
        variables queens_vairables = new variables();
        for (int i =1; i<n+1; i++){
            queens_vairables.add_variables(Integer.toString(i));
        }
        domains queens_domains = new domains();
        for (int i = 1; i<n+1; i++){
            domainsListqueens.add(Integer.toString(i));
        }
        for (int i = 1; i<n+1; i++){
            queens_domains.set_domains(Integer.toString(i), domainsListqueens);
        }

        ArrayList<String> var_q = new ArrayList<>();
//        int index = 0;
        for (int i = 1; i<n+1; i++){
           var_q.add(Integer.toString(i));
        }

        csp queens_csp = new csp(queens_vairables.get_variablesList(), queens_domains.get_domainsDictionary());

//        System.out.println(queens_domains.get_domainsDictionary());
//        for (int i = 1; i<n+1; i++){
            queens_csp.add_binary_constraint(new n_queens(var_q));
//        }
//        System.out.println(queens_csp.mycontraints_HASHTABLE);

//        System.out.println(queens_csp.mydomain_HASHTABLE);
//        System.out.println(queens_vairables.get_variablesList());
//        System.out.println(queens_domains.get_domainsDictionary());

//        System.out.println(queens_csp.backtracking(new Hashtable<>()));

        Hashtable<String, String> queen_result = new Hashtable<String, String>();
        if (queens_csp.backtracking(queen_result) == null) {
            System.out.println("CSP not solvable!");
        }
//        System.out.println(map_csp.backtracking(map_result));
        Hashtable<String, String> out = new Hashtable<String, String>();
        out.putAll(queens_csp.backtracking(queen_result));
        //printing the result:
        Set<String> out_print = out.keySet();
        for (String key : out_print) {
            System.out.println("Column: " + key + "\t Row: " + out.get(key));
        }

    }
}
