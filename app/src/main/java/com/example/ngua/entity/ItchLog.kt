package com.example.ngua.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "itchLog")
data class ItchLog(
     var upperArm: Int =0,
     var lowerArm: Int =0,
     var shoulder: Int =0,
     var back: Int =0,
     var chest: Int =0,
     var bell : Int=0,
     var femoral: Int =0,
     var leg :Int =0,
    @PrimaryKey  var date : String
)
