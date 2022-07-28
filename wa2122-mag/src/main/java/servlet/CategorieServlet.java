package servlet;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import resource.*;
import utils.ErrorCode;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class CategorieServlet extends AbstractServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String op = req.getRequestURI();
        op = op.substring(op.lastIndexOf("categorie/") + 10);

        switch (op) {

            case "overview/":
                overviewDataOperations(req, res);

                break;
            default:
                writeError(res, ErrorCode.OPERATION_UNKNOWN);
                logger.warn("requested op " + op);
        }

    }


    private void overviewDataOperations(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            logger.debug("overview page shown");
            HttpSession session = req.getSession(true);
            String email = (String) session.getAttribute("email");
            logger.debug(email);
            List<JSONObject> result = new ArrayList<>();
            List<Categories> categories = new ListCategorieDatabase(getDataSource().getConnection()).listCategorie();
            List<Product> products;
            JSONObject categorieJSON;
            JSONObject productJSON;
            List<JSONObject> productsJSON;


            for (int i = 0; i < categories.size(); i++) {
                categorieJSON = new JSONObject();
                categorieJSON.put("id", categories.get(i).getId());
                categorieJSON.put("name", categories.get(i).getName());
                categorieJSON.put("description", categories.get(i).getDescription());

                products = new ListProductByCategorieDatabase(getDataSource().getConnection(), categories.get(i)).getProductByCategorie();
                productsJSON = new ArrayList<>();
                for (int j = 0; j < products.size(); j++) {
                    productJSON = new JSONObject();
                    productJSON.put("id", products.get(j).getId());
                    productJSON.put("description", products.get(j).getDescription());
                    productJSON.put("price", products.get(j).getPrice());
                    productJSON.put("name", products.get(j).getName());
                    productJSON.put("url", products.get(j).geturl());
                    productsJSON.add(productJSON);
                }
                categorieJSON.put("products", productsJSON);

                result.add(categorieJSON);
            }
            System.out.println(result);

            JSONObject resultJSON = new JSONObject();
            resultJSON.put("data", result);

            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.setContentType("application/json");
            res.getWriter().write(resultJSON.toString());

        } catch (NamingException | SQLException e) {
            writeError(res, ErrorCode.INTERNAL_ERROR);
            logger.error("stacktrace:", e);
        }
    }

}