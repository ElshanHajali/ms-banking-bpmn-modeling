package az.company.msbanking.camunda;

import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import javax.inject.Named;

@Slf4j
@Named("feeCalculationDelegate")
public class FeeCalculateDelegate implements JavaDelegate {
    // FIXME: 11/24/2022 Calculate Fee to create account
    @Override
    public void execute(DelegateExecution execution) throws Exception {
        log.info("FeeCalculateDelegate.execute.start");

        log.info("FeeCalculateDelegate.execute.success");
    }
}
