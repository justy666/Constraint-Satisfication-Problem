

//By Frederick Liu, Justin Shen, Amish Fakun
import java.io.*;
import java.util.*;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        general_testing test = new general_testing();

        Scanner input = new Scanner(System.in);

        System.out.println("\n***** Map Coloring && Job Shop Scheduling *****");
        System.out.println("Enter File Name: ('map.txt' or 'job.txt')");
        String fileName = input.nextLine();
        if (fileName.equals("map.txt")){
            test.test_map_from_file(fileName);
        } else if (fileName.equals("job.txt")){
            test.test_job_from_file(fileName);
        }

        System.out.println("\n***** N-Queens Solution (10 Points Bonus) *****");
        System.out.println("What is your value of 'N': ");
        int n = input.nextInt();
        test.test_n_queens_bonus(n);
        System.out.println("\nWe were able to generate and represent the N-Queens Problem as a CSP, \nbut had some trouble with coming up with the binary constraint...");
        System.out.println("We tried our best but this is all we were able to get so far...");
    }
}
