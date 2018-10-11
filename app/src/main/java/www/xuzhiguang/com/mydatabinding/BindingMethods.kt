package www.xuzhiguang.com.mydatabinding

import android.databinding.BindingAdapter
import android.support.annotation.DrawableRes
import android.widget.ImageView


object BindingMethods {
    /**
     * BindingAdapter将属性(xzg:srcCompat)绑定到ImageView类中的setImageDrawable方法
     * drawableId 便是xzg:srcCompat的属性值
     */
    @BindingAdapter("xzg:srcCompat")
    @JvmStatic
    fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
        view.setImageResource(drawableId)
    }
}