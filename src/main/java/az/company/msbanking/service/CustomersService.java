package az.company.msbanking.service;

import az.company.msbanking.dao.entity.CustomersEntity;
import az.company.msbanking.dao.repository.AccountsRepository;
import az.company.msbanking.dao.repository.CustomersRepository;
import az.company.msbanking.dto.constant.ExceptionConstant;
import az.company.msbanking.dto.request.AccountsRequest;
import az.company.msbanking.dto.request.CustomersRequest;
import az.company.msbanking.dto.response.AccountCustomerResponse;
import az.company.msbanking.dto.response.AccountsResponse;
import az.company.msbanking.dto.response.CustomersResponse;
import az.company.msbanking.exception.ObjectNotFoundException;
import az.company.msbanking.mapper.AccountMapper;
import az.company.msbanking.mapper.factory.AccountFactory;
import az.company.msbanking.mapper.factory.CustomerFactory;

import static az.company.msbanking.mapper.CustomerMapper.MAP;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CustomersService {
    private final CustomersRepository customersRepository;
    private final AccountsRepository accountsRepository;

    public CustomersService(CustomersRepository customersRepository, AccountsRepository accountsRepository) {
        this.customersRepository = customersRepository;
        this.accountsRepository = accountsRepository;
    }

    public List<CustomersResponse> getCustomers() {
        log.info("ActionLog.getCustomers.start");
        return customersRepository.findAll().stream()
                .map(MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public CustomersResponse getCustomer(Long id) {
        log.info("ActionLog.getCustomer.start");
        return MAP.entityToResponse(fetchCustomerById(id));
    }

    public List<AccountsResponse> getAccountsByCustomersId(Long customerId) {
        return accountsRepository
                .findAccountsEntityByCustomersId(customerId).stream()
                .map(AccountMapper.MAP::entityToResponse)
                .collect(Collectors.toList());
    }

    public CustomersResponse saveCustomer(CustomersRequest request) {
        log.info("ActionLog.saveCustomer.start");
        var customer = customersRepository.save(CustomerFactory.buildCustomerEntity(request));
        log.info("ActionLog.saveCustomer.success");
        return MAP.entityToResponse(customer);
    }

    @Transactional
    public AccountCustomerResponse addAccountsToCustomer(Long customerId,
                                                         AccountsRequest accountsRequest) {
        log.info("ActionLog.addAccountsToCustomer.start");
        CustomersEntity customerFromDB = fetchCustomerById(customerId);

        var account = AccountFactory
                .buildAccountEntity(accountsRequest, customerFromDB);

        customerFromDB.getAccounts().add(account);

        CustomersEntity customer = customersRepository.save(customerFromDB);
        log.info("ActionLog.addAccountsToCustomer.success");

        var accountResponse =
                AccountMapper.MAP.entityToResponse(account);
        var customerResponse =
                MAP.entityToResponse(customer);
        return new AccountCustomerResponse(customerResponse, accountResponse);
    }

    private CustomersEntity fetchCustomerById(Long id) {
        return customersRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException(
                        String.format(ExceptionConstant.NOT_FOUND_MESSAGE, id),
                        ExceptionConstant.NOT_FOUND_CODE
                ));
    }
}
