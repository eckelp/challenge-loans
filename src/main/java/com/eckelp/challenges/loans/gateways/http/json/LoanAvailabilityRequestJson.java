package com.eckelp.challenges.loans.gateways.http.json;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoanAvailabilityRequestJson(
    @NotBlank(message = "Name can't be empty") String name,
    @NotBlank(message = "CPF can't be empty") @Size(min = 10, message = "CPF must have at least 10 characters") String cpf,
    @Min(value = 1, message = "Value must be greater than 1") double income,
    @Min(value = 18, message = "Customer must not be under 18 years old") int age,
    @NotBlank @Size(min = 2, max = 2, message = "Location must have 2 characters") String location
) {
}
