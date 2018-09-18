package todo.nothing.submissio2.Tampilan.FirstFragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.*
import todo.nothing.submissio2.Adapter.Api.ApiRepository
import todo.nothing.submissio2.Adapter.FirstAdapter
import todo.nothing.submissio2.R
import todo.nothing.submissio2.Util.SpaceItemDecoration
import todo.nothing.submissio2.Util.gone
import todo.nothing.submissio2.Util.visible
import todo.nothing.submissio2.Adapter.Data.Jadwal


/**
 * A simple [Fragment] subclass.
 */
class FirstFragment : Fragment(), PrevView{
    private var schedules: MutableList<Jadwal> = mutableListOf()
    private lateinit var listSchedules: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var adapter: FirstAdapter
    private lateinit var presenter: FirstPresent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return UI {
            frameLayout {
                lparams(width = matchParent, height = matchParent)
                swipeRefresh = swipeRefreshLayout {
                    id = R.id.swipeRefresh
                    setColorSchemeResources(R.color.colorAccent,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    relativeLayout {
                        lparams(width = matchParent, height = matchParent)

                        listSchedules = recyclerView {
                            id = R.id.rvPrevEvent
                            layoutManager = LinearLayoutManager(ctx)
                            addItemDecoration(SpaceItemDecoration(8))
                        }.lparams(width = matchParent, height = matchParent) {
                            centerInParent()

                        }
                        progressBar = progressBar {
                            id = R.id.pbPrevEvent
                        }.lparams {
                            centerHorizontally()
                        }
                    }
                }
            }
        }.view

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()

        swipeRefresh.onRefresh {
            presenter.getEventList(getString(R.string.resource_eventspastleague))
        }
    }
    private fun initAdapter() {
        adapter = FirstAdapter(schedules)
        listSchedules.adapter = adapter

        val request = ApiRepository()
        val gson = Gson()
        presenter = FirstPresent(this, request, gson)
        presenter.getEventList(getString(R.string.resource_eventspastleague))
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.gone()
    }
    override fun showEventList(data: List<Jadwal>) {
        swipeRefresh.isRefreshing = false
        schedules.clear()
        schedules.addAll(data)
        Log.d("HeightIcon", "Height" + data)
        adapter.notifyDataSetChanged()
    }

}
