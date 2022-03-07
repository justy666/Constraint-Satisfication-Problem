/*
Justin Shen | Frederick Shitong Liu | Amish Fakun
jshen37@u.rochester.edu | sliu85@u.rochester.edu | afakun@u.rochester.edu 
UR ID: 31819329 
CSC 242 Project 2
*/

********* A BRIEF INTRODUCTION ********
In this project, we implemented the Job Shop Scheduling and Map Coloring CSP (and the N-queens problem as a 10 points bonus). We created a total of nine classes to represent those problems. As described in the text book, the basic elements of a constraint satisfaction problem are 1) variables, 2) domains, and 3) constraints (which includes unary constraints and binary constraints). The class variables.java is for variables representation, which we set it as an ArrayList of strings, for domains, we called it a domains.java, which is a list of domains but also with variables attached to it. It is therefore a dictionary/hashtable of strings as keys and array list of strings as the values. So for example, the domain for region WA is r g b, we store that into the domain hash table which is {WA = [r, g, b]}. To specify binary constraints, we created the abstract class constraints.java which contains an ArrayList that will take the domains and variables of its sub-classes - which are essentially the CSP we are trying solve. To represent the Job Shop Scheduling problem, we created a subclass under the constraint class, it contains a boolean method that overrides the same method from the parent class constraints.java and evaluates the constraint based on the precedence constraint Ti + Di <= Ti+1 from the book. The class takes in two string which is the name of each job. In solving the Map Coloring problem, we also created a subclass under the constraint.java parent class, we override the same method as we did for the Job problem, but because this constraint is different, instead of using that precedence constraint function, we simply used the ".equals" operator since WA ≠ SA is a constraint as a boolean return value. In representing the general CSP, we created the csp.java class which takes in a set of variables and their domains, this is the generic class that will resolve basically all CSPs (with of course, minor twists on the constraints). We created a function that test the consistency of the assignment, and a function that takes in the binary constraint (basically a CSP problem with the two string inputs) and the backtracking algorithm solving problems recursively by trying to build a solution incrementally. Our backtracking algorithm returns a hashTable with keys as the regions or jobs, and values as the assigned value. We converted the Job and Map problems into two txt files named "map.txt" and "job.txt". The class general_testing.java reads those files and return the values into constraint.java and their subclasses. Note, constraint.java is a subclass of general_testing.java as we needed to use the values from general_testing.java in constraint.java's subclasses. For example, in order to make the job problem more dynamic, we need to store all the names of the job and their duration into a local dictionary in general_testing.java and access them in job_problem.java for the precedence constraint function. We originally hard coded the constraints in there but then we realize there's a more dynamic way of doing it. For unary constraint in the case of Map Coloring, we simply wrote a loop that loops through the domains of that specific targeted variable and then whatever it is equal or not equal to, we remove the other unnecessary elements in the domain of that specific variable. For bonus, we implemented N-queens problems as a CSP, the variables and domains are essentially the same thing, the constraints are that each queen can not eat each other. We hope that we can receive the 10 points bonus for our hard work. 

Thanks!

*********** COMPILING ***********

To compile and run our program:

1. Open your terminal, change your file directory to /sliu85_project2_submission

2. After you change your directory, please copy and paste or type the following:

javac Main.java

*NOTE* (YOU MAY RECEIVE A WARNING - "./general_testing.java uses unchecked or unsafe operations." THIS IS BECAUSE WE ARE READING EXTERNAL FILES, PLEASE JUST IGNORE THAT WARNING AND PROCEED TO STEP 3.)

3. After you typed in the line(s) above, please copy and paste or type the following:

java Main

