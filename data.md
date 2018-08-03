小版本一致
1. 使用exp导出scott用户的所有数据库对象，新建用户testscott,
将scott的所有数据库对象使用imp命令导入到testscott.
> * 命令，不进入数据库, 导出数据库命令
```terminal
exp scott/tiger@orcl file=d:\dmp\scott.dmp log=d:\dmp\scott.txt 
```

> * 授权
Connect as SYSTEM.

```sql
CREATE USER username IDENTIFIED BY apassword;

GRANT CONNECT TO username;

GRANT EXECUTE on schema.procedure TO username;
```
You may also need to:

授权
```sql
GRANT SELECT [, INSERT] [, UPDATE] [, DELETE] on schema.table TO username;
```
to whichever tables the procedure uses.

* 创建用户并授权
```sql
grant dba to testscott2;
grant select any table to testscott2;
grant unlimited tablespace to testscott2;
grant update any table to testscott2;
grant execute on dbms_session to testscott2;
grant execute on DBMS_PIPE to testscott2;
grant execute on dbms_lock to testscott2;
--授予dba权限 
grant connect,resource,dba to testscott2;
```

> * 恢复数据

```sql
imp testscott/testscott@orcl file=d:/dump/scott.dmp full=y
```
实例名要先创建

将cmd页面使用utf-8
> * chcp 65001
> * which will change the code page to UTF-8. Also, you need to use Lucida console fonts.
sqlPlus好看的输出
```sql
set linesize 30000
set wrap off
```

> * 使用expdb.exe 导出
D:\app\79001\product\11.2.0\dbhome_2\BIN

> * expdp
创建directory
先有目录 连接数据库
sqlplus / as sysdba
```sql
-- 查询directories
select * from dba_directories
-- 创建directory
create directory dir_scott as 'D:/dump';
-- 授权
grant read,write on DIRECTORY dir_scott to scott;
grant datapump_exp_full_database to scott;
-- 导出
expdp scott/tiger@orcl directory=dir_scott dumpfile=scott.dmp logfile=scott.logp full=yes;
```

> * impdp
```sql
-- 导入
-- 導入數據庫
impdp testscott2/testscott directory=dir_scott logfile=scott_impdp.log dumpfile=scott2.dmp  remap_schema=scott:testscott2
```

> * 执行计划
set autotrace on
set autotrace traceonly
