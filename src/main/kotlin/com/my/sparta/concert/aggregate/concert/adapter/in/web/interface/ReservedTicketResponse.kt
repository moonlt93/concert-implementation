package com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`

import io.swagger.v3.oas.annotations.media.Schema
import lombok.Builder
import lombok.Data
import java.time.LocalDateTime

@Data
@Builder
@Schema(name = "ReservedTicketResponse")
class ReservedTicketResponse(

    @Schema(name = "ticketId", description = "ticketId", example = "001-kr-0001")
    val ticketId: String,
    @Schema(name = "userId", description = "userId", example = "user1")
    val userId: String,
    @Schema(name = "expectedTime", description = "expectedTime", example = "2025-01-03T00:54:03.941946")
    val expectedTime: LocalDateTime,
    @Schema(name = "concertName", description = "concertName", example = "무장")
    val concertName: String,
    @Schema(name = "reservedSeat", description = "reservedSeat", example = "H : 3")
    val reservedSeat: Map<String, Int>

) {

}
