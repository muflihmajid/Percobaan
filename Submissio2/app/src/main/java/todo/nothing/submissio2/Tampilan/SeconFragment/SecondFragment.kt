package todo.nothing.submissio2.Tampilan.SeconFragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import todo.nothing.submissio2.R


class SecondFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_second, container, false)
    }
    companion object {
        fun nextscheduleInstance(): SecondFragment = SecondFragment()
    }
}