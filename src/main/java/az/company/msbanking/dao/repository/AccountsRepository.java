package az.company.msbanking.dao.repository;


import az.company.msbanking.dao.entity.AccountsEntity;
import az.company.msbanking.dao.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<AccountsEntity, Long> {

    List<AccountsEntity> findAccountsEntityByCustomersId(Long customerId);

}
