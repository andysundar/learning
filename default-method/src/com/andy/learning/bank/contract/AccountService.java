package com.andy.learning.bank.contract;

import java.math.BigDecimal;

import com.andy.learning.bank.model.AccountDetail;
import com.andy.learning.bank.model.AccountNumber;
import com.andy.learning.bank.model.Balance;

public interface AccountService {
    AccountNumber createAccount(AccountDetail accountDetail); 
    Balance debit(AccountNumber accountNumber, BigDecimal amount);
    Balance credit(AccountNumber accountNumber, BigDecimal amount);
}