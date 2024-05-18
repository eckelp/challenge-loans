package com.eckelp.challenges.loans.domains;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Accessors(fluent = true)
@RequiredArgsConstructor
public enum LoanType {
  PERSONAL(PersonalLoan.class),
  GUARANTEED(GuaranteedLoan.class),
  CONSIGNMENT(ConsignmentLoan.class);

  private final Class<? extends Loan> rule;
}
