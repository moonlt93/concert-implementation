package com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`

import lombok.Builder
import lombok.Data
import java.time.LocalDate
import java.time.LocalTime

@Data
@Builder
class GetReservableSeatsResponse(
    val expectedDate: LocalDate,
    val expectedTime: LocalTime,
    val reservableSeats: Map<String,List<Int>>

) {

}
