package ohgiraffers.restapi.section01.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/* @RestController : 모든 핸들러 메소드에 @Responese가 적용된것과 같다. */
@RestController
@RequestMapping("/response")
public class ResponseController {
    /* 1. 문자열 응답 */
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World🫂🫂";
    }


}
