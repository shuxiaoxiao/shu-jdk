# shu-jdk
> Java 核心类的示例、 部分工具类、 数据结构和算法

# 版本：0.0.1-1.0.x

## 第三方jar未加入

jmail （邮件）：

xml（解析xml）：

json（解析json）：

itext（操作Word、Excel、pdf）：【了解】

protocol（协议）：这里只是jdk提供的实现不是用外部jar



## com.shuframework.jdk7

### 更新日志

#### 版本：0.5.0【计划3】
更新时间：2018-03-12 至 2018-03-24【计划3】
修改内容如下：
> 添加内容： ** protocol 协议** 

#### 版本：0.4.0【计划2】
更新时间：2018-02-26 至 2018-03-10
修改内容如下：
> 添加内容： ** classloader(类加载器)、proxy(动态代理)、innerclass 内部类** 

#### 版本：0.3.0【计划1】
更新时间：2018-02-22 至 2018-02-24
修改内容如下：
> 添加内容： ** thread(多线程)** 

#### 版本：0.2.0
更新时间：2018-01-02 至 2018-02-10
修改内容如下：
> 添加内容： **io(IO流)、reflect(反射)**

#### 版本：0.1.0
更新时间：2017-12-02 至 2017-12-31
修改内容如下：
> 添加内容： **codec(加密)、lang(语言基础包)、collection(集合)、annotation(注解)、genericity(泛型)、constant(常量)、enum(枚举)、random(随机数)**



###   annotation 注解

使用常见元注解实现自定义注解

###   classloader 类加载【未完成】




###   codec 加密

	md5、sha1，sha256，base64等

###   collection 集合
 collection 包括list、set、queue,  map(其实不在collection下, 但是为了方便就放在一起了) 


###   genericity 泛型
 泛型一般与集合(collection)一起使用, 不用单独列出

###   constant 常量
```
CharsetConstant  编码常量
```


###   enums 枚举
```
ExceptionCodeEnum  异常编码枚举
```


###    exception 异常

自定义异常

###    innerclass 内部类【未完成】




###    io IO流
	字节流、字符流
	内存操作流(ByteArrayInputStream、ByteArrayOutputStream;CharArrayReader、CharArrayWriter;
			StringReader、StringWriter)
	properties类 【继承Hashtable】



###    lang 语言基础包（常用工具类）
```
BigDecimalUtil：小数精确计算工具类，加减乘除，保留小数位。
CodeConvertUtil ： 编码转换
NumberSystemConvert ：数据进制转换
DateUtil、DateFormatUtil：jdk7之前的日期工具类，jdk8后用java.time.*包详见jdk8的特性例子。
StringUtil、WordUtil：字符串工具类。
MathUtil ：数学工具类，随机单独提出了
```

###   protocol 协议【未完成】
####    tcp/udp 



####    ftp 



####    http 



####    socket 网络编程



###   proxy 代理【未完成】




###   random 随机数
```
RandomUtil：产生随机数，多线程性能低
SecureRandomUtil：安全性很高的随机数
ThreadRandomUtil：多线程并发生成随机数
```


###    reflect 反射

常见是对bean的属性进行get/set操作、bean与map的转换、对象copy


###    thread 多线程【未完成】



###   其他
  SystemUtil 系统工具类,  主要是生成code
  ValidateUtil  参数检查






# 版本：1.1.0-1.1.x(未开始)

## com.shuframework.jdk8

> jdk8 新特性,主要是lambda(函数式)、 stream、time（类似jodatime）









# 版本：1.2.0-1.2.x(未开始)

## com.shuframework.datastructure

> 数据结构，主要是 (数组)、 (链表)、 (栈)、 (队列)、 (哈希表)、 (红黑树)

###   数组
MyFixedArray （固定数组）

MyArrayList （可变长数组类似ArrayList）

###   链表
MyLinkList （链表）

###   栈
MyStack （栈）

###   队列
MyArrayQueue （数组队列）

###   哈希表
MyHashMap （哈希表）

###   红黑树
MyTree （红黑树）



## com.shuframework.arithmetic

> 算法，主要是排序算法

###   排序
  常见的排序算法有 冒泡、快速





# 版本：1.3.0-1.3.x(未开始)

## com.shuframework.designpattern

> 设计模式，主要是(单例)、 (工厂)、 (装饰)、 (代理)、 (适配)等23种
>  单例   singleton
> 工厂  factory
> 适配  adapter

