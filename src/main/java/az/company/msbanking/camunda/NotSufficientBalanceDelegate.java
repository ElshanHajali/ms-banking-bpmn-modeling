package az.company.msbanking.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("notSufficientBalanceDelegate")
public class NotSufficientBalanceDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("NotSufficientBalanceDelegate.execute.start");

        log.info("NotSufficientBalanceDelegate.execute.success");
    }
}
