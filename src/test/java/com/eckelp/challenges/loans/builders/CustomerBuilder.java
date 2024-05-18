package com.eckelp.challenges.loans.builders;

import com.eckelp.challenges.loans.domains.Customer;

public class CustomerBuilder {

  private Customer customer = new Customer("", "", 0, 0.0);

  private CustomerBuilder() {}

  public static CustomerBuilder builder() {
    return new CustomerBuilder();
  }

  public CustomerBuilder withIncome(double income){
    customer = new Customer(customer.name(), customer.location(), customer.age(), income);
    return this;
  }

  public CustomerBuilder withLocation(String location){
    customer = new Customer(customer.name(), location, customer.age(), customer.income());
    return this;
  }

  public CustomerBuilder withAge(int age){
    customer = new Customer(customer.name(), customer.location(), age, customer.income());
    return this;
  }

  public Customer build() {
    return this.customer;
  }

}
