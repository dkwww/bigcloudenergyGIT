/*
SQLyog Ultimate v8.32 
MySQL - 5.7.24-0ubuntu0.16.04.1 : Database - drug_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`drug_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `drug_db`;

/*Table structure for table `drug_admin` */

DROP TABLE IF EXISTS `drug_admin`;

CREATE TABLE `drug_admin` (
  `admin_id` varchar(100) NOT NULL COMMENT '管理员编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '站点编号',
  `admin_name` varchar(100) DEFAULT NULL COMMENT '昵称',
  `admin_pwd` varchar(50) DEFAULT NULL COMMENT '密码',
  `admin_pictrue` varchar(300) DEFAULT NULL COMMENT '头像',
  `admin_msg` varchar(500) DEFAULT NULL COMMENT '备注',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`admin_id`),
  KEY `FK_Reference_66` (`com_id`),
  CONSTRAINT `FK_Reference_66` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='后台登陆管理员';

/*Table structure for table `drug_admin_role` */

DROP TABLE IF EXISTS `drug_admin_role`;

CREATE TABLE `drug_admin_role` (
  `ar_id` varchar(100) NOT NULL COMMENT '管理员角色编号',
  `admin_id` varchar(100) DEFAULT NULL COMMENT '管理员编号',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`ar_id`),
  KEY `FK_Reference_36` (`admin_id`),
  KEY `FK_Reference_37` (`role_id`),
  CONSTRAINT `FK_Reference_36` FOREIGN KEY (`admin_id`) REFERENCES `drug_admin` (`admin_id`),
  CONSTRAINT `FK_Reference_37` FOREIGN KEY (`role_id`) REFERENCES `drug_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员角色表';

/*Table structure for table `drug_audit` */

DROP TABLE IF EXISTS `drug_audit`;

CREATE TABLE `drug_audit` (
  `aud_id` varchar(100) NOT NULL COMMENT '审核编号',
  `aud_fk_id` varchar(100) DEFAULT NULL COMMENT '业务编号',
  `aud_comtype` varchar(50) DEFAULT NULL COMMENT '厂家（0总公司、1分公司）',
  `qc_fk_id` varchar(100) DEFAULT NULL COMMENT '业务编号（公司编号）',
  `aud_time` datetime DEFAULT NULL COMMENT '审核时间',
  `aud_state` varchar(50) DEFAULT NULL COMMENT '审核状态',
  `aud_idea` varchar(500) DEFAULT NULL COMMENT '审核意见说明',
  `aud_name` varchar(100) DEFAULT NULL COMMENT '审核人',
  `aud_mes` varchar(300) DEFAULT NULL COMMENT '备注',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`aud_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='审核表';

/*Table structure for table `drug_branch_sale` */

DROP TABLE IF EXISTS `drug_branch_sale`;

CREATE TABLE `drug_branch_sale` (
  `bs_id` varchar(100) NOT NULL COMMENT '销售编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '店铺编号',
  `men_id` varchar(100) DEFAULT NULL COMMENT '会员编号',
  `bs_amount` int(10) DEFAULT NULL COMMENT '物品总数量',
  `bs_price` decimal(12,2) DEFAULT NULL COMMENT '物品总价',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`bs_id`),
  KEY `FK_Reference_31` (`com_id`),
  KEY `FK_Reference_50` (`men_id`),
  CONSTRAINT `FK_Reference_31` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`),
  CONSTRAINT `FK_Reference_50` FOREIGN KEY (`men_id`) REFERENCES `drug_member` (`men_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分店销售';

/*Table structure for table `drug_branch_sale_detail` */

DROP TABLE IF EXISTS `drug_branch_sale_detail`;

