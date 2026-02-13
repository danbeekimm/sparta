package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;


    //    @ManyToOne
    //    @JoinColumn(name = "user_id")
    //    private User user;

    //    @OneToMany
    //    @JoinColumn(name = "food_id") // users 테이블에 food_id 컬럼
    //    private List<User> userList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "orders",
            joinColumns = @JoinColumn(name = "food_id"), //order테이블로 조인할 컬럼 설정
            inverseJoinColumns = @JoinColumn(name = "user_id") // 반대 위치인 user Entity에서 중간으로 조인할 컬럼
    ) // 중간테이블생성

    private List<User> userList = new ArrayList<>();
}
