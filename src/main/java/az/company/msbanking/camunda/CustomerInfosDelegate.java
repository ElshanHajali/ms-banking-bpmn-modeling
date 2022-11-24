package az.company.msbanking.camunda;

import az.company.msbanking.dto.response.CustomersResponse;
import az.company.msbanking.service.CustomersService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("customerInfosDelegate")
public class CustomerInfosDelegate implements JavaDelegate {

    private final CustomersService customersService;

    public CustomerInfosDelegate(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("CustomerInfosDelegate.execute.start");
        Long customerId = (Long) execution.getVariable("customerId");

        CustomersResponse customer =
                customersService.getCustomer(customerId);

        execution.setVariable("customer", customer);
        log.info("CustomerInfosDelegate.execute.success");
    }

}
