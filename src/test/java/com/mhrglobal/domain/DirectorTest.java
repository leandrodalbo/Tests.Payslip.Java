package com.mhrglobal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectorTest {

    private final Employee director = new Director(564.0);

    @Test
    public void shouldCalculateOvertimePayed() {
        assertThat(director.overtimePayed()).isEqualTo(0);
    }

    @Test
    public void shouldCalculateTheTotalSalary() {
        assertThat(director.totalSalary()).isEqualTo(564.0);
    }

    @Test
    public void shouldGetTheRightRole() {
        assertThat(director.role()).isEqualTo("director");
    }
}
