package com.my.sparta.concert.aggregate.concert.adapter.`in`.web.controller

import com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`.GetReservableSeatsResponse
import com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`.ReserveConcertRequest
import com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`.ReservedTicketResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import lombok.RequiredArgsConstructor
import org.apache.tomcat.websocket.AuthenticationException
import org.springframework.web.bind.annotation.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime


@RestController
@RequiredArgsConstructor
@RequestMapping("/concert")
class ConcertCommandController(

) {

    @Operation(summary = "콘서트를 예매한다.", description = "콘서트 예매정보를 반환한다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "500", description = "원하는 userId가 아닙니다."),
        ]
    )
    /* 콘서트를 예매한다. */
    @PostMapping
    fun reserveConcert(
        @RequestBody reserveConcertRequest: ReserveConcertRequest,
        @RequestHeader("Authorization") authorization: String,
    ): ReservedTicketResponse {

        val map = mutableMapOf<String, Int>()
        map.put("H", 3);
        map.put("K", 4);

        if (reserveConcertRequest.userId == "user1" && authorization.equals("admin")) {
            val reservedTicketResponse = ReservedTicketResponse(
                "001-kr-0001",
                "user1",
                LocalDateTime.now(),
                "무장",
                map
            )

            return reservedTicketResponse

        } else if (!authorization.equals("admin")) {
            throw AuthenticationException("인증된 사용자가 아닙니다.");
        } else {
            throw IllegalArgumentException("원하는 userId가 아닙니다.")
        }

    }


    @Operation(summary = "예매가능한 콘서트 좌석을 조회한다.", description = "콘서트 예매정보를 반환한다.")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "500", description = "해당하는 concert 정보를 찾을수 없습니다."),
        ]
    )
    @GetMapping("{concertId}/reserve")
    fun getReservableSeats(
        @Parameter(
            name = "concertId",
            description = "조회할 콘서트 ID",
            required = true,
            example = "concertId1"
        )
        @PathVariable("concertId") concertId: String,
        @RequestHeader("Authorization") authorization: String,
    ): GetReservableSeatsResponse {

        val map = mutableMapOf<String, List<Int>>()
        map.put("C", listOf(1, 2, 3, 4, 5, 6, 7, 8, 9));
        map.put("D", listOf(10, 11, 12, 13, 14, 15));

        if (concertId == "concertId1") {
            val getResponse = GetReservableSeatsResponse(
                LocalDate.now(),
                LocalTime.now(),
                map
            )

            return getResponse

        } else if (authorization != "admin") {
            throw AuthenticationException("인증된 사용자가 아닙니다.")
        } else {
            throw IllegalArgumentException(" 해당하는 concert 정보를 찾을수 없습니다.");
        }

    }


}