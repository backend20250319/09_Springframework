package ohgiraffers.restapi.section01.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* @RestController : 모든 핸들러 메소드에 @Responese가 적용된것과 같다. */
@RestController
@RequestMapping("/response")
public class ResponseController {
    /* 1. 문자열 응답 */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World🫂🫂";
    }

    /* 2. Object 응답 */
    @GetMapping("/message")
    public Message getMessage() {
        return new Message(200, "메세지를 응답합니다.");
    }

    /* 3. List 응답 */
    @GetMapping("/list")
    public List<String> getList() {
        return List.of(new String[]{"사과","바나나","복숭아","수박"});
    }

}
