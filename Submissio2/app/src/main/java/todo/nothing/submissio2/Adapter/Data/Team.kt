package todo.nothing.submissio2.Adapter.Data

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Created by root on 1/23/18.
 */
data class Team(
        @SerializedName("idTeam") var teamId: String? = null,
        @SerializedName("strTeam") var teamName: String? = null,
        @SerializedName("strTeamBadge") var teamBadge: String? = null
)