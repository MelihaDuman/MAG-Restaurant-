package resource;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Order {
    private final int order_id;

    private final int user_id;
    private final String order_date;



    public Order(int order_id, int user_id, String order_date){
        this.order_id = order_id;

        this.order_date = order_date;
        this.user_id=user_id;

    }

    public String toString(){
        return "ORDER - order_id: %d store_id: %d user_id:%d date: %s ".formatted(order_id, user_id, order_date);
    }
    
    
    public JSONObject toJSON(){
        JSONObject jobj  = new JSONObject();
        jobj.put("orderid", this.order_id);
        jobj.put("userid", this.user_id);
        jobj.put("orderdate", this.order_date);
        return jobj;
    }

    public static Order fromJSON(InputStream inputStream) throws IOException, JSONException {
        String dataString = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        JSONObject jobj = new JSONObject(dataString);

       int store_id = jobj.getInt("storeid");
        int user_id = jobj.getInt("userid");
        String order_date = jobj.getString("orderdate");
        int order_id=0;
        if (jobj.has("orderid")){
            order_id = jobj.getInt("orderid");
        }
        return new  Order(order_id,  user_id, order_date);

    }



    public int getOrder_id() {
        return order_id;
    }


    public String getOrder_date() {
        return order_date;
    }


    public int getUser_id() {
        return user_id;
    }
}
