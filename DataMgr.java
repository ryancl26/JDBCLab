import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DataMgr{

    private static final String MEAL_PLANNING_DB_URL = "jdbc:mysql://localhost:3306/mealPlanning";
    private static final String ARCADE_GAMES_DB_URL = "jdbc:mysql://localhost:3306/arcadeGames";
    private static final String VIDEO_GAME_SYSTEMS_DB_URL = "jdbc:mysql://localhost:3306/videoGameSystem";


    public static Connection getMealPlanningConnection() throws SQLException{
        String username = getUsername();
        String password = getPassword();
        return DriverManager.getConnection(MEAL_PLANNING_DB_URL, username, password);
    }

    public static Connection getArcadeGamesConnection() throws SQLException{
        String username = getUsername();
        String password = getPassword();
        return DriverManager.getConnection(ARCADE_GAMES_DB_URL, username, password);
    }

    public static Connection getVideoGameSystemsConnection() throws SQLException{
        String username = getUsername();
        String password = getPassword();
        return DriverManager.getConnection(VIDEO_GAME_SYSTEMS_DB_URL, username, password);
    }

    private static String getUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }

    private static String getPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

}