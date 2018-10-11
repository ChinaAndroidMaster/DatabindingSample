# DatabindingSample
RecycleView 和DataBinding的可观察性质结合，刷新item中的某个值

在列表中常遇到item中有点赞或者收藏的操作，同时点赞和收藏数量同步更新。该sample利用DataBing的Observable fields（https://developer.android.google.cn/topic/libraries/data-binding/observability）
和 BindingAdapter 来实现‘数据变动的监听’
