package servlet;

import dao.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;
import resource.*;
import utils.ErrorCode;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class OrderServlet extends AbstractServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String op = req.getRequestURI();
        op = op.substring(op.lastIndexOf("cart/") + 5);

        switch (op) {

            case "overview/":
                overviewDataOperations(req, res);

                break;
            default:
                writeError(res, ErrorCode.OPERATION_UNKNOWN);
                logger.warn("requested op " + op);
        }

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String op = req.getRequestURI();
        op = op.substring(op.lastIndexOf("cart/") + 5);

        switch (op) {
            case "payment/":
                try {
                    sendEmail(req, res);
                } catch (NamingException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                break;
            default:
                writeError(res, ErrorCode.OPERATION_UNKNOWN);
                logger.warn("requested op " + op);
        }

    }


    private void overviewDataOperations(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            logger.debug("Cart overview page shown");
            String email=req.getParameter("email");
            Cart cart = new Cart(email);
            List<Product> products = new ListOrdersByProductidAndEmailDatabase(getDataSource().getConnection(), cart ).getProduct();
            JSONObject productJSON;
            List<JSONObject> productsJSON  = new ArrayList<>();
            logger.debug(email);


            for (int i = 0; i < products.size(); i++) {
                    productJSON = new JSONObject();
                    productJSON.put("id", products.get(i).getId());
                    productJSON.put("price", products.get(i).getPrice());
                    productJSON.put("name", products.get(i).getName());
                productJSON.put("number", products.get(i).getnumber());
                productJSON.put("url", products.get(i).geturl());
                productJSON.put("description", products.get(i).getDescription());
                    productsJSON.add(productJSON);
                }
            JSONObject resultJSON = new JSONObject();
            resultJSON.put("data", productsJSON);
            logger.debug(resultJSON);
            res.setStatus(HttpServletResponse.SC_OK);
            res.setHeader("Access-Control-Allow-Origin", "*");
            res.setContentType("application/json");
            res.getWriter().write(resultJSON.toString());

        } catch (NamingException | SQLException e) {
            writeError(res, ErrorCode.INTERNAL_ERROR);
            logger.error("stacktrace:", e);
        }
    }
    private void sendEmail(HttpServletRequest req, HttpServletResponse res) throws IOException, NamingException, SQLException {

        // Sender's email ID needs to be mentioned
        String from = "noreply@MAGpark.com";
        // Assuming you are sending email from localhost
        String host = "localhost";
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);
        String to =req.getParameter("email");
        User usert = new User(to);
        User user = new GetUserByMailDatabase(getDataSource().getConnection(), usert).getUserByMail();
        Cart delCart = new DeleteAllOrdersByEmailDatabase(getDataSource().getConnection(), user).deleteUser();
        res.setStatus(HttpServletResponse.SC_OK);
        res.setHeader("Access-Control-Allow-Origin", "*");

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // Set Subject: header field
            message.setSubject("Order Received!");
            // Now set the actual message
            message.setText("Dear "+user.getFirst_name()+" "+user.getLast_name()+",\n"+
                    "Your payment was accepted, we are preparing your order.\n\n"+
                    "Kind regards,\n"+
                    "MAG inc.");

            // Send message
            Transport.send(message);

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}