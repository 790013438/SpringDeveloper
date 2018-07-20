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
索引
信息部      张磊         网络
云平台 冯科 http://192.168.16.25/Citrix/DesktopWeb/site/directLaunch.aspx
不要从里面关机
不允许修改ip
只能装到D盘
file://192.168.16.21/shareFiles
不要装wps
myeclipse
new web project -> 取消User default location -> lib文件上一层 -> next ->
src修改成javacode -> next -> WebRoot修改成webapp,取消Generate index.jsp welcome file ->
create from archetype
填写archetype-catalog版本号4.0.1-SNAPSHOT的值
不要有空字符，不要数字打头
配置maven，全是Override
全局idea设置，default settings-> Build,Execution,Deployment -> 设置maven的仓库

解压mysql
进入C:\mysql-5.7.12-win32\bin cmd目录
1、执行：mysqld --initialize --user=mysql --console 会自动生成data目录，还有一个随机密码，记下来。 2、执行：mysqld --console 启动mysql，另打开进入C:\mysql-5.7.12-win32\bin dos界面,登录mysql -uroot -p 输入刚才记录的密码，执行：set password = password('root');修改密码。
设置成系统启动，mysqld.exe -install
net start mysql
net stop mysql
http://blog.csdn.net/zxfc88/article/details/8597473
mysql>alter database mydb character set utf8;
SET NAMES gbk;


内网地址：
http://192.168.10.201:7076
ta + cloud
yhcip
ta + 2
ta + 3
首先厚脸皮

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

33. 查询部门30中的所有员工信息
select *
from emp
where deptno=30;

34. 列出所有办事员(CLERK)的姓名,编号和部门编号
select ename,empno,deptno
from emp
where job='CLERK';

35. 找出奖金高于薪金的员工信息
select *
from emp
where comm > sal;

36. 找出奖金高于薪金的60%的员工信息
select *
from emp
where comm >= sal * 60;

37. 找出部门10中所有经理(MANAGER) 和部门20中所有办事员（CLERK）的详细资料
select *
from emp
where deptno = 10 and job = 'MANAGER' or deptno = 20 and job = 'CLERK';

38. 找出部门10中所有经理(MANAGER)和部门20中所有办事员(CLERK),既不是经理又不是办事员但薪金大于或等于2000的所有员工的详细资料
select *
from emp
where deptno = 10 and job = 'MANAGER' or deptno = 20 and job = 'CLERK' or
((not(job = 'MANAGER' or job = 'CLERK')) and sal >= 2000);

39. 找出员工可以获取到奖金的工作
select distinct job
from emp
where comm is not null and comm <> 0;

40. 找出不收取或收取奖金低于100的员工信息
select *
from emp
where comm is null or comm = 0 or comm < 100;

41. 找出各月倒数第3天受雇的所有员工信息
select *
from emp
where hiredate > last_day(hiredate) - 3;

42. 找出早于12年前受雇的员工信息
select *
from emp
where months_between(sysdate, hiredate) / 12 > 12;

43. 以首字母大写的方式显示所有员工的姓名
select initcap(ename)
from ename;

44. 显示正好5个字符的员工的姓名
select ename
from emp
where length(ename) = 5;

45. 显示不带有"R"的员工的姓名
select ename
from emp
where ename not like "%R%";

46. 显示所有员工的姓名的前三个字符
select substr(ename, 0, 3)
from emp;

47. 显示所有员工的姓名,用'a'代替所有的'A'
select replace(ename, 'A', 'a')
from emp;

48. 显示满10年服务年限的员工的姓名和受雇日期
select ename, hiredate
from emp
where months_between(sysdate, hiredate) / 12 > 10;

49. 显示员工详细信息，按姓名排升序
select *
from emp
order by ename asc;

50. 显示员工的姓名和受雇日期，根据其服务年限，将最老的员工排在最前
select ename, hiredate
from emp
order by months_between(sysdate, hiredate) desc;

51. 显示所有员工的姓名，工作和薪金，按工作的降序排序，若工作相同则薪金升序排序
select ename,jobs,sal
from emp
order by job desc,sal asc;

52. 显示所有员工的姓名，加入公司的年份和月份，按受雇日期所在月排序，若月份相同则将最早年份的员工排在前面（要求使用extract函数）
select ename, extract(year from hiredate), extract(month from hiredate)
from emp
order by extract(month from hiredate) asc, months_between(sysdate, hiredate) desc;

