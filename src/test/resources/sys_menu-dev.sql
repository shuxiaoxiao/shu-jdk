/*
Navicat MySQL Data Transfer

Source Server         : bmkp_test_tx
Source Server Version : 50505
Source Host           : tdsql-4b9a8yqj.gz.cdb.myqcloud.com:23
Source Database       : saas

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-07-25 18:27:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `pid` bigint(20) DEFAULT NULL COMMENT '父id',
  `level` tinyint(4) DEFAULT NULL COMMENT '层级',
  `url` varchar(255) DEFAULT NULL COMMENT '请求地址',
  `type` tinyint(4) DEFAULT NULL COMMENT '菜单类型。1菜单, 2按钮',
  `system_type` tinyint(4) DEFAULT NULL COMMENT '系统类型 1saas车管  2saas后台',
  `is_leaf` tinyint(4) DEFAULT NULL COMMENT '是否是叶子节点 0 不是 1是',
  `icon_url` varchar(255) DEFAULT NULL COMMENT '图标路径',
  `enabled` tinyint(4) DEFAULT NULL COMMENT '是否可用。1可用，0删除，-1失效',
  `sortno` int(11) DEFAULT NULL COMMENT '排序号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `ele_id` varchar(255) DEFAULT NULL COMMENT '前端标识',
  `href` varchar(255) DEFAULT NULL COMMENT '元素url',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=379 DEFAULT CHARSET=utf8mb4 COMMENT='菜单权限';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '账号中心', '0', '1', '', '1', '1', '0', '', '1', '1', null, null, 'account', 'https://devt.bmkp.cn/bmkp-saas-account/');
INSERT INTO `sys_menu` VALUES ('2', '组织机构管理', '1', '1', '', '2', '1', '0', '', '1', '1', null, null, 'orgManagement', '');
INSERT INTO `sys_menu` VALUES ('3', '机构管理', '2', '0', '/enterprise/selectPage', '2', '1', '0', '', '1', '1', null, null, 'orgManage', '/mechanism');
INSERT INTO `sys_menu` VALUES ('4', '新增机构', '3', '1', '/enterprise/add', '3', '1', '1', '', '1', '4', null, null, 'add_mechanism', '');
INSERT INTO `sys_menu` VALUES ('5', '编辑机构', '3', '0', '/enterprise/update', '3', '1', '1', '', '1', '5', null, null, 'edit_mechanism', '');
INSERT INTO `sys_menu` VALUES ('6', '禁用机构', '3', '0', '/enterprise/updateEnable', '3', '1', '1', '', '1', '6', null, null, 'ban_mechanism', '');
INSERT INTO `sys_menu` VALUES ('7', '查看机构', '3', '0', '/enterprise/showDetail', '3', '1', '1', '', '1', '7', null, null, 'show_mechanism', '');
INSERT INTO `sys_menu` VALUES ('8', '启用机构', '3', '0', '/enterprise/updateEnable', '3', '1', '1', '', '1', '8', null, null, 'run_mechanism', '');
INSERT INTO `sys_menu` VALUES ('9', '删除机构', '3', '0', '/enterprise/updateEnable', '3', '1', '1', '', '0', '9', null, null, 'delete_mechanism', '');
INSERT INTO `sys_menu` VALUES ('10', '导出机构EXCEL', '3', '0', '', '3', '1', '1', '', '0', '10', null, null, 'export_mechanism', '');
INSERT INTO `sys_menu` VALUES ('11', '查询机构', '3', '0', '/enterprise/selectPage2', '3', '1', '1', '', '1', '24', null, null, 'search_mechanism', '');
INSERT INTO `sys_menu` VALUES ('12', '角色管理', '2', '0', '/sysRole/selectPage', '2', '1', '0', '', '1', '2', null, null, 'roleManage', '/role');
INSERT INTO `sys_menu` VALUES ('13', '新增角色', '12', '1', '/sysRole/addRole', '3', '1', '1', '', '1', '19', null, null, 'addRole', '');
INSERT INTO `sys_menu` VALUES ('14', '查看角色', '12', '0', '/sysRole/getRoleDetail', '3', '1', '1', '', '1', '20', null, null, 'viewRole', '');
INSERT INTO `sys_menu` VALUES ('15', '编辑角色', '12', '0', '/sysRole/updateRole', '3', '1', '1', '', '1', '21', null, null, 'editRole', '');
INSERT INTO `sys_menu` VALUES ('16', '删除角色', '12', '0', '', '3', '1', '1', '', '0', '22', null, null, 'deleteRole', '');
INSERT INTO `sys_menu` VALUES ('17', '复制角色', '12', '1', '/sysRole/getRoleDetailCopy', '3', '1', '1', '', '1', '23', null, null, 'copyRole', '');
INSERT INTO `sys_menu` VALUES ('18', '查询角色', '12', '0', '/sysRole/selectPage2', '3', '1', '1', '', '1', '25', null, null, 'searchRole', '');
INSERT INTO `sys_menu` VALUES ('19', '帐号管理', '2', '0', '/sysUser/selectPage', '2', '1', '0', '', '1', '3', null, null, 'accountManage', '/account');
INSERT INTO `sys_menu` VALUES ('20', '新增账户', '19', '1', '/sysUser/add', '3', '1', '1', '', '1', '11', null, null, 'accountAdd', '');
INSERT INTO `sys_menu` VALUES ('21', '查看账户', '19', '0', '/sysUser/showDetail', '3', '1', '1', '', '1', '12', null, null, 'checkAccount', '');
INSERT INTO `sys_menu` VALUES ('22', '编辑账户', '19', '0', '/sysUser/update', '3', '1', '1', '', '1', '13', null, null, 'editAccount', '');
INSERT INTO `sys_menu` VALUES ('23', '启用账户', '19', '0', '/sysUser/updateEnable', '3', '1', '1', '', '1', '14', null, null, 'startAccount', '');
INSERT INTO `sys_menu` VALUES ('24', '账户管理_数据权限', '19', '0', '/sysUser/authEnterprise', '3', '1', '1', '', '1', '15', null, null, 'dataPermission', '');
INSERT INTO `sys_menu` VALUES ('25', '账户管理_禁用', '19', '0', '/sysUser/updateEnable', '3', '1', '1', '', '1', '16', null, null, 'forbidden', '');
INSERT INTO `sys_menu` VALUES ('26', '账户管理_删除', '19', '0', '/sysUser/updateEnable', '3', '1', '1', '', '0', '17', null, null, 'accountDelete', '');
INSERT INTO `sys_menu` VALUES ('27', '账户管理_导出excel', '19', '0', '', '3', '1', '1', '', '0', '18', null, null, 'exportAllTable', '');
INSERT INTO `sys_menu` VALUES ('28', '查询账户', '19', '0', '/sysUser/selectPage2', '3', '1', '1', '', '1', '26', null, null, 'searchAccount', '');
INSERT INTO `sys_menu` VALUES ('29', '出租车', '0', '1', '', '1', '1', '0', '', '1', '2', null, null, 'taxi', 'https://devt.bmkp.cn/bmkp-saas-taxi/');
INSERT INTO `sys_menu` VALUES ('30', '车辆管理', '29', '1', '', '2', '1', '0', '', '1', '3', null, null, 'vehicle', '');
INSERT INTO `sys_menu` VALUES ('31', '现有车辆', '30', '0', '/car/selectPage', '2', '1', '0', '', '1', '4', null, null, 'vehicleManagement', '/vehicleManagement/vehicleTable');
INSERT INTO `sys_menu` VALUES ('32', '新增车辆', '31', '1', '/car/add,/car/updateDriveLicense,/car/updateTransportCert,/car/updateCarInsurance,/car/updateCarDevice', '3', '1', '1', '', '1', '5', null, null, 'VehicleListAddBtn', '/vehicleManagement/vehiclePanel');
INSERT INTO `sys_menu` VALUES ('33', '车辆查询', '31', '0', '/car/selectPage2', '3', '1', '1', '', '1', '6', null, null, 'VehicleListQueryBtn', '');
INSERT INTO `sys_menu` VALUES ('34', '车辆查看', '31', '1', '/car/showDetail,/driver/selectListByCarId', '3', '1', '1', '', '1', '7', null, null, 'VehicleListCheckBtn', '/vehicleManagement/vehicleView');
INSERT INTO `sys_menu` VALUES ('35', '车辆编辑', '31', '1', '/car/updateCarBaseInfo,/car/updateDriveLicense,/car/updateTransportCert,/car/updateCarInsurance,/car/updateCarDevice', '3', '1', '1', '', '1', '8', null, null, 'VehicleListEditBtn', '/vehicleManagement/vehiclePanel');
INSERT INTO `sys_menu` VALUES ('36', '车辆出售', '31', '0', '', '3', '1', '1', '', '0', '9', null, null, 'VehicleListSaleBtn', '');
INSERT INTO `sys_menu` VALUES ('37', '车辆删除', '31', '0', '/car/delete', '3', '1', '1', '', '1', '10', null, null, 'VehicleListDeleteBtn', '');
INSERT INTO `sys_menu` VALUES ('38', '司机管理', '29', '1', '', '2', '1', '0', '', '1', '11', null, null, 'driver', '');
INSERT INTO `sys_menu` VALUES ('39', '现有司机', '38', '0', '/driver/selectPage', '2', '1', '0', '', '1', '12', null, null, 'driverManagement', '/driverManagement/driverTable');
INSERT INTO `sys_menu` VALUES ('40', '新增司机', '39', '1', '/driver/addInfo', '3', '1', '1', '', '1', '13', null, null, 'addDriverBtn', '/driverManagement/driverPanel');
INSERT INTO `sys_menu` VALUES ('41', '导出EXCEL', '39', '0', '', '3', '1', '1', '', '0', '14', null, null, 'exportDriverBtn', '');
INSERT INTO `sys_menu` VALUES ('42', '查询司机', '39', '0', '/driver/selectPage2', '3', '1', '1', '', '1', '15', null, null, 'searchDriverBtn', '');
INSERT INTO `sys_menu` VALUES ('43', '查看司机', '39', '1', '/driver/selectDetailById,/car/getDriverBindCars', '3', '1', '1', '', '1', '16', null, null, 'viewDriverBtn', '/driverManagement/driverView');
INSERT INTO `sys_menu` VALUES ('44', '编辑司机', '39', '1', '/driver/updateInfo,/driver/updateIdentify,/driver/updateDrivingLicence,/driver/updateStaffLicence', '3', '1', '1', '', '1', '17', null, null, 'editDriverBtn', '/driverManagement/driverPanel');
INSERT INTO `sys_menu` VALUES ('45', '绑定车辆', '39', '1', '/car/selectPage2,/driver/binding', '3', '1', '1', '', '1', '18', null, null, 'bindBtn', '');
INSERT INTO `sys_menu` VALUES ('46', '解绑车辆', '39', '1', '/driver/unbind', '3', '1', '1', '', '1', '19', null, null, 'unbindBtn', '');
INSERT INTO `sys_menu` VALUES ('47', '司机离职', '39', '1', '/driver/dimission', '3', '1', '1', '', '1', '20', null, null, 'quitBtn', '');
INSERT INTO `sys_menu` VALUES ('48', '删除司机', '39', '1', '', '3', '1', '1', '', '0', '21', null, null, 'deleteDriverBtn', '');
INSERT INTO `sys_menu` VALUES ('49', '合同管理', '29', '1', '', '2', '1', '0', '', '1', '22', null, null, 'contractManagement', '');
INSERT INTO `sys_menu` VALUES ('50', '合同类型管理', '49', '0', '/contractType/selectPage', '2', '1', '0', '', '1', '23', null, null, 'contractType', '/contractType');
INSERT INTO `sys_menu` VALUES ('51', '新增合同类型', '50', '1', '/contractType/add', '3', '1', '1', '', '1', '24', null, null, 'addContractType', '');
INSERT INTO `sys_menu` VALUES ('52', '编辑合同类型', '50', '1', '/contractType/update', '3', '1', '1', '', '1', '25', null, null, 'editContractType', '');
INSERT INTO `sys_menu` VALUES ('53', '删除合同类型', '50', '0', '/contractType/delete', '3', '1', '1', '', '0', '26', null, null, 'deleteContractType', '');
INSERT INTO `sys_menu` VALUES ('54', '查询合同类型', '50', '0', '/contractType/selectPage2', '3', '1', '1', '', '1', '27', null, null, 'searchContractType', '');
INSERT INTO `sys_menu` VALUES ('55', '有效合同管理', '49', '0', '/contract/selectPage', '2', '1', '0', '', '1', '28', null, null, 'effectiveContract', '/effectiveContract');
INSERT INTO `sys_menu` VALUES ('56', '新增合同', '55', '1', '/contract/add', '3', '1', '1', '', '1', '29', null, null, 'addEffective', '/effectiveContract/addEffective');
INSERT INTO `sys_menu` VALUES ('57', '查询合同', '55', '0', '/contract/selectPage2', '3', '1', '1', '', '1', '30', null, null, 'searchEffective', '');
INSERT INTO `sys_menu` VALUES ('58', '查看合同', '55', '1', '/contract/get', '3', '1', '1', '', '1', '31', null, null, 'viewEffective', '/effectiveContract/viewEffective');
INSERT INTO `sys_menu` VALUES ('59', '编辑合同', '55', '1', '/contract/update', '3', '1', '1', '', '1', '32', null, null, 'editEffective', '/effectiveContract/editEffective');
INSERT INTO `sys_menu` VALUES ('60', '合同续约', '55', '1', '/contract/extend', '3', '1', '1', '', '1', '33', null, null, 'renewEffective', '/effectiveContract/renewEffective');
INSERT INTO `sys_menu` VALUES ('61', '合同解约', '55', '1', '/contract/end', '3', '1', '1', '', '1', '34', null, null, 'cutoutEffective', '/effectiveContract/cutoutEffective');
INSERT INTO `sys_menu` VALUES ('62', '操作记录', '55', '1', '/contract/getOperationRecords,/contract/getExtendRecords', '3', '1', '1', '', '1', '35', null, null, 'logEffective', '/effectiveContract/logEffective');
INSERT INTO `sys_menu` VALUES ('63', '删除合同', '55', '1', '/contract/delete', '3', '1', '1', '', '0', '36', null, null, 'deleteEffective', '/effectiveContract/deleteEffective');
INSERT INTO `sys_menu` VALUES ('64', '失效合同管理', '49', '0', '/endedContract/selectPage', '2', '1', '0', '', '1', '37', null, null, 'invalidContract', '/invalidContract');
INSERT INTO `sys_menu` VALUES ('65', '导出EXCEL', '64', '0', '', '3', '1', '1', '', '0', '38', null, null, '', '');
INSERT INTO `sys_menu` VALUES ('66', '失效合同查询', '64', '1', '/endedContract/selectPage2', '3', '1', '1', '', '1', '39', null, null, 'invalidQuery', '/invalidContract/invalidQuery');
INSERT INTO `sys_menu` VALUES ('67', '查询条件重置', '64', '1', '', '3', '1', '1', '', '1', '40', null, null, 'invalidReset', '');
INSERT INTO `sys_menu` VALUES ('68', '失效合同查看', '64', '1', '/contract/get', '3', '1', '1', '', '1', '41', null, null, 'invalidView', '/invalidContract/invalidView ');
INSERT INTO `sys_menu` VALUES ('69', '失效合同续约', '64', '1', '/contract/extend', '3', '1', '1', '', '1', '42', null, null, 'invalidContinue', '/invalidContract/invalidContinue');
INSERT INTO `sys_menu` VALUES ('70', '操作按钮', '64', '1', '', '3', '1', '1', '', '1', '43', null, null, 'invalidOperation', '');
INSERT INTO `sys_menu` VALUES ('71', '操作记录', '64', '1', '/contract/getOperationRecords,/contract/getExtendRecords', '3', '1', '1', '', '1', '44', null, null, 'invalidLog', '/invalidContract/invalidLog');
INSERT INTO `sys_menu` VALUES ('72', '失效合同删除', '64', '0', '', '3', '1', '1', '', '0', '45', null, null, 'invalidDelet', '/invalidContract/invalidDelet');
INSERT INTO `sys_menu` VALUES ('73', '统计报表', '29', '1', '', '2', '1', '0', '', '1', '46', null, null, 'report', '');
INSERT INTO `sys_menu` VALUES ('74', '打表记录', '73', '0', '/taxiDeviceTrade/selectPage', '2', '1', '0', '', '1', '47', null, null, 'chargeRecord', '/chargeRecord');
INSERT INTO `sys_menu` VALUES ('75', '导出EXCEL', '74', '0', '', '3', '1', '1', '', '0', '48', null, null, 'exportCharge', '');
INSERT INTO `sys_menu` VALUES ('76', '打表记录查询', '74', '0', '/taxiDeviceTrade/exportDeviceTrade', '3', '1', '1', '', '1', '49', null, null, 'chargeQuery', '');
INSERT INTO `sys_menu` VALUES ('77', '风控管理', '29', '1', '', '2', '1', '0', '', '1', '50', null, null, 'chargeControlManagement', '');
INSERT INTO `sys_menu` VALUES ('78', '打表管制', '77', '0', '/superviseTaximeter/selectPage', '2', '1', '0', '', '1', '51', null, null, 'chargeControlTable', '/chargeControlManagement/chargeControlTable');
INSERT INTO `sys_menu` VALUES ('79', '打表管制查询', '78', '0', '/superviseTaximeter/selectPage2', '3', '1', '1', '', '1', '52', null, null, 'chargeControlSearch', '');
INSERT INTO `sys_menu` VALUES ('80', '新增打表管制', '78', '1', '/superviseTaximeter/add', '3', '1', '1', '', '1', '53', null, null, 'chargeControlAdd', '/chargeControlManagement/chargeControlPanel');
INSERT INTO `sys_menu` VALUES ('81', '编辑打表管制', '78', '1', '/superviseTaximeter/update', '3', '1', '1', '', '1', '54', null, null, 'chargeControlEdit', '/chargeControlManagement/chargeControlPanel');
INSERT INTO `sys_menu` VALUES ('82', '查看打表管制', '78', '1', '/superviseTaximeter/selectDetailById', '3', '1', '1', '', '1', '55', null, null, 'chargeControlView', '/chargeControlManagement/chargeControlPanel');
INSERT INTO `sys_menu` VALUES ('83', '取消打表管制', '78', '1', '/superviseTaximeter/cancelById', '3', '1', '1', '', '1', '56', null, null, 'chargeControlCancel', '');
INSERT INTO `sys_menu` VALUES ('84', '流水构成', '73', '0', '/taxiOrderStatistic/selectPage', '2', '1', '0', '', '1', '58', null, null, 'serialCompose', '/serialCompose');
INSERT INTO `sys_menu` VALUES ('85', '订单明细', '73', '0', '/taxiOrder/selectPage', '2', '1', '0', '', '1', '57', null, null, 'orderDetail', '/orderDetail');
INSERT INTO `sys_menu` VALUES ('86', '流水构成查询', '84', '0', '/taxiOrderStatistic/selectPage2', '3', '1', '1', '', '1', '59', null, null, 'serialComposeSearch', '');
INSERT INTO `sys_menu` VALUES ('87', '订单明细查询', '85', '0', '/taxiOrder/selectPage2', '3', '1', '1', '', '1', '60', null, null, 'orderDetailSearch', '');
INSERT INTO `sys_menu` VALUES ('88', '流水构成导出EXCEL', '84', '0', '', '3', '1', '1', '', '0', '61', null, null, 'serialComposeExport', '');
INSERT INTO `sys_menu` VALUES ('89', '订单明细导出EXCEL', '85', '0', '', '3', '1', '1', '', '0', '62', null, null, 'orderDetailExport', '');
INSERT INTO `sys_menu` VALUES ('90', '实时数据', '29', '1', null, '2', '1', '0', null, '1', '63', null, null, 'realTimeData', null);
INSERT INTO `sys_menu` VALUES ('91', '车辆定位', '90', '0', '/taxiDriverPosition/getCarRealTime', '2', '1', '0', '', '1', '64', null, null, 'carPosition', '/carPosition');
INSERT INTO `sys_menu` VALUES ('92', '历史司机', '38', '0', '/historyDriver/selectPage', '2', '1', '0', '', '1', '13', null, null, 'historyDriver', '/driverManagement/historyDriver');
INSERT INTO `sys_menu` VALUES ('93', '查看历史司机', '92', '1', '/historyDriver/selectDetailById', '3', '1', '1', '', '1', '14', null, null, 'historyDriverSee', '/driverManagement/seeDriver');
INSERT INTO `sys_menu` VALUES ('94', '删除历史司机', '92', '0', '/historyDriver/delete', '3', '1', '1', '', '1', '15', null, null, 'historyDriverDelete', '');
INSERT INTO `sys_menu` VALUES ('95', '编辑历史司机', '92', '1', '/driver/updateInfo', '3', '1', '1', '', '1', '16', null, null, 'historyDriverEdit', '/driverManagement/driverEdit/driverOneStep');
INSERT INTO `sys_menu` VALUES ('96', '查询历史司机', '92', '0', '/historyDriver/selectPage2', '3', '1', '1', '', '1', '17', null, null, 'historyDriverSearch', '');
INSERT INTO `sys_menu` VALUES ('97', '重置历史司机', '92', '0', '', '3', '1', '1', '', '1', '18', null, null, 'historyDriverReset', '');
INSERT INTO `sys_menu` VALUES ('98', '查询车辆定位', '91', '0', '/taxiDriverPosition/getCarRealTimeWithParam', '3', '1', '1', '', '1', '0', null, null, 'positionquery ', '');
INSERT INTO `sys_menu` VALUES ('99', '重置车辆定位', '91', '0', '/taxiDriverPosition/getCarRealTimeWithParam', '3', '1', '1', '', '1', '1', null, null, 'positionreset', '');
INSERT INTO `sys_menu` VALUES ('100', '现有司机导入', '39', '0', '/driver/importDriver', '3', '1', '1', '', '1', '30', null, null, 'driverImport', '/driverManagement/importDriver');
INSERT INTO `sys_menu` VALUES ('101', '车辆导入', '31', '0', '/car/importCars', '3', '1', '1', '', '1', '20', null, null, 'VehicleListExportBtn', '/vehicleManagement/importVehicle');
INSERT INTO `sys_menu` VALUES ('102', '网约车', '0', '1', '', '1', '1', '0', null, '1', '3', null, null, 'networkcar', 'https://devt.bmkp.cn/bmkp-saas-networkcar/');
INSERT INTO `sys_menu` VALUES ('103', '司机管理', '102', '1', '', '2', '1', '0', null, '1', '1', null, null, 'driver', '/driverManagement');
INSERT INTO `sys_menu` VALUES ('104', '车辆管理', '102', '1', '', '2', '1', '0', null, '1', '2', null, null, 'vehicle', '/vehicleManagement');
INSERT INTO `sys_menu` VALUES ('105', '财务管理', '102', '1', '', '2', '1', '0', null, '1', '3', null, null, 'financial', '/financialManagement');
INSERT INTO `sys_menu` VALUES ('106', '现有车辆管理', '104', '0', '/wyc/car/selectPage', '2', '1', '0', null, '1', '1', '0000-00-00 00:00:00', null, 'currentCar', '/vehicleManagement/vehicleTable');
INSERT INTO `sys_menu` VALUES ('107', '现有司机管理', '103', '0', '/wyc/driver/selectPage', '2', '1', '0', null, '1', '3', null, null, 'currentDriver', '/driverManagement/driverTable');
INSERT INTO `sys_menu` VALUES ('108', '押金管理', '105', '0', '/wyc/depositPayRecord/selectPage', '2', '1', '0', null, '1', '3', null, null, 'deposit', '/cashPledgeManagement/cashPledgeTable');
INSERT INTO `sys_menu` VALUES ('109', '现有司机新增', '107', '0', '/wyc/driver/addInfo', '3', '1', '1', null, '1', '3', null, '0000-00-00 00:00:00', 'networkAddDtiver', '/driverManagement/driverPanel');
INSERT INTO `sys_menu` VALUES ('110', '押金管理查看', '108', null, '/wyc/depositPayRecord/selectDetailById', '3', '1', '1', null, '1', null, null, null, 'cashPledgeTableCheckBtn', '/cashPledgeManagement/cashPledgeView');
INSERT INTO `sys_menu` VALUES ('111', '押金管理退款', '108', null, '/wyc/depositRefund/refund', '3', '1', '1', null, '1', '3', null, null, 'cashPledgeTableRefundBtn', '/cashPledgeManagement/cashPledgeRefund');
INSERT INTO `sys_menu` VALUES ('112', '现有司机导出', '107', null, '', '3', '1', '1', null, '0', null, null, null, 'networkExportDtiver', 'l');
INSERT INTO `sys_menu` VALUES ('113', '现有司机搜索', '107', '1', '/wyc/driver/selectPage2', '3', '1', '1', null, '1', null, null, null, 'networkSearchDriver', null);
INSERT INTO `sys_menu` VALUES ('114', '现有司机导入', '107', '0', '', '3', '1', '1', null, '1', null, null, null, 'networkImportDriver', null);
INSERT INTO `sys_menu` VALUES ('115', '现有司机查看', '107', '0', '/wyc/driver/selectDetailById,/wyc/car/getDriverBindCars,/wyc/depositPayRecord/selectDetailById', '3', '1', '1', null, '1', null, null, null, 'networkSeeDriver', '/driverManagement/driverView');
INSERT INTO `sys_menu` VALUES ('116', '现有司机编辑', '107', '0', '/wyc/driver/updateInfo,/wyc/driver/updateIdentify,/wyc/driver/updateDrivingLicence,/wyc/driver/updateStaffLicence', '3', '1', '1', null, '1', null, null, null, 'networkEditDriver', '/driverManagement/driverEdit');
INSERT INTO `sys_menu` VALUES ('117', '取还车管理', '104', '0', '/wyc/carBorrow/selectMenu', '2', '1', '0', null, '1', null, null, null, 'TakeCarmanagement', '/vehicleManagement/TakeCarmanagement');
INSERT INTO `sys_menu` VALUES ('118', '车辆库存管理', '104', '0', '/wyc/carStatistic/selectPage', '2', '1', '0', null, '1', null, null, null, 'VehicleInventory', '/vehicleManagement/VehicleInventory');
INSERT INTO `sys_menu` VALUES ('119', '车辆库存管理查询', '118', '0', '/wyc/carStatistic/selectPage2', '3', '1', '1', null, '1', null, null, null, 'VehicleInventoryenquiry', null);
INSERT INTO `sys_menu` VALUES ('120', '取还车记录', '117', '0', '/wyc/borrowRecord/selectPage', '2', '1', '0', null, '1', null, null, null, 'TakeCarRecord', '');
INSERT INTO `sys_menu` VALUES ('121', '取还车记录查看', '120', '0', '/wyc/borrowRecord/selectDetailById', '3', '1', '1', null, '1', null, '2018-03-16 15:14:44', null, 'takeCarRecordView', '/vehicleManagement/vehicleRecordView');
INSERT INTO `sys_menu` VALUES ('122', '取还车记录删除', '120', '0', '/wyc/borrowRecord/delete', '3', '1', '1', null, '1', null, null, null, 'takeCarRecordDel', null);
INSERT INTO `sys_menu` VALUES ('123', '取还车记录导出excel', '120', '0', null, '3', '1', '1', null, '1', null, null, null, 'takeCarRecordExport', null);
INSERT INTO `sys_menu` VALUES ('124', '取还车记录查询', '120', '0', '/wyc/borrowRecord/selectPage2', '3', '1', '1', null, '1', null, null, null, 'takeCarRecordQuery', null);
INSERT INTO `sys_menu` VALUES ('126', '押金管理缴纳', '108', '0', '/wyc/depositPay/pay', '3', '1', '1', null, '1', null, null, null, 'cashPledgeTablePayBtn', '/cashPledgeManagement/cashPledgePay');
INSERT INTO `sys_menu` VALUES ('127', '押金管理编辑', '108', '0', '/wyc/depositPay/update,/wyc/depositRefund/update', '3', '1', '1', null, '1', null, null, null, 'cashPledgeTableListEditBtn', '/cashPledgeManagement/cashPledgeEdit');
INSERT INTO `sys_menu` VALUES ('128', '押金管理查询', '108', '0', '/wyc/depositPayRecord/selectPage2', '3', '1', '1', null, '1', null, null, null, 'cashPledgeTableQueryBtn', null);
INSERT INTO `sys_menu` VALUES ('129', '押金管理导出', '108', '0', '/wyc/depositPayRecord/exportDepositRecord', '3', '1', '1', null, '1', null, null, null, 'cashPledgeTableExportBtn', null);
INSERT INTO `sys_menu` VALUES ('130', '现有车辆新增', '106', '0', '/wyc/car/add', '3', '1', '1', null, '1', null, null, null, 'currentCaradd', '/vehicleManagement/vehiclePanel');
INSERT INTO `sys_menu` VALUES ('131', '现有车辆查看', '106', '0', '/wyc/car/showDetail,/wyc/driver/selectListByCarId', '3', '1', '1', null, '1', null, null, null, 'currentCarView', '/vehicleManagement/vehicleView');
INSERT INTO `sys_menu` VALUES ('132', '现有车辆导入', '106', '0', '', '3', '1', '1', null, '0', null, null, null, 'currentCarExport', '/vehicleManagement/importVehicle');
INSERT INTO `sys_menu` VALUES ('133', '现有车辆编辑', '106', '0', '/wyc/car/updateCarBaseInfo,/wyc/car/updateDriveLicense,/wyc/car/updateTransportCert,/wyc/car/updateCarInsurance,/wyc/car/updateCarDevice', '3', '1', '1', null, '1', null, null, null, 'currentCarEditor', '/vehicleManagement/vehicleEdit');
INSERT INTO `sys_menu` VALUES ('134', '现有车辆搜索', '106', '0', '/wyc/car/selectPage2', '3', '1', '1', null, '1', null, null, null, 'currentCarSearch', null);
INSERT INTO `sys_menu` VALUES ('135', '车辆库存管理导出', '118', '0', '/wyc/carStatistic/export', '3', '1', '1', null, '1', null, null, null, 'VehicleInventoryExport', null);
INSERT INTO `sys_menu` VALUES ('140', '风控子系统', '0', '1', '', '1', '1', '0', null, '1', '4', '2018-03-02 15:41:32', null, 'risk', 'https://devt.bmkp.cn/bmkp-saas-risk/');
INSERT INTO `sys_menu` VALUES ('141', '司机风控', '140', '1', '', '2', '1', '0', null, '1', '1', '2018-03-02 15:41:46', null, 'driverRiskManage', null);
INSERT INTO `sys_menu` VALUES ('142', '司机风控管理', '141', '0', '/risk/driverRiskSignManage/selectPage', '2', '1', '0', null, '1', '1', '2018-03-02 15:41:55', null, 'riskManage', '/riskManage');
INSERT INTO `sys_menu` VALUES ('143', '司机人脸审核', '141', '0', '/risk/driverRiskFaceReview/dataPage1', '2', '1', '0', null, '1', '2', '2018-03-02 15:42:06', null, 'faceAudit', '/faceAudit');
INSERT INTO `sys_menu` VALUES ('144', '已安装应用检测', '141', '0', '/risk/driverRiskAppCheck/selectDriverPage', '2', '1', '0', null, '1', '3', '2018-03-02 15:42:10', null, 'applicationCheck', '/applicationCheck');
INSERT INTO `sys_menu` VALUES ('145', '司机签到', '141', '0', '/risk/driverRiskSignManage/signStatistic1', '2', '1', '0', null, '1', '4', '2018-03-12 09:40:13', null, 'sign', '/sign');
INSERT INTO `sys_menu` VALUES ('146', '司机人脸审核操作', '143', '0', '/risk/driverRiskFaceReview/review', '3', '1', '1', null, '1', '2', '2018-03-15 09:34:49', null, 'faceAuditReview', null);
INSERT INTO `sys_menu` VALUES ('147', '司机人脸审核批量操作', '143', '0', '/risk/driverRiskFaceReview/batchReview', '3', '1', '1', null, '1', '3', '2018-03-15 09:35:50', null, 'faceAuditBatchReview', null);
INSERT INTO `sys_menu` VALUES ('148', '司机人脸审核查看详情', '143', '0', '/risk/driverRiskFaceReview/getDetail', '3', '1', '1', null, '1', '5', '2018-03-15 16:52:37', null, 'faceAuditDetail', null);
INSERT INTO `sys_menu` VALUES ('149', '司机风控管理数据查询', '142', '0', '/risk/driverRiskSignManage/selectPage2', '3', '1', '1', null, '1', '1', '2018-03-15 17:43:21', null, 'riskManageQuery', null);
INSERT INTO `sys_menu` VALUES ('150', '司机风控管理数据修改', '142', '0', '/risk/driverRiskSignManage/edit', '3', '1', '1', null, '1', '2', '2018-03-15 17:43:53', null, 'riskManageEdit', null);
INSERT INTO `sys_menu` VALUES ('151', '司机风控管理数据批量修改', '142', '0', '/risk/driverRiskSignManage/batchEdit', '3', '1', '1', null, '1', '3', '2018-03-15 17:45:36', null, 'riskManageBatchEdit', null);
INSERT INTO `sys_menu` VALUES ('152', '司机签到查询', '145', '0', '/risk/driverRiskSign/selectPage2', '3', '1', '1', null, '1', '1', '2018-03-15 18:08:37', null, 'driverSignQuery', null);
INSERT INTO `sys_menu` VALUES ('153', '司机人脸审核数据查询', '143', '0', '/risk/driverRiskFaceReview/dataPage2 ', '3', '1', '1', null, '1', '1', '2018-03-15 09:28:04', null, 'faceAuditQuery', null);
INSERT INTO `sys_menu` VALUES ('154', '司机人脸审核数据导出', '143', '0', '/risk/driverRiskFaceReview/export', '3', '1', '1', null, '1', '4', '2018-03-15 09:38:13', null, 'faceAuditDateExport', null);
INSERT INTO `sys_menu` VALUES ('155', '司机风控管理数据删除', '142', '0', '/risk/driverRiskSignManage/delete', '3', '1', '1', null, '0', '4', '2018-03-19 17:09:54', null, 'riskManageDelete', null);
INSERT INTO `sys_menu` VALUES ('156', '司机风控管理数据导出', '142', '0', '/risk/driverRiskSignManage/export', '3', '1', '1', null, '1', '5', '2018-03-19 17:11:18', null, 'riskManageExportExcel', null);
INSERT INTO `sys_menu` VALUES ('157', '司机风控管理默认值查询', '142', '0', '/risk/driverRiskDefault/getDetail', '3', '1', '1', null, '1', '6', '2018-03-19 17:44:45', null, 'riskManageGetDefault', null);
INSERT INTO `sys_menu` VALUES ('158', '司机风控管理默认值修改', '142', '0', '/risk/driverRiskDefault/update', '3', '1', '1', null, '1', '7', '2018-03-19 17:45:08', '0000-00-00 00:00:00', 'riskManageEditDefault', null);
INSERT INTO `sys_menu` VALUES ('160', '司机互斥应用数据列表查询', '144', '0', '/risk/driverRiskAppCheck/selectDriverPage2', '3', '1', '1', null, '1', '1', '2018-03-20 14:37:30', null, 'riskAppCheckQuery', null);
INSERT INTO `sys_menu` VALUES ('161', '司机互斥应用个人详情查询', '144', '0', '/risk/driverRiskAppCheck/selectPage2', '3', '1', '1', null, '1', '2', '2018-03-20 15:37:31', null, 'riskAppCheckDetail', null);
INSERT INTO `sys_menu` VALUES ('162', '司机互斥应用个人数据修改', '144', '0', '/risk/driverRiskAppCheck/edit', '3', '1', '1', null, '1', '3', '2018-03-20 15:37:00', null, 'riskAppCheckEdit', null);
INSERT INTO `sys_menu` VALUES ('163', '司机系统互斥应用查询', '144', '0', '/risk/driverRiskAppDefault/selectPage2', '3', '1', '1', null, '1', '4', '2018-03-20 15:42:24', null, 'riskAppCheckDefaultQuery', null);
INSERT INTO `sys_menu` VALUES ('164', '司机系统互斥应用新增', '144', '0', '/risk/driverRiskAppDefault/create', '3', '1', '1', null, '1', '5', '2018-03-20 15:39:18', null, 'riskAppCheckDefaultCreate', null);
INSERT INTO `sys_menu` VALUES ('165', '司机系统互斥应用编辑', '144', '0', '/risk/driverRiskAppDefault/edit', '3', '1', '1', null, '1', '6', '2018-03-20 15:40:03', null, 'riskAppCheckDefaultEdit', null);
INSERT INTO `sys_menu` VALUES ('166', '司机签到日统计查询', '145', '0', '/risk/driverRiskSignManage/singleDriverStastic', '3', '1', '1', null, '1', '2', '2018-03-20 16:49:46', null, 'riskDriverDaySignQuery', null);
INSERT INTO `sys_menu` VALUES ('167', '司机签到查询', '145', '0', '/risk/driverRiskSignManage/signStatistic2', '3', '1', '1', null, '1', '3', '2018-03-20 17:44:38', null, 'riskDriverSignQuery', null);
INSERT INTO `sys_menu` VALUES ('168', '取还车计划新增', '175', '0', '/wyc/borrowPlan/add', '3', '1', '1', null, '1', null, null, null, 'Takecarofnew', '/vehicleManagement/Vehicleadd');
INSERT INTO `sys_menu` VALUES ('169', '取还车计划查询', '175', '0', '/wyc/borrowPlan/selectPage2', '3', '1', '1', null, '1', null, null, null, 'TakecarReturnquery', '');
INSERT INTO `sys_menu` VALUES ('170', '取还车计划查看', '175', '0', '/wyc/borrowPlan/selectDetailById', '3', '1', '1', null, '1', null, null, null, 'TakecarCheckback', '/vehicleManagement/vehicleplanView');
INSERT INTO `sys_menu` VALUES ('171', '取还车计划编辑', '175', '0', '/wyc/borrowPlan/update', '3', '1', '1', null, '1', null, null, null, 'Takecarrec', '/vehicleManagement/Vehicleadd');
INSERT INTO `sys_menu` VALUES ('172', '取还车计划收车', '175', '0', '/wyc/carRetrieve/retrieve', '3', '1', '1', null, '1', null, null, null, 'Takebackthecar', '/vehicleManagement/sendAreceivecar');
INSERT INTO `sys_menu` VALUES ('173', '取还车计划发车', '175', '0', '/wyc/carDispatch/dispatch', '3', '1', '1', null, '1', null, null, null, 'Returnthecar', '/vehicleManagement/sendAreceivecar');
INSERT INTO `sys_menu` VALUES ('174', '取还车计划删除', '175', '0', '/wyc/borrowPlan/delete', '3', '1', '1', null, '1', null, null, null, 'Takecarreload', null);
INSERT INTO `sys_menu` VALUES ('175', '取还车计划', '117', '0', '/wyc/borrowPlan/selectPage', '2', '1', '0', null, '1', null, null, null, 'TakeCarPlan', '');
INSERT INTO `sys_menu` VALUES ('176', '司机系统互斥应用数据导出', '144', '0', '/risk/driverRiskAppCheck/export', '3', '1', '1', null, '1', '7', null, null, 'riskAppCheckDataExport', null);
INSERT INTO `sys_menu` VALUES ('177', '司机签到统计导出', '145', '0', '/risk/driverRiskSignManage/export/signStatistic', '3', '1', '1', null, '1', '4', null, null, 'riskSignDataExport', null);
INSERT INTO `sys_menu` VALUES ('178', '司机签到明细导出', '145', '0', '/risk/driverRiskSignManage/export', '3', '1', '1', null, '1', '5', null, null, 'riskSignDetailExport', null);
INSERT INTO `sys_menu` VALUES ('179', '安全管理', '102', '1', null, '2', '1', '0', null, '1', '3', null, null, 'secure', '/secureManagement');
INSERT INTO `sys_menu` VALUES ('180', '事故管理', '179', '0', '/wyc/accident/selectPage', '2', '1', '0', null, '1', null, null, null, 'accident', '/secureManagement/accidentManagement');
INSERT INTO `sys_menu` VALUES ('181', '维修管理', '179', '0', '/wyc/repair/selectPage', '2', '1', '0', null, '1', '2', null, null, 'maintain', '/secureManagement/maintainManagement');
INSERT INTO `sys_menu` VALUES ('182', '保险理赔', '179', '0', '/wyc/claim/selectPage', '2', '1', '0', null, '1', '3', null, null, 'insurance', '/secureManagement/insuranceClaims');
INSERT INTO `sys_menu` VALUES ('183', '系统配置', '102', '1', null, '2', '1', '0', null, '1', '3', null, null, 'system', '/systemDeploy');
INSERT INTO `sys_menu` VALUES ('184', '维保商管理', '183', '0', '/wyc/supplier/selectPage', '2', '1', '0', null, '1', null, null, null, 'maintainProvider', '/systemDeploy/maintenanceProviderMange');
INSERT INTO `sys_menu` VALUES ('185', '维保商管理新增', '184', '0', '/wyc/supplier/addInfo', '3', '1', '1', null, '1', null, null, null, 'addManagementBtn', '/systemDeploy/addManagement');
INSERT INTO `sys_menu` VALUES ('186', '维保商管理搜索', '184', '0', '/wyc/supplier/selectPage2', '3', '1', '1', null, '1', null, null, null, 'searchManagementBtn', null);
INSERT INTO `sys_menu` VALUES ('187', '维保商查看', '184', '0', '/wyc/supplier/selectDetailById', '3', '1', '1', null, '1', null, null, null, 'seeManagementBtn', '/systemDeploy/seeManagement');
INSERT INTO `sys_menu` VALUES ('188', '维保商编辑', '184', '0', '/wyc/supplier/updateInfo', '3', '1', '1', null, '1', null, null, null, 'editManagementBtn', '/systemDeploy/addManagement');
INSERT INTO `sys_menu` VALUES ('189', '事故管理新增', '180', '0', '/wyc/accident/add', '3', '1', '1', null, '1', null, null, null, 'accidentaddBtn', '/secureManagement/accidentManagement/accidentadd');
INSERT INTO `sys_menu` VALUES ('190', '事故管理查看', '180', '0', '/wyc/accident/selectById', '3', '1', '1', null, '1', null, null, null, 'accidentviewBtn', '/secureManagement/accidentManagement/accidentView');
INSERT INTO `sys_menu` VALUES ('191', '事故管理搜索', '180', '0', '/wyc/accident/selectPage2', '3', '1', '1', null, '1', null, null, null, 'accidentsearchBtn', null);
INSERT INTO `sys_menu` VALUES ('192', '事故管理编辑', '180', '0', '/wyc/accident/update', '3', '1', '1', null, '1', null, null, null, 'accidenteditBtn', '/secureManagement/accidentManagement/accidentadd');
INSERT INTO `sys_menu` VALUES ('193', '事故管理定损', '180', '0', '/wyc/lossConfirm/add', '3', '1', '1', null, '1', null, null, null, 'accidentfeeBtn', '/secureManagement/accidentManagement/accidentfee');
INSERT INTO `sys_menu` VALUES ('194', '事故管理维修', '180', '0', null, '3', '1', '1', null, '1', null, null, null, 'accidentmainBtn', '/secureManagement/maintainEdit');
INSERT INTO `sys_menu` VALUES ('195', '事故管理保险理赔', '180', '0', null, '3', '1', '1', null, '1', null, null, null, 'accidentinsuranceBtn', '/secureManagement/insuranceClaimPenal');
INSERT INTO `sys_menu` VALUES ('196', '事故管理删除', '180', '0', '/wyc/accident/delete', '3', '1', '1', null, '1', null, null, null, 'accidentdeleteBtn', null);
INSERT INTO `sys_menu` VALUES ('197', '保险理赔新增', '182', '0', '/wyc/claim/addInfo', '3', '1', '1', null, '1', null, null, null, 'insecureAddBtn', null);
INSERT INTO `sys_menu` VALUES ('198', '保险理赔查询', '182', '0', '/wyc/claim/selectPage2', '3', '1', '1', null, '1', null, null, null, 'insecureQueryBtn', null);
INSERT INTO `sys_menu` VALUES ('199', '保险理赔导出', '182', '0', '/wyc/claim/export', '3', '1', '1', null, '1', null, null, null, 'insecureExportBtn', null);
INSERT INTO `sys_menu` VALUES ('200', '保险理赔查看', '182', '0', '/wyc/claim/selectDetailById', '3', '1', '1', null, '1', null, null, null, 'insecureViewBtn', null);
INSERT INTO `sys_menu` VALUES ('201', '保险理赔编辑', '182', '0', '/wyc/claim/updateInfo', '3', '1', '1', null, '1', null, null, null, 'insecureEditBtn', null);
INSERT INTO `sys_menu` VALUES ('202', '完成理赔', '182', '0', '/wyc/claim/fisishClaimById', '3', '1', '1', null, '1', null, null, null, 'insecureCompleteBtn', null);
INSERT INTO `sys_menu` VALUES ('203', '保险理赔删除', '182', '0', '/wyc/claim/deleteClaimById', '3', '1', '1', null, '1', null, null, null, 'insecureDeleteBtn', null);
INSERT INTO `sys_menu` VALUES ('204', '维修管理新增', '181', '0', '/wyc/repair/addInfo', '3', '1', '1', null, '1', null, null, null, 'maintainAddBtn', '');
INSERT INTO `sys_menu` VALUES ('205', '维修管理查看', '181', '0', '/wyc/repair/detail', '3', '1', '1', null, '1', null, null, null, 'maintainViewBtn', '');
INSERT INTO `sys_menu` VALUES ('206', '维修管理编辑', '181', '0', '/wyc/repair/updateInfo', '3', '1', '1', null, '1', null, null, null, 'maintainEditBtn', '');
INSERT INTO `sys_menu` VALUES ('207', '维修管理删除', '181', '0', '/wyc/repair/delete', '3', '1', '1', null, '1', null, null, null, 'maintainDeleteBtn', '');
INSERT INTO `sys_menu` VALUES ('208', '维修管理查询', '181', '0', '/wyc/repair/selectPage2', '3', '1', '1', null, '1', null, null, null, 'maintainQueryBtn', '');
INSERT INTO `sys_menu` VALUES ('209', '维修管理完成维修', '181', '0', '/wyc/repair/finish', '3', '1', '1', null, '1', null, null, null, 'maintainCompleteBtn', '');
INSERT INTO `sys_menu` VALUES ('210', '维修管理导出', '181', '0', '/wyc/repair/export', '3', '1', '1', null, '1', null, null, null, 'maintainExportBtn', '');
INSERT INTO `sys_menu` VALUES ('211', '保养管理', '179', '0', '/wyc/maintain/selectPage', '2', '1', '1', null, '1', null, null, null, 'maintenanceManage', '/secureManagement/maintenanceManagement');
INSERT INTO `sys_menu` VALUES ('212', '新增保养', '211', '0', '/wyc/maintain/addInfo', '3', '1', '1', null, '1', null, null, null, 'maintenanceAddBtn', '');
INSERT INTO `sys_menu` VALUES ('213', '编辑保养', '211', '0', '/wyc/maintain/updateInfo', '3', '1', '1', null, '1', null, null, null, 'maintenanceEditBtn', '');
INSERT INTO `sys_menu` VALUES ('214', '删除保养', '211', '0', '/wyc/maintain/delete', '3', '1', '1', null, '1', null, null, null, 'maintenanceDeleteBtn', '');
INSERT INTO `sys_menu` VALUES ('215', '查看保养', '211', '0', '/wyc/maintain/detail', '3', '1', '1', null, '1', null, null, null, 'maintenanceViewBtn', '');
INSERT INTO `sys_menu` VALUES ('216', '完成保养', '211', '0', '/wyc/maintain/finish', '3', '1', '1', null, '1', null, null, null, 'maintenanceCompleteBtn', '');
INSERT INTO `sys_menu` VALUES ('217', '预警设置', '183', '0', '/sysMenu/getMenuAndBtnByMenuId', '2', '1', '1', null, '1', null, null, null, 'warningManage', '/systemDeploy/warningManage');
INSERT INTO `sys_menu` VALUES ('218', '查询保养', '211', '0', '/wyc/maintain/selectPage2', '3', '1', '1', null, '1', null, null, null, 'maintenanceQueryBtn', '');
INSERT INTO `sys_menu` VALUES ('219', '送保', '211', '0', 'maintenanceSendBtn', '3', '1', '1', null, '1', null, null, null, 'maintenanceSendBtn', '');
INSERT INTO `sys_menu` VALUES ('220', '保养预警查询', '314', '0', '/wyc/maintainceAlert/selectPage2', '3', '1', '1', null, '1', null, null, null, 'maintainAlertSearchBtn', '');
INSERT INTO `sys_menu` VALUES ('221', '保养预警添加', '314', '0', '/wyc/maintainceAlert/add', '3', '1', '1', null, '1', null, null, null, 'maintainAlertAddBtn', '');
INSERT INTO `sys_menu` VALUES ('222', '保养预警编辑', '314', '0', '/wyc/maintainceAlert/update', '3', '1', '1', null, '1', null, null, null, 'maintainAlertEditBtn', '');
INSERT INTO `sys_menu` VALUES ('223', '保养预警删除', '314', '0', '/wyc/maintainceAlert/delete', '3', '1', '1', null, '1', null, null, null, 'maintainAlertDeleteBtn', '');
INSERT INTO `sys_menu` VALUES ('224', '实时数据', '102', '1', '', '2', '1', '0', null, '1', '4', null, null, 'realTimeManagement', '/realTimeManagement');
INSERT INTO `sys_menu` VALUES ('228', '车辆定位', '224', '0', '/wyc/carPosition/getCarRealTime', '2', '1', '0', null, '1', '1', null, null, 'carPositionWyc', '/realTimeManagement/carPosition');
INSERT INTO `sys_menu` VALUES ('229', '越界报警', '224', '0', '/wyc/fenceAlert/selectPage', '2', '1', '0', null, '1', '5', null, null, 'crossingTheLine', '/realTimeManagement/crossingTheLine');
INSERT INTO `sys_menu` VALUES ('230', '失联报警', '224', '0', '/wyc/wycLossConnenctionAlarm/selectPage', '2', '1', '0', null, '1', '6', null, null, 'lostTheAlarm', '/realTimeManagement/lostTheAlarm');
INSERT INTO `sys_menu` VALUES ('231', '越界报警查看', '229', '0', '/wyc/fenceAlert/selectPage2', '3', '1', '1', null, '1', null, null, null, 'crossingTheLineView', null);
INSERT INTO `sys_menu` VALUES ('232', '失联报警查看', '230', '0', '/wyc/wycLossConnenctionAlarm/selectPage2', '3', '1', '1', null, '1', null, null, null, 'lostTheAlarmView', null);
INSERT INTO `sys_menu` VALUES ('233', '实时榜单', '224', '0', '\n/wyc/realtimeorder/selectMenu', '2', '1', '0', null, '1', '2', null, null, 'realtimelist', '/realTimeManagement/realtimelist');
INSERT INTO `sys_menu` VALUES ('237', '订单排行榜', '233', '0', '/wyc/realtimeorder/selectPage', '2', '1', '1', null, '1', null, null, null, 'orderList', null);
INSERT INTO `sys_menu` VALUES ('238', '热力图', '224', '0', null, '2', '1', '1', null, '1', '4', null, null, 'heatMap', '/realTimeManagement/heatMap');
INSERT INTO `sys_menu` VALUES ('239', '电子围栏', '224', '0', '/sysMenu/getMenuAndBtnByMenuId', '2', '1', '0', null, '1', '3', null, null, 'electricFence', '/realTimeManagement/electricFence');
INSERT INTO `sys_menu` VALUES ('240', '流水排行榜', '233', '0', '/wyc/realtimeorder/selectPage', '2', '1', '1', null, '1', null, null, null, 'currentRanking', null);
INSERT INTO `sys_menu` VALUES ('241', '订单排行榜查看', '237', '0', '/wyc/realtimeorder/selectDetail', '3', '1', '1', null, '1', null, null, null, 'orderlistview', '/realTimeManagement/realTimeView');
INSERT INTO `sys_menu` VALUES ('242', '订单排行榜查询', '237', '0', '/wyc/realtimeorder/selectPage2', '3', '1', '1', null, '1', null, null, null, 'orderlistcheck', null);
INSERT INTO `sys_menu` VALUES ('243', '流水排行榜查看', '240', '0', '/wyc/realtimeorder/selectDetail', '3', '1', '1', null, '1', null, null, null, 'currentrankingview', '/realTimeManagement/realTimeView');
INSERT INTO `sys_menu` VALUES ('244', '流水排行榜查询', '240', '0', '/wyc/realtimeorder/selectPage2', '3', '1', '1', null, '1', null, null, null, 'currentrankingcheck', null);
INSERT INTO `sys_menu` VALUES ('246', '打表记录导出', '74', '0', '/taxiDeviceTrade/exportDeviceTrade', '3', '1', '1', '', '1', '49', null, null, 'chargeExport', '');
INSERT INTO `sys_menu` VALUES ('247', '查询车辆定位', '228', '0', '/wyc/carPosition/getCarRealTimeWithParam', '3', '1', '1', null, '1', null, null, null, 'queryVehiclePosition', null);
INSERT INTO `sys_menu` VALUES ('248', '重置车辆定位', '228', '0', '/wyc/carPosition/getCarRealTimeWithParam', '3', '1', '1', null, '1', null, null, null, 'resetVehiclePosition', null);
INSERT INTO `sys_menu` VALUES ('249', '新增电子围栏', '239', '0', '/wyc/electronicFence/add', '3', '1', '1', null, '1', null, null, null, 'electricFenceAddBtn', '');
INSERT INTO `sys_menu` VALUES ('250', '修改电子围栏', '239', '0', '/wyc/electronicFence/update', '3', '1', '1', null, '1', null, null, null, 'electricFenceEditBtn', null);
INSERT INTO `sys_menu` VALUES ('251', '查看电子围栏', '239', '0', '/wyc/electronicFence/selectAll', '3', '1', '1', null, '1', null, null, null, 'electricFenceViewBtn', null);
INSERT INTO `sys_menu` VALUES ('252', '删除电子围栏', '239', '0', '/wyc/electronicFence/delete', '3', '1', '1', null, '1', null, null, null, 'electricFenceDeleteBtn', null);
INSERT INTO `sys_menu` VALUES ('253', '违章管理', '179', '0', '/carPec/selectPage', '2', '1', '0', null, '1', null, null, null, 'peccancy', '/secureManagement/peccancyManagement');
INSERT INTO `sys_menu` VALUES ('254', '违章管理查询', '253', '0', '/carPec/selectPage2', '3', '1', '1', null, '1', null, null, null, 'peccancyQueryBtn', null);
INSERT INTO `sys_menu` VALUES ('255', '违章管理添加', '253', '0', '/carPec/addOrUpdate', '3', '1', '1', null, '1', null, null, null, 'peccancyAddBtn', null);
INSERT INTO `sys_menu` VALUES ('256', '违章管理查看', '253', '0', '/carPec/detail', '3', '1', '1', null, '1', null, null, null, 'peccancyViewBtn', null);
INSERT INTO `sys_menu` VALUES ('257', '系统操作日志', '183', '0', '/sysLog/selectPage', '2', '1', '1', null, '1', '3', null, null, 'logRecord', '/systemDeploy/logRecord');
INSERT INTO `sys_menu` VALUES ('258', '系统操作日志查看', '257', '0', '/sysLog/detail', '3', '1', '1', null, '1', null, null, null, 'logRecordViewBtn', '/systemDeploy/logRecordView');
INSERT INTO `sys_menu` VALUES ('259', '系统操作日志查询', '257', '0', '/sysLog/selectPage2', '3', '1', '1', null, '1', null, null, null, 'logRecordSearchBtn', '');
INSERT INTO `sys_menu` VALUES ('260', '保养管理导出', '211', '0', '/wyc/maintain/export', '3', '1', '1', null, '1', null, null, null, 'maintenanceExportBtn', null);
INSERT INTO `sys_menu` VALUES ('261', '违章管理编辑', '253', '0', '/carPec/addOrUpdate', '3', '1', '1', null, '1', null, null, null, 'peccancyEditBtn', null);
INSERT INTO `sys_menu` VALUES ('262', '违章管理导出', '253', '0', '/carPec/export', '3', '1', '1', null, '1', null, null, null, 'peccancyExportBtn', null);
INSERT INTO `sys_menu` VALUES ('263', '违章管理删除', '253', '0', '/carPec/deleteOrUpdateStatus', '3', '1', '1', null, '1', null, null, null, 'peccancyDeleteBtn', null);
INSERT INTO `sys_menu` VALUES ('264', '违章管理处理完成', '253', '0', '/carPec/deleteOrUpdateStatus', '3', '1', '1', null, '1', null, null, null, 'peccancyFinishBtn', null);
INSERT INTO `sys_menu` VALUES ('265', '车辆年检', '179', '0', '/wyc/carInspect/selectPage', '2', '1', '1', null, '1', '9', null, null, 'vehicleInspection', '/secureManagement/vehicleInspection');
INSERT INTO `sys_menu` VALUES ('266', '年检车辆（操作）', '265', '0', null, '3', '1', '1', null, '1', null, null, null, 'inspectionVehicle', '/secureManagement/inspectionVehicle');
INSERT INTO `sys_menu` VALUES ('267', '续保管理', '179', '0', '/wyc/carRenewInsur/selectPage', '2', '1', '0', null, '1', '10', null, null, 'renewal', '/secureManagement/renewal');
INSERT INTO `sys_menu` VALUES ('268', '完成续保', '267', '0', '/wyc/carRenewInsur/renewInsur', '3', '1', '1', null, '1', '0', null, null, 'renewalCompleteBtn', '');
INSERT INTO `sys_menu` VALUES ('269', '续保导出', '267', '0', null, '3', '1', '1', null, '0', '0', null, null, 'renewalExportBtn', '');
INSERT INTO `sys_menu` VALUES ('270', '续保管理查询', '267', '0', '/wyc/carRenewInsur/selectPage2', '3', '1', '1', null, '1', '10', null, null, 'renewalQueryBtn', '');
INSERT INTO `sys_menu` VALUES ('271', '公务车管理', '102', '1', null, '2', '1', '0', null, '1', '10', null, null, 'officialVehicleManagement', '/officialCarManagement');
INSERT INTO `sys_menu` VALUES ('272', '用车申请', '271', '0', '/wyc/carApply/selectPage', '2', '1', '0', null, '1', null, null, null, 'applyVehicle', '/officialCarManagement/applyVehicleTable');
INSERT INTO `sys_menu` VALUES ('273', '违章记录', '271', '0', '/official/peccancy/selectPage', '2', '1', '0', null, '1', null, null, null, 'endorsement', '/officialCarManagement/endorsementTable');
INSERT INTO `sys_menu` VALUES ('274', '公务车罚金', '105', '0', '/wyc/penaltyRecord/selectPage', '2', '1', '0', null, '1', null, null, null, 'officialCarFine', '/cashPledgeManagement/officialCarFineTable');
INSERT INTO `sys_menu` VALUES ('275', '公务车罚金查看', '274', '0', '/wyc/penaltyRecord/selectPage', '3', '1', '1', null, '1', null, null, null, 'officialCarFineView', '');
INSERT INTO `sys_menu` VALUES ('276', '公务车罚金缴纳', '274', '0', '/wyc/penaltyPay/pay', '3', '1', '1', null, '1', null, null, null, 'officialCarFinePay', null);
INSERT INTO `sys_menu` VALUES ('278', '用车申请查询', '272', '0', '/wyc/carApply/selectPage2', '3', '1', '1', null, '1', null, null, null, 'officialCarSearchBtn', '');
INSERT INTO `sys_menu` VALUES ('279', '用车申请添加', '272', '0', '/wyc/carApply/insert', '3', '1', '1', null, '1', null, null, null, 'officialCarAddBtn', '');
INSERT INTO `sys_menu` VALUES ('280', '用车申请编辑', '272', '0', '/wyc/carApply/update', '3', '1', '1', null, '1', null, null, null, 'officialCarEditBtn', '');
INSERT INTO `sys_menu` VALUES ('281', '用车申请查看', '272', '0', '/wyc/carApply/detail', '3', '1', '1', null, '1', null, null, null, 'officialCarViewBtn', '');
INSERT INTO `sys_menu` VALUES ('282', '用车申请发车', '272', '0', '/wyc/carApply/dispatch', '3', '1', '1', null, '1', null, null, null, 'officialCarDispatchBtn', '');
INSERT INTO `sys_menu` VALUES ('283', '用车申请收车', '272', '0', '/wyc/carApply/retrieve', '3', '1', '1', null, '1', null, null, null, 'officialCarRetrieveBtn', '');
INSERT INTO `sys_menu` VALUES ('284', '用车申请删除', '272', '0', '/wyc/carApply/delete', '3', '1', '1', null, '1', null, null, null, 'officialCarDeleteBtn', '');
INSERT INTO `sys_menu` VALUES ('285', '用车申请导出', '272', '0', null, '3', '1', '1', null, '0', null, null, null, 'officialCarExportBtn', '');
INSERT INTO `sys_menu` VALUES ('286', '违章管理一键违章查询', '253', '0', '/carPec/thirdQuery', '3', '1', '1', null, '1', null, null, null, 'peccancyThirdQueryBtn', null);
INSERT INTO `sys_menu` VALUES ('287', '违章管理发送违章提醒短信', '253', '0', '/carPec/pecSendSms', '3', '1', '1', null, '1', null, null, null, 'peccancySendSmsBtn', null);
INSERT INTO `sys_menu` VALUES ('288', '车辆年检查询', '265', '0', '/wyc/carInspect/selectPage2', '3', '1', '1', null, '1', null, null, null, 'carInspectSelectBtn', null);
INSERT INTO `sys_menu` VALUES ('289', '车辆年检新增', '265', '0', '/wyc/carInspect/insert', '3', '1', '1', null, '1', null, null, null, 'carInspectAddBtn', '/secureManagement/inspectionAdd');
INSERT INTO `sys_menu` VALUES ('290', '车辆年检导出', '265', '0', '/wyc/carInspect/attendanceExport', '3', '1', '1', null, '1', null, null, null, 'carInspectExcelBtn', null);
INSERT INTO `sys_menu` VALUES ('291', '车辆年检重置', '265', '0', null, '3', '1', '1', null, '1', null, null, null, 'carInspectResetBtn', null);
INSERT INTO `sys_menu` VALUES ('292', '车辆年检查看', '265', '0', '/wyc/carInspect/selectDetail', '3', '1', '1', null, '1', null, null, null, 'carInspectViewBtn', '/secureManagement/inspectionView');
INSERT INTO `sys_menu` VALUES ('293', '车辆年检编辑', '265', '0', '/wyc/carInspect/update', '3', '1', '1', null, '1', null, null, null, 'carInspectEditBtn', '/secureManagement/inspectionAdd');
INSERT INTO `sys_menu` VALUES ('294', '车辆年检年检车辆', '265', '0', '/wyc/carInspect/vehicle/selectPage2', '3', '1', '1', null, '1', null, null, null, 'carInspectVehicleBtn', '');
INSERT INTO `sys_menu` VALUES ('295', '车辆年检考勤', '265', '0', '/wyc/carInspect/vehicle/sign/selectPage2', '3', '1', '1', null, '1', null, null, null, 'carInspectAttendanceBtn', '/secureManagement/attendance');
INSERT INTO `sys_menu` VALUES ('296', '车辆年检取消', '265', '0', '/wyc/carInspect/cancel', '3', '1', '1', null, '1', null, null, null, 'carInspectCancelBtn', null);
INSERT INTO `sys_menu` VALUES ('297', '车辆年检删除', '265', '0', '/wyc/carInspect/delete', '3', '1', '1', null, '1', null, null, null, 'carInspectDeleteBtn', null);
INSERT INTO `sys_menu` VALUES ('298', '违章记录查询', '273', '0', '/official/peccancy/selectPage2', '3', '1', '1', null, '1', null, null, null, 'endorsementQueryBtn', null);
INSERT INTO `sys_menu` VALUES ('299', '违章记录一键查询', '273', '0', '/official/peccancy/selectPeccancy', '3', '1', '1', null, '1', null, null, null, 'endorsementAkeySearchBtn', null);
INSERT INTO `sys_menu` VALUES ('300', '违章记录手动查询', '273', '0', '/official/peccancy/selectPeccancy', '3', '1', '1', null, '1', null, null, null, 'endorsementHandSearchBtn', null);
INSERT INTO `sys_menu` VALUES ('301', '公务车罚金查询', '274', '0', '/wyc/penaltyRecord/selectPage2', '3', '1', '1', null, '1', null, null, null, 'officialCarFineQuery', null);
INSERT INTO `sys_menu` VALUES ('302', '公务车罚金编辑', '274', '0', '/wyc/penaltyPay/update', '3', '1', '1', null, '1', null, null, null, 'officialCarFineEdit', null);
INSERT INTO `sys_menu` VALUES ('304', '公告发布', '183', '0', null, '2', '1', '0', null, '1', '5', null, null, 'announcementsIssued', '/announcementManagement/announcementIssued');
INSERT INTO `sys_menu` VALUES ('305', '公告列表', '183', '0', '/workbench/bulletin/wyc/selectPage', '2', '1', '0', null, '1', '6', null, null, 'announcementsList', '/announcementManagement/announcementList');
INSERT INTO `sys_menu` VALUES ('306', '公告列表导出', '305', '0', null, '3', '1', '1', null, '0', null, null, null, 'bulletinListExport', null);
INSERT INTO `sys_menu` VALUES ('307', '公告列表查看', '305', '0', null, '3', '1', '1', null, '1', null, null, null, 'bulletinListView', '/announcementManagement/announcementListView');
INSERT INTO `sys_menu` VALUES ('308', '公告列表删除', '305', '0', null, '3', '1', '1', null, '1', null, null, null, 'bulletinListDeleted', null);
INSERT INTO `sys_menu` VALUES ('309', '公告列表查询', '305', '0', null, '3', '1', '1', null, '1', null, null, null, 'bulletinListCheck', null);
INSERT INTO `sys_menu` VALUES ('310', '公告列表重置', '305', '0', null, '3', '1', '1', null, '1', null, null, null, 'bulletinListReset', null);
INSERT INTO `sys_menu` VALUES ('311', '系统配置', '29', '1', null, '2', '1', '0', null, '1', '70', null, null, 'systemConfiguration', '/systemConfiguration');
INSERT INTO `sys_menu` VALUES ('312', '公告发布', '311', '0', null, '2', '1', '0', null, '1', null, null, null, 'announcementsIssued', '/systemConfiguration/announcementIssued');
INSERT INTO `sys_menu` VALUES ('313', '公告列表', '311', '0', '/workbench/bulletin/taxi/selectPage', '2', '1', '0', null, '1', null, null, null, 'announcementsList', '/systemConfiguration/announcementList');
INSERT INTO `sys_menu` VALUES ('314', '保养预警', '217', '0', '', '2', '1', '0', null, '1', null, null, null, 'maintainAlertBtn', '');
INSERT INTO `sys_menu` VALUES ('315', '年检预警', '217', '0', '', '2', '1', '1', null, '1', null, null, null, 'annualAlertBtn', '');
INSERT INTO `sys_menu` VALUES ('316', '保险预警', '217', '0', '', '2', '1', '1', null, '1', null, null, null, 'insuranceAlertBtn', '');
INSERT INTO `sys_menu` VALUES ('317', '热点图', '90', '0', null, '2', '1', '1', null, '1', null, null, null, 'heatMap', '/heatMap');
INSERT INTO `sys_menu` VALUES ('318', '打表统计', '73', '0', '/taxiDeviceTrade/statisList2', '2', '1', '0', null, '1', null, null, null, 'meterStatistics', '/meterStatistics');
INSERT INTO `sys_menu` VALUES ('319', '工作台', '102', '1', '', '2', '1', '1', null, '1', '10', null, null, 'workBench', '');
INSERT INTO `sys_menu` VALUES ('320', '总控制台', '319', '0', '', '2', '1', '1', null, '1', null, null, null, 'topWorkTable', '/workBenchManage/topWorkBench');
INSERT INTO `sys_menu` VALUES ('321', '报表系统', '0', '1', '', '1', '1', '0', null, '1', '5', '2018-03-02 15:41:32', null, 'report', 'https://devt.bmkp.cn/bmkp-saas-report/');
INSERT INTO `sys_menu` VALUES ('322', '天王星:乘用车', '321', '1', '', '2', '1', '0', null, '1', null, null, null, 'passengerVehicle', '');
INSERT INTO `sys_menu` VALUES ('323', '乘用车订单明细-客服', '322', '0', '', '2', '1', '0', null, '1', '1', null, null, 'orderDetail', '/passengerVehicleManage/orderDetail');
INSERT INTO `sys_menu` VALUES ('324', '公告列表导出', '313', '0', null, '3', '1', '1', null, '0', null, null, null, 'announcementListExcel', null);
INSERT INTO `sys_menu` VALUES ('325', '公告列表查看', '313', '0', null, '3', '1', '1', null, '1', null, null, null, 'announcementListView', '/systemConfiguration/announcementListView');
INSERT INTO `sys_menu` VALUES ('326', '公告列表删除', '313', '0', null, '3', '1', '1', null, '1', null, null, null, 'announcementListDeleted', null);
INSERT INTO `sys_menu` VALUES ('327', '公告列表查询', '313', '0', null, '3', '1', '1', null, '1', null, null, null, 'announcementListCheck', null);
INSERT INTO `sys_menu` VALUES ('328', '乘用车按城市汇总', '322', '0', null, '2', '1', '0', null, '1', '3', null, null, 'aggregatedByCity', '/passengerVehicleManage/aggregatedByCity');
INSERT INTO `sys_menu` VALUES ('329', '乘用车按公司汇总', '322', '0', null, '2', '1', '0', null, '1', '4', null, null, 'summaryByCompany', '/passengerVehicleManage/summaryByCompany');
INSERT INTO `sys_menu` VALUES ('330', '预警设置', '311', '0', '/sysMenu/getMenuAndBtnByMenuId', '2', '1', '1', null, '1', null, null, null, 'warningManage', '/systemConfiguration/warningManage');
INSERT INTO `sys_menu` VALUES ('331', '合同预警', '330', '0', '', '2', '1', '0', null, '1', null, null, null, 'contractAlertBtn', '');
INSERT INTO `sys_menu` VALUES ('332', '网约车包车订单明细', '322', '0', null, '2', '1', '0', null, '1', '7', null, null, 'networkcarbcOrderDetail', '/passengerVehicleManage/networkcarbcOrderDetail');
INSERT INTO `sys_menu` VALUES ('333', '接送机订单明细', '322', '0', null, '2', '1', '0', null, '1', '8', null, null, 'transferOrderDetail', '/transferOrder/transferOrderDetail');
INSERT INTO `sys_menu` VALUES ('334', '乘用车客户乘坐汇总', '322', '0', null, '2', '1', '0', null, '1', '5', null, null, 'customerRideSummary', '/passengerVehicleManage/customerRideSummary');
INSERT INTO `sys_menu` VALUES ('335', '管理后台', '0', '1', null, '1', '1', '0', null, '1', '6', '2018-07-23 15:49:23', null, 'manage', 'https://devt.bmkp.cn/bmkp-saas-manage/');
INSERT INTO `sys_menu` VALUES ('336', '云服务管理', '335', '1', null, '2', '1', '0', null, '1', '1', null, null, 'cloudService', null);
INSERT INTO `sys_menu` VALUES ('337', '斑马云菜单管理', '336', '0', null, '2', '1', '1', null, '1', '1', null, null, 'cloudMenu', '/cloudService/menu');
INSERT INTO `sys_menu` VALUES ('338', '默认角色配置', '336', '0', null, '2', '1', '1', null, '1', '2', null, null, 'cloudDefaultRole', '/cloudService/role');
INSERT INTO `sys_menu` VALUES ('339', '套餐维护', '336', '0', null, '2', '1', '1', null, '1', '3', null, null, 'cloudPackage', '/cloudService/cloudPackage');
INSERT INTO `sys_menu` VALUES ('340', '工作台', '29', '1', '', '2', '1', '1', null, '1', '10', null, null, 'workBench', '');
INSERT INTO `sys_menu` VALUES ('341', '总控制台', '340', '0', '', '2', '1', '1', null, '1', null, null, null, 'topWorkTable', '/workBenchManage/topWorkBench');
INSERT INTO `sys_menu` VALUES ('342', '乘用车日运营', '322', '0', null, '2', '1', '0', null, '1', '2', null, null, 'dailyOperations', '/passengerVehicleManage/dailyOperations');
INSERT INTO `sys_menu` VALUES ('343', '乘用车订单明细-运营', '322', '0', null, '2', '1', '0', null, '1', '6', null, null, 'orderDetailO', '/passengerVehicleManage/orderDetailO');
INSERT INTO `sys_menu` VALUES ('344', '打表统计查询', '318', '0', null, '3', '1', '1', null, '1', null, null, null, 'setMeterStatisticsSearchBtn', '/taxiDeviceTrade/statisList');
INSERT INTO `sys_menu` VALUES ('345', '打表统计导出', '318', '0', null, '3', '1', '1', null, '1', null, null, null, 'setMeterStatisticsExportBtn', '/taxi/export');
INSERT INTO `sys_menu` VALUES ('346', '企业管理', '335', '1', null, '2', '1', '0', null, '1', '2', null, null, 'enterprise', null);
INSERT INTO `sys_menu` VALUES ('347', '企业审核', '346', '0', '/enterpriseAudit/selectPage', '2', '1', '1', null, '1', '1', null, null, 'enterpriseAuth', '/enterprise/auth');
INSERT INTO `sys_menu` VALUES ('348', '乘客信息查询', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'passengersQuery', '/userStatistics/passengersQuery');
INSERT INTO `sys_menu` VALUES ('349', '用户统计按日汇总-乘用车', '363', '0', '', '2', '1', '0', '', '1', null, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'userDailyBus', '/userStatistics/userDaily');
INSERT INTO `sys_menu` VALUES ('350', '用户统计按月汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'userMonthly', '/userStatistics/userMonthly');
INSERT INTO `sys_menu` VALUES ('351', '用户统计按时间段汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'userByTime', '/userStatistics/userByTime');
INSERT INTO `sys_menu` VALUES ('352', '用户统计按城市汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'userByCity', '/userStatistics/userByCity');
INSERT INTO `sys_menu` VALUES ('353', '用户账户留存率', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'userRetained', '/userStatistics/userRetained');
INSERT INTO `sys_menu` VALUES ('363', '超新星:用户统计', '321', '1', null, '2', '1', '0', null, '1', null, null, null, 'userStatistics', '/userStatistics');
INSERT INTO `sys_menu` VALUES ('364', '司机信息查询', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverQuery', '/userStatistics/driverQuery');
INSERT INTO `sys_menu` VALUES ('365', '司机统计按日汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverDaily', '/userStatistics/driverDaily');
INSERT INTO `sys_menu` VALUES ('366', '司机统计按司机汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverBydriver', '/userStatistics/driverByDriver');
INSERT INTO `sys_menu` VALUES ('367', '司机统计按城市汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverByCity', '/userStatistics/driverByCity');
INSERT INTO `sys_menu` VALUES ('368', '司机有效在线时长统计', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverEffectiveTime', '/userStatistics/driverOnlineTime');
INSERT INTO `sys_menu` VALUES ('369', '平台司机信息统计', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'platformDriver', '/userStatistics/platformDriverInformation');
INSERT INTO `sys_menu` VALUES ('370', '企业信息查询', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'enterpriseQuery', '/userStatistics/enterpriseInformation');
INSERT INTO `sys_menu` VALUES ('371', '司机意向', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverIntention', '/userStatistics/driverIntention');
INSERT INTO `sys_menu` VALUES ('372', '司机注册审核信息', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverAudit', null);
INSERT INTO `sys_menu` VALUES ('373', 'APP车载上线信息统计', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'appInformationStatistics', '/userStatistics/appOnlineStatics');
INSERT INTO `sys_menu` VALUES ('374', 'app启动汇总', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'appLaunchSummary', null);
INSERT INTO `sys_menu` VALUES ('375', 'app启动明细', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'appStartupDetails', null);
INSERT INTO `sys_menu` VALUES ('376', '司机在线时长统计-全部', '363', '0', null, '2', '1', '0', null, '1', null, null, null, 'driverOnlineTimeStatistics', null);
INSERT INTO `sys_menu` VALUES ('377', '用户统计按日汇总-出租车', '363', '0', '', '2', '1', '0', '', '1', null, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 'userDailyTaix', '/userStatistics/userDailyTaix');
