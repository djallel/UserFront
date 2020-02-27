package com.userfront.brouillon.ordered;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RatingImpl {

    @Autowired
    List<Rating> ratings;

    public void getRatings(String [] args) {

        for(Rating rating : ratings) {
            System.out.println(rating.getRating());
        }
    }
}
