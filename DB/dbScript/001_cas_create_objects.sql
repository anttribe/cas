/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/4 15:45:29                            */
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
   create_time          datetime comment '����ʱ��',
   ordinal              int comment '˳��, ֵԽ��, ����Խ��ǰ',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

/*==============================================================*/
/* Table: cas_t_core_content                                    */
/*==============================================================*/
create table cas_t_core_content
(
   id                   bigint not null auto_increment comment 'id���',
   link                 varchar(512) comment 'ԭ����',
   content_type         bigint not null comment '��������',
   create_time          datetime comment '����ʱ��',
   website              bigint comment '����վ��',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������Ա�';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��������ֵ';

/*==============================================================*/
/* Table: cas_t_core_content_type                               */
/*==============================================================*/
create table cas_t_core_content_type
(
   id                   bigint not null auto_increment comment 'id���',
   name                 varchar(64) not null comment '��������',
   code                 varchar(32) not null comment '����code',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�������ͱ�';

/*==============================================================*/
/* Table: cas_t_core_crawler                                    */
/*==============================================================*/
create table cas_t_core_crawler
(
   id                   bigint not null auto_increment comment 'id���',
   title                varchar(128) comment '���ƣ�����������',
   website              bigint not null comment '����վ��',
   interval_time        int comment '����2��page֮��ļ��ʱ��',
   retry_times          int comment '����ʧ��֮����ظ�����',
   timeout              int comment '��ʱʱ��',
   content_type         bigint not null comment '��������',
   create_time          datetime comment '����ʱ��',
   crawl_time           datetime comment '���һ����ȡ����ʱ��',
   state                varchar(32) comment '״̬',
   available            varchar(8) comment '�Ƿ����',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����������Թ���';

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='վ����Ϣ��';

alter table cas_t_core_content add constraint FK_Reference_6 foreign key (content_type)
      references cas_t_core_content_type (id) on delete restrict on update restrict;

alter table cas_t_core_content_attr add constraint FK_Reference_3 foreign key (content_type)
      references cas_t_core_content_type (id) on delete restrict on update restrict;

alter table cas_t_core_content_attr_value add constraint FK_content_value_refer_content foreign key (content)
      references cas_t_core_content (id) on delete restrict on update restrict;

alter table cas_t_core_crawler add constraint FK_Reference_4 foreign key (content_type)
      references cas_t_core_content_type (id) on delete restrict on update restrict;

alter table cas_t_core_crawler add constraint FK_Reference_5 foreign key (website)
      references cas_t_core_website (id) on delete restrict on update restrict;

alter table cas_t_core_crawler_regular add constraint FK_crawler_attr_regular foreign key (crawler)
      references cas_t_core_crawler (id) on delete restrict on update restrict;

