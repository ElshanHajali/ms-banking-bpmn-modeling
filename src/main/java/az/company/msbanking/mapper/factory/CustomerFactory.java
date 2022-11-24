package az.company.msbanking.mapper.factory;

import az.company.msbanking.dao.entity.CustomersEntity;
import az.company.msbanking.dto.request.CustomersRequest;

public class CustomerFactory {
    public static CustomersEntity buildCustomerEntity(CustomersRequest request) {
        return new CustomersEntity(null,
                request.getName(),
                request.getBalance(),
                request.getBirthDate(),
                request.getAddress(), null
        );
    }
}
