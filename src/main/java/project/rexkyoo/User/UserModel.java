package project.rexkyoo.User;

import project.rexkyoo.User.Role;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class UserModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "user_id")
    private int id;
    private String userName;
    private String password;
    private Role role;

    public UserModel()
    {}

    public UserModel(String userName, String password, Role role)
    {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Role getRole()
    {
        return role;
    }

}
