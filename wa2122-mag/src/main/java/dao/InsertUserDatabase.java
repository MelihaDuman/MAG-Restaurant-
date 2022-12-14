package dao;

import resource.User;

import java.sql.*;

public class InsertUserDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "INSERT INTO MAG.account VALUES (?, md5(?),?,?,?::MAG.roles) RETURNING *;";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The user to be inserted
     */
    User user;

    public InsertUserDatabase(final Connection con, final User u) {
        this.con = con;
        this.user = u;
    }

    public User insertUser() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the created user
        User newUser = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, user.getEmail());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFirst_name());
            pstmt.setString(4, user.getLast_name());
            pstmt.setString(5, user.getRole());


            rs = pstmt.executeQuery();

            if (rs.next()) {
                newUser = new User(rs.getString(1), rs.getString(2),
                        rs.getString(3),rs.getString(4), rs.getString(5));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }

            con.close();
        }

        return newUser;
    }

}
