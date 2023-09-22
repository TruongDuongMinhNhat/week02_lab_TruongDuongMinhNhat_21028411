package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.enums;

public enum EmployeeStatus {
    ACTIVE(1), IN_ACTIVE(0), TERMINATE(-1);
    private int value;
    EmployeeStatus(int value) { this.value = value; }
}
