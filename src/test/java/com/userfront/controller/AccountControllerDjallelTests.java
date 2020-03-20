package com.userfront.controller;

import com.userfront.Data.DataTest;
import com.userfront.UserFrontApplication;
import com.userfront.domain.PrimaryAccount;
import com.userfront.domain.PrimaryTransaction;
import com.userfront.domain.User;
import com.userfront.service.AccountService;
import com.userfront.service.TransactionService;
import com.userfront.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(classes = {UserFrontApplication.class})
@AutoConfigureMockMvc
@WebMvcTest
@WebAppConfiguration
public class AccountControllerDjallelTests extends DataTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @InjectMocks
    private AccountController accountController;

    @Mock
    private UserService userService;

    @Mock
    private AccountService accountService;

    @Mock
    private TransactionService transactionService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc  = MockMvcBuilders.standaloneSetup(accountController).build();

    }

    @Ignore
    public void primaryAccount_ShouldAddprimaryAccountEntriesAndprimaryTransactionListToModelAndRenderprimaryAccountView() throws Exception {

        PrimaryTransaction PrimaryTransaction1 = getPrimaryTransaction();
        User user = getUser();
        PrimaryAccount primaryAccount = user.getPrimaryAccount();

        Mockito.when(transactionService.findPrimaryTransactionList(Matchers.anyString())).thenReturn(getPrimaryTransactions());
        Mockito.when(userService.findByUsername(Matchers.anyString())).thenReturn(getUser());
      //  Mockito.when(accountController.primaryAccount(any(Model.class),any(Principal.class))).thenCallRealMethod();


        this.mockMvc.perform(get("/primaryAccount")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("/primaryAccount")));


        mockMvc.perform(get("/account/primaryAccount"))
                .andExpect(status().isOk())
                .andExpect(view().name("account/primaryAccount"))
                .andExpect(forwardedUrl("src/main/resources/templates/primaryAccount.html"))
                .andExpect(model().attribute("primaryAccount", hasSize(2)))
                .andExpect(model().attribute("primaryTransactionList", hasItem(
                        allOf(
                                hasProperty("id", is(1L)),
                                hasProperty("description", is("Lorem ipsum")),
                                hasProperty("title", is("Foo"))
                        )
                )))
                .andExpect(model().attribute("primaryTransactionList", hasItem(
                        allOf(
                                hasProperty("id", is(2L)),
                                hasProperty("description", is("Lorem ipsum")),
                                hasProperty("title", is("Bar"))
                        )
                )));

        verify(transactionService, times(1)).findPrimaryTransactionList(anyString());
        verifyNoMoreInteractions(transactionService);

    }


}
