package az.company.msbanking.controller;

import az.company.msbanking.dto.response.CommonResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/accounts")
public class BpmnAccountsController {
    private final RuntimeService runtimeService;

    public BpmnAccountsController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @GetMapping
    public ResponseEntity<?> getAccounts() {
        var commonResponse = runtimeService
                .createProcessInstanceByKey(
                        "fetch_accounts"
                ).executeWithVariablesInReturn()
                .getVariables()
                .getValue("response", CommonResponse.class);

        return ResponseEntity.ok().body(commonResponse);
    }
}
