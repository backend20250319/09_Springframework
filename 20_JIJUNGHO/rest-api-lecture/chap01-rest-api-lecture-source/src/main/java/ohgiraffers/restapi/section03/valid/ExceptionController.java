package ohgiraffers.restapi.section03.valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/* 전역적으로 Exception 발생을 캐치해서 Handling할 클래스 */
@RestControllerAdvice
public class ExceptionController {

    // 회원 정보가 없을때 발생하는 예외처리
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserException(UserNotFoundException e) {

        String code = "ERROR_CODE_0000";
        String description = "회원 정보 조회 실패";
        String detail = e.getMessage();

        return new ResponseEntity<>(
                new ErrorResponse(code, description, detail), HttpStatus.NOT_FOUND
        );
    }

    // UserDTO의 @Valid 검증 실패(MethodArgumentNotValidException 발생) 시 예외 응답 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValidException(MethodArgumentNotValidException e) {
        String code = "";
        String description = "";
        String detail = "";

        detail = e.getBindingResult().getFieldError().getDefaultMessage();
        String bindingResultCode = e.getBindingResult().getFieldError().getCode();
        switch(bindingResultCode) {
            case "NotNull" :
                code = "ERROR_CODE_00001";
                description = "필수 값이 누락 되었습니다.";
                break;
            case "NotBlank" :
                code = "ERROR_CODE_00002";
                description = "필수 값이 공백으로 처리 되었습니다.";
                break;
            case "Size" :
                code = "ERROR_CODE_00003";
                description = "알맞은 크기의 값이 입력 되지 않았습니다.";
                break;
        }

        return new ResponseEntity<>(
                new ErrorResponse(code, description, detail), HttpStatus.BAD_REQUEST
        );
    }
}
