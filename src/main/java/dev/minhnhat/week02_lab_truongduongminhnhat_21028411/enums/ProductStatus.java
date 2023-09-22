package dev.minhnhat.week02_lab_truongduongminhnhat_21028411.enums;

public enum ProductStatus {
    SOLD(1), SOLD_OUT(0), STOP(-1);
    private int value;
    ProductStatus(int value) {
        this.value = value;
    }
}
