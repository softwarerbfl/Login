package com.example.gongdewapplicationmaven.dto;
/*DTO객체*/
import com.example.gongdewapplicationmaven.model.User;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class UserForm {
    private Long id; //고유번호
    private String email; //이메일
    private String password;//비밀번호
    private String name;
    private String birth; //생일
    private String major;//학과
    private String hobby; //취미

    public User toEntity(){
        return new User(null, email,password,name, birth, major, hobby);
    }
}
