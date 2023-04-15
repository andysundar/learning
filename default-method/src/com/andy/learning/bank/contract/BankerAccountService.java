package com.andy.learning.bank.contract;

import com.andy.learning.bank.model.AccountNumber;
import com.andy.learning.bank.model.AccountStatus;

public interface BankerAccountService extends AccountService {
    AccountStatus closeAccount(AccountNumber accountNumber); 
}
