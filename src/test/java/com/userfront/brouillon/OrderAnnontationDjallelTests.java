package com.userfront.brouillon;

import com.userfront.brouillon.ordered.Average;
import com.userfront.brouillon.ordered.Excellent;
import com.userfront.brouillon.ordered.Good;
import com.userfront.brouillon.ordered.Rating;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class OrderAnnontationDjallelTests {

    @Mock
    private List<Rating> ratings;

    @Mock
    private Rating rating;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Good good;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Excellent excellent;

    @Mock(answer = Answers.CALLS_REAL_METHODS)
    private Average average;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        ratings = new ArrayList<Rating>();
        ratings.add(good);
        ratings.add(excellent);
        ratings.add(average);
    }

    @Test
    public void givenOrder__whenInjected__thenByOrderValue() {
/*
        Mockito.when(good.getRating()).thenCallRealMethod();
        Mockito.when(excellent.getRating()).thenCallRealMethod();
        Mockito.when(average.getRating()).thenCallRealMethod();*/

        assertThat(ratings.get(0).getRating(), is(equalTo(2)));
        assertThat(ratings.get(1).getRating(), is(equalTo(1)));
        assertThat(ratings.get(2).getRating(), is(equalTo(3)));
    }
}
