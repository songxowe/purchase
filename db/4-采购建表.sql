
/*==============================================================*/
/* Table: CONTRACT                                              */
/*==============================================================*/
create table CONTRACT (
   ID                   number               not null,
   CONT_NUM             varchar2(20)           ,
   BUYER                varchar2(50)           ,
   SELLER               varchar2(50)           ,
   SUPPLIER_NUM         varchar2(20)           ,
   CONT_DATE            date              ,
   CONT_TYPE            varchar2(10)           ,
   STOCK_TYPE           varchar2(10)           ,
   CONT_ITEM            varchar2(50)           ,
   MONEY                varchar2(20)           ,
   TAX_RATE             varchar2(10)           ,
   WRAP_BACK            varchar2(50)           ,
   VERIFY_STAND         varchar2(50)           ,
   TRAN                 varchar2(50)           ,
   PAY_COND             varchar2(50)           ,
   VERIFY_DATE          date              ,
   QUALITY_STAND        varchar2(50)          ,
   STANDARD_NO          varchar2(50)           ,
   PLACE                varchar2(50)           ,
   CONT_PRICE           number(10,2)         ,
   TRANSPORT            varchar2(50)           ,
   PAY_WAY              varchar2(50)           ,
   OUT_PERM             varchar2(10)           ,
   OUT_DAY              varchar2(10)           ,
   WRAP_REQUIRE         varchar2(50)           ,
   REMARK               varchar2(400)          ,
   constraint PK_CONTRACT primary key  (ID)
);
 

/*==============================================================*/
/* Table: CONTRACT_APPLY                                        */
/*==============================================================*/
create table CONTRACT_APPLY (
   ID                   number               not null,
   CONT_APP_NUM         varchar2(20)           ,
   STAT_QUOTE           varchar2(10)           ,
   TOP_QUOTE            varchar2(10)           ,
   LOW_QUOTE            varchar2(10)           ,
   ALL_SUM_PRICE        number(12,2)         ,
   REMARK               varchar2(200)          ,
   AUTHOR_ID            varchar2(20)           ,
   AUTHOR               varchar2(20)           ,
   PLANER_ID            varchar2(20)           ,
   PLANER               varchar2(20)           ,
   PLAN_AGREE           varchar2(10)           ,
   PLAN_OPINION         varchar2(400)          ,
   PLAN_DATE            date              ,
   LEADER_ID            varchar2(20)           ,
   LEADER               varchar2(20)           ,
   LEAD_AGREE           varchar2(10)           ,
   LEAD_OPINION         varchar2(400)          ,
   LEAD_DATE            date              ,
   constraint PK_CONTRACT_APPLY primary key  (ID)
);
 

/*==============================================================*/
/* Table: CONTRACT_DETAIL                                       */
/*==============================================================*/
create table CONTRACT_DETAIL (
   ID                   number               not null,
   CONT_ID              number                ,
   MATERIAL_CODE        varchar2(20)           ,
   MATERIAL_NAME        varchar2(50)           ,
   AMOUNT               number           ,
   UNIT_PRICE           number(10,2)         ,
   MEASURE_UNIT         varchar2(10)           ,
   SUM_PRICE            number(10,2)         ,
   MIX_PRICE            number(10,2)         ,
   OTHER_PRICE          number(10,2)         ,
   TOTAL_PRICE          number(10,2)         ,
   END_DATE             varchar2(10)           ,
   ADDRESS              varchar2(400)          ,
   TRANS                 varchar2(50)           ,
   WRAP_REQUIRE         varchar2(400)          ,
   FACTORY              varchar2(400)          ,
   OTHER_REQUIRE        varchar2(200)          ,
   constraint PK_CONTRACT_DETAIL primary key  (ID)
);
 

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE (
   ID                   number               not null,
   EMP_NUM              varchar2(20)           ,
   EMP_NAME             varchar2(20)           ,
   SEX                  varchar2(10)           ,
   PHONE                varchar2(20)           ,
   FAX                  varchar2(20)           ,
   EMAIL                varchar2(50)           ,
   ZIP                  varchar2(20)           ,
   ADDRESS              varchar2(200)          ,
   USER_ID              number                ,
   constraint PK_EMPLOYEE primary key  (ID)
);
 

/*==============================================================*/
/* Table: ENQUIRE                                               */
/*==============================================================*/
create table ENQUIRE (
   ID                   number               not null,
   ENQUIRE_NUM          varchar2(20)           ,
   ENQUIRE_NAME         varchar2(50)           ,
   BUILD_DATE			date					,
   COMPANY              varchar2(50)           ,
   LINKMAN              varchar2(20)           ,
   ADDRESS              varchar2(400)          ,
   PHONE                varchar2(20)           ,
   FAX                  varchar2(20)           ,
   ZIP                  varchar2(20)           ,
   EMAIL                varchar2(50)           ,
   END_DATE             date              ,
   REMARK               varchar2(200)          ,
   constraint PK_ENQUIRE primary key  (ID)
);
 

