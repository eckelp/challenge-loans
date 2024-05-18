package com.eckelp.challenges.loans.gateways.http.json;

import java.util.Collection;

public record LoanAvailabilityResponseJson(
    String name,
    Collection<LoanRateResponseJson> loans
) {
}
