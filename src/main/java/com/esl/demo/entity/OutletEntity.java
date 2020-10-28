package com.esl.demo.entity;

import com.esl.demo.dto.OutletDto;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "outlets")
public class OutletEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Outlet name can't be null.")
    @Column
    private String name;

    @NotNull(message = "Outlet deleted status can't be null.")
    @Column
    private Boolean deleted;

    @NotNull(message = "Outlet code can't be null.")
    @Size(min = 2, max = 5, message = "Country code should be between 2 and 5 characters long.")
    @Column
    private String code;

    public OutletEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OutletDto convertToDto() {

        OutletDto returnDto = new OutletDto();

        returnDto.setId(this.id);
        returnDto.setName(this.name);
        returnDto.setDeleted(this.deleted);
        returnDto.setCode(this.code);
        return returnDto;
    }
}
