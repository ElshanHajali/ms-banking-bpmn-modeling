package az.company.msbanking.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "customers")
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private BigDecimal balance;
    private LocalDate birthDate; // yyyy-MM-dd
    private String address;

    @OneToMany(cascade = {REFRESH, DETACH, MERGE, PERSIST},
            mappedBy = "customers")
    private List<AccountsEntity> accounts;
    // Types of Accounts
    // Personal Accounts.
    // Real Accounts.
    // Nominal Accounts.

    public CustomersEntity() { }

    public CustomersEntity(Long id, String name,
                           BigDecimal balance, LocalDate birthDate, String address, List<AccountsEntity> accounts) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.birthDate = birthDate;
        this.address = address;
        this.accounts = accounts;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<AccountsEntity> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountsEntity> accounts) {
        this.accounts = accounts;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomersEntity)) return false;
        CustomersEntity that = (CustomersEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "CustomersEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                '}';
    }
}
