package com.eckelp.challenges.loans.domains;

import com.eckelp.challenges.loans.builders.CustomerBuilder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ConsignmentLoanTest {

  private final ConsignmentLoan consignmentLoan;

  public ConsignmentLoanTest() {
    this.consignmentLoan = new ConsignmentLoan();
  }

  @ParameterizedTest
  @CsvSource({
      "1000, 18, BR, false",
      "1000, 40, BR, false",
      "1000, 18, SP, false",
      "1000, 40, SP, false",
      "4000, 18, BR, false",
      "4000, 40, BR, false",
      "4000, 18, SP, false",
      "4000, 40, SP, false",
      "9000, 18, BR, true",
      "9000, 40, BR, true",
      "9000, 18, SP, true",
      "9000, 40, SP, true",
  })
  public void shouldCheckConsignmentLoanAvailability(double income, int age, String location, boolean expectedResult) {
    final var customer = CustomerBuilder.builder()
                                        .withIncome(income)
                                        .withAge(age)
                                        .withLocation(location)
                                        .build();

    final var result = consignmentLoan.apply(customer);

    assertThat(result).isEqualTo(expectedResult);
  }
}
