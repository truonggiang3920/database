CREATE SCHEMA IF NOT EXISTS student_cms_plusplus DEFAULT CHARACTER SET utf8mb4;
USE student_cms_plusplus;
CREATE TABLE IF NOT EXISTS student (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR (45) NOT NULL,
mssv VARCHAR (20),
password VARCHAR  (20),
phone VARCHAR  (20),
address VARCHAR  (50),
age INT,
email VARCHAR  (20),
created_timstamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
last_updated_timestamp TIMESTAMP
);
CREATE TABLE IF NOT EXISTS class (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR (45) NOT NULL,
major VARCHAR (20),
total_student VARCHAR (20),
teacher_name VARCHAR (45),
teacher_phone VARCHAR (20),
created_timstamp timestamp default current_timestamp,
last_updated_timestamp timestamp
);
CREATE TABLE IF NOT EXISTS student_class (
student_id INT,
class_id INT
)