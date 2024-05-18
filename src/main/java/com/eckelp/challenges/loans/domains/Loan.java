package com.eckelp.challenges.loans.domains;

public interface Loan {
  boolean apply(Customer customer);
  double rate();

}
