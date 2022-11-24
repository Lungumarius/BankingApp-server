package services;

import com.example.bankingappserver.DTO.AccountDTO;
import com.example.bankingappserver.model.Account;

public interface AccountService {

    public AccountDTO saveNewAccount(Account account);

    public Account getAccountByUserId(int id);

}
