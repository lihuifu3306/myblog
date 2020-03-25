> 春天到了，万物复苏，又到了动物们交配的季节！ - 人与自然
### 打造博客系统
- **主要是技术实践** 其实没必要使用springcloud来搭建，有点高射炮打蚊子的赶脚，但是为了学习技术，目前就这样搞吧
- 后端技术栈
    * springcloud Finchley.SR2 + springboot2.0.3 + mybatisplus + maven + mysql
    * swagger框架实现接口文档。地址：http://localhost:6001/swagger-ui.html#
    * 项目使用alibaba cloude view一键部署工具
    * linux 环境 centos7
    * jdk 1.8
- 前端技术栈
   * vue2.0
- **项目进度**
   * 尝试了springboot推荐的devtools热部署插件，并没有想象中那么好用，改用jRebel。
   * 每次还要启动网关层太麻烦，干脆使用过滤器Filter实现跨域。
   * 新增拦截器，监听器。配合定时任务统计每天博客的访问量，由于对多线程以及高并发相关知识欠缺，可能会导致统计数据不正确。
   * 以前没有多想，把评论和留言搞成了两张表，今天回头看了一下，咦，完全没必要，一个表就能搞定的呀。
- **遇到的问题**
   * 写sql无从下手，多表要join的时候，导致我逐一查出来然后组装，急需恶补sql。
   * 前端技术只会基本的html+css+query，导致前端界面不知道该怎么写，无从下手。所以准备学习vue。
   * 遇到了时区问题，springboot解析后返回的时间少了8个小时，后来把jackson解析换成了fastjson解析，又过了一会，算了，还是用默认的吧。
   
- **下一步要完成的任务**
   * 集成redis实现缓存。
   * 使用qq邮箱发送邮件。
