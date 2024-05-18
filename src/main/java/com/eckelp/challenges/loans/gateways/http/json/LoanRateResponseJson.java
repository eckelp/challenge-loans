package com.eckelp.challenges.loans.gateways.http.json;

import com.eckelp.challenges.loans.domains.LoanType;
import com.fasterxml.jackson.annotation.JsonProperty;

public record LoanRateResponseJson(
    LoanType type,
    @JsonProperty("interest_rate") double rate
) {
}
