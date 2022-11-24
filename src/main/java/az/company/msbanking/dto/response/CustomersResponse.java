package az.company.msbanking.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomersResponse implements Serializable {
    static final long serialVersionUID = -7034897190745766939L;
    private Long id;
    private String name;
    private BigDecimal balance;
    private String Address;
    private LocalDate birthDate;

    public CustomersResponse(Long id, String name,
                             BigDecimal balance, String address,
                             LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        Address = address;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "CustomersResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", Address='" + Address + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
