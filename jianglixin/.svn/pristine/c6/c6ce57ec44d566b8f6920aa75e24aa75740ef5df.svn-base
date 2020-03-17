/*
 Navicat Premium Data Transfer

 Source Server         : project
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost:3306
 Source Schema         : logistics

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : 65001

 Date: 27/02/2018 12:53:22
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `account_indent` int(11) NOT NULL COMMENT '订单id',
  `account_money` float(255, 2) DEFAULT NULL COMMENT '订单收费',
  PRIMARY KEY (`account_indent`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 502.22);
INSERT INTO `account` VALUES (2, 494.88);
INSERT INTO `account` VALUES (3, 496.01);
INSERT INTO `account` VALUES (4, 511.11);
INSERT INTO `account` VALUES (5, 509.12);
INSERT INTO `account` VALUES (6, 178.12);

-- ----------------------------
-- Table structure for allow
-- ----------------------------
DROP TABLE IF EXISTS `allow`;
CREATE TABLE `allow`  (
  `allow_power` int(255) NOT NULL COMMENT '外联power_id',
  `allow_post` int(255) DEFAULT NULL COMMENT '外联post_id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of allow
-- ----------------------------
INSERT INTO `allow` VALUES (5, 4);
INSERT INTO `allow` VALUES (21, 4);
INSERT INTO `allow` VALUES (22, 4);
INSERT INTO `allow` VALUES (23, 4);
INSERT INTO `allow` VALUES (24, 4);
INSERT INTO `allow` VALUES (6, 4);
INSERT INTO `allow` VALUES (25, 4);
INSERT INTO `allow` VALUES (1, 1);
INSERT INTO `allow` VALUES (7, 1);
INSERT INTO `allow` VALUES (8, 1);
INSERT INTO `allow` VALUES (9, 1);
INSERT INTO `allow` VALUES (10, 1);
INSERT INTO `allow` VALUES (11, 1);
INSERT INTO `allow` VALUES (12, 1);
INSERT INTO `allow` VALUES (13, 1);
INSERT INTO `allow` VALUES (2, 1);
INSERT INTO `allow` VALUES (14, 1);
INSERT INTO `allow` VALUES (3, 1);
INSERT INTO `allow` VALUES (15, 1);
INSERT INTO `allow` VALUES (16, 1);
INSERT INTO `allow` VALUES (17, 1);
INSERT INTO `allow` VALUES (4, 1);
INSERT INTO `allow` VALUES (18, 1);
INSERT INTO `allow` VALUES (19, 1);
INSERT INTO `allow` VALUES (20, 1);
INSERT INTO `allow` VALUES (5, 1);
INSERT INTO `allow` VALUES (21, 1);
INSERT INTO `allow` VALUES (22, 1);
INSERT INTO `allow` VALUES (23, 1);
INSERT INTO `allow` VALUES (24, 1);
INSERT INTO `allow` VALUES (6, 1);
INSERT INTO `allow` VALUES (25, 1);
INSERT INTO `allow` VALUES (26, 1);
INSERT INTO `allow` VALUES (1, 2);
INSERT INTO `allow` VALUES (7, 2);
INSERT INTO `allow` VALUES (8, 2);
INSERT INTO `allow` VALUES (9, 2);
INSERT INTO `allow` VALUES (10, 2);
INSERT INTO `allow` VALUES (11, 2);
INSERT INTO `allow` VALUES (12, 2);
INSERT INTO `allow` VALUES (13, 2);
INSERT INTO `allow` VALUES (2, 2);
INSERT INTO `allow` VALUES (14, 2);
INSERT INTO `allow` VALUES (3, 2);
INSERT INTO `allow` VALUES (15, 2);
INSERT INTO `allow` VALUES (16, 2);
INSERT INTO `allow` VALUES (17, 2);
INSERT INTO `allow` VALUES (4, 2);
INSERT INTO `allow` VALUES (18, 2);
INSERT INTO `allow` VALUES (19, 2);
INSERT INTO `allow` VALUES (20, 2);
INSERT INTO `allow` VALUES (5, 2);
INSERT INTO `allow` VALUES (21, 2);
INSERT INTO `allow` VALUES (22, 2);
INSERT INTO `allow` VALUES (23, 2);
INSERT INTO `allow` VALUES (24, 2);
INSERT INTO `allow` VALUES (6, 2);
INSERT INTO `allow` VALUES (25, 2);
INSERT INTO `allow` VALUES (26, 2);
INSERT INTO `allow` VALUES (1, 3);
INSERT INTO `allow` VALUES (7, 3);
INSERT INTO `allow` VALUES (8, 3);
INSERT INTO `allow` VALUES (9, 3);
INSERT INTO `allow` VALUES (10, 3);
INSERT INTO `allow` VALUES (11, 3);
INSERT INTO `allow` VALUES (12, 3);
INSERT INTO `allow` VALUES (13, 3);
INSERT INTO `allow` VALUES (2, 3);
INSERT INTO `allow` VALUES (14, 3);
INSERT INTO `allow` VALUES (3, 3);
INSERT INTO `allow` VALUES (15, 3);
INSERT INTO `allow` VALUES (16, 3);
INSERT INTO `allow` VALUES (17, 3);
INSERT INTO `allow` VALUES (4, 3);
INSERT INTO `allow` VALUES (18, 3);
INSERT INTO `allow` VALUES (19, 3);
INSERT INTO `allow` VALUES (5, 3);
INSERT INTO `allow` VALUES (21, 3);
INSERT INTO `allow` VALUES (22, 3);
INSERT INTO `allow` VALUES (24, 3);
INSERT INTO `allow` VALUES (6, 3);
INSERT INTO `allow` VALUES (25, 3);
INSERT INTO `allow` VALUES (26, 3);

-- ----------------------------
-- Table structure for bills
-- ----------------------------
DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills`  (
  `bills_indent` int(255) NOT NULL COMMENT '订单id',
  `bills_users` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户id',
  `bills_shape` int(255) DEFAULT NULL COMMENT '用户删除订单的状态',
  PRIMARY KEY (`bills_indent`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bills
-- ----------------------------
INSERT INTO `bills` VALUES (1, 'aaa555', 1);
INSERT INTO `bills` VALUES (2, 'aaa555', 1);
INSERT INTO `bills` VALUES (3, 'aaa555', 1);
INSERT INTO `bills` VALUES (4, 'aaa555', 1);
INSERT INTO `bills` VALUES (5, 'aaa555', 1);
INSERT INTO `bills` VALUES (6, 'aaa555', 1);

-- ----------------------------
-- Table structure for car
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `car_id` int(50) NOT NULL AUTO_INCREMENT COMMENT '运输车辆编号',
  `car_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车牌',
  `car_type` int(255) NOT NULL COMMENT '车型',
  `car_size` int(11) NOT NULL COMMENT '车辆载重容量',
  `car_state` int(1) NOT NULL COMMENT '车辆状态',
  `car_belong_station` int(255) DEFAULT NULL COMMENT '网点id',
  `car_arrive_station` int(255) DEFAULT NULL COMMENT '到达网点id',
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of car
-- ----------------------------
INSERT INTO `car` VALUES (1, '豫A88888', 1, 20, 2, 1, NULL);
INSERT INTO `car` VALUES (2, '豫B33333', 1, 20, 2, 2, NULL);
INSERT INTO `car` VALUES (3, '豫A66666', 1, 5, 2, 1, NULL);
INSERT INTO `car` VALUES (4, '豫B55555', 1, 5, 2, 2, NULL);

-- ----------------------------
-- Table structure for cargo
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo`  (
  `cargo_indent` int(225) NOT NULL COMMENT '订单id',
  `cargo_weight` float(225, 2) NOT NULL COMMENT '货物重量',
  `cargo_size` float(225, 2) NOT NULL COMMENT '货物大小',
  `cargo_type` int(255) NOT NULL COMMENT '货物类型外联type\r\n',
  `cargo_explain` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '货物备注',
  PRIMARY KEY (`cargo_indent`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES (1, 2.10, 5.00, 1, '苹果');
INSERT INTO `cargo` VALUES (2, 1.11, 1.21, 7, '金');
INSERT INTO `cargo` VALUES (3, 1.50, 1.10, 2, '玻璃');
INSERT INTO `cargo` VALUES (4, 2.30, 12.50, 1, '香蕉');
INSERT INTO `cargo` VALUES (5, 5.22, 2.20, 4, '铅块');
INSERT INTO `cargo` VALUES (6, 15.30, 20.60, 6, ' 炸药');

-- ----------------------------
-- Table structure for cartype
-- ----------------------------
DROP TABLE IF EXISTS `cartype`;
CREATE TABLE `cartype`  (
  `cartype_id` int(255) NOT NULL AUTO_INCREMENT,
  `cartype_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`cartype_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cartype
-- ----------------------------
INSERT INTO `cartype` VALUES (1, '汽车');
INSERT INTO `cartype` VALUES (2, '三轮车');
INSERT INTO `cartype` VALUES (3, '半挂');
INSERT INTO `cartype` VALUES (4, '前四后八');
INSERT INTO `cartype` VALUES (5, '十来米厢式');

-- ----------------------------
-- Table structure for comego
-- ----------------------------
DROP TABLE IF EXISTS `comego`;
CREATE TABLE `comego`  (
  `comego_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出库id',
  `comego_indent` int(255) NOT NULL COMMENT '订单编号',
  `comego_time` date NOT NULL COMMENT '出入库时间',
  `comego_station` int(255) NOT NULL COMMENT '网点id',
  `comego_car` int(255) DEFAULT NULL,
  PRIMARY KEY (`comego_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for comein
-- ----------------------------
DROP TABLE IF EXISTS `comein`;
CREATE TABLE `comein`  (
  `comein_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '入库ID',
  `comein_indent` int(255) NOT NULL COMMENT '订单编号',
  `comein_time` date DEFAULT NULL COMMENT '入库时间',
  `comein_station` int(255) DEFAULT NULL COMMENT '网点ID',
  PRIMARY KEY (`comein_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`  (
  `company_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司名称',
  `company_introduce` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '公司简介',
  `company_phone` bigint(20) DEFAULT NULL COMMENT '公司电话',
  PRIMARY KEY (`company_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for driver
-- ----------------------------
DROP TABLE IF EXISTS `driver`;
CREATE TABLE `driver`  (
  `driver_worker` int(11) NOT NULL COMMENT '驾驶人编号',
  `driver_car` int(255) DEFAULT NULL COMMENT '车辆id'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of driver
-- ----------------------------
INSERT INTO `driver` VALUES (23423, 1);
INSERT INTO `driver` VALUES (0, 1);
INSERT INTO `driver` VALUES (2, 1);
INSERT INTO `driver` VALUES (2, 1);
INSERT INTO `driver` VALUES (6666666, 1);

-- ----------------------------
-- Table structure for indent
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent`  (
  `indent_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `indent_time` date NOT NULL COMMENT '订单时间',
  `indent_receiver_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人姓名',
  `indent_receiver_phone` bigint(11) NOT NULL COMMENT '收货人手机号',
  `indent_receiver_postcode` int(6) NOT NULL COMMENT '收货人邮编',
  `indent_receiver_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人地址',
  `indent_shipper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发货人姓名',
  `indent_shipper_phone` bigint(11) NOT NULL COMMENT '发货人手机号',
  `indent_shipper_postcode` int(6) NOT NULL COMMENT '发货人邮编',
  `indent_shipper_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发货人地址',
  `indent_situation` int(20) NOT NULL,
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of indent
-- ----------------------------
INSERT INTO `indent` VALUES (1, '2018-02-26', '郑州物流', 13838458751, 451150, '2', '闪电物流', 13838457862, 451100, '1', 3);
INSERT INTO `indent` VALUES (2, '2018-02-26', '郑州物流', 13884568759, 451150, '2', '闪电物流', 13838457862, 451100, '1', 3);
INSERT INTO `indent` VALUES (3, '2018-02-26', '北京物理', 13818555545, 451150, '2', '闪电物流', 13838457862, 451100, '1', 3);
INSERT INTO `indent` VALUES (4, '2018-02-26', '余姚市', 13818555545, 451150, '1', '闪电物流', 13838457862, 451100, '2', 3);
INSERT INTO `indent` VALUES (5, '2018-02-26', '索拉卡', 13838458751, 458525, '1', '闪电物流', 13838457862, 451100, '2', 3);
INSERT INTO `indent` VALUES (6, '2018-02-26', '风暴', 13838458751, 451150, '2', '闪电物流', 13838457862, 451100, '1', 3);

-- ----------------------------
-- Table structure for keeper
-- ----------------------------
DROP TABLE IF EXISTS `keeper`;
CREATE TABLE `keeper`  (
  `keeper_worker` int(255) NOT NULL COMMENT '员工id管理员',
  `keeper_warehose` int(255) NOT NULL COMMENT '仓库id',
  PRIMARY KEY (`keeper_worker`, `keeper_warehose`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of keeper
-- ----------------------------
INSERT INTO `keeper` VALUES (1111111, 3);
INSERT INTO `keeper` VALUES (3333333, 1);
INSERT INTO `keeper` VALUES (66666666, 2);
INSERT INTO `keeper` VALUES (454352345, 1);
INSERT INTO `keeper` VALUES (454352345, 2);
INSERT INTO `keeper` VALUES (454352345, 3);
INSERT INTO `keeper` VALUES (666666665, 2);
INSERT INTO `keeper` VALUES (966986986, 2);
INSERT INTO `keeper` VALUES (966986986, 3);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `post_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位编号',
  `post_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职位名字',
  PRIMARY KEY (`post_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '董事长');
INSERT INTO `post` VALUES (2, '总经理');
INSERT INTO `post` VALUES (3, '网点经理');
INSERT INTO `post` VALUES (4, '秘书');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power`  (
  `power_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `power_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '权限类型',
  `power_parent` int(255) DEFAULT NULL COMMENT '父类权限',
  `power_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`power_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES (1, '订单管理', 0, NULL);
INSERT INTO `power` VALUES (2, '用户管理', 0, NULL);
INSERT INTO `power` VALUES (3, '职员管理', 0, NULL);
INSERT INTO `power` VALUES (4, '网点管理', 0, NULL);
INSERT INTO `power` VALUES (5, '车辆管理', 0, NULL);
INSERT INTO `power` VALUES (6, '其他', 0, NULL);
INSERT INTO `power` VALUES (7, '查询所有订单', 1, '/lightning3/before/yuhaiyang/showIndent.jsp');
INSERT INTO `power` VALUES (8, '订单审核', 1, '/lightning3/before/yuhaiyang/auditIndent.jsp');
INSERT INTO `power` VALUES (9, '订单出库', 1, '/lightning3/before/yuhaiyang/comeinIndent.jsp');
INSERT INTO `power` VALUES (10, '订单发车', 1, '/lightning3/before/yuhaiyang/comegoIndent.jsp');
INSERT INTO `power` VALUES (11, '来货车辆', 1, '/lightning3/before/wangzelong/comein.jsp');
INSERT INTO `power` VALUES (12, '车辆返回', 1, '/lightning3/before/wangzelong/gohome.jsp');
INSERT INTO `power` VALUES (13, '订单到达', 1, '/lightning3/before/yuhaiyang/comegoHome.jsp');
INSERT INTO `power` VALUES (14, '用户查询', 2, '/lightning3/later/makui/showAll.jsp');
INSERT INTO `power` VALUES (15, '角色管理', 3, '/lightning3/Post/findShowPost.action');
INSERT INTO `power` VALUES (16, '权限管理', 3, '/lightning3/before/wangjia/admin.jsp');
INSERT INTO `power` VALUES (17, '员工管理', 3, '/lightning3/before/wangjia/showWorker.jsp');
INSERT INTO `power` VALUES (18, '网点信息', 4, '/lightning3/Station/findStationCount.action');
INSERT INTO `power` VALUES (19, '增加网点', 4, '/lightning3/before/wuminghui/insertStation.jsp');
INSERT INTO `power` VALUES (21, '车辆信息', 5, '/lightning3/Car/findCarCount.action');
INSERT INTO `power` VALUES (22, '车辆类型增加', 5, '/lightning3/before/wuminghui/insertCartype.jsp');
INSERT INTO `power` VALUES (24, '车辆信息增加', 5, '/lightning3/before/wuminghui/insertCar.jsp');
INSERT INTO `power` VALUES (25, '订单统计', 6, '/lightning3/before/yuhaiyang/showNowDateIndent.jsp');
INSERT INTO `power` VALUES (26, '价格与货物类型', 6, '/lightning3/before/wangzelong/showPrice.jsp');

-- ----------------------------
-- Table structure for price
-- ----------------------------
DROP TABLE IF EXISTS `price`;
CREATE TABLE `price`  (
  `price_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '价格编号 ',
  `price_km` float(10, 2) DEFAULT NULL COMMENT '公里数每元 ',
  `price_ton` float(10, 2) DEFAULT NULL COMMENT '每吨多少钱',
  `price_piece` float(10, 2) DEFAULT NULL COMMENT '每立方米多少钱',
  `price_province` int(6) DEFAULT NULL COMMENT '燃油费',
  `price_explain` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '价格说明填写栏',
  PRIMARY KEY (`price_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of price
-- ----------------------------
INSERT INTO `price` VALUES (1, 1.30, 3.20, 1.10, 100, '燃油费');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `role_worker` int(255) DEFAULT NULL COMMENT '员工的编号',
  `role_post` int(255) DEFAULT NULL COMMENT '职位编号'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (444444, 1);
INSERT INTO `role` VALUES (111111, 3);
INSERT INTO `role` VALUES (222222, 3);
INSERT INTO `role` VALUES (555555, 4);
INSERT INTO `role` VALUES (333333, 1);
INSERT INTO `role` VALUES (666666, 4);
INSERT INTO `role` VALUES (777777, 1);

-- ----------------------------
-- Table structure for situation
-- ----------------------------
DROP TABLE IF EXISTS `situation`;
CREATE TABLE `situation`  (
  `situation_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '状态ID',
  `situation_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态名称',
  PRIMARY KEY (`situation_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of situation
-- ----------------------------
INSERT INTO `situation` VALUES (1, '未发车');
INSERT INTO `situation` VALUES (2, '未出库');
INSERT INTO `situation` VALUES (3, '待审核');
INSERT INTO `situation` VALUES (4, '已完成');
INSERT INTO `situation` VALUES (5, '运输中');
INSERT INTO `situation` VALUES (6, '订单异常');
INSERT INTO `situation` VALUES (7, '来货入库');

-- ----------------------------
-- Table structure for state
-- ----------------------------
DROP TABLE IF EXISTS `state`;
CREATE TABLE `state`  (
  `state_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆状态id',
  `state_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '车辆状态信息',
  PRIMARY KEY (`state_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of state
-- ----------------------------
INSERT INTO `state` VALUES (1, '运输中');
INSERT INTO `state` VALUES (2, '空闲');
INSERT INTO `state` VALUES (3, '运回中');
INSERT INTO `state` VALUES (4, '维护中');
INSERT INTO `state` VALUES (5, '休息中');

-- ----------------------------
-- Table structure for station
-- ----------------------------
DROP TABLE IF EXISTS `station`;
CREATE TABLE `station`  (
  `station_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '网点编号',
  `station_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网点名字',
  `station_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '网点具体地址',
  `station_admin` int(255) DEFAULT NULL COMMENT '网点经理',
  `station_phone` int(11) DEFAULT NULL COMMENT '网点联系电话',
  PRIMARY KEY (`station_id`, `station_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of station
-- ----------------------------
INSERT INTO `station` VALUES (1, '郑州闪电', '郑州', 111111, 666666);
INSERT INTO `station` VALUES (2, '北京闪电', '北京', 222222, 888888);

-- ----------------------------
-- Table structure for status
-- ----------------------------
DROP TABLE IF EXISTS `status`;
CREATE TABLE `status`  (
  `status_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '状态id',
  `status_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态信息',
  PRIMARY KEY (`status_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of status
-- ----------------------------
INSERT INTO `status` VALUES (1, '在职');
INSERT INTO `status` VALUES (2, '离职');
INSERT INTO `status` VALUES (3, '驾驶中');
INSERT INTO `status` VALUES (4, '空闲');

-- ----------------------------
-- Table structure for time
-- ----------------------------
DROP TABLE IF EXISTS `time`;
CREATE TABLE `time`  (
  `time_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '仓库id',
  `time_car_id` int(255) NOT NULL,
  `time_start` datetime(0) NOT NULL COMMENT 'type_id',
  `time_end` datetime(0) DEFAULT NULL COMMENT '所属网点',
  `time_date` int(255) NOT NULL,
  PRIMARY KEY (`time_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `type_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '类型编号（货物）',
  `type` char(40) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类别（货物）',
  PRIMARY KEY (`type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1, '水果');
INSERT INTO `type` VALUES (2, ' 易碎');
INSERT INTO `type` VALUES (3, '饼干');
INSERT INTO `type` VALUES (4, '金属');
INSERT INTO `type` VALUES (5, '液体');
INSERT INTO `type` VALUES (6, '危险品');
INSERT INTO `type` VALUES (7, '贵金属');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `users_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id(账号)',
  `users_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户密码',
  `users_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `users_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户电话',
  `users_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户身份正号码',
  `users_postcode` int(255) NOT NULL COMMENT '用户邮编',
  PRIMARY KEY (`users_id`, `users_phone`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('aaa555', 'aaa555', '闪电物流', '13838457862', '41018419980101555x', 451100);

-- ----------------------------
-- Table structure for way
-- ----------------------------
DROP TABLE IF EXISTS `way`;
CREATE TABLE `way`  (
  `way_car` int(255) NOT NULL COMMENT '车辆id',
  `way_direction` int(255) DEFAULT NULL COMMENT '运送哪里的网点',
  `way_km` float(255, 2) DEFAULT NULL COMMENT '运输距离',
  PRIMARY KEY (`way_car`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of way
-- ----------------------------
INSERT INTO `way` VALUES (1, 2, 300.00);
INSERT INTO `way` VALUES (2, 1, 300.00);
INSERT INTO `way` VALUES (3, 2, 300.00);
INSERT INTO `way` VALUES (4, 1, 300.00);

-- ----------------------------
-- Table structure for worker
-- ----------------------------
DROP TABLE IF EXISTS `worker`;
CREATE TABLE `worker`  (
  `worker_id` int(255) NOT NULL COMMENT '员工编号',
  `worker_password` int(255) NOT NULL COMMENT '员工密码',
  `worker_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工名字',
  `worker_idcard` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工身份证',
  `worker_sex` int(255) NOT NULL COMMENT '性别',
  `worker_phone` bigint(255) NOT NULL COMMENT '手机号',
  `worker_post` int(255) DEFAULT NULL COMMENT '职位员工表外联',
  `worker_station` int(255) DEFAULT NULL COMMENT '所属网点',
  `worker_status` int(255) DEFAULT NULL COMMENT '员工状态',
  PRIMARY KEY (`worker_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of worker
-- ----------------------------
INSERT INTO `worker` VALUES (111111, 111111, '王佳', '410183199707081013', 1, 13838285242, 3, 1, 1);
INSERT INTO `worker` VALUES (222222, 222222, '吴明辉', '410183199707081011', 1, 13838285245, 3, 2, 1);
INSERT INTO `worker` VALUES (333333, 333333, '王泽隆', '410184198002025555', 1, 13838111548, 1, 1, 1);
INSERT INTO `worker` VALUES (444444, 444444, '马奎', '410183199707081011', 1, 13838285243, 1, 2, 1);
INSERT INTO `worker` VALUES (555555, 555555, '于海洋', '410183199707081016', 1, 13838285248, 4, 1, 1);
INSERT INTO `worker` VALUES (666666, 666666, '朱磊', '410148199203056555', 1, 18336397221, 4, 2, 1);
INSERT INTO `worker` VALUES (777777, 777777, '四大', '410184199901011231', 1, 13838111548, 1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
