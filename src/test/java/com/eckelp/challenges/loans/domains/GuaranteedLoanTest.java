package com.eckelp.challenges.loans.domains;

import com.eckelp.challenges.loans.builders.CustomerBuilder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class GuaranteedLoanTest {

  private final GuaranteedLoan guaranteedLoan;

  public GuaranteedLoanTest() {
    this.guaranteedLoan = new GuaranteedLoan();
  }

  @ParameterizedTest
  @CsvSource({
      "1000, 18, BR, true",
      "1000, 40, BR, true",
      "1000, 18, SP, true",
      "1000, 40, SP, true",
      "4000, 18, BR, false",
      "4000, 40, BR, false",
      "4000, 18, SP, true",
      "4000, 40, SP, false",
      "9000, 18, BR, false",
      "9000, 40, BR, false",
      "9000, 18, SP, false",
      "9000, 40, SP, false",
  })
  public void shouldCheckConsignmentLoanAvailability(double income, int age, String location, boolean expectedResult) {

    final var customer = CustomerBuilder.builder()
                                        .withIncome(income)
                                        .withAge(age)
                                        .withLocation(location)
                                        .build();

    final var result = guaranteedLoan.apply(customer);

    assertThat(result).isEqualTo(expectedResult);
  }
}
