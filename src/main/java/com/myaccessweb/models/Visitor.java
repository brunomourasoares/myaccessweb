package com.myaccessweb.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_visitor")
public class Visitor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, unique = true, length = 11)
    private String document;
    @Column(nullable = false, length = 45)
    private String fullName;
    @Column(nullable = false, length = 15)
    private String gender;
    @Column(nullable = false, length = 11)
    private String contactNumber;
    private String company;
    @Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createDate;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime updateDate;
    @Column(columnDefinition = "TEXT")
    private String observation;
    @Column(nullable = false, columnDefinition="TINYINT DEFAULT 0")
    private Boolean blocked;
    private String photoUrl;

    public Visitor() {
    }

    public Visitor(Long id, String document, String fullName, String gender, String contactNumber, String company, 
                    LocalDateTime createDate, LocalDateTime updateDate, String observation, Boolean blocked, String photoUrl) {
        this.id = id;
        this.document = document;
        this.fullName = fullName;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.company = company;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.observation = observation;
        this.blocked = blocked;
        this.photoUrl = photoUrl;
    }
}
