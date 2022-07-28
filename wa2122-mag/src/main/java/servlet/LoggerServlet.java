package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;




public class LoggerServlet extends HttpServlet{


    Logger logger;

    @Override
    public void init(ServletConfig config ) throws ServletException{
        super.init(config);

        logger= LogManager.getLogger(this.getClass());

        System.out.println("MESSAGE WRITTEN ON STANDARD OUT DURING INIT");
        logger.info("MESSAGE WRITTEN ON LOGGER DURING INIT");


    }

    @Override
    public void destroy(){

        super.destroy();
    }

    public void  doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{


        String str = req.getParameter("message");

        System.out.println("stdout:" + str);
        logger.info("log info:" + str);
        logger.debug("log debug" + str);
        logger.error("log error" + str);
        logger.warn("log warn:" + str);



    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{


    }



}