53. 显示在一个月为30天的情况，所有员工的名字和日薪金，忽略余数
select ename, trunc(sal/30)
from emp;

54. (以下emp表)找出在(任何年份的)2月受雇的所有员工信息
select *
from emp
where extract(month from hiredate) = 2;

55. 对于每个员工，显示名字和其加入公司的天数，保留2位小数(四舍五入)
select ename, round(sysdate - hiredate, 2)
from emp;

56. 显示姓名字段的任何位置包含"A"的所有员工的姓名
select ename
from emp
where ename like "%A%"

57. (hr用户)查询系统当前日期
select sysdate
from dual;

58. 请查询每个员工的姓名、薪水和加薪15.5%之后的薪水(trunc取整)
select last_name, salary, trunc(salary * 1.155)
from employees;

59. 显示员工加薪15.5%（取整）之后员工的名字、原薪水和增加的薪水。(不允许做update操作,trunc取整)
select last_name, salary, trunc(salary * 1.155) - salary
from employees;

60. 请显示所有以'J', 'A', 'M'打头的员工的名字和名字长度，且按照名字排升序
select last_name, length(last_name)
from employees
where last_name like 'J%' or
last_name like "A%" or
last_name like "M%"
order by last_name asc;

61. 请查询员工名和工作时间（换算成月并取整），并按工作时间排降序
select last_name, trunc(months_between(sysdate, hire_date))
from employees
order by trunc(months_between(sysdate, hire_date)) desc;

62. 请查询员工的名字和薪水，并将薪水列变成15个字符长度，左边填充"$"符号
select last_name,LPAD(salary, 15, '$')
from employees;

63. 请查询部门id为90的所有员工的名字和他们参加工作的星期数(保留2位小数，不需要四舍五入)使用
select last_name, trunc((sysdate - hire_date) / 7, 2)
from employees
where department_id=90

64. 创建报告，显示员工名和奖金系数，如果奖金系数为空，则显示"无奖金"
select last_name
case
    when commission_pct is null then '无奖金'
    when commission_pct is not null then to_char(commission_pct)
end
from employees
where department_id = 90;

65. 请使用decode语句，查询员工的job_id和级别。例如：
Job Grade
AD_PRES A
ST_MAN B
IT_PROG C
SA_REP D
ST_CLERK E
None of the above 0
select job_id Job, decode(job_id, 'AD_PRES', 'A', 'ST_MAN', 'B', 'IT_PROG', 'C', 'SA_REP', 'D', 'ST_CLERK', 'E', '0') Grade
from employees;

66. 请使用case语句，查询员工的job_id和级别。例如：
Job Grade
AD_PRES A
ST_MAN B
IT_PROG C
SA_REP D
ST_CLERK E
None of the above 0
```sql
select job_id Job
case job_id
    when 'AD_PRES' then 'A'
    when 'ST_MAN' then 'B'
    when 'IT_PROG' then 'C'
    when 'SA_REP' then 'D'
    when 'ST_CLERK' then 'E'
    else '0'
end
from employees;
```

67. 查询emp和dept表，产生笛卡尔积(多表行相乘)
select * from emp,dept

68. 加where条件过滤查询emp和dept表产生的笛卡尔积
select * from emp,dept
where emp.deptno = dept.deptno

69. 查询emp和dept表，产生笛卡尔积(多表行相乘)，并为表去别名
select * from emp t1, dept t2

70. 查询雇员姓名，所在部门编号和名称
select ename, deptno, (select dname from dept t2 where deptno = t1.deptno)
from emp t1

71. 查询所有雇员姓名，工作，领导的姓名
select ename,job,(select ename from emp t2 where t2.empno = t1.mgr)
from emp t1;

72. 查询雇员姓名，工作，领导姓名及部门名称
select ename,job,(select ename from emp t2 where t2.empno = t2.mgr)
,(select dname from dept where deptno = t1.deptno)
from emp t1;

73. 查询雇员姓名，工作，工资及工资等级
select ename, job, sal, (select grade from salgrade where losal <= t1.sal and hisal >= t1.sal)
from emp t1;

