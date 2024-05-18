package com.eckelp.challenges.loans.gateways.http;

import com.eckelp.challenges.loans.gateways.http.converters.CustomerConverter;
import com.eckelp.challenges.loans.gateways.http.json.LoanAvailabilityRequestJson;
import com.eckelp.challenges.loans.gateways.http.json.LoanAvailabilityResponseJson;
import com.eckelp.challenges.loans.usecases.GetLoanAvailability;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
@RequiredArgsConstructor
public class LoanAvailabilityController {

  private final CustomerConverter converter;
  private final GetLoanAvailability getLoanAvailability;


  @PostMapping
  public ResponseEntity<LoanAvailabilityResponseJson> loanAvailability(@RequestBody @Valid final LoanAvailabilityRequestJson json) {

    final var customer = converter.convert(json);

    final var loanRates = getLoanAvailability.execute(customer);

    return ResponseEntity.ok(converter.convert(customer, loanRates));
  }
}
