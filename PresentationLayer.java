import java.sql.*;

public class PresentationLayer {
    public static void main(String[] args) {
        try {
            DataMgr dataMgr = new DataMgr();
            Scanner scanner = new Scanner(System.in);
            Connection mealPlanningConnection = dataMgr.getMealPlanningConnection();
            MealPlanningDAL mealPlanningDAL = new MealPlanningDAL(mealPlanningConnection);

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
                    ResultSet queryResult = mealPlanningDAL.executeStatementQuery("SELECT * FROM meals");
                    break;
                case 2:
                    ResultSet procedureResult = mealPlanningDAL.executeGetRecipesProcedure();
                    break;
                case 3:
                    ResultSet statementResult = arcadeGamesDAL.executeStatementQuery("SELECT * FROM table_name");
                    break;
                case 4:
                    ResultSet preparedStatementResult = arcadeGamesDAL.executePreparedStatementQuery("SELECT * FROM table_name WHERE column_name = ?", "parameter_value");
                    break;
                case 5:
                    ResultSet callableStatementResult = arcadeGamesDAL.executeCallableStatementQuery("stored_procedure_name", "parameter_value");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            dataMgr.closeConnections(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}