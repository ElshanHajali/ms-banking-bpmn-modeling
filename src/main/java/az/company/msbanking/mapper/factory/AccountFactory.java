package az.company.msbanking.mapper.factory;

import az.company.msbanking.dao.entity.AccountsEntity;
import az.company.msbanking.dao.entity.CustomersEntity;
import az.company.msbanking.dto.request.AccountsRequest;

public class AccountFactory {

    public static AccountsEntity buildAccountEntity(AccountsRequest accountsRequest,
                                                    CustomersEntity customer) {
        return new AccountsEntity(
                null,
                accountsRequest.getType(),
                accountsRequest.getNumber(), accountsRequest.getIban(),
                accountsRequest.getCurrency(),
                null, customer
        );
    }
}
