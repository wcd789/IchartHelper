IchartHelper
============

icharjs的官方地址http://www.ichartjs.com/

chartjs helper是什么？

在ichartjs官方的所有示例中所有的图表都需要提供一组json格式的数据（如data和labels）供ichartjs绘制，实际应用中这些json数据是需要服务器端动态传递到浏览器，而不是作为一个静态页方式存在。ichartjs helper就是能够帮你在服务器端方便生成图表需要的json数据的一套java类库。

拼接这些json数据是一件很简单的事情，我们可以使用诸如Jackson这样的开源类库，事实上笔者也只是对Jackson进行了简单的封装，达到更高效使用ichart的目的。

使用ichartjs helper便可以避免关注拼接图表json数据格式的细节，不需要为页面的每个图表都实现一个拼接json的方法,省事省心好维护。
