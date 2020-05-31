# BaseRecylerViewDemo
这主要是一个对RecylerViewAdapter进行封装的demo


这demo里面主要有：

1，RecycleryViewAdapter的封装：BaseRecylerViewAdapter

2，ViewHolder的封装：BaseViewHolder

3，RecycleryView的分割线的封装：RecyclerViewDivider

4，ListViewAdapter的封装：AbsListAdapter



BaseRecylerViewAdapter，它可以实现添加头尾布局，而且支持多层头尾添加与多条目列表；还实现了子条目与子条目childView的点击监听和长按监听；增删改查都对并发进行了线程安全限制，防止对操作数据的不一致。

BaseViewHolder主要是抽取了findViewById与一些数据填充的方法，避免每次调用的时候去初始化控件再去对view进行填充等造成的代码冗余。

RecyclerViewDivider主要就是封装了常见类型的分割线的尺寸与颜色等。

AbsListAdapter就是对ListAdapter的封装，避免写过多重复的代码。要是不想使用RecycleryView的同学那使用ListViewAdapter做基类也是可以的。


<br>31/05/2020：<br> 新增了RecyclerView多条目module ---> multipleentries
<br><br>
multipleentries主要是通过delegate委托的方式对多条目做了组件化处理，对adapter进行简化，布局的设定与数据绑定都放到具体的delegate来实现。
<br><br>
adapter只需要添加具体delegate即可，具体的匹配逻辑都放在了委托类ItemViewDelegateManager，这样提示了代码的简洁性和灵活性，以便于后期的维护与拓展。<br><br>
RecyclerViewDivider也做了升级，向着万能分割线迈进，支持分割线前、后、全包、全不包以及跳过n行不绘制分割线等定制化需求，兼容了GridLayoutManager网格布局的支持。


