/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/11/26 星期一 下午 3:54:05                    */
/*==============================================================*/


drop table if exists drug_admin;

drop table if exists drug_admin_role;

drop table if exists drug_audit;

drop table if exists drug_branch_sale;

drop table if exists drug_branch_sale_detail;

drop table if exists drug_buy;

drop table if exists drug_buy_detail;

drop table if exists drug_company;

drop table if exists drug_debty;

drop table if exists drug_debty_detail;

drop table if exists drug_drug;

drop table if exists drug_drug_inv;

drop table if exists drug_drug_inv_detail;

drop table if exists drug_drug_type;

drop table if exists drug_mat_inv;

drop table if exists drug_mat_inv_detail;

drop table if exists drug_mat_type;

drop table if exists drug_material;

drop table if exists drug_material_list;

drop table if exists drug_member;

drop table if exists drug_module;

drop table if exists drug_module_role;

drop table if exists drug_mrp;

drop table if exists drug_pmc;

drop table if exists drug_pmc_details;

drop table if exists drug_provider;

drop table if exists drug_qc;

drop table if exists drug_qc_detail;

drop table if exists drug_role;

drop table if exists drug_sale;

drop table if exists drug_sale_detail;

drop table if exists drug_spec;

drop table if exists drug_wholesale;

drop table if exists drug_wholesale_detail;

/*==============================================================*/
/* Table: drug_admin                                            */
/*==============================================================*/
create table drug_admin
(
   admin_id             varchar(100) not null comment '管理员编号',
   com_id            varchar(100) comment '站点编号',
   admin_name           varchar(100) comment '昵称',
   admin_pwd            varchar(50) comment '密码',
   admin_pictrue        varchar(300) comment '头像',
   admin_msg            varchar(500) comment '备注',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (admin_id)
);

alter table drug_admin comment '后台登陆管理员';

/*==============================================================*/
/* Table: drug_admin_role                                       */
/*==============================================================*/
create table drug_admin_role
(
   ar_id                varchar(100) not null comment '管理员角色编号',
   admin_id             varchar(100) comment '管理员编号',
   role_id              varchar(100) comment '角色编号',
   primary key (ar_id)
);

alter table drug_admin_role comment '管理员角色表';

/*==============================================================*/
/* Table: drug_audit                                            */
/*==============================================================*/
create table drug_audit
(
   aud_id               varchar(100) not null comment '审核编号',
   aud_fk_id            varchar(100) comment '业务编号',
   aud_comtype          varchar(50) comment '厂家（0总公司、1分公司）',
   qc_fk_id             varchar(100) comment '业务编号（公司编号）',
   aud_time             datetime comment '审核时间',
   aud_state            varchar(50) comment '审核状态',
   aud_idea             varchar(500) comment '审核意见说明',
   aud_name             varchar(100) comment '审核人',
   aud_mes              varchar(300) comment '备注',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (aud_id)
);

alter table drug_audit comment '审核表';

/*==============================================================*/
/* Table: drug_branch_sale                                      */
/*==============================================================*/
create table drug_branch_sale
(
   bs_id                varchar(100) not null comment '销售编号',
   com_id               varchar(100) comment '店铺编号',
   men_id               varchar(100) comment '会员编号',
   bs_amount            int(10) comment '物品总数量',
   bs_price             numeric(12,2) comment '物品总价',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (bs_id)
);

alter table drug_branch_sale comment '分店销售';

/*==============================================================*/
/* Table: drug_branch_sale_detail                               */
/*==============================================================*/
create table drug_branch_sale_detail
(
   bsd_id               varchar(100) not null comment '销售明细编号',
   bs_id                varchar(100) comment '销售编号',
   drug_id              varchar(100) comment '药品编号',
   bsd_amount           int(10) comment '物品数量',
   bsd_price            numeric(8,2) comment '物品单价',
   bsd_total            numeric(12,2) comment '小计',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (bsd_id)
);

alter table drug_branch_sale_detail comment '分店销售明细';

/*==============================================================*/
/* Table: drug_buy                                              */
/*==============================================================*/
create table drug_buy
(
   buy_id               varchar(100) not null comment '采购编号',
   com_id               varchar(100) comment '店铺编号',
   buy_amount           int(10) comment '商品数量',
   buy_money            numeric(12,2) comment '总金额',
   buy_time             datetime comment '采购时间',
   buy_company          varchar(100) comment '供应商',
   buy_type             varchar(50) comment '采购类型（0原料、1药品）',
   buy_audit            varchar(50) comment '审核状态',
   buy_state            varchar(50) comment '采购状态',
   buy_qc               varchar(50) comment '质检状态',
   buy_put              varchar(50) comment '入库状态',
   buy_mes              varchar(300) comment '备注',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (buy_id)
);

