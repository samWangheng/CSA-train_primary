public class homework_4 {
//    1.mysql> create table cqupt_student(
//    -> studentid varchar(10),
//    -> name Varchar(20),
//    -> sex varchar(2),
//    -> age integer,
//    -> fee decimal(10,2),
//    -> address varchar(50),
//    -> memo varchar(300));
//    Query OK, 0 rows affected (0.09 sec)
//
//2.mysql> create table courseaa(
//    -> aa1 varchar(20),
//    -> aa2 integer,
//    -> aa3 decimal(10));
//    Query OK, 0 rows affected (0.09 sec)
//
//3.mysql> create table choosebb(
//    -> bb1 varchar(30),
//    -> bb2 integer,
//    -> bb3 decimal(6));
//    Query OK, 0 rows affected (0.08 sec)
//
//4.ALTER TABLE choosebb
//    ADD bb4 VARCHAR(20) NOT NULL DEFAULT '系统测试值';
//
//5.ALTER TABLE choosebb
//    ADD bb5 VARCHAR(10),
//    ADD PRIMARY KEY (bb5);
//
//6.CREATE VIEW View_Choosebb AS
//    SELECT Bb1 AS View_bb1, Bb4 AS View_bb2, Bb5 AS View_bb3
//    FROM ChooseBb;
//
//7.drop view view_choosebb;
//
//8.CREATE INDEX Index_bb2 ON ChooseBb (Bb2 ASC);
//    CREATE INDEX Index_bb4 ON ChooseBb (Bb4 DESC);
//
//9.DROP INDEX Index_bb2 ON ChooseBb;
//
//10.insert into test values ('赵一',20,580.00,'重邮宿舍12-3-5'),
//('钱二',19,540.00,'南福苑5-2-9'),
//        ('孙三',21,555.00,'学生新区21-5-15'),
//        ('李四',22,505.00,'重邮宿舍8-6-22'),
//        ('周五',20,495.50,'学生新区23-4-8'),
//        ('吴六',19,435.00,'南福苑2-5-12');
//
//11.mysql> insert into test_temp values ('郑七',21,490.50,'重邮宿舍11-2-1'),
//    -> ('张八',20,560.00,'南福苑3-3-3'),
//            -> ('王九',10,515.00,'学生新区19-7-1');
//
//    mysql> insert into test select * from test_temp;
//
//    mysql> update test set age=age+5 where age<20;
//
//    mysql> update test set age=age-1 where address like '南福苑%';
//
//    mysql> delete from test where age>21 && score>=500;
//
//    mysql> delete from test where score<550 && address like '重邮宿舍%';
//
//    mysql> create table student(
//    -> sno varchar(20),
//    -> name varchar(10),
//    -> age integer,
//    -> college varchar(30));
//    Query OK, 0 rows affected (0.08 sec)
//
//    mysql> create table course(
//    -> courseid varchar(15),
//    -> coursename varchar(30),
//    -> coursebeforeid varchar(15));
//    Query OK, 0 rows affected (0.10 sec)
//
//    mysql> create table choose(
//    -> sno varchar(20),
//    -> courseid varchar(30),
//    -> score decimal(5,2));
//    Query OK, 0 rows affected (0.10 sec)
//
//    mysql> insert into student values ('S00001','张三',20,'计算机学院'),
//    -> ('S00002','李四',19,'通信学院'),
//            -> ('S00003','王五',21,'计算机学院');
//
//
//    mysql> insert into course values ('C1','计算机引论',null),
//    -> ('C2','C语言','C1'),
//            -> ('C3','数据结构','C2');
//    select sno,name from student where college='计算机学院';
//    select * from student where age between 20 and 23;
//    select count(name) from student;
//
//    mysql> select count(name) from student;
//+-------------+
//        | count(name) |
//            +-------------+
//            |           3 |
//            +-------------+
//            1 row in set (0.00 sec)
//
//    mysql> select max(score) from choose;
//+------------+
//        | max(score) |
//            +------------+
//            |      95.00 |
//            +------------+
//            1 row in set (0.00 sec)
//
//    mysql> select min(score) from choose;
//+------------+
//        | min(score) |
//            +------------+
//            |      70.00 |
//            +------------+
//            1 row in set (0.00 sec)
//
//    mysql> select sum(score) from choose;
//+------------+
//        | sum(score) |
//            +------------+
//            |     572.00 |
//            +------------+
//            1 row in set (0.00 sec)
//
//    mysql> select avg(score) from choose;
//+------------+
//        | avg(score) |
//            +------------+
//            |  81.714286 |
//            +------------+
//            1 row in set (0.00 sec)
//
//    select courseid,coursename from course where coursebeforeid is null;
//
//    select a.sno,name,coursename,score from (select sno,choose.courseid,score,coursename,coursebeforeid from choose left join course on choose.courseid=course.courseid) as a left join student b on a.sno=b.sno;
//
//    select * from student where exists (select name from student where name!='张三') and name !='张三' && college='计算机学院';
//
//    select sno,score from choose where courseid='C1' && score in (select score from choose where sno=(select sno from student where name = '张三'));
//
//    mysql> select sno from choose where courseid='C1'
//    -> union
//    -> select sno from choose where courseid='C3';
//    mysql> select  distinct sno from choose where courseid='C1'
//            -> union
//    -> select  distinct sno from choose where courseid='C3';
//
//
//

}
