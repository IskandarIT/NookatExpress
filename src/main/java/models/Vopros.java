package models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Vopros {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vopros;
    private Date  date=new Date();

//    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "users")
//    private User user;
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public Vopros(String vopros) {
        this.vopros = vopros;
    }

    public Vopros() {
    }

    public String getVopros() {
        return vopros;
    }

    public void setVopros(String vopros) {
        this.vopros = vopros;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
