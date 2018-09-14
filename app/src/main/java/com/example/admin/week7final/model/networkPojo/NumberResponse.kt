package com.example.admin.week7final.model.networkPojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NumberResponse {

    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("length")
    @Expose
    var length: Int? = null
    @SerializedName("data")
    @Expose
    var data: List<Int>? = null
    @SerializedName("success")
    @Expose
    var success: Boolean? = null

    /**
     * No args constructor for use in serialization
     *
     */
    constructor() {}

    /**
     *
     * @param data
     * @param length
     * @param type
     * @param success
     */
    constructor(type: String, length: Int?, data: List<Int>, success: Boolean?) : super() {
        this.type = type
        this.length = length
        this.data = data
        this.success = success
    }

}
