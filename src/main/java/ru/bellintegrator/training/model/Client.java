package ru.bellintegrator.training.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name", length = 50, nullable = false)
    private String firistName;

    @Column(name = "second_name", length = 50, nullable = false)
    private String secondName;

    @Column(name = "middle_name", length = 50, nullable = false)
    private String middleName;

    @Column(name = "post", length = 50, nullable = false)
    private String post;

    @Column(name = "phone", length = 20, nullable = false)
    private String phone;

    @Column(name = "citizenship_id", nullable = false)
    private Long citizenshipId;

    @Column(name = "is_identified", nullable = false)
    private Boolean isIdentified;


    public Client() {

    }

    public Client(String firstName, String secondName, String middleName, String post, String phone, Long citizenshipId, Boolean isIdentified) {

        this.firistName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.post = post;
        this.phone = phone;
        this.citizenshipId = citizenshipId;
        this.isIdentified = isIdentified;
    }

    /**
     * One To Many
     */
    private Set<Office> Offices = new HashSet<Office>();

    @OneToMany(mappedBy = "Office", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Office> getOffices() {
        return this.Offices;
    }

    public void setOffices(Set<Office> Offices) {
        this.Offices = Offices;
    }

    public void addOffice(Office office) {
        office.setClient(this);
        getOffices().add(office);
    }

    public void removeContactTelDetail(Office office) {
        getOffices().remove(office);
    }
}
