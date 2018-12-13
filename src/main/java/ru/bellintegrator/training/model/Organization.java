package ru.bellintegrator.training.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
* Организация
*/
@Entity(name = "Organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Version
    private Integer version;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "full_name", length = 50, nullable = false)
    private String fullName;

    @Column(name = "inn", length = 50, nullable = false)
    private String inn;

    @Column(name= "kpp", length = 50, nullable = false)
    private String kpp;

    @Column(name = "address", length = 100, nullable = false)
    private String address;

    @Column(name = "phone", length = 20, nullable = true)
    private String phone;

    @Column(name = "is_Active", nullable = true)
    private Boolean isActive;


    public Organization() {

    }

    public Organization(String name, String fullName, String inn, String kpp, String address, String phone, Boolean isActive) {
      this.name = name;
      this.fullName = fullName;
      this.inn = inn;
      this.kpp = kpp;
      this.address = address;
      this.phone = phone;
      this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
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

    public void setName(String Name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * One To Many
     */
    private Set<Office> offices = new HashSet<Office>();

    @OneToMany(mappedBy = "Office", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<Office> getOffices() {
        return this.offices;
    }

    public void setOffices(Set<Office> offices) {
        this.offices = offices;
    }

    public void addOffice(Office office) {
        getOffices().add(office);
    }

    public void removeOffice(Office office) {
        getOffices().remove(office);
    }
}