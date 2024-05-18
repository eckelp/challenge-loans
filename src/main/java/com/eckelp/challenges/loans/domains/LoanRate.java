package com.eckelp.challenges.loans.domains;

public record LoanRate(
    LoanType type,
    double rate
) {
}
