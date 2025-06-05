package ohgiraffers.restapi.section03.valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findByUserNo(@PathVariable("userNo") int userNo) {
        boolean check = true;

        if (check) throw new UserNotFoundException("❌회원 정보를 찾을 수 없습니다.");

        return ResponseEntity.ok().build();
    }

    /*
    * @Validated @RequestBody UserDTO userDTO
    * => userDTO에 있는 유효성 검사를 체크할지 말지 설정
    * @Validated 어노테이션이 있다면 유효성 검사 체크 없으면 체크하지 않음
    * */
    @PostMapping("/users")
    public ResponseEntity<?> registUser(@Validated @RequestBody UserDTO userDTO) {
        return ResponseEntity.created(URI.create("/valid/users/1")).build();
    }

}
