package java8;

public class User {
    private final Integer id;
    private final String name;
    private final String phone;
 
    public User(Integer id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
 
    public Integer getId() {
        return id;
    }
 
    public String getName() {
        return name;
    }
 
    public String getPhone() {
        return phone;
    }

	public boolean hasSpanishPhone() {
		return this.phone.contains("+34");
	}   
}