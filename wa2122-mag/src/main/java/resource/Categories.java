package resource;

import org.json.JSONObject;

public class Categories {

    private final int category_id;
    private String category_name;
    private String description;


    public Categories(int category_id){
        this.category_id = category_id;
    }

    public Categories(int category_id, String category_name, String description) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.description = description;
    }

    public String toString(){
        return "CATEGORY - category_id: %d name: %s".formatted(category_id, category_name);
    }

    public String getName() {
        return category_name;
    }

    public int getId() {
        return category_id;
    }
    public String getDescription() {
        return description;
    }

    public JSONObject toJSON(){
        JSONObject jobj  = new JSONObject();
        jobj.put("category_id", this.category_id);
        jobj.put("category_name", this.category_name);
        return jobj;
    }
}
