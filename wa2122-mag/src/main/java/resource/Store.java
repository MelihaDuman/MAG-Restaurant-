package resource;

public class Store {

    private final int store_id;
    private String name;
    private String email;
    private String address;
    private String phone;

    public Store(int store_id) {
        this.store_id = store_id;
    }

    public Store(int store_id, String name, String email, String address, String phone) {
        this.store_id = store_id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String toString(){
        return "Storeid: %d Storename: %s email: %s address: %s phone: %s".formatted(store_id, name, email, address, phone);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return store_id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {return phone; }
}
