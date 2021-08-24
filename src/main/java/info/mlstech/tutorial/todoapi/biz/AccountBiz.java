package info.mlstech.tutorial.todoapi.biz;

import info.mlstech.tutorial.todoapi.model.Account;
import info.mlstech.tutorial.todoapi.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountBiz {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public List<Account> listAll() {

        return accountRepository.findAll();
    }

    @Transactional
    public Account create(Account account) {

        return accountRepository.save(account);
    }

    public List<Account> getAccount(String username, Boolean isLock) {

        return accountRepository.findByUsernameAndIsLock(username, isLock);
    }
}
