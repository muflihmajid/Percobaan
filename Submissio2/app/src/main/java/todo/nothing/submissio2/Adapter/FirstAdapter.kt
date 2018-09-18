package todo.nothing.submissio2.Adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import todo.nothing.submissio2.Adapter.Data.Team
import todo.nothing.submissio2.R
import todo.nothing.submissio2.Tampilan.FirstFragment.JadwalUI
import java.text.SimpleDateFormat
import java.util.*
import android.util.Log
import todo.nothing.submissio2.Adapter.Data.Jadwal

class FirstAdapter (private val matches: List<Jadwal>) :
        RecyclerView.Adapter<FirstViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstViewHolder {
        return FirstViewHolder(JadwalUI().createView(AnkoContext.create(parent.context,
                parent)))
    }

    override fun getItemCount(): Int = matches.size

    override fun onBindViewHolder(holder: FirstViewHolder, position: Int) {
        holder.bindItem(matches[position])
    }

}

class FirstViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val timeSchedule: TextView = view.find(R.id.txt_schedule)
    private val homeTeam: TextView = view.find(R.id.txt_hometeam)
    private val homeScore: TextView = view.find(R.id.txt_homescore)
    private val awayScore: TextView = view.find(R.id.txtawayscore)
    private val awayTeam: TextView = view.find(R.id.txt_awayteam)


    fun bindItem(matches: Jadwal) {

        val timeEvent = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                .parse(matches.dateEvent)
        val dateEvent = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
                .format(timeEvent)

        timeSchedule.text = dateEvent.toString()
        homeTeam.text = matches.strHomeTeam
        homeScore.text = matches.intHomeScore
        awayScore.text = matches.intAwayScore
        awayTeam.text = matches.strAwayTeam

        Log.d("Rangkuman1", "key data: ${matches.strHomeTeam}")
        val ctx = itemView.context

//        itemView.setOnClickListener {
//            ctx.startActivity<DetailActivity>(
//                    ctx.getString(R.string.item_eventdetail_id) to matches.idEvent,
//                    ctx.getString(R.string.item_home_id) to matches.idHomeTeam,
//                    ctx.getString(R.string.item_away_id) to matches.idAwayTeam)
//        }
    }
}