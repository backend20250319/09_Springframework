package com.ohgiraffers.restapi.section05.swagger

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
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
    private val users: MutableList<UserDTO> = ArrayList()

    init {
        users.add(UserDTO(1, "user01", "pass01", "유관순"))
        users.add(UserDTO(2, "user02", "pass02", "홍길동"))
        users.add(UserDTO(3, "user03", "pass03", "이순신"))
    }

    @Operation(summary = "전체 회원 조회", description = "전체 회원 목록을 조회한다.")
    @GetMapping("/users")
    fun findAllUsers(): ResponseEntity<ResponseMessage> {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType("application", "json", StandardCharsets.UTF_8)

        /* 응답 바디 설정 */
        val responseMap: MutableMap<String, Any> = HashMap()
        responseMap.put("users", users)

        /* 응답 메세지 설정 */
        val responseMessage = ResponseMessage(
            200, "조회 성공", responseMap
        )

        return ResponseEntity(responseMessage, httpHeaders, HttpStatus.OK)
    }

    @Operation(summary = "회원 번호로 회원 조회")
    @GetMapping("/users/{userNo}")
    fun findUserByNo(@PathVariable userNo: Int): ResponseEntity<ResponseMessage> {
        /* 응답 헤더 설정 : JSON 응답이 default 이기는 하나 변경이 필요한 경우 HttpHeaders 설정 변경 */
        val httpHeaders = HttpHeaders()
        httpHeaders.contentType = MediaType("application", "json", StandardCharsets.UTF_8)

        /* 응답 바디 설정 */
        val responseMap: MutableMap<String, Any> = HashMap()
        val foundUser = users.stream().filter { user: UserDTO -> user.getNo() === userNo }.findFirst().get()
        responseMap.put("user", foundUser)

        /* 응답 메세지 설정 */
        val responseMessage = ResponseMessage(
            200, "조회 성공", responseMap
        )

        return ResponseEntity(responseMessage, httpHeaders, HttpStatus.OK)
    }

    @Operation(summary = "회원 등록")
    @PostMapping("/users")
    fun registUser(@RequestBody userDTO: UserDTO): ResponseEntity<ResponseMessage> {
        val lastUserNo: Int = users[users.size - 1].getNo()
        userDTO.setNo(lastUserNo + 1)
        users.add(userDTO)

        return ResponseEntity
            .created(URI.create("/entity/users/" + users[users.size - 1].getNo()))
            .build<ResponseMessage>()
    }

    @Operation(summary = "회원 번호로 회원 수정")
    @PutMapping("/users/{userNo}")
    fun modifyUser(
        @PathVariable userNo: Int, @RequestBody userDTO: UserDTO
    ): ResponseEntity<Void> {
        val foundUser = users.stream().filter { user: UserDTO -> user.getNo() === userNo }.findFirst().get()
        foundUser.setPwd(userDTO.getPwd())
        foundUser.setName(userDTO.getName())

        return ResponseEntity.created(URI.create("/entity/users/$userNo")).build()
    }

    @Operation(summary = "회원 번호로 회원 삭제")
    @ApiResponses(
        ApiResponse(responseCode = "204", description = "회원 정보 삭제 완료"),
        ApiResponse(responseCode = "400", description = "잘못 입력 된 파라미터")
    )
    @DeleteMapping("/users/{userNo}")
    fun deleteUser(@PathVariable userNo: Int): ResponseEntity<Void> {
        val foundUser = users.stream().filter { user: UserDTO -> user.getNo() === userNo }.findFirst().get()
        users.remove(foundUser)
        return ResponseEntity.noContent().build()
    }
}