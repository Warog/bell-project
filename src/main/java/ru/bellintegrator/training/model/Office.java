package ru.bellintegrator.training.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone", length = 20, nullable = true)
    private String phone;

    @Column(name = "is_Active", nullable = false)
    private Boolean isActive;

    @Column(name = "org_id", nullable = false)
    private Long orgId;

    public Office() {

    }

    public Office(Long orgId, String name, String address, String phone, Boolean isActive) {
        this.orgId = orgId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public Long getOrgId() {
        return orgId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @ManyToMany(mappedBy = "offices")
    private Set<Client> clients;

    public Set<Client> getClient() {
        if (clients == null) {
            clients = new HashSet<>();
        }
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

}
