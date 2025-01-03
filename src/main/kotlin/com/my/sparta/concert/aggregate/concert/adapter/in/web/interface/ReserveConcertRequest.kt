package com.my.sparta.concert.aggregate.concert.adapter.`in`.web.`interface`

import io.swagger.v3.oas.annotations.media.Schema
import lombok.Data

@Data
@Schema(name = "ReserveConcertRequest")
class ReserveConcertRequest(
    @Schema(name = "userId", description = "유저Id",example = "userId1")
    val userId: String,
    @Schema(name = "concertId", description = "콘서트Id",example = "concertId1")
    val concertId: String,
) {

}
