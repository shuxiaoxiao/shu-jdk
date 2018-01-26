# shu-jdk
> Java 核心类的示例、 部分工具类、 数据结构和算法

# 版本：0.0.1-1.0.x

## com.shuframework.jdk7
更新时间：2017-12-02 至 2017-12-31
修改内容如下：(此处列出顺序为更新顺序，下面的笔记是自然排序)

> jdk7以及之前版本的内容，主要是 **lang(语言基础包)、 collection(集合)**、 innerclass(内部类)、  enum(枚举)、annotation(注解)、genericity(泛型)、io(IO流)、 **reflect(反射)**、 socket(网络编程)、 **thread(多线程)、classloader(类加载器)、proxy(动态代理)** 
jmail 需要导入javax.mail的依赖, 所以暂时不写入

###   collection 集合
 collection 包括list、set、queue, map其实不在collection下, 但是为了方便就放在一起了。 


###    exception 异常



###    innerclass 内部类




###    io IO流
	字节流、字符流
	内存操作流(ByteArrayInputStream、ByteArrayOutputStream;CharArrayReader、CharArrayWriter;
			StringReader、StringWriter)
	properties类 【继承Hashtable】



###    lang 语言基础包

	常用工具类：小数精确计算工具类、日期工具类、字符串工具类等
BigDecimalUtil：小数精确计算工具类，加减乘除，保留小数位。

DateUtil、DateFormatUtil：jdk7之前的日期工具类，jdk8后用java.time.*包详见jdk8的特性例子。

StringUtil、WordUtil：字符串工具类。



###   random随机数

RandomUtil：产生随机数，多线程性能低

SecureRandomUtil：安全性很高的随机数

ThreadRandomUtil：多线程并发生成随机数



###    reflect 反射



###    socket 网络编程




###    thread 多线程





# 版本：1.1.0-1.1.x(未开始)

## com.shuframework.jdk8

> jdk8 新特性,主要是lambda(函数式)、 stream()









# 版本：1.2.0-1.2.x(未开始)

## com.shuframework.datastructure

> 数据结构，主要是 (数组)、 (链表)、 (栈)、 (队列)、 (哈希表)、 (红黑树)



## com.shuframework.arithmetic

> 算法，主要是排序算法







# 版本：1.3.0-1.3.x(未开始)

## com.shuframework.designpattern

> 设计模式，主要是(单例)、 (工厂)、 (装饰)、 (代理)、 (适配)等23种
 单例   singleton
工厂  factory
适配  adapter

