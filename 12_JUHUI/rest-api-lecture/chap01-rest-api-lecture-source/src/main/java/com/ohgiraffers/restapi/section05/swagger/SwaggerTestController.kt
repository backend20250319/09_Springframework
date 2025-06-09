package com.ohgiraffers.restapi.section05.swagger

import com.ohgiraffers.restapi.section02.responseentity.ResponseMessage
import com.ohgiraffers.restapi.section02.responseentity.UserDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI
import java.nio.charset.StandardCharsets
import java.util.*

@Tag(name = "Spring Boot Swagger 연동(user)")
@RestController
@RequestMapping("/swagger")
class SwaggerTestController {

    //private List<UserDTO> users;

    public SwaggerTestController() {
        users = new ArrayList<>();
        users.add(new UserDTO(1, "user01", "pass01", "유관순"));
    }

    @Operation(
        summary = "전체 회원 조회", description = "전체 회원 목록을 조회한다."
    )

    @GetMapping("/users")
    fun findAllUsers(): ResponseEntity<ResponseMessage> {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        val headers = HttpHeaders()
        headers.contentType = MediaType("application", "json", StandardCharsets.UTF_8)

        /* 응답 바디(내가 담고 보낼 객체 정보 값) 설정 */
        val responseMap: MutableMap<String, Any> = HashMap()
        responseMap.put("users", users)

        /* 응답 메세지 설정 */
        val responseMessage = ResponseMessage(
            200, "조회 성공", responseMap
        )

        return ResponseEntity(responseMessage, headers, HttpStatus.OK)
    }

    @GetMapping("users/{userNo}")
    fun findUserByNo(@PathVariable userNo: Int): ResponseEntity<ResponseMessage> {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        val headers = HttpHeaders()
        headers.contentType = MediaType("application", "json", StandardCharsets.UTF_8)

        /* 응답 바디(내가 담고 보낼 객체 정보 값) 설정 */
        val responseMap: MutableMap<String, Any> = HashMap()
        val foundUser: UserDTO = users.stream().filter { user: UserDTO -> user.no == userNo }.findFirst().get()
        responseMap.put("user", foundUser)

        /* 응답 메세지 설정 */
        val responseMessage = ResponseMessage(
            200, "조회 성공", responseMap
        )

        return ResponseEntity(responseMessage, headers, HttpStatus.OK)
    }

    @PostMapping("/users")
    fun registUser(@RequestBody userDTO: UserDTO): ResponseEntity<ResponseMessage> {
        val lastUserNo: Int = users.get(users.size - 1).getNo()
        userDTO.no = lastUserNo + 1
        users.add(userDTO)

        return ResponseEntity.created(URI.create("/entity/users/" + users.get(users.size - 1).getNo()))
            .build<ResponseMessage>()
    }

    @PutMapping("/users/{userNo}")
    fun modifyUser(
        @PathVariable userNo: Int, @RequestBody userDTO: UserDTO
    ): ResponseEntity<Void> {
        val foundUser: UserDTO = users.stream().filter { user: UserDTO -> user.no == userNo }.findFirst().get()
        foundUser.pwd = userDTO.pwd
        foundUser.name = userDTO.name

        return ResponseEntity.created(URI.create("/entity/users/$userNo")).build()
    }

    @DeleteMapping("/users/{userNo}")
    fun deleteUser(@PathVariable userNo: Int): ResponseEntity<Void> {
        val foundUser: UserDTO = users.stream().filter { user: UserDTO -> user.no == userNo }.findFirst().get()
        users.remove(foundUser)
        return ResponseEntity.noContent().build()
    }
}