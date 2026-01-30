package dev.luanc.library.model.enums;

public enum LoanStatus {
    ACTIVE("ACTIVE"),
    RETURNED("RETURNED"),
    OVERDUE("OVERDUE");

    private String status;

    LoanStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
