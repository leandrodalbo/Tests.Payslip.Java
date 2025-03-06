package com.mhrglobal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EngineerTest {
    private final Employee engineer = new Engineer(100.0, 10);

    @Test
    public void shouldCalculateOvertimePayed() {
        assertThat(engineer.overtimePayed()).isEqualTo(67.50);
    }

    @Test
    public void shouldCalculateTheTotalSalary() {
        assertThat(engineer.totalSalary()).isEqualTo(167.50);
    }

    @Test
    public void shouldNotPassTheOvertimeLimit() {
        Employee engineer = new Engineer(100.0, 61);
        assertThat(engineer.overtimePayed()).isEqualTo(405.0);
    }

    @Test
    public void shouldGetTheRightRole() {
        assertThat(engineer.role()).isEqualTo("engineer");
    }

}
