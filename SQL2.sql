create schema if not exists student_cms_plusplus default character set utf8mb4;
use student_cms_plusplus;
create table if not exists student (
id int not null primary key auto_increment,
name varchar (45) not null,
mssv varchar (20),
password varchar (20),
phone varchar (20),
address varchar (50),
age int,
email varchar (20),
created_timstamp timestamp default current_timestamp,
last_updated_timestamp timestamp
);
create table if not exists class (
id int not null primary key auto_increment,
name varchar (45) not null,
major varchar (20),
total_student varchar (20),
teacher_name varchar (45),
teacher_phone varchar (20),
created_timstamp timestamp default current_timestamp,
last_updated_timestamp timestamp
);
create table if not exists student_class (
student_id int,
class_id int
)
