package az.company.msbanking.mapper;

import az.company.msbanking.dao.entity.CustomersEntity;
import az.company.msbanking.dto.response.CustomersResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
    CustomerMapper MAP = Mappers.getMapper(CustomerMapper.class);

    CustomersResponse entityToResponse(CustomersEntity customer);
}
