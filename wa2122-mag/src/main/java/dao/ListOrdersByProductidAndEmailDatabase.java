package dao;

import resource.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

public class ListOrdersByProductidAndEmailDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "SELECT MAG.products.* , count(*) FROM (MAG.products INNER JOIN MAG.cart ON (products.product_id=cart.product_id ))WHERE email=?  group by products.product_id;";
    /**
     * The connection to the database
     */
    private final Connection con;


    Cart cart;

    public ListOrdersByProductidAndEmailDatabase(final Connection con, Cart p) {
        this.con = con;
        this.cart = p;
    }

    public List <Product> getProduct() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        List<Product> foundProduct = new ArrayList<Product>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setString(1, Cart.getEmail());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                foundProduct.add(new Product(rs.getInt(1),rs.getString(2),rs.getFloat(4) ,rs.getString(5), rs.getString(6), rs.getInt(7)));
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

        return foundProduct;
    }

}
