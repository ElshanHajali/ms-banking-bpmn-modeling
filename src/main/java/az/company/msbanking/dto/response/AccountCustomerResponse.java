package az.company.msbanking.dto.response;

import java.io.Serializable;

public class AccountCustomerResponse implements Serializable {
    static final long serialVersionUID = -3387516993124229948L;
    private CustomersResponse customersResponse;
    private AccountsResponse accountsResponse;

    public AccountCustomerResponse() {
    }

    public AccountCustomerResponse(CustomersResponse customersResponse,
                                   AccountsResponse accountsResponse) {
        this.customersResponse = customersResponse;
        this.accountsResponse = accountsResponse;
    }

    public CustomersResponse getCustomersResponse() {
        return customersResponse;
    }

    public void setCustomersResponse(CustomersResponse customersResponse) {
        this.customersResponse = customersResponse;
    }

    public AccountsResponse getAccountsResponse() {
        return accountsResponse;
    }

    public void setAccountsResponse(AccountsResponse accountsResponse) {
        this.accountsResponse = accountsResponse;
    }

    @Override
    public String toString() {
        return "AccountCustomerResponse{" +
                "customersResponse=" + customersResponse +
                ", accountsResponse=" + accountsResponse +
                '}';
    }
}
