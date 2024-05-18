package com.eckelp.challenges.loans.gateways.http.converters;

import com.eckelp.challenges.loans.domains.Customer;
import com.eckelp.challenges.loans.domains.LoanRate;
import com.eckelp.challenges.loans.gateways.http.json.LoanAvailabilityRequestJson;
import com.eckelp.challenges.loans.gateways.http.json.LoanAvailabilityResponseJson;
import com.eckelp.challenges.loans.gateways.http.json.LoanRateResponseJson;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {

  public Customer convert(final LoanAvailabilityRequestJson json) {
    return new Customer(json.name(), json.location(), json.age(), json.income());
  }

  public LoanAvailabilityResponseJson convert(final Customer customer, final Collection<LoanRate> loanRates) {
    return new LoanAvailabilityResponseJson(
        customer.name(),
        loanRates.stream().map(rate -> new LoanRateResponseJson(rate.type(), rate.rate())).collect(Collectors.toSet())
    );
  }
}
