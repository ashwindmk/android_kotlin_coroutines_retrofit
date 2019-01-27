package samples.android.ashwin.com.coroutines

import com.google.gson.annotations.SerializedName

/**
 * Created by Ashwin on 1/26/2019.
 */
data class Profile (
    @SerializedName("id")
    val id: String?,

    @SerializedName("firstname")
    val firstname: String?,

    @SerializedName("lastname")
    val lastname: String?,

    @SerializedName("age")
    val age: Int,

    @SerializedName("phone")
    val phone: String?,

    @SerializedName("points")
    val points: Double
)