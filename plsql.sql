DECLARE
  CURSOR mycur(pdeptno NUMBER)
  IS
    SELECT *
    FROM   emp
    WHERE  deptno=pdeptno;

BEGIN
  dno := &dno;
  FOR empinfo IN mycur(dno)
  LOOP
    dbms_output.Put_line(empinfo);
  END  LOOP;
END;

CREATE SEQUENCE seq_2
  INCREMENT BY 1
  START WITH 1000
  MAXVALUE 9000
  CYCLE;
