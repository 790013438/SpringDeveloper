存储过程
```sql
CREATE PROCEDURE update_sal(p_dept_id NUMBER,
                            p_amount  NUMBER)
IS
BEGIN
END

CREATE PROCEDURE update_sal(p_dept_id NUMBER,
                            p_amount  NUMBER)
IS
  DECLARE   --可选
    -- Variables,cursors,user-defined exceptions
  BEGIN     --强制
    -- sql语句
    -- plsql语句
  EXCEPTION -- 可选
    -- 当错误出现时采取必要措施
  END       -- 强制

-- anonymous
DECLARE   --可选
  -- Variables,cursors,user-defined exceptions
BEGIN     --强制
  -- sql语句
  -- plsql语句
EXCEPTION -- 可选
  -- 当错误出现时采取必要措施
END       -- 强制

-- Procedure
PROCEDURE name
IS
BEGIN
  -- statements
EXCEPTION
END

-- 函数
FUNCTION name
  RETURN DATATYPE
IS
BEGIN
  -- statements
  RETURN value;
EXCEPTION
END
```

# PLSql

| 问题 | 笔记 |
| :-:  | :-:  |
|      | 小结 |

| 问题 | anonymous block(匿名块)和subprograms(子程序)的区别 |
| :-:  |                        :-:                         |
|      |                        小结                        |


|       匿名       | 子程序 |
|       :-:        |  :-:   |
|     没有名字     | 有名字 |
| 不能调用其他函数 |  可以  |
|   不能有返回值   |  可以  |
