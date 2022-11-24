package az.company.msbanking.dto.request;

import java.io.Serializable;

public class AccountsRequest implements Serializable {
    static final long serialVersionUID = -7034897190745766939L;

    private Long id;
    private String type;
    private String number;
    private String iban;
    private String currency;

    public AccountsRequest(Long id, String type,
                           String number, String iban,
                           String currency) {
        this.id = id;
        this.type = type;
        this.number = number;
        this.iban = iban;
        this.currency = currency;
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

    @Override
    public String toString() {
        return "AccountsRequest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", number='" + number + '\'' +
                ", iban='" + iban + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }
}
