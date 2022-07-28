package dao;

import java.sql.*;
import resource.*;

public class GetProductByIdDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "SELECT * FROM MAG.products WHERE product_id=?;";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * The user to be searched
     */
    Product product;

    public GetProductByIdDatabase(final Connection con, final Product u) {
        this.con = con;
        this.product = u;
    }


    public Product getProductById() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Product foundProdcut=null;


        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, product.getId());

            rs = pstmt.executeQuery();

            if (rs.next()) {
                foundProdcut = new Product(rs.getInt(1), rs.getString(2),
                        rs.getFloat(4), rs.getString(5), rs.getString(6)
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

        return foundProdcut;
    }
}
