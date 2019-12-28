package project.rexkyoo.User.Models;

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
    private String username;
    private String password;
    private int enable;

    public UserModel()
    {}

    public UserModel(String username, String password, int enable)
    {
        this.username = username;
        this.password = password;
        this.enable = enable;
    }

    public int getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public int getEnable()
    {
        return enable;
    }

    public void setEnable(int enable)
    {
        this.enable = enable;
    }
}
