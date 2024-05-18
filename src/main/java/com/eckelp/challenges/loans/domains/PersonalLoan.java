package com.eckelp.challenges.loans.domains;

import org.springframework.stereotype.Component;

@Component
public class PersonalLoan implements Loan {

  private static final double DEFAULT_RATE = 4.0;

  private static final String LOCATION = "SP";
  private static final int MAXIMUM_AGE = 30;
  private static final double MINIMUM_CLIENT_INCOME = 3000.0;
  private static final double MAXIMUM_CLIENT_INCOME = 5000.0;

  @Override
  public boolean apply(final Customer customer) {
    return customer.income() <= MINIMUM_CLIENT_INCOME
        || isIncomeBetweenMinimumAndMaximumAndCustomerAgeUnderAndCustomerLocation(customer);
  }

  @Override
  public double rate() {
    return DEFAULT_RATE;
  }

  private boolean isIncomeBetweenMinimumAndMaximumAndCustomerAgeUnderAndCustomerLocation(final Customer customer) {
    return customer.income() >= MINIMUM_CLIENT_INCOME
        && customer.income() <= MAXIMUM_CLIENT_INCOME
        && customer.age() <= MAXIMUM_AGE
        && LOCATION.equalsIgnoreCase(customer.location());
  }
}
