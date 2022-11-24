package services.implementation;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.model.Account;
import com.example.bankingappserver.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.AccountService;

@Service
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDTO saveNewAccount(Account account) {
        return null;
    }

    @Override
    public Account getAccountByUserId(int id) {
        return null;
    }
}
