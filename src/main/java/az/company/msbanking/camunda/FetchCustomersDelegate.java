package az.company.msbanking.camunda;

import az.company.msbanking.dto.response.CommonResponse;
import az.company.msbanking.dto.response.Status;
import az.company.msbanking.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("fetchCustomersDelegate")
public class FetchCustomersDelegate implements JavaDelegate {
    private final CustomersService customersService;

    public FetchCustomersDelegate(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("FetchCustomersDelegate.execute.start");
        var customersResponse =
                customersService.getCustomers();

        var commonResponse = new CommonResponse<>(
                Status.successStatus(), customersResponse
        );

        execution.setVariable("response", commonResponse);
        log.info("FetchCustomersDelegate.execute.success");
    }
}
