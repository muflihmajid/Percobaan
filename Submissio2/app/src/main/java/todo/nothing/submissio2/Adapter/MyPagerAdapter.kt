package todo.nothing.submissio2.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import todo.nothing.submissio2.Tampilan.FirstFragment.FirstFragment
import todo.nothing.submissio2.Tampilan.SeconFragment.SecondFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            }
            else -> {
                return SecondFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            else -> {
                return "Second"
            }
        }
    }
}