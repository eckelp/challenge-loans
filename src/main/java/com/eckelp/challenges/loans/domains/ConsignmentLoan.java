package com.eckelp.challenges.loans.domains;

import org.springframework.stereotype.Component;

@Component
public class ConsignmentLoan implements Loan {

  private static final double DEFAULT_RATE = 2.0;

  private static final double MINIMUM_INCOME = 5000.0;

  @Override
  public boolean apply(Customer customer) {
    return customer.income() >= MINIMUM_INCOME;
  }

  @Override
  public double rate() {
    return DEFAULT_RATE;
  }

}
