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
public class DcfGetDcfRequest {

    private Long id;
    private BigDecimal dcfWithMarginOfSafety;
}
