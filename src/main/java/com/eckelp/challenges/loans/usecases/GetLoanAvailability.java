package com.eckelp.challenges.loans.usecases;

import com.eckelp.challenges.loans.domains.Customer;
import com.eckelp.challenges.loans.domains.LoanRate;
import com.eckelp.challenges.loans.domains.LoanType;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class GetLoanAvailability {

  private final ApplicationContext context;

  public Collection<LoanRate> execute(final Customer customer) {

    final var rates = new HashSet<LoanRate>();

    Stream.of(LoanType.values()).forEach(type -> {
          final var loanRule = context.getBean(type.rule());

          if(loanRule.apply(customer)) {
            rates.add(new LoanRate(type, loanRule.rate()));
          }

    });

    return rates;
  }

}
