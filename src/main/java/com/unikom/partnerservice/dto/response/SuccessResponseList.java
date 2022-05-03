package com.unikom.partnerservice.dto.response;

import com.unikom.partnerservice.dto.PartnerDTO;
import lombok.Data;

import java.util.List;

@Data
public class SuccessResponseList {

    private int status;
    private long totalRecord;
    private List<PartnerDTO> data;

    public SuccessResponseList(int status, long totalRecord , List<PartnerDTO> data) {
        this.status = status;
        this.totalRecord = totalRecord;
        this.data = data;
    }

}