alter table drug_buy comment '采购订单';

/*==============================================================*/
/* Table: drug_buy_detail                                       */
/*==============================================================*/
create table drug_buy_detail
(
   bdet_id              varchar(100) not null comment '采购明细编号',
   buy_id               varchar(100) comment '采购编号',
   bdet_amount          int(4) comment '数量',
   bdet_price           numeric(8,2) comment '单价',
   bdet_total           numeric(12,2) comment '小计',
   bdet_fk_id           varchar(100) comment '业务编号（采购商品编号）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (bdet_id)
);

alter table drug_buy_detail comment '采购明细';

/*==============================================================*/
/* Table: drug_company                                          */
/*==============================================================*/
create table drug_company
(
   com_id               varchar(100) not null comment '店铺编号',
   com_name             varchar(100) comment '店铺名称',
   com_phone            varchar(100) comment '联系电话',
   com_address          varchar(500) comment '地址',
   com_type             varchar(50) comment '店铺类型（0总店、1分店）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (com_id)
);

alter table drug_company comment '店铺（分店、总店）';

/*==============================================================*/
/* Table: drug_debty                                            */
/*==============================================================*/
create table drug_debty
(
   deb_id               varchar(100) not null comment '财物编号',
   com_id               varchar(100) comment '店铺编号',
   deb_money            numeric(15,2) comment '总资产',
   optime               datetime comment '操作时间',
   isva                 varchar(50) comment '是否有效',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (deb_id)
);

alter table drug_debty comment '财务表';

/*==============================================================*/
/* Table: drug_debty_detail                                     */
/*==============================================================*/
create table drug_debty_detail
(
   ddet_id              varchar(100) not null comment '财物明细编号',
   deb_id               varchar(100) comment '财物编号',
   ddet_change          numeric(12,2) comment '资金变动',
   ddett_fk_id          varchar(100) comment '业务编号',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (ddet_id)
);

alter table drug_debty_detail comment '财物明细';

/*==============================================================*/
/* Table: drug_drug                                             */
/*==============================================================*/
create table drug_drug
(
   drug_id              varchar(100) not null comment '药品编号',
   spec_id              varchar(100) comment '说明书编号',
   dt_id                varchar(100) comment '药品类型编号',
   drug_name            varchar(100) comment '药品名称',
   drug_unit            varchar(50) comment '药品单位（盒、粒、片、瓶、克）',
   drug_prop            varchar(50) comment '药品属性（1处方、0非处方）',
   drug_pictrue         varchar(200) comment '药品图片',
   drug_price           numeric(5,2) comment '药品单价',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (drug_id)
);

alter table drug_drug comment '药品表';

/*==============================================================*/
/* Table: drug_drug_inv                                         */
/*==============================================================*/
create table drug_drug_inv
(
   di_id                varchar(100) not null comment '药品库存编号',
   com_id               varchar(100) comment '店铺编号',
   drug_id              varchar(100) comment '药品编号',
   di_amount            int(10) comment '数量',
   di_comtype           varchar(50) comment '采购厂家（0总公司、1分公司）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (di_id)
);

alter table drug_drug_inv comment '药品库存';

/*==============================================================*/
/* Table: drug_drug_inv_detail                                  */
/*==============================================================*/
create table drug_drug_inv_detail
(
   did_id               varchar(100) not null comment '药品库存明细编号',
   di_id                varchar(100) comment '药品库存编号',
   di_amount            int(10) comment '数量',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (did_id)
);

alter table drug_drug_inv_detail comment '药品库存明细';

/*==============================================================*/
/* Table: drug_drug_type                                        */
/*==============================================================*/
create table drug_drug_type
(
   dt_id                varchar(100) not null comment '药品类型编号',
   dt_name              varchar(100) comment '名称',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (dt_id)
);

alter table drug_drug_type comment '药品类型';

/*==============================================================*/
/* Table: drug_mat_inv                                          */
/*==============================================================*/
create table drug_mat_inv
(
   mi_id                varchar(100) not null comment '原料库存编号',
   mi_amount            int(5) comment '数量',
   mat_id               varchar(100) comment '原材料编号',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (mi_id)
);

alter table drug_mat_inv comment '原材料库存';

