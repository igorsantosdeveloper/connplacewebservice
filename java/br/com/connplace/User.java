package br.com.connplace;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ccp_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String name;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_age")
    private int age;

    @Column(name = "user_dateofbirth")
    private String dateOfBirth;

    @Column(name = "user_sex")
    private String sex;

    @OneToMany(mappedBy = "user", targetEntity = Location.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Location> locations;

    public User(){}

    public User(String name, String password, int age, String dateOfBirth, String sex) {
        this.name = name;
        this.password = password;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
