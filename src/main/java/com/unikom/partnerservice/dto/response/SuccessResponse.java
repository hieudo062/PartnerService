package com.unikom.partnerservice.dto.response;

import com.unikom.partnerservice.dto.PartnerDTO;
import lombok.Data;

@Data
public class SuccessResponse {

    private int status;
    private PartnerDTO data;

    public SuccessResponse(int status , PartnerDTO data) {
        this.status = status;
        this.data = data;
    }

}
