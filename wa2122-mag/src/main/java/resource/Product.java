package resource;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Product {

    private final int product_id ;
    private String product_name;
    private String description;
    private int category_id;
    private float price;
    private  int number;
    private String url;



    public Product(int product_id){
        this.product_id = product_id;
    }

    public Product(int product_id,  String product_name,int category_id,float price,String description, String url) {
        this.product_id = product_id;
        this.product_name= product_name;
        this.description = description;
        this.category_id = category_id;
        this.price = price;
        this.url=url;

    }
    public Product(int product_id,  String product_name,float price,String description, String url) {
        this.product_id = product_id;
        this.product_name= product_name;
        this.price = price;
        this.description=description;
        this.url=url;
    }
    public Product(int product_id,  String product_name,float price,String description, String url , int number) {
        this.product_id = product_id;
        this.product_name= product_name;
        this.price = price;
        this.description=description;
        this.url=url;
        this.number=number;
    }


    public String toString(){
        return "PRODUCT - product_id: %d product_name: %s category_id: %s price: %f description: %s".formatted(product_id, product_name, category_id, price ,  description);
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return product_name;
    }

    public String geturl() {
        return url;
    }

    public int getId() {
        return product_id;
    }
    public int getnumber() {
        return number;
    }

    public int getCategory_id() {
        return category_id;
    }



}
