package com.webapp.dcf;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DcfGetRequest {

    private Long id;
    private BigDecimal dcfWithMarginOfSafety;

}
