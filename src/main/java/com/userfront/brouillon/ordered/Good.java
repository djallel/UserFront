package com.userfront.brouillon.ordered;

import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Order(2)
public class Good implements Rating {
        @Override
        public int getRating() {
            return 2;
        }
}
