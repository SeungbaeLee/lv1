package com.spring.lv1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    private String name;
    private String title;

    private String password;

    private String content;

    @Builder
    public Board(String title, String name, String password, String content) {
        this.title = title;
        this.name = name;
        this.password = password;
        this.content = content;
    }

    public void update(String title, String name, String content) {
        this.title = title;
        this.name = name;
        this.content = content;
    }

}