/*==============================================================*/
/* Table: drug_mat_inv_detail                                   */
/*==============================================================*/
create table drug_mat_inv_detail
(
   mid_id               varchar(100) not null comment '原材料库存明细编号',
   mi_id                varchar(100) comment '原料库存编号',
   mid_amount           int(10) comment '数量',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (mid_id)
);

alter table drug_mat_inv_detail comment '原材料库存明细';

/*==============================================================*/
/* Table: drug_mat_type                                         */
/*==============================================================*/
create table drug_mat_type
(
   mt_id                varchar(100) not null comment '药材类型编号',
   mt_name              varchar(100) comment '名称',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (mt_id)
);

alter table drug_mat_type comment '原材料类型';

/*==============================================================*/
/* Table: drug_material                                         */
/*==============================================================*/
create table drug_material
(
   mat_id               varchar(100) not null comment '原材料编号',
   mt_id                varchar(100) comment '药材类型编号',
   mi_id                varchar(100) comment '原料库存编号',
   mat_name             varchar(100) comment '药材名称',
   mat_amount           int(5) comment '数量',
   mat_price            numeric(5,2) comment '单价',
   mat_unit             varchar(50) comment '药品单位（个、粒、克）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (mat_id)
);

alter table drug_material comment '原材料';

/*==============================================================*/
/* Table: drug_material_list                                    */
/*==============================================================*/
create table drug_material_list
(
   ml_id                varchar(100) not null comment '物料清单编号',
   mat_id               varchar(100) comment '原材料编号',
   drug_id              varchar(100) comment '药品编号',
   ml_amount            int(5) comment '数量',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (ml_id)
);

alter table drug_material_list comment '物料清单';

/*==============================================================*/
/* Table: drug_member                                           */
/*==============================================================*/
create table drug_member
(
   men_id               varchar(100) not null comment '会员编号',
   men_name             varchar(100) comment '名称',
   mem_pwd              varchar(100) comment '密码',
   mem_phone            varchar(50) comment '联系电话',
   mem_address          varchar(300) comment '地址',
   mem_pictrue          varchar(300) comment '头像',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (men_id)
);

alter table drug_member comment '会员';

/*==============================================================*/
/* Table: drug_module                                           */
/*==============================================================*/
create table drug_module
(
   mode_id              varchar(100) not null comment '模块编号',
   dru_mode_id          varchar(100) comment '模块管_模块编号',
   mode_url             varchar(100) comment '模块URL',
   mode_name            varchar(100) comment '模块名称',
   mode_code            varchar(100) comment '模块编码',
   mode_explain         varchar(300) comment '模块说明',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (mode_id)
);

alter table drug_module comment '模块管理';

/*==============================================================*/
/* Table: drug_module_role                                      */
/*==============================================================*/
create table drug_module_role
(
   mr_id                varchar(100) not null comment '模块角色编号',
   mode_id              varchar(100) comment '模块编号',
   role_id              varchar(100) comment '角色编号',
   primary key (mr_id)
);

alter table drug_module_role comment '模块角色表';

/*==============================================================*/
/* Table: drug_mrp                                              */
/*==============================================================*/
create table drug_mrp
(
   mrp_id               varchar(100) not null comment ' 编号',
   pd_id              varchar(100) comment '生产明细编号',
   mrp_num 					int(5) comment '生产个数',
   mrp_optime           datetime comment '制造时间',
   mrp_plan             int(5) comment '计划任务',
   mrp_rate             numeric(5,2) comment '进度',
   mrp_state            varchar(50) comment '状态（0制造中、1已完成）',
   mrp_idea             varchar(50) comment '处理方案（0停止、1继续）',
   mrp_amount           int(3) comment '制造次数',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment  '排序',
   primary key (mrp_id)
);

alter table drug_mrp comment '制造计划';

/*==============================================================*/
/* Table: drug_pmc                                              */
/*==============================================================*/
create table drug_pmc
(
   pmc_id               varchar(100) not null comment '生产计划编号',
   pmc_amount           int(10) comment '生产数量',
   pmc_start            datetime comment '开始时间',
   pmc_end              datetime comment '生产期限',
   pmc_state            varchar(50) comment '状态',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (pmc_id)
);

alter table drug_pmc comment '生产计划单';

/*==============================================================*/
/* Table: drug_pmc_details                                      */
/*==============================================================*/
create table drug_pmc_details
(
   pd_id                varchar(100) not null comment '生产计划明细编号',
   pmc_id               varchar(100) comment '生产计划编号',
   drug_id              varchar(100) comment '药品编号',
   pd_amount            int(5) comment '药品数量',
   pd_state             varchar(50) comment '状态（0未完成、1已完成）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (pd_id)
);

