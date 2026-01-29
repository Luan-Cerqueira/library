package dev.luanc.library.model.enums;

public enum BookCopyStatus {
    AVAILABLE("AVAILABLE"),
    NOT_AVAILABLE("NOT AVAILABLE"),
    DAMAGED("DAMAGED");

    private String status;

    BookCopyStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
