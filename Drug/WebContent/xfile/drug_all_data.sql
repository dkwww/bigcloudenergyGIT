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

/*------------------------------------基础数据--------------------------------------------*/

/*Data for the table `drug_admin` */

insert  into `drug_admin`(`admin_id`,`com_id`,`admin_name`,`admin_pwd`,`admin_pictrue`,`admin_msg`,`isva`,`optime`,`oper`,`sort`) values ('1','0','drug','123456','upload/photo.jpg','总店管理员','1',NULL,NULL,'1');

/*Data for the table `drug_admin_role` */

insert  into `drug_admin_role`(`ar_id`,`admin_id`,`role_id`) values ('49b92e1e14a111e9a3ba5254000ab703','1','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2');

/*Data for the table `drug_company` */

insert  into `drug_company`(`com_id`,`com_name`,`com_phone`,`com_address`,`com_type`,`isva`,`optime`,`oper`,`sort`) values ('0','优医库','12345678','上海','0','1',NULL,NULL,NULL);

/*Data for the table `drug_debty` */

insert  into `drug_debty`(`deb_id`,`com_id`,`deb_money`,`optime`,`isva`,`oper`,`sort`) values ('0','0','500000.00',NULL,'1',NULL,NULL);

/*Data for the table `drug_module` */

insert  into `drug_module`(`mode_id`,`dru_mode_id`,`mode_url`,`mode_icon`,`mode_name`,`mode_code`,`mode_explain`,`isva`,`optime`,`oper`,`sort`) values ('0',NULL,NULL,NULL,'模块管理',NULL,'选择全部模块','是',NULL,'伍晓林',NULL),('1','0',NULL,'&#xe62a;','生产管理',NULL,'管理总体生产的模块','是',NULL,'伍晓林','a'),('10','1','pages/plan/mrp/Manufacturing.html\r\n','&#xea63;','制造计划',NULL,'管理药品制造的流程','是',NULL,'伍晓林','a2'),('100','5','pages/branchQuality/branchQuality.html','&#xe634;','分店药品质检',NULL,'管理每个分店的药品质检','是',NULL,'伍晓林','d2'),('11','2','pages/drug/drug.html','&#xe649;','药品',NULL,'管理所有药品','是',NULL,'伍晓林','b1'),('12','2','pages/drug/drugType.html','&#xe639;','药品类型',NULL,'管理所有药品的类型','是',NULL,'伍晓林','b2'),('13','2','pages/inv/stock.html','&#xe609;','药品库存',NULL,'管理所有药品的库存','是',NULL,'伍晓林','b3'),('14','3','pages/material/material.html','&#xe64e;','药材',NULL,'管理所有药材','是',NULL,'伍晓林','c1'),('15','3','pages/material/materType.html','&#xe639;','药材类型',NULL,'管理所有药材的类型','是',NULL,'伍晓林','c2'),('16','3','pages/stock/buystock.html','&#xe69b;','药材库存',NULL,'管理所有药材的库存','是',NULL,'伍晓林','c3'),('17','4','pages/buy/purchase.html','&#xe687;','药材采购',NULL,'管理所有药材的采购','是',NULL,'伍晓林','e2'),('18','4','pages/branchBuy/buy.html','&#xe687;','药品采购',NULL,'管理所有药品的采购','是',NULL,'伍晓林','e1'),('19','5','pages/quality/Drugquality.html','&#xe634;','总店药品质检',NULL,'管理总店的药品的质检','是',NULL,'伍晓林','d1'),('2','0',NULL,'&#xe600;','药品管理',NULL,'管理药品的模块','是',NULL,'伍晓林','b'),('20','5','pages/buyQc/Qcbuy.html','&#xe634;','药材质检',NULL,'管理所有药材的质检','是',NULL,'伍晓林','d3'),('21','6','pages/audit/manager/pmcMngAudit.html','&#xe646;','生产计划审核',NULL,'管理经理对生产计划的审核','是',NULL,'伍晓林','g1'),('22','6','pages/audit/manager/drugMngAudit.html','&#xe646;','药品审核',NULL,'管理药品的审核','是',NULL,'伍晓林','g2'),('23','6','pages/audit/manager/examine.html','&#xe646;','采购药材审核',NULL,'管理采购药材的审核','是',NULL,'伍晓林','g3'),('24','6','pages/audit/manager/CEOaudit.html','&#xe646;','采购药品审核',NULL,'管理采购药品的审核','是',NULL,'伍晓林','g5'),('25','6','pages/audit/manager/findCEO.html','&#xe646;','销售审核',NULL,'管理经理对药品销售的审核','是',NULL,'伍晓林','g4'),('26','6','pages/audit/manager/WholesaleAudit.html','&#xe646;','批发审核',NULL,'管理经理对药品批发的审核','是',NULL,'伍晓林','g6'),('27','7','pages/audit/property/pmcPptAudit.html','&#xe646;','生产计划审核',NULL,'管理财务对生产计划的审核','是',NULL,'伍晓林','f1'),('28','7','pages/audit/property/findSale.html','&#xe646;','销售审核',NULL,'管理财务对药品销售的审核','是',NULL,'伍晓林','f3'),('29','7','pages/audit/property/buyAudit.html','&#xe646;','采购药品审核',NULL,'管理财务对药品采购的审核','是',NULL,'伍晓林','f2'),('3','0',NULL,'&#xe627;','药材管理',NULL,'管理药材的模块','是',NULL,'伍晓林','c'),('30','7','pages/audit/property/Financeaudit.html','&#xe646;','批发审核',NULL,'管理批发财务审核','是',NULL,'伍晓林','f4'),('31','8','pages/admin/admin.html','&#xe643;','用户管理',NULL,'管理所有的用户分配','是',NULL,'伍晓林','k1'),('32','8','pages/authority/role.html','&#xe605;','角色管理',NULL,'管理所有角色的模块分配','是',NULL,'伍晓林','k2'),('33','8','pages/authority/module.html','&#xea66;','模块管理',NULL,'管理所有模块的路径','是',NULL,'伍晓林','k3'),('4','0',NULL,'&#xe615;','采购管理',NULL,'管理采购的模块','是',NULL,'伍晓林','e'),('40','0',NULL,'&#xe601;','公司管理',NULL,'管理所有分公司的权限','是',NULL,'伍晓林','j'),('41','40','pages/company/company.html ','&#xe6fb;','分公司',NULL,'管理所有分公司的权限','是',NULL,'伍晓林','j1'),('42','0',NULL,'&#xe62c;','销售管理',NULL,'管理所有药品销售的模块','是',NULL,'伍晓林','h'),('43','42','pages/branchSales/member.html ','&#xe614;','会员',NULL,'管理所有注册会员','是',NULL,'伍晓林','h4'),('44','42','pages/sale/sale.html','&#xea65;','药品销售',NULL,'管理所有药品销售的模块','是',NULL,'伍晓林','h3'),('45','42','pages/wholesale/wholesalepage.html','&#xea64;','药品批发',NULL,'管理所有药品批发','是',NULL,'伍晓林','h2'),('46','42','pages/branchSales/branchSale.html','&#xe61c;','药品零售',NULL,'管理所有药品的零售','是',NULL,'伍晓林','h1'),('47','6','pages/audit/manager/checkcompany.html','&#xe646;','分公司审核',NULL,'管理所有分公司加盟的审核','是',NULL,'伍晓林','g7'),('48','0',NULL,'&#xe619;','财务管理',NULL,'管理公司财务','是',NULL,'伍晓林','i'),('49','48','pages/debty/debty.html','&#xe702;','公司财务',NULL,'管理财务','是',NULL,'伍晓林','i1'),('5','0',NULL,'&#xe638;','质检管理',NULL,'管理产品质检的模块','是',NULL,'伍晓林','d'),('6','0',NULL,'&#xe648;','经理审核',NULL,'管理经理所需要审核的模块','是',NULL,'伍晓林','g'),('7','0',NULL,'&#xe618;','财务审核',NULL,'管理所有财务审核','是',NULL,'伍晓林','f'),('8','0',NULL,'&#xe84c;','权限管理',NULL,'管理分配所有人员权限的模块','是',NULL,'伍晓林','k'),('9','1','pages/plan/pmc/pmc.html','&#xe629;','生产计划',NULL,'管理药品生产的计划设计','是',NULL,'伍晓林','a1');

