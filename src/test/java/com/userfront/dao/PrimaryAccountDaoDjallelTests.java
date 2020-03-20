package com.userfront.dao;

import com.userfront.Data.DataTest;
import com.userfront.UserFrontApplication;
import com.userfront.domain.PrimaryAccount;
import com.userfront.service.TransactionService;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;


@SpringBootTest(classes = {UserFrontApplication.class})
@WebAppConfiguration
@DataJpaTest
public class PrimaryAccountDaoDjallelTests extends DataTest {

    @Mock
    PrimaryAccountDao primaryAccountDao;

    PrimaryAccount primaryAccount;

    @Mock
    private TransactionService transactionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Ignore
    public void createPrimaryAccount_shouldReturnPrimaryAccount() throws Exception {

        primaryAccount = getPrimaryAccount();

        PrimaryAccount save = primaryAccountDao.save(primaryAccount);
        Mockito.when(primaryAccountDao.save(any(PrimaryAccount.class))).thenReturn(primaryAccount);
        PrimaryAccount save1 = primaryAccountDao.save(primaryAccount);
        PrimaryAccount result = primaryAccountDao.findByAccountNumber(save.getAccountNumber());
        assertThat(result).isNotNull();
        assertThat(result).isEqualToComparingFieldByField(getPrimaryAccount());
        primaryAccountDao.delete(primaryAccount.getId());

    }


}
