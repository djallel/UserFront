package com.userfront.Data;

import com.userfront.dao.PrimaryAccountDao;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.PrimaryTransaction;
import com.userfront.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataTest {

    @Autowired
    PrimaryAccountDao primaryAccountDao;


    public User getUser(){
        User user = new User();
        user.setUserId(1L);
        user.setFirstName("djalal");
        user.setEmail("b_tabet@esi.dz");
        user.setLastName("TABET");
        user.setPhone("0768010364");
        user.setPrimaryAccount(getPrimaryAccount());
        return user;
    }

    public PrimaryTransaction getPrimaryTransaction() {
        PrimaryTransaction PrimaryTransaction = new PrimaryTransaction(new Date() ,  "description",
                "type",  "status",  1L, new BigDecimal(2), null
        ) ;
        return PrimaryTransaction;
    }

    public List<PrimaryTransaction> getPrimaryTransactions() {
        List<PrimaryTransaction> PrimaryTransactions = new ArrayList<PrimaryTransaction>();

        PrimaryTransaction PrimaryTransaction = new PrimaryTransaction(new Date() ,  "description",
                "type",  "status",  1L, new BigDecimal(2), null
        ) ;

        PrimaryTransaction PrimaryTransaction2 = new PrimaryTransaction(new Date() ,  "description",
                "type",  "status",  1L, new BigDecimal(2), null
        ) ;

        PrimaryTransactions.add(PrimaryTransaction);
        PrimaryTransactions.add(PrimaryTransaction2);


        return PrimaryTransactions;
    }

    public PrimaryAccount getPrimaryAccount(){
        PrimaryAccount primaryAccount = new PrimaryAccount();
        //primaryAccount.setId(1L);
        primaryAccount.setAccountNumber(2);
        primaryAccount.setAccountBalance(new BigDecimal(999));
        return primaryAccount;
    }

   /* public PrimaryAccount createPrimaryAccount(){
        PrimaryAccount primaryAccount = new PrimaryAccount();
        //primaryAccount.setId(1L);
        primaryAccount.setAccountNumber(2);
        primaryAccount.setAccountBalance(new BigDecimal(999));

        primaryAccountDao.save(primaryAccount);

        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
    }*/
}