alter table drug_pmc_details comment '生产计划明细';

/*==============================================================*/
/* Table: drug_provider                                         */
/*==============================================================*/
create table drug_provider
(
   prov_id              varchar(100) not null comment '原料供应商编号',
   prov_name            varchar(100) comment '名称',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (prov_id)
);

alter table drug_provider comment '原料供应商';

/*==============================================================*/
/* Table: drug_qc                                               */
/*==============================================================*/
create table drug_qc
(
   qc_id                varchar(100) not null comment '原材料质检编号',
   com_id               varchar(100) comment '店铺编号',
   qc_amount            int(10) comment '质检总数',
   qc_fail              int(10) comment '未通过数',
   qc_rate              numeric(5,2) comment '总通过率',
   qc_optime            datetime comment '质检时间',
   qc_conpany           varchar(100) comment '质检厂家',
   qc_type              varchar(50) comment '质检类型（0原料、1药品）',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (qc_id)
);

alter table drug_qc comment '质检表';

/*==============================================================*/
/* Table: drug_qc_detail                                        */
/*==============================================================*/
create table drug_qc_detail
(
   qdet_id              varchar(100) not null comment '质检明细编号',
   qc_id                varchar(100) comment '原材料质检编号',
   qdet_fk_id           varchar(100) comment '业务编号',
   qdet_amount          int(10) comment '数量',
   qdet_fail            int(10) comment '未通过数',
   qdet_rate            numeric(5,2) comment '通过率',
   qdet_optime          datetime comment '质检时间',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (qdet_id)
);

alter table drug_qc_detail comment '材料质检明细';

/*==============================================================*/
/* Table: drug_role                                             */
/*==============================================================*/
create table drug_role
(
   role_id              varchar(100) not null comment '角色编号',
   role_name            varchar(100) comment '角色名称',
   role_code            varchar(100) comment '角色编码',
   role_describe        varchar(300) comment '角色描述',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (role_id)
);

alter table drug_role comment '角色表';

/*==============================================================*/
/* Table: drug_sale                                             */
/*==============================================================*/
create table drug_sale
(
   sale_id              varchar(100) not null comment '销售编号',
   drug_id              varchar(100) comment '药品编号',
   sale_time            datetime comment '销售时间',
   sale_amount          int(10) comment '总数',
   sale_money           numeric(12,2) comment '总金额',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (sale_id)
);

alter table drug_sale comment '销售单';

/*==============================================================*/
/* Table: drug_sale_detail                                      */
/*==============================================================*/
create table drug_sale_detail
(
   sd_id                varchar(100) not null comment '销售明细编号',
   sale_id              varchar(100) comment '销售编号',
   sd_amount            int(10) comment '物品数量',
   sd_price             numeric(8,2) comment '物品单价',
   sd_total             numeric(12,2) comment '小计',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (sd_id)
);

alter table drug_sale_detail comment '销售明细';

/*==============================================================*/
/* Table: drug_spec                                             */
/*==============================================================*/
create table drug_spec
(
   spec_id              varchar(100) not null comment '说明书编号',
   spec_name            varchar(100) comment '名称',
   spec_trait           varchar(300) comment '性状',
   spec_purpose         varchar(500) comment '功能主治',
   spec_size            varchar(100) comment '规格',
   spec_use             varchar(300) comment '用法用量',
   spec_effect          varchar(300) comment '不良反应',
   spec_taboo           varchar(300) comment '禁忌',
   spec_notice          varchar(2000) comment '注意事项',
   spec_interact        varchar(300) comment '药物相互作用',
   spec_depot           varchar(100) comment '贮藏',
   spec_pack            varchar(100) comment '包装',
   spec_validity        varchar(100) comment '有效期',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (spec_id)
);

alter table drug_spec comment '说明书';

/*==============================================================*/
/* Table: drug_wholesale                                        */
/*==============================================================*/
create table drug_wholesale
(
   whol_id              varchar(100) not null comment '销售明细编号',
   com_id               varchar(100) comment '店铺编号',
   whol_amount          int(10) comment '物品总数量',
   whol_price           numeric(8,2) comment '物品总价',
   optime               datetime comment '操作时间',
   isva                 varchar(50) comment '是否有效',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (whol_id)
);

alter table drug_wholesale comment '分店批发';

