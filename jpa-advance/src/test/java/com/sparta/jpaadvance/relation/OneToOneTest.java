package com.sparta.jpaadvance.relation;

import com.sparta.jpaadvance.entity.Food;
import com.sparta.jpaadvance.entity.User;
import com.sparta.jpaadvance.repository.FoodRepository;
import com.sparta.jpaadvance.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@Transactional
@SpringBootTest
public class OneToOneTest {
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    UserRepository userRepository;


    @Test
    @Rollback(false)
    @DisplayName("1:1 단방향 테스트")
    void test1(){
        User user = new User();
        user.setName("Robbie");

        Food food = new Food();
        food.setName("후라이드치킨");
        food.setPrice(15000);
        food.setUser(user);

        userRepository.save(user);
        foodRepository.save(food);
    }

}