/*==============================================================*/
/* Table: ENQUIRE_DETAIL                                        */
/*==============================================================*/
create table ENQUIRE_DETAIL (
   ID                   number               not null,
   ENQUIRE_ID           number                ,
   ORDER_ID             number                ,
   MATERIAL_CODE        varchar2(20)           ,
   MATERIAL_NAME        varchar2(50)           ,
   AMOUNT               number           ,
   MEASURE_UNIT         varchar2(10)           ,
   START_DATE           date              ,
   END_DATE             date              ,
   STANDARD             varchar2(20)           ,
   FACTORY              varchar2(50)           ,
   PROD_YEAR            varchar2(20)           ,
   WRAP                 varchar2(50)           ,
   REMARK               varchar2(400)          ,
   constraint PK_ENQUIRE_DETAIL primary key  (ID)
);
 

/*==============================================================*/
/* Table: ID_MAPPING                                            */
/*==============================================================*/
create table ID_MAPPING (
   ID                   number               not null,
   ORDER_ID             number                ,
   STOCK_ID             number                ,
   ENQUIRE_ID           number                ,
   CONT_APP_ID          number                ,
   QUOTE_ID             number                ,
   CONT_ID              number                ,
   STATUS               varchar2(10)           ,
   constraint PK_ID_MAPPING primary key  (ID)
);
 

/*==============================================================*/
/* Table: MATERIAL                                              */
/*==============================================================*/
create table MATERIAL (
   ID                   number               not null,
   MATERIAL_NUM         varchar2(20)           ,
   MATERIAL_NAME        varchar2(50)           ,
   MATERIAL_UNIT        varchar2(10)           ,
   MATERIAL_TYPE        varchar2(10)           ,
   constraint PK_MATERIAL primary key  (ID)
);
 

/*==============================================================*/
/* Table: ORDERS                                                */
/*==============================================================*/
create table ORDERS (
   ID                   number               not null,
   ORDER_NUM            varchar2(20)           ,
   ORDER_SOURCE         varchar2(20)           ,
   BUILD_DATE			date					,
   MATERIAL_CODE        varchar2(20)           ,
   MATERIAL_NAME        varchar2(50)           ,
   AMOUNT               number           ,
   MEASURE_UNIT         varchar2(10)           ,
   UNIT_PRICE           number(10,2)         ,
   SUM_PRICE            number(10,2)         ,
   START_DATE           date              ,
   END_DATE             date              ,
   ADDRESS              varchar2(400)          ,
   AUTHOR_ID            varchar2(20)           ,
   AUTHOR               varchar2(20)           ,
   PHONE                varchar2(20)           ,
   FAX                  varchar2(20)           ,
   EMAIL                varchar2(50)           ,
   REMARK               varchar2(200)          ,
   constraint PK_ORDERS primary key  (ID)
);
 

/*==============================================================*/
/* Table: QUOTE                                                 */
/*==============================================================*/
create table QUOTE (
   ID                   number               not null,
   QUOTE_NUM            varchar2(20)           ,
   ENQUIRE_ID           number                ,
   SUPPLIER_ID          number                ,
   QUO_COMPANY          varchar2(50)           ,
   QUO_ADDRESS          varchar2(400)          ,
   QUO_LINKMAN          varchar2(20)           ,
   QUO_PHONE            varchar2(20)           ,
   QUO_FAX              varchar2(20)           ,
   QUO_EMAIL            varchar2(50)           ,
   QUE_TITLE            varchar2(50)           ,
   QUE_DATE             date              ,
   END_DATE             date              ,
   SUM_AMOUNT           number(10,2)         ,
   OVERALL_PRICE        number(10,2)         ,
   QUO_REMARK           varchar2(400)          ,
   STATUS               varchar2(10)           ,
   constraint PK_QUOTE primary key  (ID)
);
 

/*==============================================================*/
/* Table: QUOTE_DETAIL                                          */
/*==============================================================*/
create table QUOTE_DETAIL (
   ID                   number               not null,
   QUOTE_ID             number                ,
   ORDER_ID             number                ,
   MATERIAL_CODE        varchar2(20)           ,
   MATERIAL_NAME        varchar2(50)           ,
   MEASURE_UNIT         varchar2(10)           ,
   STANDARD             varchar2(20)           ,
   FACTORY              varchar2(50)           ,
   PROD_YEAR            varchar2(10)           ,
   WRAP                 varchar2(20)           ,
   AMOUNT               number           ,
   UNIT_PRICE           number(10,2)         ,
   SUM_PRICE            number(10,2)         ,
   MIX_PRICE            number(10,2)         ,
   OTHER_PRICE          number(10,2)         ,
   TOTAL_PRICE          number(10,2)         ,
   START_DATE           date              ,
   END_DATE             date              ,
   constraint PK_QUOTE_DETAIL primary key  (ID)
);
 

