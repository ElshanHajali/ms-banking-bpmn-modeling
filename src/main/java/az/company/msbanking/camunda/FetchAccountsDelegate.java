package az.company.msbanking.camunda;

import az.company.msbanking.dto.response.CommonResponse;
import az.company.msbanking.dto.response.Status;
import az.company.msbanking.service.AccountsService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("fetchAccountsDelegate")
public class FetchAccountsDelegate implements JavaDelegate {
    private final AccountsService accountsService;

    public FetchAccountsDelegate(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("FetchAccountsDelegate.execute.start");
        var accountsResponse = accountsService.getAccounts();

        var commonResponse = new CommonResponse<>(
                Status.successStatus(), accountsResponse
        );

        execution.setVariable("response", commonResponse);
        log.info("FetchAccountsDelegate.execute.success");
    }
}
