import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArcadeGamesDAL{

    public static boolean excecuteStatement(String query){
        try{
            Connection connection = DataMgr.getArcadeGamesConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        
        return true;
        }
        catch (SQLException exception){
            System.out.println("Failed to execute statement");
        return false;
        }
    }

    public static boolean executePrepStatement(String query){
        try{
            Connection connection = DataMgr.getArcadeGamesConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
        return true;
        }
        catch (SQLException exception){
            System.out.println("Failed to execute prepared statement");
        return false;
        }
    }

    public static boolean executeCallStatement(){
        try{
            Connection connection = DataMgr.getArcadeGamesConnection();
            CallableStatement callableStatement = connection.prepareCall("");
            ResultSet resultSet = callableStatement.executeQuery();
        return true;
        }
        catch (SQLException exception){
            System.out.println("Failed to execute callable statement");
        return false;
        }
    }

    //extra credit for problem set 2
    public static boolean insertGameName(String title){
        try{
            Connection connection = DataMgr.getArcadeGamesConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL  InsertGame(?)}");
            callableStatement.setString(1, title);
            return true;
        }
        catch (SQLException exception){
            System.out.println("Failed to insert title");
            return false;
        }
    }

}