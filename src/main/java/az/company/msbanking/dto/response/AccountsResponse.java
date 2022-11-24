package az.company.msbanking.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AccountsResponse implements Serializable {
    static final long serialVersionUID = -7034897190745766939L;
    private Long id;
    private String type;
    private String number;
    private String iban;
    private String currency;
    private LocalDateTime createdAt;

    public AccountsResponse() {
    }

    public AccountsResponse(Long id, String type,
                            String number, String iban,
                            String currency,
                            LocalDateTime createdAt) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.iban = iban;
        this.currency = currency;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AccountsResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", iban='" + iban + '\'' +
                ", currency='" + currency + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
