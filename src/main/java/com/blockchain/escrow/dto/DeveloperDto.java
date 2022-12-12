package com.blockchain.escrow.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(value = Include.NON_NULL)
@Accessors(chain = true)
public class DeveloperDto {
    private Integer id;
    private String developerName;
    private String phoneNumber;
    private String address;
}
