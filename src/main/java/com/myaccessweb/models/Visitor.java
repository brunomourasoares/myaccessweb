package com.myaccessweb.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_visitor")
public class Visitor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, unique = true, length = 11)
    private String document;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false, length = 15)
    private String gender;
    @Column(nullable = false, length = 11)
    private String contactNumber;
    private String company;
    @Column(nullable = false)
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    @Column(columnDefinition = "TEXT")
    private String observation;
    @Column(nullable = false, columnDefinition="TINYINT DEFAULT 0")
    private Boolean blocked;
    private String photoUrl;

    public Visitor() {
    }

    public Visitor(UUID id, String document, String name, String gender, String contactNumber, String company, 
                    LocalDateTime createDate, LocalDateTime updateDate, String observation, Boolean blocked, String photoUrl) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.company = company;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.observation = observation;
        this.blocked = blocked;
        this.photoUrl = photoUrl;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Visitor other = (Visitor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
