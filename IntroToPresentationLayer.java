
import java.util.Scanner;
import java.sql.*;

public class IntroToPresentationLayer
{
    public static void main(String[] args)
    {
        Scanner userInformation = new Scanner(System.in);
        System.out.println("Enter username and password:");
        // String input
        String userName = userInformation.nextLine();
        String password = userInformation.nextLine();

        // Let's start simple. How do we connect to and access a database?
        // Well, the presentation layer can't do it. We need an instance of the DAL!
        IntroToDAL mealPlanningDAL = new IntroToDAL();
        ArcadeGamesDAL arcadeGamesDAL = new ArcadeGamesDAL();


        System.out.println("Choose an option:");
        System.out.println("i. Running a single query against the meal planning database");
        System.out.println("ii. Running GetRecipes stores procedure against the meal planning database");
        System.out.println("iii. Running your new method that returns the results of a statement");
        System.out.println("iv. Running your new method that returns the results of a prepared statement");
        System.out.println("v. Running your new method that returns the results of a callable statement");
        
        char choice = userInformation.next().charAt(0);

        switch (choice) {
            case 'i':
                if (dal.TryExecutingAQuery("MealPlanning", "Select * from Meal", userName, password))
                {
                    System.out.println("Successfully connected to the database");
                }
                else
                {
                    System.out.println("Failed to connect to the database");
                }
            break;
            case 'ii':
                if (dal.TryExecutingAStoredProcedure("MealPlanning", userName, password))
                {
                    System.out.println("Successfully ran a stored procedure");
                }
                else
                {
                    System.out.println("Failed to run a stored procedure");
                }
            break;
            case 'iii':
                if (ArcadeGamesDAL.executeStatement("SELECT * FROM Games"))
                {
                    System.out.println("Successfully connected to the database");
                }
                else
                {
                System.out.println("Failed to connect to the database");
                } 
            break;
            case 'iv':
                if (ArcadeGamesDAL.executePrepStatement())
                {
                    System.out.println("Successfully connected to the database");
                }
                else
                {
                System.out.println("Failed to connect to the database");
                } 
            break;
            case 'v':
                if (ArcadeGamesDAL.executeCallStatement()){
                    System.out.println("Successfully executed callable statement");
                }
                else{
                    System.out.println("Failed to execute callable statement");
                }
                }
            break;
        default: System.out.println("invalid choice");
        }
    }  