/*==============================================================*/
/* Table: STOCK                                                 */
/*==============================================================*/
create table STOCK (
   ID                   number               not null,
   STOCK_NUM            varchar2(20)           ,
   STOCK_NAME           varchar2(50)           ,
   BUILD_DATE			date					,
   AUTHOR_ID            varchar2(20)           ,
   AUTHOR               varchar2(20)           ,
   STOCK_TYPE           varchar2(20)           ,
   BUDGET               number(10,2)         ,
   START_DATE           date              ,
   END_DATE             date              ,
   SUBMIT_DATE          date              ,
   REMARK               varchar2(400)          ,
   LEADER_ID            varchar2(20)           ,
   LEADER               varchar2(20)           ,
   LEAD_AGREE           varchar2(10)           ,
   LEAD_OPINION         varchar2(400)          ,
   LEAD_DATE            date              ,
   constraint PK_STOCK primary key  (ID)
);
 

/*==============================================================*/
/* Table: STOCK_SUPPLIER                                        */
/*==============================================================*/
create table STOCK_SUPPLIER (
   STOCK_ID             number                ,
   SUPPLIER_ID          number                
);
 

/*==============================================================*/
/* Table: SUPPLIER                                              */
/*==============================================================*/
create table SUPPLIER (
   ID                   number               not null,
   SUPPLIER_NUM         varchar2(20)           ,
   CERTIFICATE          varchar2(20)           ,
   COMPANY              varchar2(50)           ,
   KIND                 varchar2(20)           ,
   CONTACT              varchar2(20)           ,
   PHONE                varchar2(20)           ,
   FAX                  varchar2(20)           ,
   EMAIL                varchar2(50)           ,
   ADDRESS              varchar2(200)          ,
   ZIP                  varchar2(20)           ,
   REG_FUND             varchar2(20)           ,
   CORPORATION          varchar2(20)           ,
   ACHIEVEMENT          number                ,
   STATUS               varchar2(10)           ,
   USER_ID              number                ,
   constraint PK_SUPPLIER primary key  (ID)
);
 

/*==============================================================*/
/* Table: SUPP_MATERIAL                                         */
/*==============================================================*/
create table SUPP_MATERIAL (
   SUPPLIER_ID          number                ,
   MATERIAL_ID          number                
);
 
 

alter table CONTRACT_DETAIL
   add constraint FK_CONTRACT_REFERENCE_CONTRACT foreign key (CONT_ID)
      references CONTRACT (ID);
 

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_REFERENCE_SYS_USER foreign key (USER_ID)
      references SYS_USERS (ID);
 

alter table ENQUIRE_DETAIL
   add constraint FK_ENQUIRE__REFERENCE_ORDERS foreign key (ORDER_ID)
      references ORDERS (ID);
 

alter table ENQUIRE_DETAIL
   add constraint FK_ENQUIRE__REFERENCE_ENQUIRE foreign key (ENQUIRE_ID)
      references ENQUIRE (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI_REFERENCE_ORDERS foreign key (ORDER_ID)
      references ORDERS (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI_REFERENCE_CONTRACT foreign key (CONT_ID)
      references CONTRACT (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI1 foreign key (CONT_APP_ID)
      references CONTRACT_APPLY (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI_REFERENCE_STOCK foreign key (STOCK_ID)
      references STOCK (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI_REFERENCE_ENQUIRE foreign key (ENQUIRE_ID)
      references ENQUIRE (ID);
 

alter table ID_MAPPING
   add constraint FK_ID_MAPPI_REFERENCE_QUOTE foreign key (QUOTE_ID)
      references QUOTE (ID);
 

alter table QUOTE
   add constraint FK_QUOTE_REFERENCE_ENQUIRE foreign key (ENQUIRE_ID)
      references ENQUIRE (ID);
 

alter table QUOTE
   add constraint FK_QUOTE_REFERENCE_SUPPLIER foreign key (SUPPLIER_ID)
      references SUPPLIER (ID);
 

alter table QUOTE_DETAIL
   add constraint FK_QUOTE_DE_REFERENCE_QUOTE foreign key (QUOTE_ID)
      references QUOTE (ID);
 

alter table QUOTE_DETAIL
   add constraint FK_QUOTE_DE_REFERENCE_ORDERS foreign key (ORDER_ID)
      references ORDERS (ID);
 

alter table STOCK_SUPPLIER
   add constraint FK_STOCK_SU_REFERENCE_STOCK foreign key (STOCK_ID)
      references STOCK (ID);
 

alter table STOCK_SUPPLIER
   add constraint FK_STOCK_SU_REFERENCE_SUPPLIER foreign key (SUPPLIER_ID)
      references SUPPLIER (ID);
 

alter table SUPPLIER
   add constraint FK_SUPPLIER_REFERENCE_SYS_USER foreign key (USER_ID)
      references SYS_USERS (ID);
 

alter table SUPP_MATERIAL
   add constraint FK_SUPP_MAT_REFERENCE_SUPPLIER foreign key (SUPPLIER_ID)
      references SUPPLIER (ID);
 

alter table SUPP_MATERIAL
   add constraint FK_SUPP_MAT_REFERENCE_MATERIAL foreign key (MATERIAL_ID)
      references MATERIAL (ID);
 

