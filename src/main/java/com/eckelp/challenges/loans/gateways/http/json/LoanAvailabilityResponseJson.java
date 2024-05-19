package com.eckelp.challenges.loans.gateways.http.json;

import java.util.Collection;

public record LoanAvailabilityResponseJson(
    String customer,
    Collection<LoanRateResponseJson> loans
) {
}