/*==============================================================*/
/* Table: drug_wholesale_detail                                 */
/*==============================================================*/
create table drug_wholesale_detail
(
   wd_id                varchar(100) not null comment '销售批发编号',
   whol_id              varchar(100) comment '销售明细编号',
   drug_id              varchar(100) comment '药品编号',
   wd_amount            int(10) comment '物品数量',
   wd_price             numeric(8,2) comment '物品单价',
   wd_total             numeric(12,2) comment '小计',
   isva                 varchar(50) comment '是否有效',
   optime               datetime comment '操作时间',
   oper                 varchar(100) comment '操作人',
   sort                 varchar(200) comment '排序',
   primary key (wd_id)
);

alter table drug_wholesale_detail comment '分店批发明细';

alter table drug_admin_role add constraint FK_Reference_36 foreign key (admin_id)
      references drug_admin (admin_id) on delete restrict on update restrict;

alter table drug_admin_role add constraint FK_Reference_37 foreign key (role_id)
      references drug_role (role_id) on delete restrict on update restrict;

alter table drug_branch_sale add constraint FK_Reference_31 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_branch_sale add constraint FK_Reference_50 foreign key (men_id)
      references drug_member (men_id) on delete restrict on update restrict;

alter table drug_branch_sale_detail add constraint FK_Reference_30 foreign key (bs_id)
      references drug_branch_sale (bs_id) on delete restrict on update restrict;

alter table drug_branch_sale_detail add constraint FK_Reference_33 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_buy add constraint FK_Reference_25 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_buy_detail add constraint FK_Reference_21 foreign key (buy_id)
      references drug_buy (buy_id) on delete restrict on update restrict;

alter table drug_debty add constraint FK_Reference_18 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_debty_detail add constraint FK_Reference_43 foreign key (deb_id)
      references drug_debty (deb_id) on delete restrict on update restrict;

alter table drug_drug add constraint FK_Reference_11 foreign key (spec_id)
      references drug_spec (spec_id) on delete restrict on update restrict;

alter table drug_drug add constraint FK_Reference_48 foreign key (dt_id)
      references drug_drug_type (dt_id) on delete restrict on update restrict;

alter table drug_drug_inv add constraint FK_Reference_29 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_drug_inv add constraint FK_Reference_32 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_drug_inv_detail add constraint FK_Reference_20 foreign key (di_id)
      references drug_drug_inv (di_id) on delete restrict on update restrict;

alter table drug_mat_inv_detail add constraint FK_Reference_24 foreign key (mi_id)
      references drug_mat_inv (mi_id) on delete restrict on update restrict;

alter table drug_material add constraint FK_Reference_22 foreign key (mt_id)
      references drug_mat_type (mt_id) on delete restrict on update restrict;

alter table drug_material add constraint FK_Reference_23 foreign key (mi_id)
      references drug_mat_inv (mi_id) on delete restrict on update restrict;

alter table drug_material_list add constraint FK_Reference_41 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_material_list add constraint FK_Reference_44 foreign key (mat_id)
      references drug_material (mat_id) on delete restrict on update restrict;

alter table drug_module add constraint FK_Reference_40 foreign key (dru_mode_id)
      references drug_module (mode_id) on delete restrict on update restrict;

alter table drug_module_role add constraint FK_Reference_38 foreign key (mode_id)
      references drug_module (mode_id) on delete restrict on update restrict;

alter table drug_module_role add constraint FK_Reference_39 foreign key (role_id)
      references drug_role (role_id) on delete restrict on update restrict;

alter table drug_mrp add constraint FK_Reference_46 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_pmc_details add constraint FK_Reference_13 foreign key (pmc_id)
      references drug_pmc (pmc_id) on delete restrict on update restrict;

alter table drug_pmc_details add constraint FK_Reference_47 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_qc add constraint FK_Reference_27 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_qc_detail add constraint FK_Reference_28 foreign key (qc_id)
      references drug_qc (qc_id) on delete restrict on update restrict;

alter table drug_sale add constraint FK_Reference_49 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;

alter table drug_sale_detail add constraint FK_Reference_19 foreign key (sale_id)
      references drug_sale (sale_id) on delete restrict on update restrict;

alter table drug_wholesale add constraint FK_Reference_34 foreign key (com_id)
      references drug_company (com_id) on delete restrict on update restrict;

alter table drug_wholesale_detail add constraint FK_Reference_35 foreign key (whol_id)
      references drug_wholesale (whol_id) on delete restrict on update restrict;

alter table drug_wholesale_detail add constraint FK_Reference_42 foreign key (drug_id)
      references drug_drug (drug_id) on delete restrict on update restrict;
      
      ALTER TABLE drug_admin ADD CONSTRAINT FK_Reference_66 FOREIGN KEY (com_id)
      REFERENCES drug_company (com_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

