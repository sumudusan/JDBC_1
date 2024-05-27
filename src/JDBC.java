import java.sql.*; //import All sql libraries
public class JDBC
{
    public static void main(String[] args)
    {
        //connecting database from url
        String url="jdbc:mysql://localhost:3306/jdbc";
        String user="root";
        String password="pas@123";
        String query="select * From users";

        try
        {
//download and use mysql driver
Class.forName("com.mysql.cj.jdbc.Driver");
//make connection using the downloaded driver
Connection connection=DriverManager.getConnection(url,user,password);
//make a statement using the connection
Statement statement= connection.createStatement();
//we can execute a query using above statement
ResultSet result =statement.executeQuery(query);

String name;
int age;
while (result.next())
{
    name= result.getString(1);
    age=result.getInt(2);
    System.out.println(name +" "+ age);
}
connection.close();

        }

        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
