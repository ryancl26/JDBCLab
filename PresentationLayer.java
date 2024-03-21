import java.sql.*;
import java.util.Scanner;
import java.util.Scanner;
import java.util.Scanner;

public class PresentationLayer {

    public PresentationLayer(old dataMgr) {
        this.dataMgr = dataMgr;
    }
    
    public static void main(String[] args) {
        try {
            old dataMgr = new old();
            Scanner scanner = new Scanner(System.in);
            Connection arcadeGamesConnection = dataMgr.getArcadeGamesConnection();
            ArcadeGamesDAL arcadeGamesDAL = new ArcadeGamesDAL(arcadeGamesConnection);

            System.out.println("Choose an option:");
            System.out.println("1. Running a single query against the meal planning database");
            System.out.println("2. Running GetRecipes stored procedure against the meal planning database");
            System.out.println("3. Running your new method that returns the results of a statement");
            System.out.println("4. Running your new method that returns the results of a prepared statement");
            System.out.println("5. Running your new method that returns the results of a callable statement");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
    case 1:
        System.out.println("Running a single query against the meal planning database...");

        break;
    case 2:
        System.out.println("Running GetRecipes stored procedure against the meal planning database...");
        break;
    case 3:

        System.out.println("Running your new method that returns the results of a statement...");
        try {
            ResultSet statementResult = arcadeGamesDAL.executeStatementQuery("SELECT * FROM table_name");
            while (statementResult.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
    case 4:
        System.out.println("Running your new method that returns the results of a prepared statement...");
        try {
            ResultSet preparedStatementResult = arcadeGamesDAL.executePreparedStatementQuery("SELECT * FROM table_name WHERE column_name = ?", "parameter_value");
            while (preparedStatementResult.next()) {
                // Process each row in the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
    case 5:

        System.out.println("Running your new method that returns the results of a callable statement...");
        try {
            ResultSet callableStatementResult = arcadeGamesDAL.executeCallableStatementQuery("stored_procedure_name", "parameter_value");
            // Process the result set
            while (callableStatementResult.next()) {
                // Process each row in the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        break;
        default:
        System.out.println("Invalid choice.");
    }
    scanner.close(); // Close scanner when done
    dataMgr.closeConnections(); // Close connections when done
    }   
    catch (SQLException e) {
        e.printStackTrace();
        }
    }
}