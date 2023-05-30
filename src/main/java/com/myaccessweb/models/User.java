package com.myaccessweb.models;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String username;
    private String password;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createDate;
    
    @Column(columnDefinition="TINYINT DEFAULT 0")
    private Boolean blocked;

    public User() {
    }

    public User(Long id, String username, String password, Instant createDate, Boolean blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.blocked = blocked;
    }
}
