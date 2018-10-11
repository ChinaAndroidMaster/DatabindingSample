package www.xuzhiguang.com.mydatabinding.ui

import android.databinding.ObservableInt
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.Path
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.R.id.top
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import www.xuzhiguang.com.mydatabinding.R
import www.xuzhiguang.com.mydatabinding.data.ObservableFieldProfile

class MainActivity : AppCompatActivity() {
    var myAdapterImpl: MyAdapterImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_content.layoutManager = LinearLayoutManager(baseContext)
        myAdapterImpl = MyAdapterImpl {
            it.likes.set(it.likes.get() + 1)   //支持数 属性所对应的字段是可观察的。当值改变时，Ui随之更新
        }
        rv_content.adapter = myAdapterImpl
        rv_content.addItemDecoration(object : RecyclerView.ItemDecoration() {
            var mDivider = resources.getDrawable(R.drawable.item_divi_line)
            override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
                val left = parent.paddingLeft
                val right = parent.width - parent.paddingRight
                var childCount = parent.childCount
                for (i in 0 until childCount) {
                    var child = parent.getChildAt(i)
                    var top = child.bottom
                    var bottom = top + mDivider.intrinsicHeight
                    mDivider.setBounds(left, top, right, bottom)
                    mDivider.draw(c)
                }

            }
        })
    }

    private val datMap = mapOf("梅西" to R.drawable.p_meisi, "C罗" to R.drawable.p_cl, "魔笛" to R.drawable.p_modi, "姆巴佩" to R.drawable.p_mbp)
    override fun onResume() {
        super.onResume()
        var dataSource = ArrayList<ObservableFieldProfile>()
        for ((k, v) in datMap) {
            val profile = ObservableFieldProfile(k, v)
            dataSource.add(profile)
        }
        myAdapterImpl?.profileData = dataSource
    }


}

