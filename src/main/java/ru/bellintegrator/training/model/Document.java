package ru.bellintegrator.training.model;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "number", length = 20, nullable = false)
    private String number;

    @Column(name = "doc_date", nullable = false)
    private Date doc_date;

    @Column(name = "type_id", nullable = false)
    private Long type_id;

    private Client client;

    @ManyToOne
    @JoinColumn(name = "id")
    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Document() {

    }

    public Document(String number, Date doc_date, Long type_id) {
        this.number = number;
        this.doc_date = doc_date;
        this.type_id = type_id;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Date getDocDate() {
        return doc_date;
    }

    public Long getTypeId() {
        return type_id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDocDate(Date doc_date) {
        this.doc_date = doc_date;
    }

    public void setTypeId(Long type_id) {
        this.type_id = type_id;
    }
}