74. 查询雇员姓名，工作，工资及工资等级，要求工资显示为A B C D E
select ename, job, sal
case(select grade from salgrade where losal <= t1.sal and hisal >= t1.sal)
    when 1 then 'A'
    when 2 then 'B'
    when 3 then 'C'
    when 4 then 'D'
    when 5 then 'E'
end
from emp t1;

75. 查询雇员姓名，年薪（薪水 + 奖金），按年薪从高到低排序
select ename, nvl(sal, 0) * 12 + nvl(comm, 0) * 12
from
emp;

76. 查询每个部门中工资最高的雇员姓名，工作，工资，部门名称，最后按工资从高到低排序，工资相同的情况下按姓名排升序
select ename, job, sal, (select dname from dept where deptno = t2.deptno)
from emp t2
where sal in(
select max(sal)
from emp t1
group by deptno)
order by sal desc, sal asc;

77. 查询每个部门的部门编号和雇员数量
select t2.deptno, sum(nvl2(t1.deptno, 1, 0))
from emp t1 right join dept t2
on t1.deptno = t2.deptno;

78. 求出每个部门的部门和平均工资（保留2位小数，截断）
select dname, trunc(avg(nvl(sal, 0)), 2)
from emp t1 right join dept t2
on t1.deptno = t2.deptno;

79. 按部门分组，并显示部门的名称，以及每个部门的员工数
```sql
select distinct dname, (select count(*) from emp t2 where t2.deptno = t1.deptno)
from emp t1 right join dept
on t1.deptno = dept.deptno;
```

80. 要求显示平均工资大于2000的部门编号和平均工资（保留2位小数，截断）
select deptno, trunc(avg(sal), 2)
from emp
group by deptno
having avg(sal) > 2000

81. 显示非销售人员工作名称以及从事同一工作雇员的月工资的总和，并且要满足从事同一工作的雇员的月工资大于$1500,输出结果按月工资的合计升序排列
select job, sum(nvl(sal, 0))
from emp
where job <> 'SALESMAN' and nvl(sal, 0) > 1500
group by job
order by sum(nvl(sal, 0)) asc

82. 求出平均工资最高的部门名称
select dname
from dept
where deptno = (select deptno from emp group by deptno having avg(sal) =
(select max(avg(sal)) from emp group by deptno));

83. 要求查询出比7654工资要高的全部雇员的信息
select *
from emp
where sal >
(select sal 
from emp
where empno = '7654');

84. 要求查询工资比7654高，与7788从事相同工作的全部雇员信息
select *
from emp
where sal >
(select sal 
from emp
where empno = '7654')
and job = (
select job
from emp
where empno = '7788');

85. 查询出工资最低的雇员姓名，工作，工资
select ename, job, sal
from emp
where sal = (
select min(sal)
from emp
)

86. 查询出各部门工资最低的雇员姓名，工作，工资
select ename, job, sal
from emp el
where sal = (
    select min(sal)
    from emp e2
    where e1.deptno = e2.deptno)

87. 要求查询部门名称，部门的员工数，部门的平均工资，部门的最低收入雇员姓名，要求显示所有部门名，如果该部门没有任何员工，则员工数和平均工资需显示0，员工姓名显示null即可。
select distinct d.dname, nvl(t.pcount, 0), nvl(t.savg, 0), (select ename from emp where sal = t.smin)
from dept d, emp e, (select deptno, count(deptno) pcount, avg(sal), min(sal)smin from emp
group by deptno) t
where d.deptno = e.deptno(+)
and d.deptno = t.deptno(+);

88.

89.

90.

91.

92.

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
> to_char(sysdate, 'mm') 两位的月，转成字符串，比如07
> to_number(char) 将字符串转换成数字，字符要求是纯数字

4个YYYY  2个YY  月MONTH,   缩写MON   2个月MM
4位年    2位年  月份名称   月份名称缩写

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

> coalesce 合并
```sql
select coalesce('', '3', '333')
from dual
```
返回第一个不空的
> decode(字段, 条件, 包装, 条件, 包装, default)
返回男女

count(1) 统计查询结果
```sql
select  count(1) total,
        sum(decode(deptno, 10, 1, 0)) "10",
        sum(decode(deptno, 20, 1, 0)) "20",
        sum(decode(deptno, 30, 1, 0)) "30"
from emp;
```
total  10  20  30
13     3   4   6

