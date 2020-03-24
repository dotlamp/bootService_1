package com.dotlamp.boot.springboot.domain.posts;

import com.dotlamp.boot.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity //테이블과 링크될 클래스로 정의
public class Posts extends BaseTimeEntity {

    @Id //PK field
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) //칼럼 생략 가능함
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
