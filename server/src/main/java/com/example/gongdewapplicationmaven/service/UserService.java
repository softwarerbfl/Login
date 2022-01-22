package com.example.gongdewapplicationmaven.service;
/*서비스 함수 구현*/
import com.example.gongdewapplicationmaven.dto.UserForm;
import com.example.gongdewapplicationmaven.model.User;
import com.example.gongdewapplicationmaven.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserService{
    @Autowired
    private UserRepository userRepository;
    //전체 USER조회 함수
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User check(Long id){
        User target = userRepository.findById(id).orElse(null);
        if(target==null){
            return null;
        }
        userRepository.save(target);
        log.info(target.toString()); //db에 저장된 객체를 찍어보기
        return target;
    }
    //user생성
    public User create(UserForm dto) {
        User user = dto.toEntity();
        if(user.getId() != null){
            return null;
        }
        return userRepository.save(user);
    }
    //로그인
    public User login(UserForm dto) {
        User user = dto.toEntity(); //사용자가 입력한 정보를 갖는 객체
        User login = userRepository.findByEmailAddress(user.getEmail(), user.getPassword()); //이메일을 건내서 해당 객체 반환
        if(login==null){
            return null;
        }
        return login;
    }
    //이메일 중복체크
    public User duplicate(UserForm dto){
        User user=dto.toEntity();
        User check = userRepository.checkDuplicaionByEmailAddress(user.getEmail());
        if(check==null){
            return null;
        }
        return check;
    }
}