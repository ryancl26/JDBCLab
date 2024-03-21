import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MealPlanningDAL {
    private Connection connection;

    public MealPlanningDAL(Connection connection) {
        this.connection = connection;
    }

    public ResultSet executeStatementQuery(String query) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        return statement.executeQuery();
    }

    public ResultSet executeGetRecipesProcedure() throws SQLException {
        String storedProcedure = "CALL GetRecipes()";
        PreparedStatement statement = connection.prepareCall(storedProcedure);
        return statement.executeQuery();
    }

    public ResultSet executePreparedStatement(String preparedQuery) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(preparedQuery);
        return statement.executeQuery();
    }
}