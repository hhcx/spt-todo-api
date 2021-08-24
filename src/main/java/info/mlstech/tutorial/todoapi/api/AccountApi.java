package info.mlstech.tutorial.todoapi.api;


import info.mlstech.tutorial.todoapi.biz.AccountBiz;
import info.mlstech.tutorial.todoapi.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acc")
public class AccountApi {

    @Autowired
    private AccountBiz accountBiz;

    // http://localhost:8080/acc
    @GetMapping
    public List<Account> listAll() {

        return accountBiz.listAll();
    }

    // http://localhost:8080/acc/f?username=xxxx&lock=false
    @GetMapping("/f")
    public List<Account> listByUsername(@RequestParam String username, @RequestParam("lock") Boolean isLock) {

        return accountBiz.getAccount(username, isLock);
    }


    // http://localhost:8080/acc
    @PostMapping
    public Account create(@RequestBody Account account) {

        return accountBiz.create(account);
    }
}
