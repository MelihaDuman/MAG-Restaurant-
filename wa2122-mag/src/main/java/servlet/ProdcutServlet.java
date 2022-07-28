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

public class ProdcutServlet extends AbstractServlet{


    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String op = req.getRequestURI();
        op = op.substring(op.lastIndexOf("product/")+8);

        switch (op){
            case "add/":
                AddOperations(req, res);
                break;
            case "delete/":
                DeleteOperations(req, res);
                break;
            default:
                writeError(res, ErrorCode.OPERATION_UNKNOWN);
                logger.warn("requested op "+op);
        }

    }
    private void AddOperations(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        try {
            Integer product_id= Integer.valueOf(req.getParameter("product_id"));
            String email =  req.getParameter("email");
            Product product;
            ErrorCode ec = null;
            Message m = null;
            String dispatchPage = null;
            Cart cart;

            if (product_id == null) {
                ec = ErrorCode.EMPTY_INPUT_FIELDS;
                m = new Message(true, ec.getErrorMessage());

                res.setStatus(ec.getHTTPCode());
                req.setAttribute("message", m);
            } else {
                product=new Product(product_id);
                if (new GetProductByIdDatabase(getDataSource().getConnection(), product).getProductById() != null) {
                    cart= new Cart( email , product_id);
                    cart = new InsertOrderDatabase(getDataSource().getConnection(), cart ).insertOrder();
                        m = new Message(true, "Order inserted correctly");
                        ec = ErrorCode.OK;

                    res.setStatus(ec.getHTTPCode());
                    req.setAttribute("message", m);
                }
            }




        } catch (NamingException | SQLException e){
            writeError(res, ErrorCode.INTERNAL_ERROR);
            logger.error("stacktrace:", e);
        }
    }
    private void DeleteOperations(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

        try {
            Integer product_id= Integer.valueOf(req.getParameter("product_id"));
            String email =  req.getParameter("email");
            Product product;
            ErrorCode ec = null;
            Message m = null;
            String dispatchPage = null;
            Cart cart;

            if (product_id == null) {
                ec = ErrorCode.EMPTY_INPUT_FIELDS;
                m = new Message(true, ec.getErrorMessage());

                res.setStatus(ec.getHTTPCode());
                req.setAttribute("message", m);
            } else {
                product=new Product(product_id);
                if (new GetProductByIdDatabase(getDataSource().getConnection(), product).getProductById() != null) {
                    cart= new Cart( email , product_id);
                    cart = new DeleteOrderByIdDatabase(getDataSource().getConnection(), cart ).DeleteOrder();
                    m = new Message(true, "Order Deleted correctly");
                    ec = ErrorCode.OK;

                    res.setStatus(ec.getHTTPCode());
                    req.setAttribute("message", m);
                }
            }




        } catch (NamingException | SQLException e){
            writeError(res, ErrorCode.INTERNAL_ERROR);
            logger.error("stacktrace:", e);
        }
    }

}
