package com.example.gongdewapplicationmaven.model;

/*엔티티*/
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String email; //이메일
    @Column
    private String password;//비밀번호
    @Column
    private String name;//사용자 이름
    @Column
    private String birth; //생일
    @Column
    private String major;//학과
    @Column
    private String hobby; //취미

    public Long getId() {
        return id;
    }
}
