package com.unikom.partnerservice.entity;


import com.unikom.partnerservice.dto.PartnerDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "partner")
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    @NotNull(message = "Code cannot be empty")
    @Size(min = 3, max = 10, message = "Code must be more than 3 character")
    private String code;

    @Column(name = "name")
    @NotNull(message = "Name cannot be empty")
    private String name;

    @Column(name = "founded_year")
    private int foundedYear;

    @Column(name = "quantity_of_employee")
    private int quantityOfEmployee;

    @Column(name = "address")
    private String address;

    @Column(name = "start_to_cooperate")
    private int startToCooperate;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_at")
    private String modifiedAt;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    public Partner() {
    }

    public Partner(PartnerDTO source) {
        BeanUtils.copyProperties(source, this);
    }

}
