/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : xiaoyuan_cloud

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 20/01/2021 14:49:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_dict
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict
-- ----------------------------
INSERT INTO `sys_dict` VALUES (1, NULL, NULL, NULL, NULL, 'admin', '2021-01-19 17:16:29', '机构类型', 'organ_type');

-- ----------------------------
-- Table structure for sys_dict_value
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict_value`;
CREATE TABLE `sys_dict_value`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `dict_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_dict_value
-- ----------------------------
INSERT INTO `sys_dict_value` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, '公司', '1', '公司', 1, 'organ_type', '1');
INSERT INTO `sys_dict_value` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, '部门', '1', '部门', 2, 'organ_type', '2');

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keep_alive` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` bigint(20) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 33 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'el-icon-setting', NULL, '系统管理', 7, '', 'sys', 1, '0');
INSERT INTO `sys_menu` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, 'views/upms/menu/index', 'el-icon-menu', NULL, '菜单管理', 1, 'menu', 'sys:menu', 11, '0');
INSERT INTO `sys_menu` VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, 'views/upms/user/index', 'el-icon-s-custom', NULL, '用户管理', 1, 'user', 'sys:user', 12, '0');
INSERT INTO `sys_menu` VALUES (4, NULL, NULL, NULL, NULL, NULL, NULL, 'views/upms/role/index', 'el-icon-s-custom', NULL, '角色管理', 1, 'role', 'sys:role', 13, '0');
INSERT INTO `sys_menu` VALUES (7, NULL, NULL, NULL, NULL, NULL, NULL, 'Layout', 'icon-quanxianguanli', NULL, '权限管理', 0, '/auth', NULL, 1, '0');
INSERT INTO `sys_menu` VALUES (11, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '菜单新增', 2, '', 'sys:menu:add', 111, '1');
INSERT INTO `sys_menu` VALUES (12, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '菜单删除', 2, '', 'sys:menu:del', 112, '1');
INSERT INTO `sys_menu` VALUES (13, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '菜单编辑', 2, '', 'sys:menu:edit', 113, '1');
INSERT INTO `sys_menu` VALUES (14, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '菜单查询', 2, '', 'sys:menu:get', 114, '1');
INSERT INTO `sys_menu` VALUES (15, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '用户新增', 3, '', 'sys:user:add', 121, '1');
INSERT INTO `sys_menu` VALUES (16, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '用户删除', 3, '', 'sys:user:del', 122, '1');
INSERT INTO `sys_menu` VALUES (17, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '用户修改', 3, '', 'sys:user:edit', 123, '1');
INSERT INTO `sys_menu` VALUES (18, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '用户查看', 3, '', 'sys:user:get', 124, '1');
INSERT INTO `sys_menu` VALUES (19, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '角色新增', 4, '', 'sys:role:add', 131, '1');
INSERT INTO `sys_menu` VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '角色删除', 4, '', 'sys:role:del', 132, '1');
INSERT INTO `sys_menu` VALUES (21, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '角色修改', 4, '', 'sys:role:edit', 133, '1');
INSERT INTO `sys_menu` VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '角色查看', 4, '', 'sys:role:get', 134, '1');
INSERT INTO `sys_menu` VALUES (23, NULL, NULL, NULL, NULL, NULL, NULL, 'views/upms/organ/index', 'el-icon-s-data', NULL, '机构管理', 1, 'organ', 'sys:organ', 14, '0');
INSERT INTO `sys_menu` VALUES (24, NULL, NULL, NULL, NULL, NULL, NULL, 'views/upms/dict/index', 'el-icon-s-management', NULL, '字典管理', 1, 'dict', 'sys:dict', 15, '0');
INSERT INTO `sys_menu` VALUES (25, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '字典新增', 24, '', 'sys:dict:add', 151, '1');
INSERT INTO `sys_menu` VALUES (26, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '字典删除', 24, '', 'sys:dict:del', 152, '1');
INSERT INTO `sys_menu` VALUES (27, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '字典修改', 24, '', 'sys:dict:edit', 153, '1');
INSERT INTO `sys_menu` VALUES (28, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '字典查看', 24, '', 'sys:dict:get', 154, '1');
INSERT INTO `sys_menu` VALUES (29, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '机构新增', 23, '', 'sys:organ:add', 141, '1');
INSERT INTO `sys_menu` VALUES (30, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '机构删除', 23, '', 'sys:organ:del', 142, '1');
INSERT INTO `sys_menu` VALUES (31, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '机构修改', 23, '', 'sys:organ:edit', 143, '1');
INSERT INTO `sys_menu` VALUES (32, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, '机构查看', 23, '', 'sys:organ:get', 144, '1');
INSERT INTO `sys_menu` VALUES (33, 'admin', '2021-01-20 14:13:04', NULL, NULL, 'admin', '2021-01-20 14:13:04', '', '', NULL, '分配权限', 4, '', 'sys:role:perm', 135, '1');

