package ru.bellintegrator.training.model;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ClientController")
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

    @Column(name = "office_id", nullable = false)
    private Long officeId;

    @Column(name = "document_id", nullable = false)
    private Long documentId;

    @Column(name = "is_identified", nullable = false)
    private Boolean isIdentified;


    public Client() {

    }

    public Client(String firstName, String secondName, String middleName, String post, String phone, Long officeId, Long documentId, Long citizenshipId, Boolean isIdentified) {

        this.firistName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.post = post;
        this.phone = phone;
        this.officeId = officeId;
        this.documentId = documentId;
        this.citizenshipId = citizenshipId;
        this.isIdentified = isIdentified;
    }

    public Long getId() {
        return id;
    }

    public Integer getVersion() {
        return version;
    }

    public String getFiristName() {
        return firistName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getPost() {
        return post;
    }

    public String getPhone() {
        return phone;
    }

    public Long getCitizenshipId() {
        return citizenshipId;
    }

    public Long getOfficeId() {
        return officeId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public Boolean getIsIdentified() {
        return isIdentified;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setFiristName(String firstName) {
        this.firistName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCitizenshipId(Long citizenshipId) {
        this.citizenshipId = citizenshipId;
    }

    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }

    /**
     * One To Many
     */
    private Set<Document> documents = new HashSet<Document>();

    @OneToMany(mappedBy = "Document", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Document> getDocuments() {
        if (documents == null) {
            documents = new HashSet<>();
        }
        return documents;
    }

    public Set<Document> setDocuments(Set<Document> documents) {
        if (documents == null) {
            documents = new HashSet<>();
        }
        return documents;
    }

    public void addDocument(Document document) {
        getDocuments().add(document);
    }

//    public void removeDocument(Document document) {
//        getDocuments().remove(document);
//    }
}
