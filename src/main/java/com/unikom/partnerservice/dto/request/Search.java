package com.unikom.partnerservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Search {

    private String code;
    private String name;
    private Integer foundedYear;
    private Integer quantityOfEmployee;

}