> * case when then end
```sql
select sal,
    case
        when sal>1500 then '>1500'
        when sal=1500 then '=1500'
        when sal<1500 then '<1500'
    end as cc
from emp;
```
```sql
select sal
    case sal
        when 1600 then 1
        when 1500 then 0
    end cc
from emp;
```

> * 分组函数
AVG, MAX, MIN, COUNT, SUM
```SQL
select max(sal), min(sal), sum(sal), avg(sal), count(sal)
from emp;
```
distinct 用在sum里，不计算重复的项
```SQL
select max(sal), min(sal), sum(sal), sum(distinct, sal), avg(sal), count(sal)
from emp;
```

对分组计算
group by
having
order by
查询每个部门
```sql
select max(sal), min(sal), sum(sal), sum(distinct, sal), avg(sal), count(sal)
from emp;
group by deptno;
```
> 空值处理
空默认忽略
```sql
select deptno, sum(comm), avg(comm), count(comm)
from emp
group by deptno;
```
deptno  sum(comm)  avg(comm)  count(comm)
30      2200       550        4
20                            0
10                            0

nvl(comm, 0)处理空值
可以根据多个列或者表达式分组
where 子句里不能出现分组函数
having 可以
```sql
select deptno, job, sum(comm)
from emp
group by deptno, job
having sum(comm) > 0
```
分组函数可以嵌套，注意sum,count返回一个值
-- 查询员工姓名和所在部门名称

```sql
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
```
* 等值连接，用等号
* 查询员工姓名及所在部门
```sql
select e.ename, d.dname
from emp e, dept d
where e.deptno(+) = d.deptno;
* 表（left） right join 表（right，右边） on 条件 右边的会全部查出来
* (+) 放在缺失的那边
如果有n个表进行等值连接，需要n-1个条件
```
* 查询员工姓名及其领导姓名
```sql
select el.ename, e2.ename mgr
from emp e1, emp e2
where e1.mgr = e2.empno(+);
```
外连接
```sql
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
```
* 自连接

* > 子查询
子查询里不用group by, top-n除外
```sql
select employee_id, last_name, job_id, salary
from employees
where salary < any
(select salary
from employees
where job_id = 'IT_PROG')
where job_id <> 'IT_PROG';
```
小于最大的，小于集合中的随机一个 || or
```sql
select employee_id, last_name, job_id, salary
from employees
where salary < ALL
(select salary
from employees
where job_id = 'IT_PROG')
where job_id <> 'IT_PROG';
```
小于集合中的全部 && and

* 子查询里的空值
判断where
select ename from emp
where empno not in (
select mgr.empno from emp mgr where job = MANAGER and empno is not null)

* 内联视图
select e.ename, a.avgsal from emp e,
(select deptno,avg(sal) avgsal from emp group by deptno) a
where e.deptno = a.deptno;

* top-n分析，工资前10名
rownumber, 行号, 查询之后编号，之后order by 排序
```sql
select ename, sal
from(select rownumber, ename, sal
from emp
order by sal desc)
where rownumber <= 10;
```

* 集合
并 UNION/UNION ALL
union 去重，all不去重
列数一致，第一个列为列名
```sql
select empno, ename
from emp
union
select deptno, dname
from dept;
```

* > 创建maven工程
骨架文件
192.168.17.18：8081/nexus/content/repository/yh-archetypes

公司内网maven配置
添加archetype
groupId com.yinhai
artifactId ta3-project-ta3-archetype
version 4.0.1-SNAPSHOT
repository http://192.168.17.18:8081/nexus/content/repositories/yh-archetypes

框架库
192.168.16.28:1521
用户 cloud
p@ssword cloud
tomcat内存
-Xms256m
-Xmx512m
-XX:PermSize=256M
-XX:MaxPermSize=512M

