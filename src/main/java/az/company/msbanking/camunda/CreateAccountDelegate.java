package az.company.msbanking.camunda;

import az.company.msbanking.dto.request.AccountsRequest;
import az.company.msbanking.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("createAccountDelegate")
public class CreateAccountDelegate implements JavaDelegate {
    private final CustomersService customersService;

    public CreateAccountDelegate(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CreateAccountDelegate.execute.start");
        var accountsRequest = (AccountsRequest) execution
                .getVariable("request");

        Long customerId = (Long) execution
                .getVariable("customerId");

        var accountCustomerResponse =
                customersService.addAccountsToCustomer(
                        customerId, accountsRequest
                );

        execution.setVariable("account_customer", accountCustomerResponse);

        log.info("CreateAccountDelegate.execute.success");
    }
}
