package dao;

import resource.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertOrderDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "INSERT INTO MAG.Cart(product_id,email) VALUES(?,?) RETURNING *;";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The user to be inserted
     */
    Cart cart;

    public InsertOrderDatabase(final Connection con, final Cart u) {
        this.con = con;
        this.cart = u;
    }

    public Cart insertOrder() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the created user
        Cart newOrder = null;

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(2, Cart.getEmail());
            pstmt.setInt(1, Cart.getProduct_id());


            rs = pstmt.executeQuery();

            if (rs.next()) {
                newOrder = new Cart(rs.getString(1), rs.getInt(2));
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

        return newOrder;
    }

}
