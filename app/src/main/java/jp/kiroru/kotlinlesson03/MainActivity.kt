package jp.kiroru.kotlinlesson03

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.os.Bundle

class MainActivity : AppCompatActivity(), NaviFragment.Listener {

    private val fm = supportFragmentManager
    private val fragments = mutableListOf<Fragment>()
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RedFragment.newInstance())
        fragments.add(GreenFragment.newInstance())
        fragments.add(BlueFragment.newInstance())

        val ft = fm.beginTransaction()
        ft.add(R.id.content, fragments[index])
        ft.add(R.id.navi, NaviFragment.newInstance())
        ft.commit()

    }

    private fun incrementIndex() {
        if (index == fragments.size - 1) {
            index = 0
        } else {
            index ++
        }
    }

    // region NaviFragment.Listener
    override fun notifyButtonPress() {
        incrementIndex()
        val ft = fm.beginTransaction()
        ft.replace(R.id.content, fragments[index])
        ft.commit()
    }
    // endregion

}