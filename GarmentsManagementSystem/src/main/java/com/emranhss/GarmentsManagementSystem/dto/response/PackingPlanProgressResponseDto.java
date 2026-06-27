package com.emranhss.GarmentsManagementSystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PackingPlanProgressResponseDto {


    private Integer planInput;


    private Integer packedSoFar;


    private Integer remaining;

}
