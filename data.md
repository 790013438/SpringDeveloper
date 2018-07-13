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
系统账号        svn账号
13595  userpp
http://192.168.16.30:8080/gptool

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

scott/tiger  --简单查询1,     单行函数1,   复杂查询1,   复杂查询2
hr/hr        --简单查询2,     单行函数2
## 1.  查询
> * 取别名，可以在双引号里打空格
```sql
SELECT  empno  "id",  ename  as  "emp  name",  "123"
FROM    emp;
```
> * 去重
```sql
SELECT  distinct  deptno
FROM    emp;
```

> * 日期用单引号
日期，月，年
'13-7-18'
中文版
'20-7月-18'
> * not 加括号
> * 连接字符串
> * 通配符，模糊查询 % _
like '' 单引号
```sql
SELECT  ename,     sal
FROM    emp
WHERE   emp.ename  like  'J%'
```
> * 数据排序
默认升序asc
降序desc
必须放在语句的最后
空值作为最大值

> * 查询年薪, 处理空值,月薪乘12
select empno, ename, job, nvl(sal, 0) * 12
from emp;

> * 处理空
nvl(comm, 0)
nvl2(判断条件, 如果不为空, 空)
nvl2(判断条件, 判断条件1, 否则)
nullif(comm, 1400)如果是1400，那么给null,否则自己.
    如果是多少，给空
数字字符串自动转换
```sql
select comm,
    nvl(comm, 0),
    nvl2(comm, comm, 0),
    nullif(comm, 1400)
```

scott
1. 查询scott用户下的所有表
SELECT *
from tabs;

2. 查询雇员表中所有信息
select *
from emp;

3. 查询雇员编号，姓名，工作，工资
SELECT empno, ename, job, sal
from emp;

4. 查询雇员编号，姓名，工作，工资，列标题需要显示中文。
SELECT empno 编号, ename 姓名, job 工作, sal工资
from emp;

5. 消除重复列，查询雇员工作种类。
SELECT distinct job 工作
from emp;

6. 查询所有雇员编号，姓名，工作，按以下格式显示：编号:7369,姓名:SMITH,工作:CLERK
SELECT '编号:' || empno || ',姓名:' || ename || ',工作:' || job
from emp;

**7. 查询雇员编号,姓名,工作,年薪**
SELECT empno,ename,job,nvl(sal, 0) * 12 + nvl(comm, 0) * 12
from emp;

8. 查询工资大于1500的雇员所有信息
select *
from emp
where sal > 1500;

9. 查询可以得到奖金的雇员所有信息
select *
from emp
where comm is not null and comm <> 0;

**10. 查询工资大于1500或可以获得奖金的雇员**
select *
from emp
where sal > 1500 or (comm is not null and comm <> 0);

11. 查询工资大于1500并且可以领取奖金的雇员
select *
from emp
where sal > 1500 and comm is not null and comm <> 0;

12. 查询工资大于1500或者不可以领取奖金的雇员
select *
from emp
where sal <= 1500 or comm is null or comm = 0;

13. 查询工资在1500到3000的所有雇员信息
select *
from emp
where sal between 1500 and 3000;

14. 查询在1981年雇用的员工信息
select *
from emp
where hiredate >= '1-1月-81' and hiredate <= '31-12月-81';

15. 查询雇员姓名中第二个字母为"M"的雇员信息
```sql
select *
from emp
where ename like '_M%'
```

16. 查询雇员工资中带8这个数字的雇员信息
select *
from emp
where sal like '%8%';

17. 查询编号是7369,7499,7521,7900的雇员信息
select *
from emp
where empno in (7369,7499,7521,7900);

18. 查询编号不是7369，7499，7521，7900的雇员信息
select *
from emp
where empno not in (7369,7499,7521,7900);

19. 查询雇员编号为7369的雇员信息
select *
from emp
where empno = 7369;

20. 查询雇员编号不为7369的雇员信息
select * 
from emp
where empno != 7369;

21. 查询雇员信息，按工资由低到高排序
select *
from emp
order by sal asc;

22. 查询雇员信息,按工资由高到低排序
select *
from emp
order by sal desc;

hr用户
23. (以下hr用户employees表)HR需要得到一个月薪$12000以上的员工名(last_name)和薪水报告，请完成查询语句
select last_name, salary
from
employees
where salary > 12000;

24. HR需要识别高收入和低收入员工群体,请显示月薪不在$5000到$12000范围内的员工名和月薪
select last_name, salary
from
employees
where not (salary between 5000 and 12000);

25. 请查询1994年雇员的员工名和雇佣日期
select last_name, hire_date
from employees
where hire_date >= '1-1月-94' and hire_date <= '31-12月-94';

26. 请查询没有领导的员工名和职位
select last_name, job_id
from employees
where manager_id is null;

27. 请查询有奖金的员工名和月薪，奖金，并按照奖金系数排序
select last_name, salary, salary * commission_pct
from employees
where commission_pct is not null
order by commission_pct desc;

28. 请查询月薪大于1000的员工名和月薪
select last_name, salary
from employees
where salary > 1000;

29. 请查询第三个字母是a的员工名
```sql
select last_name
from employees
where last_name like '_a%';
```

30. 请查询员工名包含a或e的员工名
select last_name
from employees
where last_name like '%a%' or last_name like '%e%';

31. 请查询职位是"SA_REP" 或者 "ST_CLERK",且月薪不是$2500,$3500,$7000的员工信息
select *
from employees
where JOB_ID in ('SA_REP', 'ST_CLERK')
and salary not in (2500, 3500, 7000);

32. 请查询奖金系数是20%的员工名、薪水和奖金系数
select last_name, salary, commission_pct
from employees
where commission_pct = 0.2

> * 函数
> chr(integer) 把整数换成ASCII码对应的字母，char
select chr(65)
from dual;
> initcap(字段)将单词换成第一个字母大写，init capital
> lower(字段)全小写
> upper(字段)全大写
> LPAD(string, length, char) 指定查出字段长度，在单词left左边填充指定字符
> RPAD(字段, 包装字符长度, 填充字符)右边
> ltrim(字段) 裁剪left（左边的空格，不可见字符）
> replace(字段, 被替换字符串, 新字符串)
> substr(字段, 从1开始数的位置, 数多少个字符)替换
> length()求长度

> abs(int) 求绝对值
> ceil(float) 向上取，加0.5取整
> floor(float) 向下取，减0.5取整
> power(value, exponent) 指数，value的多少次方
> round(value, 精度的位数) round(12.568, -1) 得10，小数点前一位，参与四舍五入
                           round(12.568, 0) 得13，不保留小数位
                           round(12.568, 1) 得12.6

> 日日-月月-年年
> add_months(hiredate, 2) 增加一个月
> last_day(hiredate) 求所在月得最后一天的日期
> months_between(sysdate, hiberdate) 中间隔多少月
> next_day(sysdate, '星期一') 之后是星期一的日期
> sysdate 系统时间
> current_timestamp 时间戳
> round(sysdate) 四舍五入，默认按照日期
> trunc(sysdate) 截断，只能截取单个，年，月，日
> extract(year from sysdate) 提取年
> to_char(sysdate, 'mm') 两位的月，转成字符串
4个YYYY  2个YY  MONTH,  MON  2个月MM
4位年    2位年

> to__char(date, 'format') 将日期转换成指定格式
```sql
```
```sql
select to_char(023.450), to_number('1.34')
from dual
```
不包含数字的0
```sql
select to_char(13857.760, '$99,999.0000'), to_number('12.34')
from dual;
```
9代表数字，0代表没有保留零
>
