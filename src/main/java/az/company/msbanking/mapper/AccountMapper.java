package az.company.msbanking.mapper;

import az.company.msbanking.dao.entity.AccountsEntity;
import az.company.msbanking.dto.response.AccountsResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper MAP = Mappers.getMapper(AccountMapper.class);

    AccountsResponse entityToResponse(AccountsEntity account);
}
