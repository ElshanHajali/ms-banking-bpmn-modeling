package az.company.msbanking.controller;

import az.company.msbanking.dto.response.AccountsResponse;
import az.company.msbanking.service.AccountsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v2/accounts")
public class AccountsController {
    private final AccountsService accountsService;

    public AccountsController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @GetMapping
    public List<AccountsResponse> getAccounts() {
        return accountsService.getAccounts();
    }

    @GetMapping("{id}")
    public AccountsResponse getAccount(
            @PathVariable Long id) {
        return accountsService.getAccount(id);
    }
}
