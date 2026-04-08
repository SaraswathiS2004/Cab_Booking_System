package dto;

public class Login {
    private String name;
    private String password;
    private Role role;

    public enum Role{
        ADMIN , USER , DRIVER
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    }
    public void setRole(Role role){
        this.role = role;
    }
    public Role getRole(){
        return role;
    }
}
