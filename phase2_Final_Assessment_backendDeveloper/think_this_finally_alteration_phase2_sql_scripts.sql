drop schema if exists brandnew;

create schema brandnew;

use brandnew;

drop table if exists classes;

create table classes(
classes_id bigint primary key not null auto_increment,
class_name varchar(255) default null,
class_student_id bigint default null,
class_subject_id bigint default null,
class_teacher_id bigint default null,
date_added timestamp default now());

drop table if exists student;

create table student(
student_id bigint primary key not null auto_increment,
first_name varchar(255) default null,
last_name varchar(255) default null,
email varchar(255) default null,
student_class_id bigint default null,
date_added timestamp default now(),
key `student_class_fk` (`student_class_id`),
constraint `student_cl_fk` foreign key (`student_class_id`) references `classes`(`classes_id`));

alter table classes
add constraint `class_student_fk` 
foreign key (`class_student_id`) references `student`(`student_id`);

drop table if exists subject;

create table subject(
subject_id bigint not null primary key auto_increment,
subject_name varchar(255) default null,
`subject_classes_id` bigint default null,
date_added timestamp default now());

drop table if exists teacher;

create table teacher(
teacher_id bigint not null primary key auto_increment,
first_name varchar(255) default null,
last_name varchar(255) default null,
email varchar(255) default null,
`teacher_class_id` bigint default null,
date_added timestamp default now(),
key teacher_class_fk (`teacher_class_id`),
constraint teacher_cl_fk foreign key (`teacher_class_id`)
references `classes`(`classes_id`));

alter table subject
add constraint subject_class_fk
foreign key (`subject_classes_id`) references `classes`(`classes_id`);

alter table classes
add constraint `class_teacher_fk` 
foreign key (`class_teacher_id`) references `teacher`(`teacher_id`);

alter table classes
add constraint `class_subject_fk` 
foreign key (`class_subject_id`) references `subject`(`subject_id`);
