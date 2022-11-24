package az.company.msbanking.service;

import az.company.msbanking.dao.entity.AccountsEntity;
import az.company.msbanking.dao.repository.AccountsRepository;
import az.company.msbanking.dto.constant.ExceptionConstant;
import az.company.msbanking.dto.response.AccountsResponse;
import az.company.msbanking.exception.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static az.company.msbanking.mapper.AccountMapper.MAP;

@Slf4j
@Service
public class AccountsService {
    private final AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public List<AccountsResponse> getAccounts() {
        log.info("ActionLog.getAccounts.start");
        return accountsRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public AccountsResponse getAccount(Long id) {
        log.info("ActionLog.getAccount.start");
        return MAP.entityToResponse(fetchAccountById(id));
    }

    public AccountsEntity fetchAccountById(Long id) {
        return accountsRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format(ExceptionConstant.NOT_FOUND_MESSAGE, id),
                        ExceptionConstant.NOT_FOUND_CODE
                ));
    }
}
