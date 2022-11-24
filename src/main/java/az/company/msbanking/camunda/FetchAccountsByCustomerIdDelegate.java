package az.company.msbanking.camunda;

import az.company.msbanking.dto.response.CommonResponse;
import az.company.msbanking.dto.response.Status;
import az.company.msbanking.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("fetchAccountsByCustomerIdDelegate")
public class FetchAccountsByCustomerIdDelegate implements JavaDelegate {
    private final CustomersService customersService;

    public FetchAccountsByCustomerIdDelegate(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("FetchAccountsByCustomerIdDelegate.execute.start");
        var customerId = (Long) execution
                .getVariable("customerId");

        var accountsResponse =
                customersService.getAccountsByCustomersId(customerId);

        var commonResponse = new CommonResponse<>(
                Status.successStatus(),
                accountsResponse
        );

        execution.setVariable("response", commonResponse);
        log.info("FetchAccountsByCustomerIdDelegate.execute.success");
    }
}
