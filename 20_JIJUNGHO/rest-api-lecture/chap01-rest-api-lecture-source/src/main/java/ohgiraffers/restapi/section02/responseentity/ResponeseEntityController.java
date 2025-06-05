package ohgiraffers.restapi.section02.responseentity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entity")
public class ResponeseEntityController {

    private List<UserDTO> users;

    public ResponeseEntityController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
        users.add(new UserDTO(2, "user02", "pass02", "홍길동"));
        users.add(new UserDTO(3, "user03", "pass03", "이순신"));

    }

    @GetMapping("/user")
    public ResponseEntity<ResponeseMessage> findAllUser() {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답에 대한 body 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("users", users);

        /* 응답 메세지 설정 */
        ResponeseMessage responeseMessage = new ResponeseMessage(
                2, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responeseMessage, httpHeaders, HttpStatus.OK);
    }

    @GetMapping("/users/{userNo}")
    public ResponseEntity<ResponeseMessage> findUserByNo(@PathVariable int userNo) {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(
                new MediaType("application", "json", StandardCharsets.UTF_8)
        );

        /* 응답에 대한 body 설정 */
        Map<String, Object> responseMap = new HashMap<>();
        UserDTO foundUser = users.stream().filter(user -> user.getNo() == userNo).findFirst().get();
        responseMap.put("foundUser", foundUser);

        /* 응답 메세지 설정 */
        ResponeseMessage responeseMessage = new ResponeseMessage(
                200, "조회 성공", responseMap
        );

        return new ResponseEntity<>(responeseMessage, httpHeaders, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<ResponeseMessage> registUser(@RequestBody UserDTO userDTO) {

        int lastUserNo = users.get(users.size() - 1).getNo();
        userDTO.setNo(lastUserNo + 1);
        users.add(userDTO);

        return ResponseEntity.created(URI.create("/entity/users" + users.get(users.size() - 1).getNo())).build();
    }

}
