package com.myaccessweb.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.myaccessweb.models.VisitorExit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VisitorExitDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Instant createDate;

    public VisitorExitDTO() {
    }

    public VisitorExitDTO(Long id, Instant createDate) {
        this.id = id;
        this.createDate = createDate;
    }

    public VisitorExitDTO(VisitorExit entity) {
        this.id = entity.getId();
        this.createDate = entity.getCreateDate();
    }
}
