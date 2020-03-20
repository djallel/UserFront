package com.userfront.service;

import com.userfront.Data.DataTest;
import com.userfront.UserFrontApplication;
import com.userfront.dao.PrimaryAccountDao;
import com.userfront.dao.SavingsAccountDao;
import com.userfront.domain.PrimaryAccount;
import com.userfront.service.UserServiceImpl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.any;


@SpringBootTest(classes = {UserFrontApplication.class})
@WebAppConfiguration
@DataJpaTest
public class AccountServiceDjallelTests extends DataTest {

    @Mock
     PrimaryAccountDao primaryAccountDao;

    @Mock
     SavingsAccountDao savingsAccountDao;

    @Mock
     UserService userService;

    @Mock
     TransactionService transactionService;

    @InjectMocks
    AccountServiceImpl accountService  ;

    PrimaryAccount primaryAccount;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void createPrimaryAccount_shouldReturnPrimaryAccount() throws Exception {

        primaryAccount = getPrimaryAccount();

        Mockito.when(primaryAccountDao.save(any(PrimaryAccount.class))).thenReturn(primaryAccount);
        Mockito.when(primaryAccountDao.findByAccountNumber(anyInt())).thenReturn(primaryAccount);
        PrimaryAccount result = accountService.createPrimaryAccount();
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(getPrimaryAccount());
        primaryAccountDao.delete(primaryAccount.getId());

    }


 /*   @Test
    public void createPrimaryAccount_shouldReturnPrimaryAccount2() throws Exception {

        PrimaryAccount primaryAccount1 = getPrimaryAccount();

        Mockito.when(primaryAccountDao.save(any(PrimaryAccount.class))).thenReturn(primaryAccount1);
        Mockito.when(primaryAccountDao.findByAccountNumber(anyInt())).thenReturn(primaryAccount1);
        PrimaryAccount save1 = primaryAccountDao.save(primaryAccount1);
//        PrimaryAccount result = primaryAccountDao.findByAccountNumber(save.getAccountNumber());
        PrimaryAccount result = accountService.createPrimaryAccount();
        assertThat(result).isNotNull();
        assertThat(save1.getAccountNumber()).isEqualToComparingFieldByField(primaryAccount1.getAccountNumber());
        assertThat(result).isEqualToComparingFieldByField(getPrimaryAccount());
        primaryAccountDao.delete(primaryAccount1.getId());

    }*/


}
