package resource;

import org.json.JSONObject;

public class User {
    static  String email;
    private String password;
    private String first_name;
    private String last_name;
    private String role;

    public User(String email){
        this.email = email;

    }
    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String first_name, String last_name, String role) {
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public User(String email, String password, String first_name, String last_name, String role) {
        this.email = email;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    public static String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getRole() {
        return role;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }



    public JSONObject toJSON(){
        JSONObject uJson = new JSONObject();
        uJson.put("email", email);
        uJson.put("first_name", first_name);
        uJson.put("last_name", last_name);
        uJson.put("password", password);
        uJson.put("role", role);

        return uJson;
    }
}
