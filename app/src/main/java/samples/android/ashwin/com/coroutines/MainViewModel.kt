package samples.android.ashwin.com.coroutines

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.HttpException

/**
 * Created by Ashwin on 1/26/2019.
 */
class MainViewModel : ViewModel() {
    private val _text = MutableLiveData<String>()

    val text: LiveData<String>
        get() = _text

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun load() {
        val retrofit = RetrofitFactory.createNetworkClient(Constants.URL, BuildConfig.DEBUG)
        val service = retrofit.create(RetrofitService::class.java)
        uiScope.launch {
            val request = service.getProfile()
            try {
                val response = request.await()
                _text.value = response.body().toString()
            } catch (e: HttpException) {
                Log.e(Constants.TAG, "exception!", e)
            } catch (e: Throwable) {
                Log.e(Constants.TAG, "exception!", e)
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
