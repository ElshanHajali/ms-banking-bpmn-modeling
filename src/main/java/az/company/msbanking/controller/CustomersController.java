package az.company.msbanking.controller;

import az.company.msbanking.dto.request.AccountsRequest;
import az.company.msbanking.dto.request.CustomersRequest;
import az.company.msbanking.dto.response.AccountCustomerResponse;
import az.company.msbanking.dto.response.CustomersResponse;
import az.company.msbanking.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/customers")
public class CustomersController {
    private final CustomersService customersService;

    public CustomersController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("{id}")
    public CustomersResponse getCustomer(@PathVariable Long id) {
        return customersService.getCustomer(id);
    }

    @GetMapping
    public List<CustomersResponse> getCustomers() {
        return customersService.getCustomers();
    }

    @PostMapping
    public ResponseEntity<CustomersResponse> saveCustomer(
            @RequestBody CustomersRequest request) {
        var response =
                customersService.saveCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("{customerId}/accounts")
    public ResponseEntity<AccountCustomerResponse> addAccountToCustomer(
            @PathVariable Long customerId,
            @RequestBody AccountsRequest accountsRequest
    ) {
        var response =
                customersService.addAccountsToCustomer(
                        customerId, accountsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
