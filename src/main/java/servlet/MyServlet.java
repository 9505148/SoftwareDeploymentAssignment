package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "MyServlet", 
        urlPatterns = {"/status"}
    )
public class MyServlet extends HttpServlet {
/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("IF YOU ARE SEEING THIS THEN IT IS WORKING".getBytes());
        out.flush();
        out.close();
    }*/
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

        ServletOutputStream out = response.getOutputStream();
        
        String userAge = request.getParameter("age");
        String userName = request.getParameter("name");
        
        Connection connection = getConnection();
        // connection = DatabaseUrl.extract().getConnection();
        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        
       /* if(userAge == "1")
        {
        	get("/db", (request, response) ->  
        {
            Connection connection = null;
            Map<String, Object> attributes = new HashMap<>();
            try {
              connection = DatabaseUrl.extract().getConnection();
              Statement stmt = connection.createStatement();
              stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
              stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
              ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

              ArrayList<String> output = new ArrayList<String>();
              while (rs.next()) {
                output.add( "Read from DB: " + rs.getTimestamp("tick"));
              }

               attributes.put("results", output);
               return new ModelAndView(attributes, "db.ftl");
             } catch (Exception e) {
               attributes.put("message", "There was an error: " + e);
               return new ModelAndView(attributes, "error.ftl");
             } finally {
               if (connection != null) try{connection.close();} catch(SQLException e){}
             }
           } , new FreeMarkerEngine());
        }
        */
        out.write(request.getParameter("age").getBytes());
        out.flush();
        out.close();
    }
/**
 * postgres://qkzwskiqlsnorc:9IvEOeX1QUiVZPhAWWXelQz9s7@ec2-54-243-208-195.compute-1.amazonaws.com:5432/df1609d1j6jvn9
 * password, 9IvEOeX1QUiVZPhAWWXelQz9s7
 * user, qkzwskiqlsnorc
 * @return
 * @throws URISyntaxException
 * @throws SQLException
 */
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
    

}