-server -XX:PermSize=256M -XX:MaxPermSize=512m -Dfile.encoding=UTF-8
rO0ABXNyAChjb20uemVyb3R1cm5hcm91bmQubGljZW5zaW5nLlVzZXJMaWNlbnNlAAAAAAAAAAECAANMAAdkYXRhTWFwdAAPTGphdmEvdXRpbC9NYXA7WwAHbGljZW5zZXQAAltCWwAJc2lnbmF0dXJlcQB+AAJ4cHB1cgACW0Ks8xf4BghU4AIAAHhwAAACZqztAAVzcgARamF2YS51dGlsLkhhc2hNYXAFB9rBwxZg0QMAAkYACmxvYWRGYWN0b3JJAAl0aHJlc2hvbGR4cD9AAAAAAAAYdwgAAAAgAAAAFHQACGxhc3ROYW1ldAAFZmxveWR0AAtHZW5lcmF0ZWRCeXQABEFVVE90AAVFbWFpbHQAEmZsb3lkYml0QGdtYWlsLmNvbXQADE9yZ2FuaXphdGlvbnQABHpya2p0AAplbnRlcnByaXNldAAEdHJ1ZXQAB1Byb2R1Y3R0AAZKUmViZWx0AAtHZW5lcmF0ZWRPbnNyAA5qYXZhLnV0aWwuRGF0ZWhqgQFLWXQZAwAAeHB3CAAAAWSxv0K2eHQACXZhbGlkRnJvbXEAfgAQdAAHT3JkZXJJZHQAAHQAC2xpbWl0ZWRGcm9tcQB+ABB0AAd2ZXJzaW9udAAEMS4yMXQABE5hbWV0AAtmbG95ZCBmbG95ZHQABVNlYXRzdAABMXQAA3VpZHQAKDI0MjE0OTM1MDRkYzU1MDZkNGU4NmIxN2I0OTRhYzk3MzJmMmY1OTJ0AAlmaXJzdE5hbWV0AAVmbG95ZHQABFR5cGV0AApldmFsdWF0aW9udAAKdmFsaWRVbnRpbHNxAH4AD3cIAAABbAlwbrZ4dAAIb3ZlcnJpZGV0AAVmYWxzZXQADGxpbWl0ZWRVbnRpbHEAfgAidAAJdmFsaWREYXlzc3IAEWphdmEubGFuZy5JbnRlZ2VyEuKgpPeBhzgCAAFJAAV2YWx1ZXhyABBqYXZhLmxhbmcuTnVtYmVyhqyVHQuU4IsCAAB4cAAAAA54dXEAfgAEAAABAJ8omr46kbiA0+O1YolrdirgIWKWhWrZotMvkI2wHYjH8GGGu6f+zR0tefATw6I7015IT2nuLnuVDMHWCu86ey58bR0pFwxUlI/CBJYN+sqzMJYvSbjBmKAcHofH8IbKtd2Ok4avmBSPh4U2OC7pp+HDK32mAUIfQOlXpPIaagMgjGtgjVsGAv8sDlp2kaGahi5+aXj797WyQ2+SUcPlbZ096bstLzeZnMmiC8lwxe+xLuEnvGCy4V1fMT5IcixE80uFQd2U554z5J7nNF1VBOeX5VckCNwgvN3HNeNcbmDvWZB+aDNfACqRREfX+e43Kzz9lovql7PeZ27VBzHkkzE=

8080 jvm_bindException
1099端口占用，修改端口,新配tomcat
8445占用，

TaParamDTO,从中获取数据， ValueObject
BaseController,所有控制器的父类, Controller
> setData(), setSelectInputList()下拉列表，setList(), getTaDto()获取数据
!左边保持一致
异步，submit,返回json

web-app/web.xml -> app-context.xml -> jdbc.properties ->
hiberdate.properties -> cas.properties -> session-redis.properties
-> spring/spring-dynamicDatasource.xml ->
spring/spring-dynamicTransaction.xml -> transactionProxy
spring-ibatis.xml(可以修改)
开发阶段注释
404 修改404
源文件夹(src/java, src/resource)合并成class
inc.jsp -> inc-face.jsp
        -> /appinc.jsp -> 第三方的东西整个项目都要用

<script>
document.
//渲染页面布局
</script>
padding 内边距
margin 外边距
注释是<%--

容器组件
panel
box 专门布局、div
fieldset form表单
tabs、tab

列布局
<ta:fieldset id="first1" key="fieldset组件" fit="true">
  <ta:
</ta:fieldset>

layout="border"

一个组件的最后fit=true，占据父元素剩下的高度
heightDiff="100", 下面留白
box div 有东西才有高度

百分比布局（autoPercentHeight）
<ta:box></ta:box>
日期 - lableWidth设置标签宽度
图片勾，box百分比

