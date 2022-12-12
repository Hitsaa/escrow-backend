package com.blockchain.escrow.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@JsonInclude(value = Include.NON_NULL)
@Accessors(chain = true)
public class DeveloperProjectDto {
    private Integer id;
    private String status;
    private ProjectDto project;
    private DeveloperDto developer;
}
