package com.unikom.partnerservice.dto;

import com.unikom.partnerservice.entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartnerDTO {

    private Long id;

    @NotNull(message = "Code cannot be empty")
    @Size(min = 3, max = 10, message = "Code must be more than 3 character")
    private String code;

    @NotNull(message = "Name cannot be empty")
    private String name;

    private int foundedYear;

    private int quantityOfEmployee;

    private String address;

    private int startToCooperate;

    private Boolean isDeleted;

    public void update(PartnerDTO source) {
        BeanUtils.copyProperties(source, this, "id");
    }

    public PartnerDTO(Partner source){
        BeanUtils.copyProperties(source, this, "isDeleted");
    }

}
