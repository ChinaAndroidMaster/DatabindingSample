package www.xuzhiguang.com.mydatabinding.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_like_trend.view.*
import www.xuzhiguang.com.mydatabinding.R
import www.xuzhiguang.com.mydatabinding.data.ObservableFieldProfile
import www.xuzhiguang.com.mydatabinding.databinding.ItemLikeTrendBinding

class MyAdapterImpl(var itemClick: (ObservableFieldProfile) -> Unit) : RecyclerView.Adapter<MyAdapterImpl.MyViewHolder>() {
    var adapterData = ArrayList<ObservableFieldProfile>()
    var profileData: ArrayList<ObservableFieldProfile>
        set(value) {
            adapterData = value
            notifyDataSetChanged()
        }
        get() {
            return this.adapterData
        }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        var itemView = DataBindingUtil.inflate<ItemLikeTrendBinding>(LayoutInflater.from(p0.context), R.layout.item_like_trend, p0, false)
        return MyViewHolder(itemView, itemClick)
    }

    override fun getItemCount(): Int {
        return adapterData?.size!!
    }

    override fun onBindViewHolder(viewHolder: MyViewHolder, p1: Int) {
        viewHolder.bindViewByData(adapterData[p1])
    }

    class MyViewHolder(val view: ItemLikeTrendBinding, private val itemClick: (ObservableFieldProfile) -> Unit) : RecyclerView.ViewHolder(view.root) {

        fun bindViewByData(itemData: ObservableFieldProfile) {
            view.profile = itemData   //布局文件定义的variable 赋值
            /**
             *支持 按钮点击时触发并调用传过来的函数，把所对应的数据作为参数
             *[MainActivity]  myAdapterImpl = MyAdapterImpl {......}
             */

            itemView.bt_like.setOnClickListener { itemClick(itemData) }
        }
    }
}

