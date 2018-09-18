package todo.nothing.submissio2.Adapter.Data

import com.google.gson.annotations.SerializedName

data class JadwalRespon (
        @SerializedName("jadwal")
        val match: List<Jadwal>
)
