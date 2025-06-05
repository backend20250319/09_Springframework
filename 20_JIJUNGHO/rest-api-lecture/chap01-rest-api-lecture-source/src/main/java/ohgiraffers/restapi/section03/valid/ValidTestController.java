package ohgiraffers.restapi.section03.valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valid")
public class ValidTestController {

    @GetMapping("/users/{userNo}")
    public ResponseEntity<?> findByUserNo(@PathVariable("userNo") int userNo) {
        boolean check = true;

        if (check) throw new UserNotFoundException("❌회원 정보를 찾을 수 없습니다.");

        return ResponseEntity.ok().build();
    }
}
