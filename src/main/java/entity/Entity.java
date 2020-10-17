package entity;

import lombok.Data;

import java.sql.Date;

@Data
public class Entity {
    private String name;
    private String password;
    private int gender;
    private Date birthday;
    private String email;
    private String city;
    private String hobby;
    private String avatar;
    private String role;
}
