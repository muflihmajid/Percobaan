package todo.nothing.submissio2.Tampilan.FirstFragment

import todo.nothing.submissio2.Adapter.Data.Jadwal

interface PrevView {
    fun showLoading()
    fun hideLoading()
    fun showEventList(data: List<Jadwal>)
}