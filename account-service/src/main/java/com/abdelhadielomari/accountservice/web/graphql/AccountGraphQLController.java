package com.abdelhadielomari.accountservice.web.graphql;





import com.abdelhadielomari.accountservice.entities.Account;
import com.abdelhadielomari.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AccountGraphQLController {
    private final AccountService accountService;

    @QueryMapping
    public Account accountById(@Argument String id) {
        return accountService.getAccount(UUID.fromString(id));
    }
}
