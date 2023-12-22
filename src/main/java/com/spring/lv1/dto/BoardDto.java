package com.spring.lv1.dto;

import lombok.*;

import java.time.LocalDateTime;

public class BoardDto {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Post {

        private String name;
        private String title;
        private String password;
        private String content;
}


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Patch {

        private String name;
        private String title;
        private String password;
        private String content;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Delete {

        private String password;
    }


    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {

        private Long boardId;
        private String name;
        private String title;
        private String content;
        private LocalDateTime createdAt;
    }


}
