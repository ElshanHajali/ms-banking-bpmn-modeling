package az.company.msbanking.dto.request;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomersRequest {
    private Long id;
    private String name;
    private BigDecimal balance;
    private String accountType;
    private LocalDate birthDate;
    private String address;

    public CustomersRequest() {
    }

    public CustomersRequest(Long id, String name, BigDecimal balance, String accountType, LocalDate birthDate, String address) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.accountType = accountType;
        this.birthDate = birthDate;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomersRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
