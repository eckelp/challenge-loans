package com.eckelp.challenges.loans.domains;

public record Customer (
    String name,
    String location,
    int age,
    double income
){
}
