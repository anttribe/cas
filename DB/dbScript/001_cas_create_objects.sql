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
   id                   bigint not null auto_increment comment '编号',
   name                 varchar(128) not null comment '分类名称',
   parent               varchar(32) comment '父分类',
   tree_code            varchar(64) comment '树节点标记',
   create_time          datetime comment '创建时间',
   ordinal              int comment '顺序, 值越大, 排序越靠前',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分类信息表';

/*==============================================================*/
/* Table: cas_t_core_content                                    */
/*==============================================================*/
create table cas_t_core_content
(
   id                   bigint not null auto_increment comment 'id编号',
   link                 varchar(512) comment '原链接',
   content_type         bigint not null comment '内容类型',
   create_time          datetime comment '创建时间',
   website              bigint comment '所属站点',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容信息表';

/*==============================================================*/
/* Table: cas_t_core_content_attr                               */
/*==============================================================*/
create table cas_t_core_content_attr
(
   id                   bigint not null auto_increment comment 'id编号',
   name                 varchar(128) not null comment '属性名',
   attr_value_type      varchar(128) comment '属性值类型',
   content_type         bigint not null comment '内容类型',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容属性表';

/*==============================================================*/
/* Table: cas_t_core_content_attr_value                         */
/*==============================================================*/
create table cas_t_core_content_attr_value
(
   id                   bigint not null auto_increment comment 'id编号',
   content              bigint not null comment '所属内容',
   attr_value           longtext comment '属性值',
   content_attr         bigint not null comment '属性',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容属性值';

/*==============================================================*/
/* Table: cas_t_core_content_type                               */
/*==============================================================*/
create table cas_t_core_content_type
(
   id                   bigint not null auto_increment comment 'id编号',
   name                 varchar(64) not null comment '类型名称',
   code                 varchar(32) not null comment '类型code',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='内容类型表';

/*==============================================================*/
/* Table: cas_t_core_crawler                                    */
/*==============================================================*/
create table cas_t_core_crawler
(
   id                   bigint not null auto_increment comment 'id编号',
   title                varchar(128) comment '名称，描述性文字',
   website              bigint not null comment '所属站点',
   interval_time        int comment '处理2个page之间的间隔时间',
   retry_times          int comment '处理失败之后的重复次数',
   timeout              int comment '超时时长',
   content_type         bigint not null comment '内容类型',
   create_time          datetime comment '创建时间',
   crawl_time           datetime comment '最近一次爬取数据时间',
   state                varchar(32) comment '状态',
   available            varchar(8) comment '是否可用',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='爬虫信息表';

/*==============================================================*/
/* Table: cas_t_core_crawler_regular                            */
/*==============================================================*/
create table cas_t_core_crawler_regular
(
   id                   bigint not null auto_increment comment 'id编号',
   crawler              bigint not null comment '所属爬虫',
   attr_regular         varchar(256) comment '属性规则',
   content_attr         bigint not null comment '内容属性',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='爬虫内容属性规则';

/*==============================================================*/
/* Table: cas_t_core_website                                    */
/*==============================================================*/
create table cas_t_core_website
(
   id                   bigint not null auto_increment comment '编号',
   site_name            varchar(128) not null comment '站点名称',
   domain               varchar(512) comment '网站域名',
   logo                 varchar(64) comment '图标',
   charset              varchar(16) comment '字符集',
   user_agent           varchar(128) comment '用户代理',
   category_id          varchar(32) comment '站点所属分类',
   create_time          datetime comment '创建时间',
   primary key (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='站点信息表';

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