CREATE TABLE `drug_branch_sale_detail` (
  `bsd_id` varchar(100) NOT NULL COMMENT '销售明细编号',
  `bs_id` varchar(100) DEFAULT NULL COMMENT '销售编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `bsd_amount` int(10) DEFAULT NULL COMMENT '物品数量',
  `bsd_price` decimal(8,2) DEFAULT NULL COMMENT '物品单价',
  `bsd_total` decimal(12,2) DEFAULT NULL COMMENT '小计',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`bsd_id`),
  KEY `FK_Reference_30` (`bs_id`),
  KEY `FK_Reference_33` (`drug_id`),
  CONSTRAINT `FK_Reference_30` FOREIGN KEY (`bs_id`) REFERENCES `drug_branch_sale` (`bs_id`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`drug_id`) REFERENCES `drug_drug` (`drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分店销售明细';

/*Table structure for table `drug_buy` */

DROP TABLE IF EXISTS `drug_buy`;

CREATE TABLE `drug_buy` (
  `buy_id` varchar(100) NOT NULL COMMENT '采购编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '店铺编号',
  `buy_amount` int(10) DEFAULT NULL COMMENT '商品数量',
  `buy_money` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `buy_time` datetime DEFAULT NULL COMMENT '采购时间',
  `buy_company` varchar(100) DEFAULT NULL COMMENT '供应商',
  `buy_type` varchar(50) DEFAULT NULL COMMENT '采购类型（0原料、1药品）',
  `buy_audit` varchar(50) DEFAULT NULL COMMENT '审核状态',
  `buy_state` varchar(50) DEFAULT NULL COMMENT '采购状态',
  `buy_qc` varchar(50) DEFAULT NULL COMMENT '质检状态',
  `buy_put` varchar(50) DEFAULT NULL COMMENT '入库状态',
  `buy_mes` varchar(300) DEFAULT NULL COMMENT '备注',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `buy_submission` varchar(100) DEFAULT NULL COMMENT '提交状态',
  PRIMARY KEY (`buy_id`),
  KEY `FK_Reference_25` (`com_id`),
  CONSTRAINT `FK_Reference_25` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购订单';

/*Table structure for table `drug_buy_detail` */

DROP TABLE IF EXISTS `drug_buy_detail`;

CREATE TABLE `drug_buy_detail` (
  `bdet_id` varchar(100) NOT NULL COMMENT '采购明细编号',
  `buy_id` varchar(100) DEFAULT NULL COMMENT '采购编号',
  `bdet_amount` int(4) DEFAULT NULL COMMENT '数量',
  `bdet_price` decimal(8,2) DEFAULT NULL COMMENT '单价',
  `bdet_total` decimal(12,2) DEFAULT NULL COMMENT '小计',
  `bdet_fk_id` varchar(100) DEFAULT NULL COMMENT '业务编号（采购商品编号）',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`bdet_id`),
  KEY `FK_Reference_21` (`buy_id`),
  CONSTRAINT `FK_Reference_21` FOREIGN KEY (`buy_id`) REFERENCES `drug_buy` (`buy_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='采购明细';

/*Table structure for table `drug_company` */

DROP TABLE IF EXISTS `drug_company`;

CREATE TABLE `drug_company` (
  `com_id` varchar(100) NOT NULL COMMENT '店铺编号',
  `com_name` varchar(100) DEFAULT NULL COMMENT '店铺名称',
  `com_phone` varchar(100) DEFAULT NULL COMMENT '联系电话',
  `com_address` varchar(500) DEFAULT NULL COMMENT '地址',
  `com_type` varchar(50) DEFAULT NULL COMMENT '店铺类型（0总店、1分店）',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺（分店、总店）';

/*Table structure for table `drug_debty` */

DROP TABLE IF EXISTS `drug_debty`;

CREATE TABLE `drug_debty` (
  `deb_id` varchar(100) NOT NULL COMMENT '财物编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '店铺编号',
  `deb_money` decimal(25,2) DEFAULT NULL COMMENT '总资产',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`deb_id`),
  KEY `FK_Reference_18` (`com_id`),
  CONSTRAINT `FK_Reference_18` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财务表';

/*Table structure for table `drug_debty_detail` */

DROP TABLE IF EXISTS `drug_debty_detail`;

CREATE TABLE `drug_debty_detail` (
  `ddet_id` varchar(100) NOT NULL COMMENT '财物明细编号',
  `deb_id` varchar(100) DEFAULT NULL COMMENT '财物编号',
  `ddet_change` decimal(12,2) DEFAULT NULL COMMENT '资金变动',
  `ddett_fk_id` varchar(100) DEFAULT NULL COMMENT '业务编号',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ddet_id`),
  KEY `FK_Reference_43` (`deb_id`),
  CONSTRAINT `FK_Reference_43` FOREIGN KEY (`deb_id`) REFERENCES `drug_debty` (`deb_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='财物明细';

/*Table structure for table `drug_drug` */

DROP TABLE IF EXISTS `drug_drug`;

CREATE TABLE `drug_drug` (
  `drug_id` varchar(100) NOT NULL COMMENT '药品编号',
  `dt_id` varchar(100) DEFAULT NULL COMMENT '药品类型编号',
  `drug_name` varchar(100) DEFAULT NULL COMMENT '药品名称',
  `drug_unit` varchar(50) DEFAULT NULL COMMENT '药品单位（盒、粒、片、瓶、克）',
  `drug_prop` varchar(50) DEFAULT NULL COMMENT '药品属性（1处方、0非处方）',
  `drug_pictrue` varchar(200) DEFAULT NULL COMMENT '药品图片',
  `drug_price` decimal(8,2) DEFAULT NULL COMMENT '药品单价',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`drug_id`),
  KEY `FK_Reference_48` (`dt_id`),
  CONSTRAINT `FK_Reference_48` FOREIGN KEY (`dt_id`) REFERENCES `drug_drug_type` (`dt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品表';

/*Table structure for table `drug_drug_inv` */

DROP TABLE IF EXISTS `drug_drug_inv`;

CREATE TABLE `drug_drug_inv` (
  `di_id` varchar(100) NOT NULL COMMENT '药品库存编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '店铺编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `di_amount` int(10) DEFAULT NULL COMMENT '数量',
  `di_comtype` varchar(50) DEFAULT NULL COMMENT '采购厂家（0总公司、1分公司）',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`di_id`),
  KEY `FK_Reference_29` (`com_id`),
  KEY `FK_Reference_32` (`drug_id`),
  CONSTRAINT `FK_Reference_29` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`),
  CONSTRAINT `FK_Reference_32` FOREIGN KEY (`drug_id`) REFERENCES `drug_drug` (`drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品库存';

/*Table structure for table `drug_drug_inv_detail` */

DROP TABLE IF EXISTS `drug_drug_inv_detail`;

CREATE TABLE `drug_drug_inv_detail` (
  `did_id` varchar(100) NOT NULL COMMENT '药品库存明细编号',
  `di_id` varchar(100) DEFAULT NULL COMMENT '药品库存编号',
  `di_amount` int(10) DEFAULT NULL COMMENT '数量',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `Remarks` int(3) DEFAULT NULL COMMENT '0出库 1入库',
  PRIMARY KEY (`did_id`),
  KEY `FK_Reference_20` (`di_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品库存明细';

/*Table structure for table `drug_drug_type` */

DROP TABLE IF EXISTS `drug_drug_type`;

CREATE TABLE `drug_drug_type` (
  `dt_id` varchar(100) NOT NULL COMMENT '药品类型编号',
  `dt_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`dt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='药品类型';

/*Table structure for table `drug_mat_inv` */

DROP TABLE IF EXISTS `drug_mat_inv`;

CREATE TABLE `drug_mat_inv` (
  `mi_id` varchar(100) NOT NULL COMMENT '原料库存编号',
  `mi_amount` int(5) DEFAULT NULL COMMENT '数量',
  `mat_id` varchar(100) DEFAULT NULL COMMENT '原材料编号',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料库存';

/*Table structure for table `drug_mat_inv_detail` */

DROP TABLE IF EXISTS `drug_mat_inv_detail`;

CREATE TABLE `drug_mat_inv_detail` (
  `mid_id` varchar(100) NOT NULL COMMENT '原材料库存明细编号',
  `mi_id` varchar(100) DEFAULT NULL COMMENT '原料库存编号',
  `mid_amount` int(10) DEFAULT NULL COMMENT '数量',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`mid_id`),
  KEY `FK_Reference_24` (`mi_id`),
  CONSTRAINT `FK_Reference_24` FOREIGN KEY (`mi_id`) REFERENCES `drug_mat_inv` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料库存明细';

/*Table structure for table `drug_mat_type` */

DROP TABLE IF EXISTS `drug_mat_type`;

CREATE TABLE `drug_mat_type` (
  `mt_id` varchar(100) NOT NULL COMMENT '药材类型编号',
  `mt_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`mt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料类型';

/*Table structure for table `drug_material` */

DROP TABLE IF EXISTS `drug_material`;

CREATE TABLE `drug_material` (
  `mat_id` varchar(100) NOT NULL COMMENT '原材料编号',
  `mt_id` varchar(100) DEFAULT NULL COMMENT '药材类型编号',
  `mi_id` varchar(100) DEFAULT NULL COMMENT '原料库存编号',
  `mat_name` varchar(100) DEFAULT NULL COMMENT '药材名称',
  `mat_amount` int(5) DEFAULT NULL COMMENT '数量',
  `mat_price` decimal(5,2) DEFAULT NULL COMMENT '单价',
  `mat_unit` varchar(50) DEFAULT NULL COMMENT '药品单位（个、粒、克）',
  `mat_effect` varchar(500) DEFAULT NULL COMMENT '功效',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`mat_id`),
  KEY `FK_Reference_22` (`mt_id`),
  KEY `FK_Reference_23` (`mi_id`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`mt_id`) REFERENCES `drug_mat_type` (`mt_id`),
  CONSTRAINT `FK_Reference_23` FOREIGN KEY (`mi_id`) REFERENCES `drug_mat_inv` (`mi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原材料';

/*Table structure for table `drug_material_list` */

DROP TABLE IF EXISTS `drug_material_list`;

CREATE TABLE `drug_material_list` (
  `ml_id` varchar(100) NOT NULL COMMENT '物料清单编号',
  `mat_id` varchar(100) DEFAULT NULL COMMENT '原材料编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `ml_amount` int(5) DEFAULT NULL COMMENT '数量',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ml_id`),
  KEY `FK_Reference_41` (`drug_id`),
  KEY `FK_Reference_44` (`mat_id`),
  CONSTRAINT `FK_Reference_41` FOREIGN KEY (`drug_id`) REFERENCES `drug_drug` (`drug_id`),
  CONSTRAINT `FK_Reference_44` FOREIGN KEY (`mat_id`) REFERENCES `drug_material` (`mat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='物料清单';

/*Table structure for table `drug_member` */

DROP TABLE IF EXISTS `drug_member`;

CREATE TABLE `drug_member` (
  `men_id` varchar(100) NOT NULL COMMENT '会员编号',
  `men_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `mem_pwd` varchar(100) DEFAULT NULL COMMENT '密码',
  `mem_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `mem_address` varchar(300) DEFAULT NULL COMMENT '地址',
  `mem_pictrue` varchar(300) DEFAULT NULL COMMENT '头像',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`men_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';

/*Table structure for table `drug_module` */

DROP TABLE IF EXISTS `drug_module`;

CREATE TABLE `drug_module` (
  `mode_id` varchar(100) NOT NULL COMMENT '模块编号',
  `dru_mode_id` varchar(100) DEFAULT NULL COMMENT '模块管_模块编号',
  `mode_url` varchar(100) DEFAULT NULL COMMENT '模块URL',
  `mode_icon` varchar(100) DEFAULT NULL COMMENT '模块图标',
  `mode_name` varchar(100) DEFAULT NULL COMMENT '模块名称',
  `mode_code` varchar(100) DEFAULT NULL COMMENT '模块编码',
  `mode_explain` varchar(300) DEFAULT '' COMMENT '模块说明',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`mode_id`),
  KEY `FK_Reference_40` (`dru_mode_id`),
  CONSTRAINT `FK_Reference_40` FOREIGN KEY (`dru_mode_id`) REFERENCES `drug_module` (`mode_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块管理';

/*Table structure for table `drug_module_role` */

DROP TABLE IF EXISTS `drug_module_role`;

CREATE TABLE `drug_module_role` (
  `mr_id` varchar(100) NOT NULL COMMENT '模块角色编号',
  `mode_id` varchar(100) DEFAULT NULL COMMENT '模块编号',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`mr_id`),
  KEY `FK_Reference_38` (`mode_id`),
  KEY `FK_Reference_39` (`role_id`),
  CONSTRAINT `FK_Reference_38` FOREIGN KEY (`mode_id`) REFERENCES `drug_module` (`mode_id`),
  CONSTRAINT `FK_Reference_39` FOREIGN KEY (`role_id`) REFERENCES `drug_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块角色表';

/*Table structure for table `drug_mrp` */

DROP TABLE IF EXISTS `drug_mrp`;

CREATE TABLE `drug_mrp` (
  `mrp_id` varchar(100) NOT NULL COMMENT '制造计划编号',
  `mrp_optime` datetime DEFAULT NULL COMMENT '制造时间',
  `mrp_plan` int(5) DEFAULT NULL COMMENT '计划任务',
  `mrp_rate` varchar(100) DEFAULT NULL COMMENT '进度',
  `mrp_state` int(3) DEFAULT NULL COMMENT '状态（0制造中、1已完成）',
  `mrp_idea` int(3) DEFAULT NULL COMMENT '处理方案（0停止、1继续）',
  `mrp_amount` int(3) DEFAULT NULL COMMENT '制造次数',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `mrp_num` int(8) DEFAULT NULL COMMENT '生产数量',
  `pmc_id` varchar(100) DEFAULT NULL COMMENT '业务编号',
  `mrp_endtime` datetime DEFAULT NULL COMMENT '预计结束',
  `com_name` varchar(100) DEFAULT NULL COMMENT '计划厂家',
  `mrp_pud` int(3) DEFAULT NULL COMMENT '是否提交质检（0已提交，1未提交）',
  PRIMARY KEY (`mrp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='制造计划';

/*Table structure for table `drug_mrp_detail` */

DROP TABLE IF EXISTS `drug_mrp_detail`;

CREATE TABLE `drug_mrp_detail` (
  `md_id` varchar(100) NOT NULL COMMENT '详细编号',
  `mrp_id` varchar(100) DEFAULT NULL COMMENT '制造计划编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `md_plan` int(5) DEFAULT NULL COMMENT '计划任务',
  `md_state` int(3) DEFAULT NULL COMMENT '状态（0制造中、1已完成）',
  `md_rough` int(5) DEFAULT NULL COMMENT '未完成部分',
  `md_view` int(3) DEFAULT NULL COMMENT '处理意见',
  `mrp_amount` int(3) DEFAULT NULL COMMENT '制造次数',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `md_time` datetime DEFAULT NULL COMMENT '制造时间',
  `md_amount` int(4) DEFAULT NULL COMMENT '制造数量',
  PRIMARY KEY (`md_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='制造计划明细';

/*Table structure for table `drug_pmc` */

DROP TABLE IF EXISTS `drug_pmc`;

CREATE TABLE `drug_pmc` (
  `pmc_id` varchar(100) NOT NULL COMMENT '生产计划编号',
  `pmc_name` varchar(100) DEFAULT NULL COMMENT '计划名称',
  `pmc_amount` int(10) DEFAULT NULL COMMENT '生产数量',
  `pmc_start` datetime DEFAULT NULL COMMENT '开始时间',
  `pmc_end` datetime DEFAULT NULL COMMENT '生产期限',
  `pmc_state` varchar(50) DEFAULT NULL COMMENT '状态',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `com_name` varchar(200) DEFAULT NULL COMMENT '店铺名字',
  PRIMARY KEY (`pmc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产计划单';

/*Table structure for table `drug_pmc_details` */

DROP TABLE IF EXISTS `drug_pmc_details`;

CREATE TABLE `drug_pmc_details` (
  `pd_id` varchar(100) NOT NULL COMMENT '生产计划明细编号',
  `pmc_id` varchar(100) DEFAULT NULL COMMENT '生产计划编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `pd_state` varchar(50) DEFAULT NULL COMMENT '状态（0未完成、1已完成）',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `pd_amount` int(11) DEFAULT NULL COMMENT '数量',
  `hang` int(11) DEFAULT NULL COMMENT '已完成数量',
  PRIMARY KEY (`pd_id`),
  KEY `FK_Reference_13` (`pmc_id`),
  KEY `FK_Reference_47` (`drug_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`pmc_id`) REFERENCES `drug_pmc` (`pmc_id`),
  CONSTRAINT `FK_Reference_47` FOREIGN KEY (`drug_id`) REFERENCES `drug_drug` (`drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='生产计划明细';

/*Table structure for table `drug_provider` */

DROP TABLE IF EXISTS `drug_provider`;

CREATE TABLE `drug_provider` (
  `prov_id` varchar(100) NOT NULL COMMENT '原料供应商编号',
  `prov_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`prov_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='原料供应商';

/*Table structure for table `drug_qc` */

DROP TABLE IF EXISTS `drug_qc`;

CREATE TABLE `drug_qc` (
  `qc_id` varchar(100) NOT NULL COMMENT '原材料质检编号',
  `pmc_id` varchar(100) DEFAULT NULL COMMENT '质检业务编号',
  `qc_amount` int(10) DEFAULT NULL COMMENT '质检总数',
  `qc_fail` int(10) DEFAULT NULL COMMENT '未通过数',
  `qc_rate` varchar(100) DEFAULT NULL COMMENT '总通过率',
  `qc_optime` datetime DEFAULT NULL COMMENT '质检时间',
  `qc_conpany` varchar(100) DEFAULT NULL COMMENT '质检厂家',
  `qc_type` int(5) DEFAULT NULL COMMENT '质检类型（0原料、1药品）',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  `qc_state` varchar(200) DEFAULT NULL COMMENT '质检状态',
  `qc_put` varchar(200) DEFAULT NULL COMMENT '入库状态',
  PRIMARY KEY (`qc_id`),
  KEY `FK_Reference_27` (`pmc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='质检表';

/*Table structure for table `drug_qc_detail` */

DROP TABLE IF EXISTS `drug_qc_detail`;

CREATE TABLE `drug_qc_detail` (
  `qdet_id` varchar(100) NOT NULL COMMENT '质检明细编号',
  `qc_id` varchar(100) DEFAULT NULL COMMENT '原材料质检编号',
  `qdet_fk_id` varchar(100) DEFAULT NULL COMMENT '业务编号',
  `qdet_amount` int(10) DEFAULT NULL COMMENT '数量',
  `qdet_fail` int(10) DEFAULT NULL COMMENT '未通过数',
  `qdet_rate` varchar(100) DEFAULT NULL COMMENT '通过率',
  `qdet_optime` datetime DEFAULT NULL COMMENT '质检时间',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`qdet_id`),
  KEY `FK_Reference_28` (`qc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='材料质检明细';

/*Table structure for table `drug_role` */

DROP TABLE IF EXISTS `drug_role`;

CREATE TABLE `drug_role` (
  `role_id` varchar(100) NOT NULL COMMENT '角色编号',
  `role_name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(100) DEFAULT NULL COMMENT '角色编码',
  `role_describe` varchar(300) DEFAULT NULL COMMENT '角色描述',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

/*Table structure for table `drug_sale` */

DROP TABLE IF EXISTS `drug_sale`;

CREATE TABLE `drug_sale` (
  `sale_id` varchar(100) NOT NULL COMMENT '销售编号',
  `sale_time` datetime DEFAULT NULL COMMENT '销售时间',
  `sale_amount` int(10) DEFAULT NULL COMMENT '总数',
  `sale_money` decimal(12,2) DEFAULT NULL COMMENT '总金额',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售单';

/*Table structure for table `drug_sale_detail` */

DROP TABLE IF EXISTS `drug_sale_detail`;

CREATE TABLE `drug_sale_detail` (
  `sd_id` varchar(100) NOT NULL COMMENT '销售明细编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `sale_id` varchar(100) DEFAULT NULL COMMENT '销售编号',
  `sd_amount` int(10) DEFAULT NULL COMMENT '物品数量',
  `sd_price` decimal(8,2) DEFAULT NULL COMMENT '物品单价',
  `sd_total` decimal(12,2) DEFAULT NULL COMMENT '小计',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`sd_id`),
  KEY `FK_Reference_19` (`sale_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`sale_id`) REFERENCES `drug_sale` (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售明细';

/*Table structure for table `drug_spec` */

DROP TABLE IF EXISTS `drug_spec`;

CREATE TABLE `drug_spec` (
  `spec_id` varchar(100) NOT NULL COMMENT '说明书编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `spec_name` varchar(100) DEFAULT NULL COMMENT '名称',
  `spec_trait` varchar(300) DEFAULT NULL COMMENT '性状',
  `spec_purpose` varchar(500) DEFAULT NULL COMMENT '功能主治',
  `spec_size` varchar(100) DEFAULT NULL COMMENT '规格',
  `spec_use` varchar(300) DEFAULT NULL COMMENT '用法用量',
  `spec_effect` varchar(300) DEFAULT NULL COMMENT '不良反应',
  `spec_taboo` varchar(300) DEFAULT NULL COMMENT '禁忌',
  `spec_notice` varchar(2000) DEFAULT NULL COMMENT '注意事项',
  `spec_interact` varchar(300) DEFAULT NULL COMMENT '药物相互作用',
  `spec_depot` varchar(100) DEFAULT NULL COMMENT '贮藏',
  `spec_pack` varchar(100) DEFAULT NULL COMMENT '包装',
  `spec_validity` varchar(100) DEFAULT NULL COMMENT '有效期',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`spec_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='说明书';

/*Table structure for table `drug_wholesale` */

DROP TABLE IF EXISTS `drug_wholesale`;

CREATE TABLE `drug_wholesale` (
  `whol_id` varchar(100) NOT NULL COMMENT '销售明细编号',
  `com_id` varchar(100) DEFAULT NULL COMMENT '店铺编号',
  `whol_amount` int(10) DEFAULT NULL COMMENT '物品总数量',
  `whol_price` decimal(8,2) DEFAULT NULL COMMENT '物品总价',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`whol_id`),
  KEY `FK_Reference_34` (`com_id`),
  CONSTRAINT `FK_Reference_34` FOREIGN KEY (`com_id`) REFERENCES `drug_company` (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分店批发';

/*Table structure for table `drug_wholesale_detail` */

DROP TABLE IF EXISTS `drug_wholesale_detail`;

CREATE TABLE `drug_wholesale_detail` (
  `wd_id` varchar(100) NOT NULL COMMENT '销售批发编号',
  `whol_id` varchar(100) DEFAULT NULL COMMENT '销售明细编号',
  `drug_id` varchar(100) DEFAULT NULL COMMENT '药品编号',
  `wd_amount` int(10) DEFAULT NULL COMMENT '物品数量',
  `wd_price` decimal(8,2) DEFAULT NULL COMMENT '物品单价',
  `wd_total` decimal(12,2) DEFAULT NULL COMMENT '小计',
  `isva` varchar(50) DEFAULT NULL COMMENT '是否有效',
  `optime` datetime DEFAULT NULL COMMENT '操作时间',
  `oper` varchar(100) DEFAULT NULL COMMENT '操作人',
  `sort` varchar(200) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`wd_id`),
  KEY `FK_Reference_35` (`whol_id`),
  KEY `FK_Reference_42` (`drug_id`),
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`whol_id`) REFERENCES `drug_wholesale` (`whol_id`),
  CONSTRAINT `FK_Reference_42` FOREIGN KEY (`drug_id`) REFERENCES `drug_drug` (`drug_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分店批发明细';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