text
columnWidth 百分比
readOnly 只读，传值
disabled 不传值
displable 是否显示
type 指定password, file
validType 定义验证，url、email、ip、integer、issue期号、zipcode邮编、idcard身份证
validFunction自定义验证方式
```html
<ta:text key="姓名" validType="self" validFunction="fnValid()" onChange=""></ta:text>
<script>
  function fnValid() {
    var name = Base.getValue("txt1");
    if (name.length > 20) {
      Base.alert("姓名长度")
    }
  }
</script>
```
buttonLayout 包含 button
```html
<ta:buttonLayou>

</ta:buttonLayou>
<script>
  // 异步
  function fnTest() {
    Base.submit("flst1", "demoAction!test.do");
  }
  // 设置值
  Base.setValue("txt1", "张三");
  // 获取值
  Base.getValue("txt1");
  // 弹框
  Base.alert("提示信息", "warn");
  // 设置禁用
  Base.setDisabled("text1")
  // 恢复显示
  Base.setEnable("txt1");
  // 设置星号
  Base.setRequired("txt1")
  // 隐藏，是否占位
  Base.hideObj(), Base.showObj
  // 显示对象
  Base.showObj()
  Base.setReadOnly
</script>
```
```java
@RequestMapping("demo1Action!test.do")
public String test() throws Execution {
    // 异步
    ParamDTO paramDTO = getDto();
    return JSON;
}
// 从后台设置值
setData("txt1", "李四");
```
cssInput对应框
labelStyle 对标签
labelWidth 标签宽度

bpopTipMsg="pop" 提示信息
bpopTipMsgWidth 宽高
popWin="true" 显示放大镜按钮, 搜索，可以指定url
softkeyborad="true" 有软键盘
showDetailed 放上去显示全
toolTip="提示信息" required="true" 没有输入有提示框，hover
name属性，转到key
placeholder 框内信息
value 给框里设置默认值
ta:text texthelp 小box

ta:number
cssInput, cssInput='font-size:20px;color:red'
precision=2 小数位数显示为2，保存到数据库，16 = max14 + 2precision
asAacount="true" 数值金额
amountPre = "$" 金额
alignLeft 左显示
<ta:fieldset>
  <ta:number alignLeft="true"></ta:number>
</ta:fieldset>
min=10, max=100数值区间
numberRound="true" 四舍五入

ta:date
datetime
validNowTime left-> 今天及之前
issue=true 社保期号，4位年两位月
datetime="true" 时分秒
dateYear="true" 只有年
dateMonth="true" 年月
fulltime 毫秒
enableKeyborard 方向键移动,通过方向键选择日期
pchanged 改变日期触发，面板有变化
onChange 移开有变化
```html
<ta:fieldset id="fls3" key="date组件" cols=3>
  <ta:date id="date1" key="date1"></ta:date>
</ta:fieldset>
```
默认没有日期面板，showSelectPanel="true"显示日期
Base.submitForm("form的id")
valideNowTime="left" 有提示
valideNowTime="right" 提示选今天及以后
min="2017-12-01" 之前的日期置灰
max="201808-07-01"

textarea组件
maxLength 最大长度
minLength 最小长度
height=100px
onmouseover 鼠标移入
onmouseout 鼠标移出
<ta:textarea></ta:textarea>

button组件
hotKey alt + 字母， ctrl+s
icon="icon-edit" isShowIcon="true"
asToolBar
returnType reset

buttonGroup 要和selectBuuton混用，圆角边
button,sumbit,selectButton
button,sumbit混用可以
align center/lest/right 页面的位置
columnWidth 百分比
<ta:buttonGroup id="btngrp1">
  <ta:button id="btn11" key="btn11" icon="icon-save" isShowIcon="true"></ta:button>
  <ta:button id="btn12" key="btn12"></ta:button>
</ta:buttonGroup>
buttonLayou 圆角边
<ta:buttonLayout id="btngrp1">
  <ta:button id="btn11" key="btn11"></ta:button>
  <ta:button id="btn12" key="btn12"></ta:button>
</ta:buttonGroup>
显示图标
<ta:button id="btn11" key="btn11" icon="icon-save" isShowIcon="true"></ta:button>
asToolBarItem="true" 买有边框
hotkey="ctrl+a"
hotkey="a" alt + a
isok="true" 红色，确认框
**type="resetPage" 刷新整个页面**

