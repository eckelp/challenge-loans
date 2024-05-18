package com.eckelp.challenges.loans.usecases;

import com.eckelp.challenges.loans.builders.CustomerBuilder;
import com.eckelp.challenges.loans.domains.LoanRate;
import com.eckelp.challenges.loans.domains.LoanType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GetLoanAvailabilityTest {

  @Autowired
  private GetLoanAvailability getLoanAvailability;

  @ParameterizedTest
  @CsvSource({
      "2000, 18, BR, true",
      "2000, 40, BR, true",
      "2000, 18, BR, true",
      "2000, 40, BR, true",
      "3000, 18, BR, true",
      "3000, 40, BR, true",
      "3000, 18, BR, true",
      "3000, 40, BR, true",
      "9000, 18, BR, false",
      "9000, 40, BR, false",
      "9000, 18, BR, false",
      "9000, 40, BR, false",
  })
  public void shouldReturnPersonalAndGuaranteedLoanForMinimumIncome(double income, int age, String location, boolean expectedResult) {
    final var expectedTypes = List.of(LoanType.PERSONAL, LoanType.GUARANTEED);
    final var customer = CustomerBuilder.builder()
                                        .withIncome(income)
                                        .withAge(age)
                                        .withLocation(location)
                                        .build();

    final var loans = getLoanAvailability.execute(customer);
    final var resultSize = loans.stream()
                                .map(LoanRate::type)
                                .distinct()
                                .filter(expectedTypes::contains)
                                .count();

    assertThat(resultSize == 2).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({
      "2000, 18, BR, false",
      "2000, 40, BR, false",
      "2000, 18, BR, false",
      "2000, 40, BR, false",
      "3000, 18, BR, false",
      "3000, 40, BR, false",
      "3000, 18, BR, false",
      "3000, 40, BR, false",
      "5000, 18, BR, false",
      "5000, 40, BR, false",
      "5000, 18, SP, true",
      "5000, 40, SP, false",
  })
  public void shouldReturnPersonalAndGuaranteedAndConsignmentLoan(double income, int age, String location, boolean expectedResult) {
    final var expectedTypes = List.of(LoanType.values());
    final var customer = CustomerBuilder.builder()
                                        .withIncome(income)
                                        .withAge(age)
                                        .withLocation(location)
                                        .build();

    final var loans = getLoanAvailability.execute(customer);
    final var resultSize = loans.stream()
                                .map(LoanRate::type)
                                .distinct()
                                .filter(expectedTypes::contains)
                                .count();

    assertThat(resultSize == 3).isEqualTo(expectedResult);
  }

  @ParameterizedTest
  @CsvSource({
      "2000, 18, BR, false",
      "2000, 40, BR, false",
      "2000, 18, BR, false",
      "2000, 40, BR, false",
      "3000, 18, BR, false",
      "3000, 40, BR, false",
      "3000, 18, BR, false",
      "3000, 40, BR, false",
      "5000, 18, BR, true",
      "5000, 40, BR, true",
      "5000, 18, SP, true",
      "5000, 40, SP, true",
      "9000, 18, BR, true",
      "9000, 40, BR, true",
      "9000, 18, SP, true",
      "9000, 40, SP, true",
  })
  public void shouldReturnConsignmentLoan(double income, int age, String location, boolean expectedResult) {
    final var expectedTypes = List.of(LoanType.CONSIGNMENT);
    final var customer = CustomerBuilder.builder()
                                        .withIncome(income)
                                        .withAge(age)
                                        .withLocation(location)
                                        .build();

    final var loans = getLoanAvailability.execute(customer);
    final var resultSize = loans.stream()
                                .map(LoanRate::type)
                                .distinct()
                                .filter(expectedTypes::contains)
                                .count();

    assertThat(resultSize == 1).isEqualTo(expectedResult);
  }

}
