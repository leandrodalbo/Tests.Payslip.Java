package com.mhrglobal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManagerTest {
    private final Employee manager = new Manager(330.0, 3);

    @Test
    public void shouldCalculateOvertimePayed() {
        assertThat(manager.overtimePayed()).isEqualTo(22.5);
    }

    @Test
    public void shouldCalculateTheTotalSalary() {
        assertThat(manager.totalSalary()).isEqualTo(352.5);
    }

    @Test
    public void shouldNotPassTheOvertimeLimit() {
        Employee manager = new Manager(100.0, 61);
        assertThat(manager.overtimePayed()).isEqualTo(450.0);
    }

    @Test
    public void shouldGetTheRightRole() {
        assertThat(manager.role()).isEqualTo("manager");
    }
}
