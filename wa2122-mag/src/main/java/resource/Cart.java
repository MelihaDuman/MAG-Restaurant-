package resource;

import jakarta.servlet.ServletInputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Cart {
    private static int product_id ;

    private static String email;


    public Cart(String email, int product_id) {
        this.product_id = product_id;
        this.email=email;
    }
    public Cart(String email) {
        this.email=email;
    }


    public JSONObject toJSON() {
        JSONObject jobj = new JSONObject();
        jobj.put("email", this.email);
        jobj.put("productid", this.product_id);

        return jobj;
    }

    public static Cart fromJSON(InputStream inputStream) throws IOException, JSONException {
        String dataString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        JSONObject jobj = new JSONObject(dataString);


        String email = jobj.getString("email");
        int product_id = jobj.getInt("productid");
        return new Cart( email, product_id);

    }


    public static Cart fromJSON(ServletInputStream inputStream) {
        return null;
    }

    public static List<Order> fromJSONlist(ServletInputStream inputStream) {
        return null;
    }


    public String toString(){
        return "ORDERITEMS -  product_id:%d ".formatted( product_id);
    }


    public static int getProduct_id() {
        return product_id;
    }

    public static String getEmail() {return email;}



}


