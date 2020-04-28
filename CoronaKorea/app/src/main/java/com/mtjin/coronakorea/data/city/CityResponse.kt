package com.mtjin.coronakorea.data.city


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "city")
data class CityResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("busan")
    val busan: Busan,
    @SerializedName("chungbuk")
    val chungbuk: Chungbuk,
    @SerializedName("chungnam")
    val chungnam: Chungnam,
    @SerializedName("daegu")
    val daegu: Daegu,
    @SerializedName("daejeon")
    val daejeon: Daejeon,
    @SerializedName("gangwon")
    val gangwon: Gangwon,
    @SerializedName("gwangju")
    val gwangju: Gwangju,
    @SerializedName("gyeongbuk")
    val gyeongbuk: Gyeongbuk,
    @SerializedName("gyeonggi")
    val gyeonggi: Gyeonggi,
    @SerializedName("gyeongnam")
    val gyeongnam: Gyeongnam,
    @SerializedName("incheon")
    val incheon: Incheon,
    @SerializedName("jeju")
    val jeju: Jeju,
    @SerializedName("jeonbuk")
    val jeonbuk: Jeonbuk,
    @SerializedName("jeonnam")
    val jeonnam: Jeonnam,
    @SerializedName("korea")
    val korea: Korea,
    @SerializedName("quarantine")
    val quarantine: Quarantine,
    @SerializedName("resultCode")
    val resultCode: String,
    @SerializedName("resultMessage")
    val resultMessage: String,
    @SerializedName("sejong")
    val sejong: Sejong,
    @SerializedName("seoul")
    val seoul: Seoul,
    @SerializedName("ulsan")
    val ulsan: Ulsan
)