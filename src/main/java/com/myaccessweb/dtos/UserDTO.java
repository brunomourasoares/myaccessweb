package com.myaccessweb.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.myaccessweb.models.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String username;
    private String password;
    private Instant createDate;
    private Boolean blocked;

    public UserDTO() {
    }

    public UserDTO(Long id, String username, String password, Instant createDate, Boolean blocked) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.blocked = blocked;
    }

    public UserDTO(User entity) {
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.password = entity.getPassword();
        this.createDate = entity.getCreateDate();
        this.blocked = entity.getBlocked();
    }
}
