package dao;
import resource.*;

import java.sql.*;

public class DeleteAllOrdersByEmailDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "DELETE FROM MAG.cart WHERE email=? RETURNING *;";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The user to be deleted
     */
    User user;

    public DeleteAllOrdersByEmailDatabase(final Connection con, final User u) {
        this.con = con;
        this.user = u;
    }

    public Cart deleteUser() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the created user
        Cart deletedOrders = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, user.getEmail());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                deletedOrders= new Cart(rs.getString(1)
                );
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

        return deletedOrders;
    }

}