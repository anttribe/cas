/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/3/9 14:51:35                            */
/*==============================================================*/


drop table if exists cas_t_core_category;

drop table if exists cas_t_core_content;

drop table if exists cas_t_core_content_attr;

drop table if exists cas_t_core_content_attr_value;

drop table if exists cas_t_core_content_type;

drop table if exists cas_t_core_crawler;

drop table if exists cas_t_core_crawler_regular;

drop table if exists cas_t_core_website;

/*==============================================================*/
/* Table: cas_t_core_category                                   */
/*==============================================================*/
create table cas_t_core_category
(
   id                   bigint not null auto_increment comment '���',
   name                 varchar(128) not null comment '��������',
   parent               varchar(32) comment '������',
   tree_code            varchar(64) comment '���ڵ���',
   sort_no              int comment '˳��',
   remarks              varchar(256) comment '��ע',
   create_time          datetime comment '����ʱ��',
   primary key (id)
);

alter table cas_t_core_category comment '������Ϣ��';

/*==============================================================*/
/* Table: cas_t_core_content                                    */
/*==============================================================*/
create table cas_t_core_content
(
   id                   bigint not null auto_increment comment 'id���',
   link                 varchar(512) comment 'ԭ����',
   create_time          datetime comment '����ʱ��',
   website              bigint comment '����վ��',
   content_type         varchar(16) comment '��������',
   primary key (id)
);

alter table cas_t_core_content comment '������Ϣ��';

/*==============================================================*/
/* Table: cas_t_core_content_attr                               */
/*==============================================================*/
create table cas_t_core_content_attr
(
   id                   bigint not null auto_increment comment 'id���',
   name                 varchar(128) not null comment '������',
   attr_value_type      varchar(128) comment '����ֵ����',
   content_type         bigint not null comment '��������',
   primary key (id)
);

alter table cas_t_core_content_attr comment '�������Ա�';

/*==============================================================*/
/* Table: cas_t_core_content_attr_value                         */
/*==============================================================*/
create table cas_t_core_content_attr_value
(
   id                   bigint not null auto_increment comment 'id���',
   content              bigint not null comment '��������',
   attr_value           longtext comment '����ֵ',
   content_attr         bigint not null comment '����',
   primary key (id)
);

alter table cas_t_core_content_attr_value comment '��������ֵ';

/*==============================================================*/
/* Table: cas_t_core_content_type                               */
/*==============================================================*/
create table cas_t_core_content_type
(
   id                   bigint not null auto_increment comment 'id���',
   name                 varchar(64) not null comment '��������',
   code                 varchar(32) not null comment '����code',
   primary key (id)
);

alter table cas_t_core_content_type comment '�������ͱ�';

/*==============================================================*/
/* Table: cas_t_core_crawler                                    */
/*==============================================================*/
create table cas_t_core_crawler
(
   id                   bigint not null auto_increment comment 'id���',
   title                varchar(128) comment '���ƣ�����������',
   website              varchar(8) comment '����վ��',
   crawler_url          varchar(512) not null comment '����url��ַ',
   content_type         varchar(16) comment '��������',
   interval_time        int comment '����2��page֮��ļ��ʱ��',
   retry_times          int comment '����ʧ��֮����ظ�����',
   timeout              int comment '��ʱʱ��',
   create_time          datetime comment '����ʱ��',
   crawl_time           datetime comment '���һ����ȡ����ʱ��',
   state                varchar(32) comment '״̬',
   available            varchar(8) comment '�Ƿ����',
   primary key (id)
);

alter table cas_t_core_crawler comment '������Ϣ��';

/*==============================================================*/
/* Table: cas_t_core_crawler_regular                            */
/*==============================================================*/
create table cas_t_core_crawler_regular
(
   id                   bigint not null auto_increment comment 'id���',
   crawler              bigint not null comment '��������',
   attr_regular         varchar(256) comment '���Թ���',
   content_attr         bigint not null comment '��������',
   primary key (id)
);

alter table cas_t_core_crawler_regular comment '�����������Թ���';

/*==============================================================*/
/* Table: cas_t_core_website                                    */
/*==============================================================*/
create table cas_t_core_website
(
   id                   bigint not null auto_increment comment '���',
   site_name            varchar(128) not null comment 'վ������',
   domain               varchar(512) comment '��վ����',
   logo                 varchar(64) comment 'ͼ��',
   charset              varchar(16) comment '�ַ���',
   user_agent           varchar(128) comment '�û�����',
   category_id          varchar(32) comment 'վ����������',
   create_time          datetime comment '����ʱ��',
   primary key (id)
);

alter table cas_t_core_website comment 'վ����Ϣ��';

alter table cas_t_core_content_attr add constraint FK_Reference_3 foreign key (content_type)
      references cas_t_core_content_type (id) on delete restrict on update restrict;

alter table cas_t_core_content_attr_value add constraint FK_content_value_refer_content foreign key (content)
      references cas_t_core_content (id) on delete restrict on update restrict;

alter table cas_t_core_crawler_regular add constraint FK_crawler_attr_regular foreign key (crawler)
      references cas_t_core_crawler (id) on delete restrict on update restrict;

