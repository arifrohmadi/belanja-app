package uns.belanja.data.remote.responses

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("data")
    val data: Data,
    @SerializedName("code")
    val code: Int,
    @SerializedName("msg")
    val msg: String
) {
    data class Data(
        @SerializedName("id")
        val id: Int,
        @SerializedName("image")
        val image: String,
        @SerializedName("name")
        val name: String,
        @SerializedName("price")
        val price: Int
    )
}