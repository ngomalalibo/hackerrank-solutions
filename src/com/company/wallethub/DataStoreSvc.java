package com.company.wallethub;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public interface DataStoreSvc
{
    // returns VALUE or throws EXCEPTION if key is missing
    String get(String key);
    
    // ADDs the key only when missing and returns TRUE if successfully added or FALSE if the key already exists
    boolean add(String key, String value);
    
    // returns TRUE if the key exists (indicating the value was updated) or FALSE if the key does not exist (and so was not updated)
    boolean update(String key, String value);
    
    // returns boolean if updated
    boolean delete(String key);
}


class BankAccountSvc
{
    
    private DataStoreSvc dataStoreSvc;  // assume this is properly initialized with an implementation of DataStoreSvc
    
    private ConcurrentMap<String, Boolean> accountLock = new ConcurrentHashMap<>();
    
    /**
     * get current balance of the account and add amount to current balance and update the account. Assume “accountId” already exists in the data store.
     */
    public void debitCreditAccount(String accountId, long amount)
    {
        
        //TODO implement obtainLock and removeLock method to allow the bank to update the balance of account with accountId
        // without the possibility of sync issues if method is running on multiple servers and trying to update same account
        
        if (obtainLock(accountId))
        {
            updateBalance(accountId, amount);
        }
        
        removeLock(accountId);
    }
    
    private boolean obtainLock(String accountId)
    {
        if (accountLock.get(accountId))
        {
            System.out.println("Account in locked");
            return false;
        }
        else
        {
            accountLock.put(accountId, true);
            return true;
        }
    }
    
    private void removeLock(String accountId)
    {
        accountLock.put(accountId, false);
    }
    
    private void updateBalance(String accountId, long amount)
    {
        String key = getBalanceKey(accountId);
        String balance = dataStoreSvc.get(key); // assume balance would always exist
        long newBalance = Long.parseLong(balance) + amount;
        dataStoreSvc.update(key, String.valueOf(newBalance));
    }
    
    private String getBalanceKey(String accountId)
    {
        return "balance_" + accountId;
    }
    
}