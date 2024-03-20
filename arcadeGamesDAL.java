import java.sql.*;

public class arcadeGamesDAL {
    private Connection connection;

    public arcadeGamesDAL(Connection connection) {
        this.connection = connection;
    }

    public ResultSet executeStatementQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    public ResultSet executePreparedStatementQuery(String query, Object... params) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            preparedStatement.setObject(i + 1, params[i]);
        }
        return preparedStatement.executeQuery();
    }

    public ResultSet executeCallableStatementQuery(String procedureName, Object... params) throws SQLException {
        CallableStatement callableStatement = connection.prepareCall("{call " + procedureName + "}");
        for (int i = 0; i < params.length; i++) {
            callableStatement.setObject(i + 1, params[i]);
        }
        return callableStatement.executeQuery();
    }
}
