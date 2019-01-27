package samples.android.ashwin.com.coroutines

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Ashwin on 1/26/2019.
 */
interface RetrofitService {
    @GET("profile.json")
    fun getProfile(): Deferred<Response<Profile>>
}