/*Data for the table `drug_module_role` */

insert  into `drug_module_role`(`mr_id`,`mode_id`,`role_id`) values ('03bx4auwvfmr9463trmwx5inh065h8mypxp6iusa','10','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('0t2uj8cy7oy6yz4t3dchjhjtqsykutd6ni6fwakc','18','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('2ixomt7ej4m9gg073crue0ry2fa40hdhr820wi2n','31','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('34yhmc9tf30sqzdzs6dq99x334fc75jcejcym5u9','28','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('3j045c6yraek0fg5kwox27sosh5ao7aobuid5de8','6','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('4i9gqb6kfe05sq35hzgoje83wn2spcku0zssuj8x','14','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('4kbbj4sdtf4f0sdgfr6ihvzzu63enj9mgviu8i2k','7','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('67thxwfey3qei5iu502r8z2aaoc2y3s72d3bnihc','25','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('76dk95gfdkebhgccquue6qr6i8c9gzhehbvi0cqm','1','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('7a97va3gfd7omcamiev2a845rfasbrrg0v7vevjy','43','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('7rykmjc3o563keo5ybymracjos55kdexsgn2pw4v','42','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('8oqkdprm755fh3j44dswp972nu9wn9phqghrxd4d','6','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('98s8q76fa3wqpeti0bzjew66ezmvo89ts6wrzzhj','2','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('9rq7ox0qipyi8ek75e2cebadmeozegifkkqifp59','29','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('a870ht83tpkt88vywtyqn9msxuy7v8nzykpywtu9','24','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('cco0b7tyugj8nwbd3rvv4gofmqapc6pyr35x0j3p','47','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('cfdkxazsvxkv0uhdhupua9guqft992i2a4aa74eq','100','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('cgcoomthpeu8iuuugzbyctn3w8s0fvdeo2ijjz58','4','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('d25tyxiqb9tskbq02vkfqg9juekc3tkzexkdvx3b','33','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('f4pdfi7j0sxs5502654mmycq03xp7fxrtyt64kck','20','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('g53hdz0z6e2joujtxqumn6voyp8ryx6pn62pqznm','49','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('h94xh2j6j3kakncsy8xhuzzmc2i0tpjgfijvvtip','32','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('haeojy4ckui9svfkufd83omiicx3vb0ohu47ppxw','8','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('jiktc5v067w7tjho3rk4jbb9d575kkduhceodksb','42','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('jwqzm3mq47m7dpgzrfg92a6squzh328kj36qf5ac','44','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('k6a2973g84xbfbvxm29ba2ywk6nimkjruf903s0g','16','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('k6mttz5gi4z7umjho8m6z7aqb2hmrkvkucf0wjm5','22','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('kc4xwoix90ao77oeez2rredi0psxjbnvh7exkfqx','2','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('kvc2gpvf330oeuu4knur6aqnmdn3a4z62t4fbcxs','21','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('kvhniocq9hnbkjpek3tb5h28g4cgdtoy2ocfzr7i','17','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('mb6k3ohby8u4ahx6teeqqx0apaxq3aigrnpckwba','46','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('msh7rqvxsuwwcod8qbbbvruksxykk85z3anoc3x9','5','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('nkfq7323vzsu20api3my3hckjf3wpkyy9tcx99ca','5','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('nth9su0n8jsy2wqqvvh5jkz0ssmywvcc0eeuaaqx','27','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('opv3uj5kpx34xasx59akb4zwqtgm6qzdect3q0pc','9','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('oytwhz7h0sngs2gpt033jgjmfegs9a9syb30m5yx','30','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('p9hjymf3tuhv9gv0q448ryik0cyvuezpmtgdhpqt','40','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('q6hr89jb6ufs65id6r5k7kt7ur6bfb5shk6uct59','23','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('qamxixed6uya0i5vy2xieux8z33su0q7ebdvsmue','13','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('r8kudo8pxsf2gaj9vfvbawpz7o6zikongkugm6au','11','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('sc3ue80d7xpve9aqtriqbv9cco44zdywhmz8f5fn','0','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('sy7rrngd62vdmkeweujhjozfxzj3gsk0y27yg7vp','3','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('tg9uwtatbpnawy3foigyakw7jdq64wiqd0i40b5t','19','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('twh6vqkr8w7pock70jcbehtw02suh754h3xk0gus','7','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('v8vog2m8taennqv820mo9isg6ctjneadiut8ns66','15','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('w2zoc6v29j7q23t0ruorbp3kkefbo72gegs39csp','4','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('wb5s2nyp3eqbnmdtzxu44vf28fs8h2cpepwoiu0e','26','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('xf8p4km0g0nm5b87dco5ejapm4bidnc8p2swqequ','13','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('xnxpvgynx2y5skjmsgv7c8qeq74tbowd7npqg6ea','48','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('xs3iwyum7qdvotbqgh4dp35nquewauzcqrsikony','45','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('xvgq9sxpckh8h8vm954xxraqn40osq248i7tdmyg','0','ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv'),('xwddm8ndi32jc9ejun00gu7quhy3strgkx9rvqaq','12','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2'),('ymdug5idz9eq9u7fmqfgyee6pwqm8tsbh5p936bz','41','ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2');

/*Data for the table `drug_role` */

insert  into `drug_role`(`role_id`,`role_name`,`role_code`,`role_describe`,`isva`,`optime`,`oper`,`sort`) values ('ju65jzmd5p3cfnmoz56e065iquy708ceifme7icv','分公司管理员',NULL,'用于管理分公司的事务','是','2019-01-10 14:14:34','admin',NULL),('ru7omep73t3zpb95c2qk5zkmhu22rmmesge05po2','总公司管理员',NULL,'用于管理总公司的','是','2019-01-10 14:15:21','admin',NULL);

/*------------------------------------测试数据--------------------------------------------*/

/*Data for the table `drug_audit` */

insert  into `drug_audit`(`aud_id`,`aud_fk_id`,`aud_comtype`,`qc_fk_id`,`aud_time`,`aud_state`,`aud_idea`,`aud_name`,`aud_mes`,`isva`,`optime`,`oper`,`sort`) values ('69bf5b3b1ad211e9a3ba5254000ab703','0e6f252a1ad111e9a3ba5254000ab703',NULL,'0','2019-01-18 11:37:45','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:19',NULL,'1547782664574'),('6b1d982e1ad211e9a3ba5254000ab703','4d7a80b11ace11e9a3ba5254000ab703',NULL,'0','2019-01-18 11:37:47','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:16',NULL,'1547782666876'),('875c4bec1ad211e9a3ba5254000ab703','95f218321acd11e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:34','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:12',NULL,'1547782714258'),('88d3a7b41ad211e9a3ba5254000ab703','5fc53c771acb11e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:37','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:09',NULL,'1547782716731'),('8a4420d81ad211e9a3ba5254000ab703','64a885891a3411e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:39','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:05',NULL,'1547782719126'),('8bd1a6811ad211e9a3ba5254000ab703','2691810e1a2d11e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:42','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:40:01',NULL,'1547782721731'),('8d6c19101ad211e9a3ba5254000ab703','d91bf3dd1a1511e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:44','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:39:57',NULL,'1547782724427'),('8efef29f1ad211e9a3ba5254000ab703','d3c75a261a1411e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:47','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:39:53',NULL,'1547782727052'),('90795cd21ad211e9a3ba5254000ab703','8ffb136d1a1311e9a3ba5254000ab703',NULL,'0','2019-01-18 11:38:50','10111','质量没问题，同意生产。','drug',NULL,'1','2019-01-18 11:39:49',NULL,'1547782729556');

/*Data for the table `drug_drug` */

insert  into `drug_drug`(`drug_id`,`dt_id`,`drug_name`,`drug_unit`,`drug_prop`,`drug_pictrue`,`drug_price`,`isva`,`optime`,`oper`,`sort`) values ('0e6f252a1ad111e9a3ba5254000ab703','00465e781a0b11e9a3ba5254000ab703','脑白金','盒','0','upload/135987755292471bb1d027d0d51dffba.jpg','80.00','1','2019-01-18 11:28:02',NULL,'1547782081879'),('2691810e1a2d11e9a3ba5254000ab703','00e943841a2d11e9a3ba5254000ab703','珍视明滴眼液','毫升','0','upload/e4d3c1093b0444d882198ba66949c78e.jpg','30.00','1','2019-01-17 15:54:44',NULL,'1547711684229'),('4d7a80b11ace11e9a3ba5254000ab703','48dfd37d1a0a11e9a3ba5254000ab703','健胃消食片','片','0','upload/631fa3187f054571b0bcbc6e5790bb23.jpg','12.50','1','2019-01-18 11:16:11',NULL,'1547780899163'),('5fc53c771acb11e9a3ba5254000ab703','3ff82bae1a0a11e9a3ba5254000ab703','小柴胡颗粒','袋','0','upload/7096e5c5048b40a4a394f34ed90caf13.jpg','15.80','1','2019-01-18 10:48:47',NULL,'1547779641382'),('64a885891a3411e9a3ba5254000ab703','dcea430d1a2e11e9a3ba5254000ab703','小儿肺热咳喘口服液','支','0','upload/f7e5843bc3b4454ca5cbf50aa394eae9.jpg','15.80','1','2019-01-17 16:46:35',NULL,'1547714794827'),('8ffb136d1a1311e9a3ba5254000ab703','6a371dc21a1311e9a3ba5254000ab703','阿莫西林胶囊','粒','1','upload/c9946eb6564945a89e306031cbd40259.jpg','15.50','1','2019-01-18 10:47:35',NULL,'1547700694177'),('95f218321acd11e9a3ba5254000ab703','976126481a0a11e9a3ba5254000ab703','藿香正气水','瓶','0','upload/c7e1656e9271470a986284d9b68670fd.jpg','8.00','1','2019-01-18 11:03:11',NULL,'1547780591247'),('d3c75a261a1411e9a3ba5254000ab703','00465e781a0b11e9a3ba5254000ab703','六味地黄丸','粒','0','upload/1fa4bc3bb5ec43fb9977d678bcf40156.jpg','25.50','1','2019-01-17 13:00:37',NULL,'1547701237405'),('d91bf3dd1a1511e9a3ba5254000ab703','4c2d211d1a0a11e9a3ba5254000ab703','排毒养颜胶囊','粒','0','upload/85706791ae8f45d49f5880e814acb8df.jpg','18.80','1','2019-01-17 13:07:56',NULL,'1547701675843');

/*Data for the table `drug_drug_inv` */

insert  into `drug_drug_inv`(`di_id`,`com_id`,`drug_id`,`di_amount`,`di_comtype`,`isva`,`optime`,`oper`,`sort`) values ('0322c57172164ee6a122061d4f77ea74','0','64a885891a3411e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('11ddd74bbaeb46b0922f6133bb841af4','0','4d7a80b11ace11e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('3c0450d1049a40ddbb0f4638448501ba','0','95f218321acd11e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('4cb37690bc64437db21a6bb011f6a935','0','8ffb136d1a1311e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('7e6b3f03c6d645f0befbc4c9ddfc0420','0','2691810e1a2d11e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('84f6af1019084a4ab863650afd4d419a','0','d3c75a261a1411e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('96634fe89e0047d595e333a1a9f9f50d','0','d91bf3dd1a1511e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('97de4f6979e440e6959bd5ae94e60061','0','5fc53c771acb11e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL),('d9907d211fb7457f921e57ee5592e434','0','0e6f252a1ad111e9a3ba5254000ab703',0,NULL,'1',NULL,NULL,NULL);

/*Data for the table `drug_drug_type` */

insert  into `drug_drug_type`(`dt_id`,`dt_name`,`isva`,`optime`,`oper`,`sort`) values ('00465e781a0b11e9a3ba5254000ab703','补药','1','2019-01-17 11:50:17',NULL,'1547697017110'),('00e943841a2d11e9a3ba5254000ab703','眼药水','1','2019-01-17 15:53:41',NULL,'1547711621058'),('0a8b46d81a1311e9a3ba5254000ab703','止疼药','1','2019-01-17 12:47:50',NULL,'1547700470332'),('199086851a1311e9a3ba5254000ab703','抗生素','1','2019-01-17 12:48:15',NULL,'1547700495499'),('211199f01a1311e9a3ba5254000ab703','血清','1','2019-01-17 12:48:28',NULL,'1547700508103'),('259acebb1a1311e9a3ba5254000ab703','疫苗','1','2019-01-17 12:48:36',NULL,'1547700515724'),('3ff82bae1a0a11e9a3ba5254000ab703','感冒药','1','2019-01-17 11:44:54',NULL,'1547696694487'),('4461631f1a0a11e9a3ba5254000ab703','退烧药','1','2019-01-17 11:45:02',NULL,'1547696701885'),('48dfd37d1a0a11e9a3ba5254000ab703','胃药','1','2019-01-17 11:45:09',NULL,'1547696709425'),('4c2d211d1a0a11e9a3ba5254000ab703','泻药','1','2019-01-17 11:45:15',NULL,'1547696714968'),('5050230d1a0a11e9a3ba5254000ab703','催眠药','1','2019-01-17 11:45:22',NULL,'1547696721909'),('6a371dc21a1311e9a3ba5254000ab703','消炎药','1','2019-01-17 12:50:31',NULL,'1547700630818'),('976126481a0a11e9a3ba5254000ab703','解暑药','1','2019-01-17 11:47:21',NULL,'1547696841122'),('dcea430d1a2e11e9a3ba5254000ab703','止咳药','1','2019-01-17 16:07:00',NULL,'1547712419630');

/*Data for the table `drug_mat_inv` */

insert  into `drug_mat_inv`(`mi_id`,`mi_amount`,`mat_id`,`isva`,`optime`,`oper`,`sort`) values ('20190117112924jm2rxrtvne',0,'8a5a5cdb17354e73a5dece9c56642d8c',NULL,NULL,NULL,NULL),('201901171130023s2cv5ff5h',0,'bdf52684e6f14a8a80b0c487e1294ca7',NULL,NULL,NULL,NULL),('20190117113032chb8wnxgi0',0,'b794ecaaf95443999e20dd0b38ade89f',NULL,NULL,NULL,NULL),('20190117113138abfpw8rmtg',0,'c01948ea318547dc8cc9f9784fae2dc3',NULL,NULL,NULL,NULL),('20190117113314iug5ojb6qy',0,'2258060ae21c4ed394da06404106bb32',NULL,NULL,NULL,NULL),('20190117113408cfbedz60r3',0,'9f2f961926bc4847a96805b7639161b2',NULL,NULL,NULL,NULL),('20190117113520uz0s03jbdq',0,'492a028fd83c44dcb6f25596a5b84fc3',NULL,NULL,NULL,NULL),('20190117113551popzovfpae',0,'ad39e5cf1ca44b9b977f8611224cc52e',NULL,NULL,NULL,NULL),('20190117113649wxa6cw4h49',0,'a3e96c2c97df4f47b0d5b0b181c0ee69',NULL,NULL,NULL,NULL),('20190117113715zcphhweq87',0,'11a1c9de23374addb329dfcd649bfe3b',NULL,NULL,NULL,NULL),('20190117113749u78q4wydxr',0,'2cff1d46097346d3a18bf0768d1161f0',NULL,NULL,NULL,NULL),('20190117113826sc8x4bhte9',0,'d1847d9b370645c4b8b5d3838162371d',NULL,NULL,NULL,NULL),('20190117114052r6u9dvkxw4',0,'96411151a48542878f205979726dcfd2',NULL,NULL,NULL,NULL),('20190117114112kqedwee4ac',0,'bfef316c48084ed99aa40a028c0e1c79',NULL,NULL,NULL,NULL),('20190117114143e9z6kg6khy',0,'fb72bfd993674117b13a8a858c8215d6',NULL,NULL,NULL,NULL),('20190117160129fxvcbfqhjq',0,'8250b163e9b747a0ae5978cf1d0695b2',NULL,NULL,NULL,NULL),('201901171602033ph25by70k',0,'c66f4e50fea44bfd8f0dbd08deb10066',NULL,NULL,NULL,NULL),('20190117160450w0a65r2uj2',0,'ff1bce95cab34be38692fe841b12869d',NULL,NULL,NULL,NULL),('20190117160534icxcmkthpe',0,'2e7b2a09c0c54497a98a994326866aaf',NULL,NULL,NULL,NULL),('201901171606139zwz2h7cpz',0,'7df0061502e8428285dbb3d109e665d0',NULL,NULL,NULL,NULL),('20190117160640yca9mx3649',0,'6b56e07363d9491e949ceeef99624054',NULL,NULL,NULL,NULL),('20190117160730w7ms5w5gaf',0,'9cf3cb3fa92948da8146aba650c0a2b6',NULL,NULL,NULL,NULL),('20190117160819jbids3zvsj',0,'46f5b5883e404a33aa50f6ec209b0603',NULL,NULL,NULL,NULL),('2019011716093067z5v29upv',0,'845ea54374fc4115b9194bb48c305372',NULL,NULL,NULL,NULL),('201901171611412jsqmb79u5',0,'ecdbca400149496c8d527d8a858a9f38',NULL,NULL,NULL,NULL),('20190117161424isd7u2toa8',0,'0b0fed8a4dc24f26bb90881fd7a1b49a',NULL,NULL,NULL,NULL),('20190117161455gcrfwgr7ic',0,'00b07b1f1f6c48d0b5e2231dd895cb2f',NULL,NULL,NULL,NULL),('20190117161522v0n5hktckm',0,'561e7ecc7d0d4469881a40c42f5a237e',NULL,NULL,NULL,NULL),('20190117161810m66h47k92x',0,'c18536752bda4738b179baf5bf183a42',NULL,NULL,NULL,NULL),('20190117162004x8uvnhtfcn',0,'68c41282f8e54b45bd574d841c9c41f5',NULL,NULL,NULL,NULL),('20190117163055b80nuv9c62',0,'504a86f6329343a58e0a17bd98a11113',NULL,NULL,NULL,NULL),('20190117163226ut7qdegckb',0,'4bc623d615c14d1f8c2c8107cf9b0bcb',NULL,NULL,NULL,NULL),('20190117165129khvjqi4if6',0,'b02217ba1adf4d48a142e76530b68fcb',NULL,NULL,NULL,NULL);

/*Data for the table `drug_mat_type` */

insert  into `drug_mat_type`(`mt_id`,`mt_name`,`isva`,`optime`,`oper`,`sort`) values ('11b474f0bfdb4ec5baf7efe0a123dd7e','全草类','1','2019-01-17 11:26:30',NULL,NULL),('15dae0f1bffc4299b74d2560113d43e5','叶类','1','2019-01-17 11:26:37',NULL,NULL),('182d56ddce554b6991bc02cc174845e2','树皮类','1','2019-01-17 11:27:58',NULL,NULL),('1b1154424e474e519b7b3e307675a0d4','矿物类','1','2019-01-17 11:27:02',NULL,NULL),('691cbc0331724365bae172d736611694','菌藻类','1','2019-01-17 11:26:44',NULL,NULL),('9debe91f679044b8bc55d461ec225751','果实种子类','1','2019-01-17 11:27:30',NULL,NULL),('a9117bf2f77548ae920c2e8733bb6f7a','动物类','1','2019-01-17 11:26:50',NULL,NULL),('bf7c317770a14638a9cfdb0d5e7a2417','其它加工类','1','2019-01-17 11:27:13',NULL,NULL),('c60fe95422744b85bb22321e1661656a','花类','1','2019-01-17 11:27:22',NULL,NULL),('ea30aa0d56ed4df987efae268903ea68','藤木类','1','2019-01-17 11:28:17',NULL,NULL),('eda41fdbfb0544c99bf6e8d4381ce2a8','根茎类','1','2019-01-17 11:26:22',NULL,NULL);

/*Data for the table `drug_material` */

insert  into `drug_material`(`mat_id`,`mt_id`,`mi_id`,`mat_name`,`mat_amount`,`mat_price`,`mat_unit`,`mat_effect`,`isva`,`optime`,`oper`,`sort`) values ('00b07b1f1f6c48d0b5e2231dd895cb2f','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'枇杷',0,'118.00','个','琵琶林','1','2019-01-17 16:14:55',NULL,NULL),('0b0fed8a4dc24f26bb90881fd7a1b49a','9debe91f679044b8bc55d461ec225751',NULL,'川贝母',0,'20.00','个','透风','1','2019-01-17 16:14:24',NULL,NULL),('11a1c9de23374addb329dfcd649bfe3b','a9117bf2f77548ae920c2e8733bb6f7a',NULL,'白术',0,'71.00','粒','白白的','1','2019-01-17 11:37:15',NULL,NULL),('2258060ae21c4ed394da06404106bb32','c60fe95422744b85bb22321e1661656a',NULL,'三叉苦',0,'74.00','克','苦','1','2019-01-17 11:33:14',NULL,NULL),('2cff1d46097346d3a18bf0768d1161f0','a9117bf2f77548ae920c2e8733bb6f7a',NULL,'西洋参',0,'11.00','个','人参你说呢','1','2019-01-17 11:37:49',NULL,NULL),('2e7b2a09c0c54497a98a994326866aaf','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'麻黄',0,'99.00','个','麻花','1','2019-01-17 16:05:34',NULL,NULL),('46f5b5883e404a33aa50f6ec209b0603','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'柴胡',0,'64.00','个','为和解剂','1','2019-01-17 16:08:19',NULL,NULL),('492a028fd83c44dcb6f25596a5b84fc3','1b1154424e474e519b7b3e307675a0d4',NULL,'金盏银盘',0,'960.00','个','金光闪闪','1','2019-01-17 11:35:20',NULL,NULL),('4bc623d615c14d1f8c2c8107cf9b0bcb','9debe91f679044b8bc55d461ec225751',NULL,'茯苓',0,'2.00','克','保养','1','2019-01-17 16:32:26',NULL,NULL),('504a86f6329343a58e0a17bd98a11113','9debe91f679044b8bc55d461ec225751',NULL,'山楂',0,'12.00','克','渣渣','1','2019-01-17 16:30:55',NULL,NULL),('561e7ecc7d0d4469881a40c42f5a237e','182d56ddce554b6991bc02cc174845e2',NULL,'桔梗',0,'52.00','个','清热解毒','1','2019-01-17 16:15:22',NULL,NULL),('68c41282f8e54b45bd574d841c9c41f5','1b1154424e474e519b7b3e307675a0d4',NULL,'液体葡萄糖',0,'852.00','克','甜甜的噢','1','2019-01-17 16:20:04',NULL,NULL),('6b56e07363d9491e949ceeef99624054','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'石膏',0,'333.00','克','宣肺化痰 ','1','2019-01-17 16:06:40',NULL,NULL),('7df0061502e8428285dbb3d109e665d0','c60fe95422744b85bb22321e1661656a',NULL,'苦杏仁',0,'45.00','个','清热解毒','1','2019-01-17 16:06:13',NULL,NULL),('8250b163e9b747a0ae5978cf1d0695b2','1b1154424e474e519b7b3e307675a0d4',NULL,'珍珠层粉',0,'74.00','克','上四味','1','2019-01-17 16:01:29',NULL,NULL),('845ea54374fc4115b9194bb48c305372','9debe91f679044b8bc55d461ec225751',NULL,'黄芩',0,'23.00','个','解表散热，疏肝和胃','1','2019-01-17 16:09:30',NULL,NULL),('8a5a5cdb17354e73a5dece9c56642d8c','182d56ddce554b6991bc02cc174845e2',NULL,'熟地黄',0,'50.00','粒','滋润身体','1','2019-01-17 11:29:24',NULL,NULL),('96411151a48542878f205979726dcfd2','ea30aa0d56ed4df987efae268903ea68',NULL,'枳实',0,'52.00','个','益气活血，通便排毒。用于气虚血','1','2019-01-17 11:40:52',NULL,NULL),('9cf3cb3fa92948da8146aba650c0a2b6','ea30aa0d56ed4df987efae268903ea68',NULL,'甘草',0,'10.00','克','解渴','1','2019-01-17 16:07:30',NULL,NULL),('9f2f961926bc4847a96805b7639161b2','c60fe95422744b85bb22321e1661656a',NULL,'岗梅',0,'88.00','粒','哈哈','1','2019-01-17 11:34:08',NULL,NULL),('a3e96c2c97df4f47b0d5b0b181c0ee69','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'大黄',0,'600.00','克','黄黄的','1','2019-01-17 11:36:49',NULL,NULL),('ad39e5cf1ca44b9b977f8611224cc52e','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'薄荷油',0,'20.00','克','油条','1','2019-01-17 11:35:51',NULL,NULL),('b02217ba1adf4d48a142e76530b68fcb','9debe91f679044b8bc55d461ec225751',NULL,'板蓝根',0,'2.00','克','清热散火','1','2019-01-17 16:51:29',NULL,NULL),('b794ecaaf95443999e20dd0b38ade89f','c60fe95422744b85bb22321e1661656a',NULL,'牡丹皮',0,'12.00','个','香','1','2019-01-17 11:30:32',NULL,NULL),('bdf52684e6f14a8a80b0c487e1294ca7','1b1154424e474e519b7b3e307675a0d4',NULL,'酒萸肉',0,'64.00','克','呜呜呜','1','2019-01-17 11:30:02',NULL,NULL),('bfef316c48084ed99aa40a028c0e1c79','1b1154424e474e519b7b3e307675a0d4',NULL,'青阳参',0,'52.00','个','热毒内盛所致便秘、座疮、颜面色','1','2019-01-17 11:41:12',NULL,NULL),('c01948ea318547dc8cc9f9784fae2dc3','ea30aa0d56ed4df987efae268903ea68',NULL,'山药',0,'89.00','个','补身体','1','2019-01-17 11:31:38',NULL,NULL),('c18536752bda4738b179baf5bf183a42','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'薄荷脑',0,'12.00','个','补脑神器','1','2019-01-17 16:18:10',NULL,NULL),('c66f4e50fea44bfd8f0dbd08deb10066','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'天然冰片',0,'96.00','个','冰爽','1','2019-01-17 16:02:03',NULL,NULL),('d1847d9b370645c4b8b5d3838162371d','bf7c317770a14638a9cfdb0d5e7a2417',NULL,'芒硝',0,'99.00','粒','爽','1','2019-01-17 11:38:26',NULL,NULL),('ecdbca400149496c8d527d8a858a9f38','c60fe95422744b85bb22321e1661656a',NULL,'党参',0,'74.00','个','主治外感病，邪犯少阳证','1','2019-01-17 16:11:41',NULL,NULL),('fb72bfd993674117b13a8a858c8215d6','1b1154424e474e519b7b3e307675a0d4',NULL,'肉苁蓉',0,'52.00','个','内容物为黄棕色至棕褐色的粉末；','1','2019-01-17 11:41:44',NULL,NULL),('ff1bce95cab34be38692fe841b12869d','1b1154424e474e519b7b3e307675a0d4',NULL,'硼酸',0,'66.00','克','酸酸的','1','2019-01-17 16:04:50',NULL,NULL);

/*Data for the table `drug_material_list` */

insert  into `drug_material_list`(`ml_id`,`mat_id`,`drug_id`,`ml_amount`,`isva`,`optime`,`oper`,`sort`) values ('20a30c0b1a1611e9a3ba5254000ab703','fb72bfd993674117b13a8a858c8215d6','d91bf3dd1a1511e9a3ba5254000ab703',2,'1','2019-01-17 13:09:56',NULL,'1547701795854'),('20f3c6b31a1611e9a3ba5254000ab703','bfef316c48084ed99aa40a028c0e1c79','d91bf3dd1a1511e9a3ba5254000ab703',3,'1','2019-01-17 13:09:56',NULL,'1547701796404'),('2147b71b1a1611e9a3ba5254000ab703','96411151a48542878f205979726dcfd2','d91bf3dd1a1511e9a3ba5254000ab703',2,'1','2019-01-17 13:09:57',NULL,'1547701796921'),('219d360a1a1611e9a3ba5254000ab703','d1847d9b370645c4b8b5d3838162371d','d91bf3dd1a1511e9a3ba5254000ab703',4,'1','2019-01-17 13:09:57',NULL,'1547701797474'),('21f29e301a1611e9a3ba5254000ab703','2cff1d46097346d3a18bf0768d1161f0','d91bf3dd1a1511e9a3ba5254000ab703',5,'1','2019-01-17 13:09:58',NULL,'1547701798047'),('2249a2ec1a1611e9a3ba5254000ab703','11a1c9de23374addb329dfcd649bfe3b','d91bf3dd1a1511e9a3ba5254000ab703',7,'1','2019-01-17 13:09:59',NULL,'1547701798613'),('229d8bcc1a1611e9a3ba5254000ab703','a3e96c2c97df4f47b0d5b0b181c0ee69','d91bf3dd1a1511e9a3ba5254000ab703',4,'1','2019-01-17 13:09:59',NULL,'1547701799154'),('4c8104771ad111e9a3ba5254000ab703','11a1c9de23374addb329dfcd649bfe3b','0e6f252a1ad111e9a3ba5254000ab703',3,'1','2019-01-18 11:29:46',NULL,'1547782186018'),('4cc65c321ad111e9a3ba5254000ab703','2cff1d46097346d3a18bf0768d1161f0','0e6f252a1ad111e9a3ba5254000ab703',7,'1','2019-01-18 11:29:46',NULL,'1547782186482'),('4d19835e1ad111e9a3ba5254000ab703','ecdbca400149496c8d527d8a858a9f38','0e6f252a1ad111e9a3ba5254000ab703',8,'1','2019-01-18 11:29:47',NULL,'1547782187017'),('4d7759021ad111e9a3ba5254000ab703','845ea54374fc4115b9194bb48c305372','0e6f252a1ad111e9a3ba5254000ab703',5,'1','2019-01-18 11:29:48',NULL,'1547782187601'),('7f6ad6741acf11e9a3ba5254000ab703','c18536752bda4738b179baf5bf183a42','4d7a80b11ace11e9a3ba5254000ab703',6,'1','2019-01-18 11:16:52',NULL,'1547781412457'),('7ff72a051acf11e9a3ba5254000ab703','504a86f6329343a58e0a17bd98a11113','4d7a80b11ace11e9a3ba5254000ab703',4,'1','2019-01-18 11:16:53',NULL,'1547781413366'),('840d6ea81ad211e9a3ba5254000ab703','d1847d9b370645c4b8b5d3838162371d','95f218321acd11e9a3ba5254000ab703',4,'1','2019-01-18 11:38:29',NULL,'1547782708710'),('845a70d71ad211e9a3ba5254000ab703','ff1bce95cab34be38692fe841b12869d','95f218321acd11e9a3ba5254000ab703',6,'1','2019-01-18 11:38:29',NULL,'1547782709178'),('84a601061ad211e9a3ba5254000ab703','9cf3cb3fa92948da8146aba650c0a2b6','95f218321acd11e9a3ba5254000ab703',3,'1','2019-01-18 11:38:30',NULL,'1547782709718'),('84fcf2421ad211e9a3ba5254000ab703','504a86f6329343a58e0a17bd98a11113','95f218321acd11e9a3ba5254000ab703',7,'1','2019-01-18 11:38:30',NULL,'1547782710282'),('936be9901a1511e9a3ba5254000ab703','c01948ea318547dc8cc9f9784fae2dc3','d3c75a261a1411e9a3ba5254000ab703',8,'1','2019-01-17 13:05:59',NULL,'1547701558952'),('93c150501a1511e9a3ba5254000ab703','b794ecaaf95443999e20dd0b38ade89f','d3c75a261a1411e9a3ba5254000ab703',10,'1','2019-01-17 13:05:59',NULL,'1547701559491'),('941cea611a1511e9a3ba5254000ab703','bdf52684e6f14a8a80b0c487e1294ca7','d3c75a261a1411e9a3ba5254000ab703',5,'1','2019-01-17 13:06:00',NULL,'1547701560089'),('94724e921a1511e9a3ba5254000ab703','8a5a5cdb17354e73a5dece9c56642d8c','d3c75a261a1411e9a3ba5254000ab703',3,'1','2019-01-17 13:06:01',NULL,'1547701560665'),('96512a011a1411e9a3ba5254000ab703','ad39e5cf1ca44b9b977f8611224cc52e','8ffb136d1a1311e9a3ba5254000ab703',5,'1','2019-01-17 12:58:54',NULL,'1547701134298'),('96a8124d1a1411e9a3ba5254000ab703','a3e96c2c97df4f47b0d5b0b181c0ee69','8ffb136d1a1311e9a3ba5254000ab703',3,'1','2019-01-17 12:58:55',NULL,'1547701134883'),('96fbf6701a1411e9a3ba5254000ab703','2258060ae21c4ed394da06404106bb32','8ffb136d1a1311e9a3ba5254000ab703',4,'1','2019-01-17 12:58:55',NULL,'1547701135398'),('975172bd1a1411e9a3ba5254000ab703','8a5a5cdb17354e73a5dece9c56642d8c','8ffb136d1a1311e9a3ba5254000ab703',2,'1','2019-01-17 12:58:56',NULL,'1547701135979'),('a21b47161a3511e9a3ba5254000ab703','b02217ba1adf4d48a142e76530b68fcb','64a885891a3411e9a3ba5254000ab703',3,'1','2019-01-17 16:55:27',NULL,'1547715327461'),('a27e60661a3511e9a3ba5254000ab703','9cf3cb3fa92948da8146aba650c0a2b6','64a885891a3411e9a3ba5254000ab703',2,'1','2019-01-17 16:55:28',NULL,'1547715328091'),('a2e310761a3511e9a3ba5254000ab703','6b56e07363d9491e949ceeef99624054','64a885891a3411e9a3ba5254000ab703',4,'1','2019-01-17 16:55:29',NULL,'1547715328723'),('a33e9dac1a3511e9a3ba5254000ab703','7df0061502e8428285dbb3d109e665d0','64a885891a3411e9a3ba5254000ab703',5,'1','2019-01-17 16:55:29',NULL,'1547715329351'),('a3a1c6621a3511e9a3ba5254000ab703','2e7b2a09c0c54497a98a994326866aaf','64a885891a3411e9a3ba5254000ab703',7,'1','2019-01-17 16:55:30',NULL,'1547715330000'),('a9c923921aca11e9a3ba5254000ab703','c66f4e50fea44bfd8f0dbd08deb10066','2691810e1a2d11e9a3ba5254000ab703',10,'1','2019-01-18 10:42:16',NULL,'1547779336053'),('aa2cfe981aca11e9a3ba5254000ab703','8250b163e9b747a0ae5978cf1d0695b2','2691810e1a2d11e9a3ba5254000ab703',8,'1','2019-01-18 10:42:17',NULL,'1547779336699'),('c79884651acb11e9a3ba5254000ab703','ecdbca400149496c8d527d8a858a9f38','5fc53c771acb11e9a3ba5254000ab703',7,'1','2019-01-18 10:50:16',NULL,'1547779815538'),('c7edddfe1acb11e9a3ba5254000ab703','845ea54374fc4115b9194bb48c305372','5fc53c771acb11e9a3ba5254000ab703',4,'1','2019-01-18 10:50:16',NULL,'1547779816097'),('c85d45ea1acb11e9a3ba5254000ab703','46f5b5883e404a33aa50f6ec209b0603','5fc53c771acb11e9a3ba5254000ab703',6,'1','2019-01-18 10:50:17',NULL,'1547779816813');

/*Data for the table `drug_spec` */

insert  into `drug_spec`(`spec_id`,`drug_id`,`spec_name`,`spec_trait`,`spec_purpose`,`spec_size`,`spec_use`,`spec_effect`,`spec_taboo`,`spec_notice`,`spec_interact`,`spec_depot`,`spec_pack`,`spec_validity`,`isva`,`optime`,`oper`,`sort`) values ('01f8685c1acb11e9a3ba5254000ab703','2691810e1a2d11e9a3ba5254000ab703','珍视明滴眼液','为近无色至微黄色的澄明液体；气香。','明目去翳，清热解痉。用于肝阴不足、肝气偏盛所致的不能久视、轻度眼胀、眼痛、青少年远视力下降；青少年假性近视、视力疲劳、轻度青光眼见上述证候者。','每瓶装（1）8ml（2）15ml','滴于眼睑内，一次1～2滴，一日3～5次；必要时可酌情增加。','尚不明确','尚不明确','1：本品为外用滴眼液，禁止内服。 　　2：忌烟、酒、辛辣刺激性食物。 　　3：眼部有炎症者应去医院就诊。 　　4：用药后有沙涩磨痛、流泪频频、眼痒、眼睑皮肤潮红、眼胀者应停用，并到医院就诊。 　　5：如视力下降明显应到医院就诊。 　　6：滴眼时瓶口勿接触眼睛，使用后应将瓶盖拧紧，以免污染药液。 　　7：用药7天症状无缓解，应去医院就诊。 　　8：打开瓶盖后，15天内用完。 　　9：对本品过敏者禁用，过敏体质者慎用。 　　10：本品性状发生改变时禁止使用。 　　11：儿童必须在成人监护下使用。 　　12：请将本品放在儿童不能接触的地方。 　　13：如正在使用其它一些药品，使用本品前请咨询医师或药师。','如与其它药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。','密闭，置凉暗处（避光并不超过20度）。','瓶装','12个月（打开瓶盖后，15天内用完。）','1',NULL,NULL,'1547779483981'),('1635c8481a3611e9a3ba5254000ab703','64a885891a3411e9a3ba5254000ab703','小儿肺热咳喘口服液','棕红色的液体，久置有少量沉淀；味苦、微甜。','清热解毒，宣肺化痰。热邪犯于肺卫所致发热、汗出、微恶风寒、咳嗽、痰黄，或兼喘息、口千而渴。','10ml*6支','口服。一岁至三岁一次1支，一日3次；四岁至七岁一次1支，一日4次；八岁至十二岁每次2支，一日3次，或遵医嘱。','大剂量服用，可能有轻度胃肠不适反应。','尚不明确。','1.忌辛辣、生冷、油腻食物。 2.不宜在服药期间同时服用滋补性中药。 3.婴儿应在医生指导下服用。 4.风寒闭肺、内伤久咳这不适用。 5.高血压、心脏病患儿慎用，脾虚易腹泻着应在医生指导下服用。 6.发热体温超过38.5℃的患者，应去医院就诊。 7.服药3天症状无缓解，应去医院就诊。 8.对本品过敏者禁用，过敏体质者慎用。 9.本品性状发生改变时禁止使用。 10.儿童必须在成人监护下使用。 11.请将本品放在儿童不能接触的地方。 12.如正在使用其他药品，使用本品前请咨询医师或药师。 13.运动员慎用。','如与其他药物同时使用可能会发生药物相互作用，详情咨询医师或药师。','药品阴凉贮存区(20℃以下)。','瓶装','36个月。','1',NULL,NULL,'1547715522234'),('250a3c641a1411e9a3ba5254000ab703','8ffb136d1a1311e9a3ba5254000ab703','阿莫西林胶囊','本品为胶囊剂，内容物为白色或类白色粉末。','阿莫西林适用于敏感菌(不产β内酰胺酶菌株)所致的下列感染： 　　1.溶血链球菌、肺炎链球菌、葡萄球菌或流感嗜血杆菌所致中耳炎、鼻窦炎、咽炎、扁桃体炎等上呼吸道感染。 　　2.大肠埃希菌、奇异变形杆菌或粪肠球菌所致的泌尿生殖道感染。 　　3.溶血链球菌、葡萄球菌或大肠埃希菌所致的皮肤软组织感染。 　　4.溶血链球菌、肺炎链球菌、葡萄球菌或流感嗜血杆菌所致急性支气管炎、肺炎等下呼吸道感染。 　　5.急性单纯性淋病。 　　6.本品尚可用于治疗伤寒、伤寒带菌者及钩端螺旋体病；阿莫西林亦可与克拉霉素、兰索拉唑三联用药根除胃、十二指肠幽门螺杆菌，降低消化道溃疡复发率。','0.5g（按C16H19N3O5S计算）','口服。成人一次0.5g，每6～8小时1次，一日剂量不超过4g。 　　小儿一日剂量按体重20～40mg/Kg，每8小时1次；3个月以下婴儿一日剂量按体重30mg/Kg，每12小时1次。 　　肾功能严重损害患者需调整给药剂量，其中内生肌酐清除率为10～30ml/分钟的患者每12小时0.25～0.5g；内生肌酐清除率小于10ml/分钟的患者每24小时0.25～0.5g。','1.恶心、呕吐、腹泻及假膜性肠炎等胃肠道反应。 　　2.皮疹、药物热和哮喘等过敏反应。 　　3.贫血、血小板减少、嗜酸性粒细胞增多等。 　　4.血清氨基转移酶可轻度增高。 　　5.由念珠菌或耐药菌引起的二重感染。 　　6.偶见兴奋、焦虑、失眠、头晕以及行为异常等中枢神经系统症状。','青霉素过敏及青霉素皮肤试验阳性患者禁用。','1. 青霉素类口服药可引起过敏性休克，有多见于青霉素或头孢菌素过敏史的患者。用药前必须详细询问药物过敏史并做青霉素皮肤试验。如发生过敏性休克，应就地抢救，予以保持气道畅通、吸氧及应用肾上腺素、糖皮质激素等治疗措施。 　　2.传染性单核细胞增多症患者应用本品易发生皮疹，应避免使用。 　　3.疗程较长患者应检查肝、肾功能和血常规。 　　4.阿莫西林可导致采用Benedict或Fehling试剂的尿糖试验出现假阳性。 　　5.下列情况应慎用： 　　(1)有哮喘、枯草热等过敏性疾病史者。 　　(2)老年人和肾功能严重损害时可能须调整剂量。','1．丙磺舒竞争性地减少本品的肾小管分泌，两者同时应用可引起阿莫西林血浓度升高、半衰期延长。 　　2．氯霉素、大环内酯类、磺胺类和四环素类药物在体外干扰阿莫西林的抗菌作用，但其临床意义不明。','遮光，密封保存。','铝塑起泡包装:0.5g/粒,20粒/小盒','36个月。','1',NULL,NULL,'1547700944244'),('35b1ee141ad211e9a3ba5254000ab703','0e6f252a1ad111e9a3ba5254000ab703','脑白金','棕色液体。','失眠,便秘','(胶囊)025克*10粒+(口服液)250毫升','胶囊：每日一次，睡前一小时服用，每次1粒，60岁以上每次2粒（可根据自身情况调整用量0.5~2粒） 口服液：每日1-3次空腹服用，首次服用建议每次2杯（50ml）,以后每次1杯（25ml），每次服用完拧紧盖，放冰箱保存，10日内食完，不得嘴对瓶直接饮用。','尚不明确。','青少年、孕妇及哺乳期妇女、自身免疫性疾病患者及抑郁型精神病患者。','1.脑白金并非人人皆可，儿童、少年、孕妇、乳母均不宜服用。 2.自身免疫性疾病患者，如风湿和类风湿关节炎、红斑狼疮、某些肾炎患者也不宜服用。 3.抑郁型精神病，如老年抑郁症（其主要症状之一就是睡不好觉）也不宜服用。','如与其他药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。','置于阴凉干燥处。','盒装','24个月','1',NULL,NULL,'1547782577226'),('62174d141a1511e9a3ba5254000ab703','d3c75a261a1411e9a3ba5254000ab703','六味地黄丸','本品为棕褐色至黑褐色的大蜜丸；味甜而酸。','滋阴补肾。','大蜜丸每丸重9克','口服。大蜜丸一次1丸，一日2次。','尚不明确。','尚不明确。','1.忌不易消化食物。 2.感冒发热病人不宜服用。 3.有高血压、心脏病、肝病、糖尿病、肾病等慢性病严重者应在医师指导下服用。 4.儿童、孕妇、哺乳期妇女应在医师指导下服用。 5.服药4周症状无缓解，应去医院就诊。 6.对本品过敏者禁用，过敏体质者慎用。 7.本品性状发生改变时禁止使用。 8.儿童必须在成人监护下使用。 9.请将本品放在儿童不能接触的地方。 10.如正在使用其他药品，使用本品前请咨询医师或药师。','尚不明确。','密封。','瓶装','60个月','1',NULL,NULL,'1547701476154'),('74509e821acc11e9a3ba5254000ab703','5fc53c771acb11e9a3ba5254000ab703','小柴胡颗粒','本品为黄色至棕褐色的颗粒；味甜。或为棕黄色的颗粒；味淡、微辛。','解表散热，疏肝和胃。','每袋装10g，4g、2.5g（无蔗糖）','开水冲服。一次l一2袋，一日3次。','尚不明确。','尚不明确。','1.忌烟、酒及辛辣、生冷、油腻食物。 2.不宜在服药期间同时服用滋补性中药。 3.风寒感冒者不适用。 4.糖尿病患者及有高血压、心脏病、肝病、肾病等慢性病严重者应在医师指导下服用。 5.儿童、孕妇、哺乳期妇女、年老体弱者应在医师指导下服用。 6.发热体温超过38.5度的患者，应去医院就诊。 7.服药3天症状无缓解，应去医院就诊。 8.对本品过敏者禁用，过敏体质者慎用。 9.本品性状发生改变时禁止使用。 10.儿童必须在成人监护下使用。 11.请将本品放在儿童不能接触的地方。 12.如正在使用其他药品，使用本品前请咨询医师或药师。','尚不明确。','密封。','袋装','36个月','1',NULL,NULL,'1547780105329'),('bfe2af761acf11e9a3ba5254000ab703','4d7a80b11ace11e9a3ba5254000ab703','健胃消食片','本品为浅棕黄色的片或薄膜衣片，也可为异形片，薄膜衣片除去包衣后显浅棕黄色；气微香，味微甜、酸。','健胃消食。','片剂，每片重（1）0.8克或（2）0.5克','口服，可以咀嚼。规格（1）一次3片，一日3次。规格（2）成人一次4-6片，儿童二岁至四岁一次2片，五岁至八岁一次3片，九岁至十四岁一次4片；一日三次。小儿酌减。','尚未明确。','尚不明确。','1. 饮食宜清淡，忌酒及辛辣、生冷、油腻食物。 2. 有高血压、心脏病、肝病、糖尿病、肾病等慢性病严重者应在医师指导下服用。 3. 儿童、孕妇、哺乳期妇女、年老体弱者应在医师指导下服用。 4. 服药3天症状无缓解，应去医院就诊。 5. 对本品过敏者禁用，过敏体质者慎用。 6. 本品性状发生改变时禁止使用。 7. 儿童必须在成人监护下使用。 8. 请将本品放在儿童不能接触的地方。 9. 如正在使用其他药品，使用本品前请咨询医师或药师。','如与其他药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。','密封。','铝箔纸','24个月','1',NULL,NULL,'1547781520610'),('e01a3ce61acd11e9a3ba5254000ab703','95f218321acd11e9a3ba5254000ab703','藿香正气水','本品为深棕色的澄清液体（贮存略有沉淀）；味辛、苦。','解表化湿，理气和中。','酊剂10毫升每支','口服。一次半支(5毫升)～1支(10毫升)，一日2次，用时摇匀。','服用藿香正气水有发生药症、紫癜的个别报道。','尚不明确。','1.忌烟、酒及辛辣、生冷、油腻食物，饮食宜清淡。 2.不宜在服药期间同时服用滋补性中药。 3.有高血压、心脏病、肝病、糖尿病、肾病等慢性病严重者应在医师指导下服用。 4.儿童、孕妇、哺乳期妇女、年老体弱者应在医师指导下服用。 5.吐泻严重者应及时去医院就诊。 6.本品含乙醇(酒精)40%～50%，服药后不得驾驶机、车、船、从事高空作业、机械作业及操作精密仪器。 7.严格按用法用量服用，本品不宜长期服用。 8.服药3天症状无缓解，应去医院就诊。 9.对本品及酒精过敏者禁用，过敏体质者慎用。 10.本品性状发生变化时禁止服用。','如与其他药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。','密封。','瓶装','36个月','1',NULL,NULL,'1547780715665'),('e1db052b1a1811e9a3ba5254000ab703','d91bf3dd1a1511e9a3ba5254000ab703','排毒养颜胶囊','本品为帽紫红、体白色胶囊剂，内容物为黄棕色至棕褐色的粉末；味微苦。','益气活血，通便排毒。用于气虚血瘀，热毒内盛所致便秘、座疮、颜面色斑。','每粒装0.4克','1 、便秘、排便不爽者。一次3-6粒，一日2次，根据大便情况酌情加减药量，以大便通畅，每天1-2次为宜。 2 、大便一日1次者，以1粒起服，每日服1-2次，根据大便情况逐渐加量至大便通畅，每天1-2次为宜。','尚不明确。','孕妇忌服。','1、服药期间忌食生冷、辛辣油腻之物。  2、服药后症状无改善，或症状加重，或出现新的症状者，应立即停药并到医院就诊。  3、服用本品同时不宜服用含藜芦、五灵脂、皂夹或其制剂，不宜喝茶和吃萝卜以免影响药效。  4、小儿及年老体弱者，应在医师指导下服用。  5、对本品过敏者禁用， 过敏体质者慎用。 6、本品性状发生改变时禁止使用。  7、儿童必须在成人监护下使用。  8、请将此药品放在儿童不能接触的地方。  9、如正在服用其他药品，使用本品前请咨询医师或药师。','如与其他药物同时使用可能会发生药物相互作用，详情请咨询医师或药师。','密封。','瓶装','64个月','1',NULL,NULL,'1547702978945');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;