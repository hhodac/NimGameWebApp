import java.sql.*;

public class Database {
//    private static final String driver = "com.mysql.jdbc.Driver";
//    private static final String username = "root";
//    private static final String password = "Casper169.";
//    private static final String database = "WinterProj";
//    private static final String url = "jdbc:mysql://localhost:3306/" + database +
//            "?autoReconnect=true&useSSL=false";
//    private Connection conn;

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String username = "nimgame";
    private static final String password = "MySQLnim2019";
    private static final String database = "nimdb";
    private static final String url = "jdbc:mysql://nimgamedb.mysql.database.azure.com:3306/" + database +
            "?autoReconnect=true&useSSL=false";
    private Connection conn;

    // Constructors
    // Load MySQL app.servlets.Database driver
    public Database() {
        try {
            Class.forName(driver);
            System.out.println("Loaded the embedded driver.");
            this.conn = null;
        }
        catch (Exception err) {
            System.err.println("Unable to load the embedded driver.");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public void setConnection() {
        boolean connecting = false;
        while (!connecting) {
            try {
                System.out.println("Connecting to and creating database...");
                this.conn = DriverManager.getConnection(url, username, password);
                System.out.println("System created.");
                connecting = true;
            }
            catch (SQLException err) {
                System.err.println("SQL error.");
                err.printStackTrace(System.err);
                System.exit(0);
            }
        }
    }

    public void closeConnection() {
        try {
            this.conn.close();
            System.out.println("Connection to database is successfully closed.");
        }
        catch (SQLException err) {
            System.err.println("SQL error.");
            err.printStackTrace(System.err);
            System.exit(0);
        }
    }

    // addAccount
    public boolean addAccount (String username, String password)
            throws SQLException {
        PreparedStatement updateAccount = null;
        try {
            setConnection();
            this.conn.setAutoCommit(false);
            String query;
            query = "INSERT INTO WinterProj.TEST "
                    + "(testid, tname, tpass)"
                    + " VALUES (default, ?, ?)";

            updateAccount = conn.prepareStatement(query);
            updateAccount.setString (1, username);
            updateAccount.setString (2, password);
            updateAccount.executeUpdate();
            conn.commit();
            System.out.println("Update successful");
            return true;
        }
        catch (SQLException err) {
            System.out.println("SQL error.");
            err.printStackTrace();
            System.out.println();
            return false;
        }
        finally {
            if (updateAccount != null) {
                updateAccount.close();
            }
            conn.setAutoCommit(true);
            if (conn!=null) closeConnection();
        }
    }

    // removeAccount
    public boolean removeAccount (String username)
            throws SQLException {
        PreparedStatement updateAccount = null;
        try {
            setConnection();
            this.conn.setAutoCommit(false);
            String query;
            if (isUsernameExist(username)) {
                query = "DELETE FROM WinterProj.TEST " +
                        "WHERE tname = ?";
                updateAccount = conn.prepareStatement(query);
                updateAccount.setString (1, username);
                updateAccount.executeUpdate();
                conn.commit();
                System.out.println("Update successful");
                return true;
            } else {
                throw new SQLException("User not found.");
            }
        }
//        catch (SQLException err) {
//            System.out.println("SQL error.");
//            System.out.println(err.getMessage());
//            System.out.println();
//            return false;
//        }
        finally {
            if (updateAccount != null) {
                updateAccount.close();
            }
            conn.setAutoCommit(true);
            if (conn!=null) closeConnection();
        }
    }

    // Check if username exist
    public boolean isUsernameExist (String username)
            throws SQLException {
        Database db = new Database();
        db.setConnection();
        Connection conn = db.getConnection();
        String check_exist = "SELECT testid FROM TEST WHERE tname = '"+username+"'";
        System.out.println(check_exist);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(check_exist);
        int count = 0;
        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("testid");
            //Display values
            System.out.print("ID: " + id);
            count++;
        }

        if (count > 0) {
            System.out.println("User found.");
            System.out.println(count);
            return true;
        }
        else {
            System.out.println("user not found");
            System.out.println(count);
            return false;
        }
    }

    // Search for username
    public ResultSet searchUsername (String username)
            throws SQLException {
        Database db = new Database();
        db.setConnection();
        Connection conn = db.getConnection();
        String searchQuery = "SELECT testid, tname, tpass FROM TEST WHERE tname LIKE '"+username+"'";
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(searchQuery);

//        String searchPreQuery = "SELECT testid, tname, tpass FROM TEST WHERE tname LIKE ?";
//        PreparedStatement prestmt = conn.prepareStatement(searchPreQuery);
//        prestmt.setString(1, username);
//        return prestmt.executeQuery();

    }
}
