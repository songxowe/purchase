
/*==============================================================*/
/* User:使用SYS账户创建用户purchase，然后使用 purchase 账户建表                                          */
/*==============================================================*/

create user purchase identified by 123;
grant sysdba,resource,connect to purchase;
