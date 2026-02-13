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

import java.util.List;

@Transactional
@SpringBootTest
public class OneToManyTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;

    @Test
    @Rollback(value = false)
    @DisplayName("1대n 방향테스트")
    void test1() {
        User user = new User();
        user.setName("Robbie");

        User user2 = new User();
        user2.setName("Robbert");

        Food food = new Food();
        food.setName("츼킨");
        food.setPrice(10000);
//        food.getUserList().add(user);
//        food.getUserList().add(user2);

        userRepository.save(user);
        userRepository.save(user2);
        foodRepository.save(food);
    }

    @Test
    @DisplayName("1대N 조회 테스트")
    void test2() {
        Food food = foodRepository.findById(2L).orElseThrow(NullPointerException::new);
        System.out.println("food.getName() = " + food.getName());

//        // 해당 음식을 주문한 고객 정보 조회
//        List<User> userList = food.getUserList();
//        for (User user : userList) {
//            System.out.println("user.getName() = " + user.getName());
//        }
    }






}
