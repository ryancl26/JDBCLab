import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataMgr {
    // Database connection URLs
    private static final String MEAL_PLANNING_DB_URL = "jdbc:mysql://localhost:3306/meal_planning";
    private static final String ARCADE_GAMES_DB_URL = "jdbc:mysql://localhost:3306/arcade_games";
    private static final String VIDEO_GAME_SYSTEMS_DB_URL = "jdbc:mysql://localhost:3306/video_game_systems";

  
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    // Connection objects for each database
    private Connection mealPlanningConnection;
    private Connection arcadeGamesConnection;
    private Connection videoGameSystemsConnection;

    // MealPlanning database
    public Connection getMealPlanningConnection() throws SQLException {
        if (mealPlanningConnection == null || mealPlanningConnection.isClosed()) {
            mealPlanningConnection = DriverManager.getConnection(MEAL_PLANNING_DB_URL, USERNAME, PASSWORD);
        }
        return mealPlanningConnection;
    }

    // ArcadeGames database
    public Connection getArcadeGamesConnection() throws SQLException {
        if (arcadeGamesConnection == null || arcadeGamesConnection.isClosed()) {
            arcadeGamesConnection = DriverManager.getConnection(ARCADE_GAMES_DB_URL, USERNAME, PASSWORD);
        }
        return arcadeGamesConnection;
    }

    // VideoGameSystems database
    public Connection getVideoGameSystemsConnection() throws SQLException {
        if (videoGameSystemsConnection == null || videoGameSystemsConnection.isClosed()) {
            videoGameSystemsConnection = DriverManager.getConnection(VIDEO_GAME_SYSTEMS_DB_URL, USERNAME, PASSWORD);
        }
        return videoGameSystemsConnection;
    }
}