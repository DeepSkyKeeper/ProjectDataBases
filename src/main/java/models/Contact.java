package models;
import javax.persistence.*;

@Entity
@Table(name = "\"Contacts\"")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable=false)
    private Integer id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name ="\"customerId\"")
    private User customer;

    @Column(name = "\"contactName\"",nullable=false)
    private String contactName;

    @Column(name = "\"phone\"",length=15)
    private String phone;

    @Column(name = "\"email\"",length = 100)
    private String email;
    public Integer getId(){return id;}


}
