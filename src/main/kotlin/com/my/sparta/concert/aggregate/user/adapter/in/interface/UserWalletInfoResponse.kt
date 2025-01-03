package com.my.sparta.concert.aggregate.user.adapter.`in`.`interface`

import lombok.Data

@Data
class UserWalletInfoResponse(
    val userId: String,
    val chargeMoney: Double
) {}