selectButton
hotKey、icon、
```sql
<ta:buttonLayout id="btn11">
<ta:selectButton id="btn222" key="地区">
  <ta:selectButtonItem key="成都"></ta:selectButtonItem>
  <ta:selectButtonItem key="重庆"></ta:selectButtonItem>
</ta:selectButton>
</ta:selectButton>
```
宽高

Base.setDate(map, boolean = true);

下拉列表
<ta:fieldset id="fist1"></ta:fieldset>

datagrid
labelStyle 标签
cssInput 输入文本

给下拉树设置
```java
setData("treeId", "id,name");
```
```javascript
Base.setValue("treeId", "id,name")
```

js
* getObj 对象
* getIdCardGender 获取身份证的性别
```html
<ta:checkoutboxgroup id="">
  <ta:checkbox></ta:checkbox>
  <ta:checkbox></ta:checkbox>
  <ta:checkbox></ta:checkbox>
</ta:checkoutboxgroup>
<script>
   
</script>
```
* 没有选中value值是空，没设置是on
Base.getValue()

* 获取标签Label
Base.getFieldLabel("id");

* 获取身份证的出生日期
var idcard = Base.getValue("txtIdcard");
Base.alert(Base.getIdCardBirthday(idcard));

* 设置标签值
setFieldLabel

* 设置值，json对象
setValue({"txt1":"张三","txt2":"行政"});

* 设置组件的标签
Base.setFieldLabel("txt", "名字")

* 聚焦, 首次进入把焦点放在框上
focus
```html
Base.focus('id');
```

* resetForm 重置表单填入信息,页面初始状态

* hideObj 隐藏
Base.hideObj("num1,num2", true) 要占位
Base.hideObj("num1,num2")不占位，向前移

* clearData 清楚数据
Base.cearData("text1,text2")

js事件，交互
click focus blur change...
onClick="fn1();fn2()"
function fn1() {
*  Base.submit("id", url)
}
dto.getAsString("id");

*  三个参数json Base.submit("id", url, parameter)
parameter -> {key: value}
parameter -> {'dto.x': 100, 'dto.y': 200}
Base.submit("id", url, {'dto.x': 100, 'dto.y': 200})

*  四个参数回调函数，只写韩树明 json Base.submit("id", url, parameter, fnreturn)
```javascript
function fnreturn() {
  return true;
}
```
可以阻止提交

*  五个参数回调函数，只写韩树明 json Base.submit("id", url, parameter, fnreturn, 自动验证boolean)

> * tree js调整

> * tab js调整

> * panel js调整

> * checkbox js调整
默认选中 Base.setValue("id", "on")

selectInput
onselect 回调函数，获取值

loadSelectInputData
后端 writeJsonToClient(); return null;

> * datagrid js调整
getGridSelectedRows(gridid); 获取选中行的json格式数据
submitGridAllData(grdid, url, submitIds) 提交表格
clearGridDirty(grdid) 清楚分页渲染的脏数据
setGridCellData(gridId, row, cell, data)

> * window js
Base.alert("message")
Base.alert("message", type) type => error, warn, success
无阻塞
block
Base.alet("message", type, function回调)
msgTopTip(message)
msgTopTip(message, time)
msgTopTip(message, time, width, height, style)
openWindow
confirm

> * ibatis: config, sql -> spring-ibatis.xml -> app
> * springServer

> * sqlMapConfig
```sqlMapConfig-xxx.xml
<sqlMapConfigi
    userName
></sqlMapConfig>
```

<sqlMap namespace="不重名">
  <select id="queryAllEmp" resultClass="java.util.HashMap">
      select e.empno,
  e.ename as ename,
  to_char(e.hiredatei, 'yyyy-mm-dd') as hiredate
  from emp e;
  </select>
</sqlMap>

不写这个会dao空
```spring-ibatis.xml
<bean id="sqlMapClient" class="org.springframework.orm.ibatis.SqlMapConfig">
    <property>
</bean>
```

解决Oracle乱码
```sql
select userenv('language') from dual;
```
sql语句查询出来的值，设置为环境变量的value
设置环境变量
NLS_LANG SIMPLIFIED CHINESE_CHINA.AL32UTF8
