package todo.nothing.submissio2.Tampilan.FirstFragment


import android.util.Log
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import todo.nothing.submissio2.Adapter.Api.ApiRepository
import todo.nothing.submissio2.Adapter.Api.TheSportDBApi
import org.jetbrains.anko.coroutines.experimental.bg
import org.jetbrains.anko.doAsync
import todo.nothing.submissio2.Adapter.Data.JadwalRespon
import todo.nothing.submissio2.Util.CoroutineContextProvider

class FirstPresent(private val view: PrevView,
                    private val apiRequest: ApiRepository,
                    private val gson: Gson,
                   private val context: CoroutineContextProvider = CoroutineContextProvider()) {
    fun getEventList(match: String?) {
        view.showLoading()
        async(context.main) {
            val data = bg {
                gson.fromJson(apiRequest.doRequest(TheSportDBApi.getSchedule(match)),
                        JadwalRespon::class.java
                )
            }
            Log.d("HeightIcon", "Height" + data)
            view.showEventList(data.await().match)
            view.hideLoading()
        }
    }
}