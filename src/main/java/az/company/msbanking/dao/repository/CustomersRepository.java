package az.company.msbanking.dao.repository;

import az.company.msbanking.dao.entity.CustomersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<CustomersEntity, Long> {
}
