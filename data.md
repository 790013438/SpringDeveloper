450297
floydbit255
Module    Manufacturer:SK  Hynix
Module    Part             Number:HMA81GS6AFR8N-UH
productInfoMaintenance/productEntryAction.do
productInfoMaintenance/floydPracticeAction.do
C:\Users\79001\gpms\webapp\WEB-INF\page\gpms\productInfoMaintenance\productEntryInsertProjectApproval.jsp
17行
<ta:form  cols="3"         id="form1"  enctype="multipart/form-data"  methord="post">
methord   ->               是这个属性吗
写dao
不能获取申请人名字
陈艳      陈姐
张雷
圆圆
信息部      张磊         网络
云平台 冯科 http://192.168.16.25/Citrix/DesktopWeb/site/directLaunch.aspx
不要从里面关机
不允许修改ip
只能装到D盘
file://192.168.16.21/shareFiles
不要装wps
myeclipse
装java
权限111/123456
复制到d盘，再打开
本机装Oracle11g
最后关门
youtube oracle
all about vue

一天mybatis
8.3  8.4     sql
16-22日项目
4次笔试
3个周项目
课堂练习10分
3分递减
117
一年以内经验,初级岗培
05班
云平台有课程表
大家好，我叫程淼，程是程序员的程，淼是三个水那个淼，来自应用开发部，我家是四川泸州的。毕业于攀枝花学院，软件工程专业，
接下来的时间，      我们是同事的关系也是同学的关系，希望大家在学习和工作上互相帮助。
我们来到这里是缘分，来到这里一起学习，希望大家多多帮助。
一起共进退，拿到满意的成绩
一起学习，共同进步
吴华君      部门         年龄   地区
唐绍林      学校  学习和工作多帮助
张琳琳
孙娜
    赵家蔚      新疆         1组
    张苗苗
    韦联告      自黑
丁伟      辽宁
理学家
张略      桂林
温兆      广西
韦联告
林玉粮
何天豪      眼镜
元子林      瘦
潘俊      都敏君的军
城阳
黄胜      攀枝花
梁红菊   免费导游，有眼镜
元慧泉
袁世凯   成都事业部   内江师范学院   软件工程
杨寅杰
陈玉婷   四川乐山
扬丝岩   住房公积金
唐瑞国   湖北   武汉   事业部   家甘肃
涂   湖北事业部
北京事业部
熊凯   遂宁
空调2701
杜孝飞      成都事业部         广安

    赵家蔚      新疆         1组
    张苗苗
    韦联告      自黑

执行力强，创新中心银海大学

user015/111111

# ibatis
> * SqlMapConfig.xml
> * 映射文件
> * java实体 pojo

> 插入
1. SqlMapConfig.xml
2. SqlClientBuilder对象
3. SqlMapClient对象
4. API
$$读取classpath的配置文件$$
## 1. SqlMapConfig.xml
> * <settings> 元素
> * <datasource>
```xml

```
> * <sqlMap>
<!-- CLASSPATH RESOURCES -->
<sqlMap resource=""></sqlMap>
<!-- url RESOURCES -->
<sqlMap url=""></sqlMap>

## 2. SqlMap.xml
> * <statement> 元素
> * <procedure> 元素
> * <insert> 元素 通过配置可以返回主键，但是标签里没有属性
> * <> 特殊符号 转义
```xml
<![CDATA[
    SELECT from
]]
```
> * parameterClass
全包名
<statement id="insertProduct" parameterClass="java.lang.Integer">
    select * from PRODUCT where PRO__ID = #value#
</statement>
> * resultClass
```xml
<statement id="getPerson" parameterClass="int" resultClass="example.domain.Person">
    SELECT RER_ID as id,
    PER_FIRST_NAME
</statement>
```
取别名和成员字段对应

## 3. SqlMapClientBuilder
读取SqlMapConfig.xml
## 3. SqlMapClient
queryForObject()
两个参数的返回查询结果，三个参数，第三个参数获得结果, 4个参数分页
```java
sqlMap.startTransaction();
Custom
```
事务
```java
public void statTransaction() throws SQLException
Item item = (Item) sqlMap.
public void commitTransaction() throws SQLException
public void endTransaction() throws SQLException
```
每个线程只能开启一个事务
repository sqlMap-XXX.xml id

192.168.16.28:1521 orl库 ta312 ta312

Window->Preferences->General ->Content Type->Text->JSP 最下面设置为UTF-8

Window->Preferences->General->Workspace 面板Text file encoding 选择UTF-8

Window->Preferences->Web->JSP Files 面板选择 ISO 10646/Unicode(UTF-8)
https://zhuanlan.zhihu.com/p/24986821

General > Editors > Text Editors. Check “Insert spaces for tabs”
Java > Code Style > Formatter. Create a new profile. Go to the Indentation tab and set “Tab policy” to “Spaces only”
Ant > Editor > Formatter. Uncheck "Use tab character instead of spaces"
https://stackoverflow.com/questions/40214092/eclipse-spaces-instead-of-tabs-project-file

实例 = 后台进程 + 内存结构
数据库 = 数据文件 + 控制文件 + 重做日志文件
一个实例只能打开一个数据库
PGA 私有全局区
REVOKE {privilege}
ON object
FROM {user}
[CASCADE CONSTRAINTS 将用户付出去的收回]

