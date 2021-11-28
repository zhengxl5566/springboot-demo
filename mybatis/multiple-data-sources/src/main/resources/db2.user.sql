/*
 Navicat Premium Data Transfer

 Source Server         : MyDB
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : 123.57.211.17:3306
 Source Schema         : db2

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 05/11/2021 09:18:16
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`   int(0) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, 'zhengxl');

SET
FOREIGN_KEY_CHECKS = 1;
