package az.company.msbanking.camunda;

import az.company.msbanking.dto.response.AccountCustomerResponse;
import az.company.msbanking.dto.response.CommonResponse;
import az.company.msbanking.dto.response.Status;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("prepareResponseDelegate")
public class PrepareResponseDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("PrepareResponseDelegate.execute.start");
        AccountCustomerResponse accountCustomerResponse =
                (AccountCustomerResponse) execution
                        .getVariable("account_customer");

        var commonResponse = new CommonResponse<>(
                Status.successStatus(),
                accountCustomerResponse
        );

        execution.setVariable("response", commonResponse);
        log.info("PrepareResponseDelegate.execute.success");
    }
}
