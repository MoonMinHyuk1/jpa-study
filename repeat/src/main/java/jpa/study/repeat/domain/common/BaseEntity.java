package jpa.study.repeat.domain.common;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    private Date createdDate;
    private Date lastModifiedDate;
}
