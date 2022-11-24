package az.company.msbanking.controller;

import az.company.msbanking.dto.request.AccountsRequest;
import az.company.msbanking.dto.response.CommonResponse;
import org.camunda.bpm.engine.RuntimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customers")
public class BpmnCustomersController {
    private final RuntimeService runtimeService;

    public BpmnCustomersController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @GetMapping("{customerId}/accounts")
    public ResponseEntity<?> getAccountsByCustomersId(
            @PathVariable Long customerId
    ) {
        var commonResponse = runtimeService
                .createProcessInstanceByKey(
                        "accounts_by_customer_id"
                ).setVariable("customerId", customerId)
                .executeWithVariablesInReturn()
                .getVariables()
                .getValue("response", CommonResponse.class);
        return ResponseEntity.ok().body(commonResponse);
    }

    @GetMapping
    public ResponseEntity<?> getCustomers() {
        var commonResponse = runtimeService
                .createProcessInstanceByKey(
                        "fetch_customers"
                ).executeWithVariablesInReturn()
                .getVariables()
                .getValue("response", CommonResponse.class);

        return ResponseEntity.ok().body(commonResponse);
    }

    @PostMapping("{customerId}/accounts")
    public ResponseEntity<?> saveAccount(
            @PathVariable Long customerId,
            @RequestBody AccountsRequest accountsRequest
    ) {
        var response = runtimeService
                .createProcessInstanceByKey("process_account")
                .setVariable("customerId", customerId)
                .setVariable("request", accountsRequest)
                .executeWithVariablesInReturn()
                .getVariables()
                .getValue("response", CommonResponse.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
