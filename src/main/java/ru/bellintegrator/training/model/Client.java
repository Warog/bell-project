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


    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinTable(
            name = "User_Office",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "office_id")
    )
    private Set<Office> offices;

    public Set<Office> getOffices() {
        if (offices == null) {
            offices = new HashSet<>();
        }
        return offices;
    }

    public void addOffiec(Office office) {
        getOffices().add(office);
        office.getClient().add(this);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
        office.getClient().remove(this);
    }

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
    private Set<Document> documents = new HashSet<Document>();

    @OneToMany(mappedBy = "Document", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Document> getDocuments() {
        return this.documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public void addDocument(Document document) {
        document.setClient(this);
        getDocuments().add(document);
    }

    public void removeDocument(Document document) {
        getDocuments().remove(document);
    }
}