-- ----------------------------
-- Table structure for sys_oauth_client
-- ----------------------------
DROP TABLE IF EXISTS `sys_oauth_client`;
CREATE TABLE `sys_oauth_client`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `resource_ids` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `client_secret` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密钥',
  `scope` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '域',
  `authorized_grant_types` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权模式',
  `web_server_redirect_uri` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `authorities` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `access_token_validity` int(11) NULL DEFAULT NULL,
  `refresh_token_validity` int(11) NULL DEFAULT NULL,
  `additional_information` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `autoapprove` char(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '终端信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_oauth_client
-- ----------------------------
INSERT INTO `sys_oauth_client` VALUES ('admin', NULL, 'admin', 'server', 'password,refresh_token,authorization_code,client_credentials', '', NULL, NULL, NULL, NULL, 'true', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_oauth_client` VALUES ('gen', NULL, 'gen', 'server', 'password,refresh_token', NULL, NULL, NULL, NULL, NULL, 'true', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_oauth_client` VALUES ('miniapp', '', 'miniapp', 'server', 'refresh_token,password', '', '', NULL, NULL, '', 'true', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_oauth_client` VALUES ('swagger', '', 'swagger', 'server', 'password,refresh_token', '', '', NULL, NULL, '', 'true', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `sys_oauth_client` VALUES ('weixin', '', 'weixin', 'server', 'password,refresh_token', '', '', NULL, NULL, '', 'true', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for sys_organ
-- ----------------------------
DROP TABLE IF EXISTS `sys_organ`;
CREATE TABLE `sys_organ`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_organ
-- ----------------------------
INSERT INTO `sys_organ` VALUES (1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '10000', NULL, '高斯贝尔', 0, '12345678910', 1, '1');
INSERT INTO `sys_organ` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, '', '10001', '', '成都驰通', 1, '18680021020', 2, '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `ds_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ds_type` int(11) NULL DEFAULT NULL,
  `role_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, NULL, NULL, 0, NULL, NULL, NULL, NULL, 0, 'ROLE_ADMIN', '管理员', '管理员');
INSERT INTO `sys_role` VALUES (3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 'ROLE_TEST', '测试专用', '测试角色');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menu_id` bigint(20) NULL DEFAULT NULL,
  `role_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2, 1);
INSERT INTO `sys_role_menu` VALUES (3, 3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 4, 1);
INSERT INTO `sys_role_menu` VALUES (5, 7, 1);
INSERT INTO `sys_role_menu` VALUES (6, 11, 1);
INSERT INTO `sys_role_menu` VALUES (7, 12, 1);
INSERT INTO `sys_role_menu` VALUES (8, 13, 1);
INSERT INTO `sys_role_menu` VALUES (9, 14, 1);
INSERT INTO `sys_role_menu` VALUES (10, 15, 1);
INSERT INTO `sys_role_menu` VALUES (11, 16, 1);
INSERT INTO `sys_role_menu` VALUES (12, 17, 1);
INSERT INTO `sys_role_menu` VALUES (13, 18, 1);
INSERT INTO `sys_role_menu` VALUES (14, 19, 1);
INSERT INTO `sys_role_menu` VALUES (15, 20, 1);
INSERT INTO `sys_role_menu` VALUES (16, 21, 1);
INSERT INTO `sys_role_menu` VALUES (17, 22, 1);
INSERT INTO `sys_role_menu` VALUES (18, 23, 1);
INSERT INTO `sys_role_menu` VALUES (19, 24, 1);
INSERT INTO `sys_role_menu` VALUES (20, 25, 1);
INSERT INTO `sys_role_menu` VALUES (21, 26, 1);
INSERT INTO `sys_role_menu` VALUES (22, 27, 1);
INSERT INTO `sys_role_menu` VALUES (23, 28, 1);
INSERT INTO `sys_role_menu` VALUES (24, 29, 1);
INSERT INTO `sys_role_menu` VALUES (25, 30, 1);
INSERT INTO `sys_role_menu` VALUES (26, 31, 1);
INSERT INTO `sys_role_menu` VALUES (27, 32, 1);
INSERT INTO `sys_role_menu` VALUES (28, 33, 1);
INSERT INTO `sys_role_menu` VALUES (29, 23, 3);
INSERT INTO `sys_role_menu` VALUES (30, 29, 3);
INSERT INTO `sys_role_menu` VALUES (31, 31, 3);
INSERT INTO `sys_role_menu` VALUES (32, 32, 3);
INSERT INTO `sys_role_menu` VALUES (33, 30, 3);
INSERT INTO `sys_role_menu` VALUES (34, 7, 3);
INSERT INTO `sys_role_menu` VALUES (35, 1, 3);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `del_flag` int(11) NULL DEFAULT NULL,
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lock_flag` int(11) NULL DEFAULT NULL,
  `organ_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wx_openid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'pyd@qq.com', 0, '1', '$2a$10$5zksEq3c.xGm2qd6CrhvneztkI5nZcZzyRS5/E1vFQanxnCT5P4cW', '12345678910', 'admin', NULL);
INSERT INTO `sys_user` VALUES (3, NULL, NULL, NULL, NULL, 'admin', '2021-01-19 17:21:31', NULL, 'test@qq.com', 0, '2', '$2a$10$5zksEq3c.xGm2qd6CrhvneztkI5nZcZzyRS5/E1vFQanxnCT5P4cW', '12345678901', 'test', NULL);

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (2, 1, 2);
INSERT INTO `sys_user_role` VALUES (6, 3, 3);

SET FOREIGN_KEY_CHECKS = 1;
