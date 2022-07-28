package dao;

import resource.Categories;
import resource.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;

public class ListProductByCategorieDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "SELECT * FROM MAG.products WHERE categorie_id=?;";
    /**
     * The connection to the database
     */
    private final Connection con;


    Categories categories;

    public ListProductByCategorieDatabase(final Connection con, final Categories p) {
        this.con = con;
        this.categories = p;
    }

    public List <Product> getProductByCategorie() throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // the created ride
        List<Product> foundProduct = new ArrayList<Product>();

        try {
            pstmt = con.prepareStatement(STATEMENT);
            pstmt.setInt(1, categories.getId());

            rs = pstmt.executeQuery();

            while (rs.next()) {
                foundProduct.add(new Product(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getFloat(4),rs.getString(5),rs.getString(6)));
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
