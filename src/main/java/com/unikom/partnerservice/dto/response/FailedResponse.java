package com.unikom.partnerservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailedResponse {

    private int status;
    private String errorCode;
    private String errorDescription;

}
