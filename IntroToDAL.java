// Author:  Wendy-Beth Minton
// Class:   3810 Database
// Lab:     Introduction to Database Connectivity

// THIS IS THE ONLY CLASS THAT SHOULD IMPORT JDBC! 
import java.sql.*;

// This is an example DAL. Notice all the database logic is contained within this class.
public class IntroToDAL
{
    // Notice that the databaseName, user and password are passed into this method. We are in the DAL,
    // and we cannot prompt the user for this information. That should be done in the presentation layer
    private Connection getMySQLConnection(String databaseName, String user, String password)
    {
        try
        {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + databaseName, user, password);
        } 
        catch (SQLException exception)
        {
            System.out.println("Failed to connect to the database" + exception.getMessage());
            return null;
        }
    }
      
    public boolean TryExecutingAQuery(String databaseName, String query, String user, String password)
    {
        try
        {

            Connection myConnection = getMySQLConnection(databaseName, user, password);
            Statement myStatement = myConnection.createStatement();
            ResultSet myRelation = myStatement.executeQuery(query);


            while (myRelation.next())
            {
                // For each row, we know there are two columns, RecipeName,
                // and IngredientId. Let's print them out, just to prove
                // we got the data from the database correctly.
                String myRecipeName = myRelation.getString("RecipeName");
                int myIngredientId = myRelation.getInt("IngredientId");
                System.out.println("Tuple Values:" + myRecipeName + "," + myIngredientId);
                
                // But, really you should add an instance of the object to the array of objects
            }
        } 
         catch (SQLException exception)
        {
            System.out.println("Epic Fail Executing a Query:" + exception.getMessage());
            return false;
        }
        return true;
    }

    public boolean TryExecutingAStoredProcedure(String databaseName, String user, String password)
    {
        Connection myConnection = getMySQLConnection(databaseName, user, password);
        try
        {
            CallableStatement myStoredProcedureCall = myConnection.prepareCall("{Call GetRecipes()}");
            ResultSet myResults = myStoredProcedureCall.executeQuery();

            // Iterate over the ResultSet, row by row
            while (myResults.next())
            {
                String myRecipeName = myResults.getString("RecipeName");
                String myCookbookName = myResults.getString("CookbookName");
                int numServings = myResults.getInt("TotalServings");
                System.out.println("Tuple Values:" + myRecipeName + "," + myCookbookName + "," + numServings);
            }
        } catch (SQLException myException)
        {
            System.out.println("Failed to execute stored procedure:" + myException.getMessage());
            return false;
        }
        return true;
    }
}