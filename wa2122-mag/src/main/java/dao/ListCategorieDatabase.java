package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import resource.Categories;

public class ListCategorieDatabase {

    /**
     * The SQL statement to be executed
     */
    private static final String STATEMENT = "SELECT * FROM MAG.categories;";
    /**
     * The connection to the database
     */
    private final Connection con;

    /**
     * Creates a new object for list all the roles in the database
     *
     * @param con
     *            the connection to the database.
     */
    public ListCategorieDatabase(final Connection con) {
        this.con = con;
    }

    /**
     * List all the roles in the database.
     *
     * @return the List of {@code String} corresponding to the roles in the database.
     *
     * @throws SQLException
     *             if any error occurs while reading the roles.
     */
    public List<Categories> listCategorie() throws SQLException {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Categories> categories = new ArrayList<>();


        try {
            pstmt = con.prepareStatement(STATEMENT);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                categories.add(new Categories (rs.getInt(1), rs.getString(2), rs.getString(3)));
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

        return categories;
    }

}
