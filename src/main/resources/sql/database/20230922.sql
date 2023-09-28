CREATE TABLE `FM_BANK` (
  `BANK_ID` varchar(20) DEFAULT NULL COMMENT '银行ID|银行ID',
  `BANK_CODE` varchar(20) NOT NULL COMMENT '银行代码|在同一个表中两个不同字段的中文注释都为银行代码',
  `BANK_TYPE` char(1) NOT NULL COMMENT '银行类别|银行类别|O-我行,B-他行,S-建房互助协会,T-第三方银行',
  `BANK_NAME` varchar(50) NOT NULL COMMENT '银行名称|银行名称',
  `STATUS` char(1) NOT NULL COMMENT '状态|状态|A-有效,F-无效,O-未过账,P-已过账',
  `COMPANY` varchar(20) DEFAULT NULL COMMENT '法人|法人',
  `TRAN_TIMESTAMP` varchar(26) NOT NULL COMMENT '交易时间戳|交易时间戳',
  PRIMARY KEY (`BANK_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='外部金融机构定义表|外部金融机构定义表，核心暂未使用'
CREATE TABLE `FM_BANK_HIERARCHY` (
  `HIERARCHY_CODE` varchar(20) NOT NULL COMMENT '层级代码|层级代码',
  `HIERARCHY_NAME` varchar(50) DEFAULT NULL COMMENT '层级说明|层级说明',
  `HIERARCHY_LEVEL` varchar(10) DEFAULT NULL COMMENT '分行级别|分行级别',
  `COMPANY` varchar(20) DEFAULT NULL COMMENT '法人|法人',
  `TRAN_TIMESTAMP` varchar(26) NOT NULL COMMENT '交易时间戳|交易时间戳',
  PRIMARY KEY (`HIERARCHY_CODE`),
  KEY `FM_BANK_HIERARCHY_IND1M` (`HIERARCHY_LEVEL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='机构层次表|机构层次表'
CREATE TABLE `FM_BRANCH_CCY` (
  `BRANCH` varchar(50) NOT NULL COMMENT '所属机构号|机构代码',
  `CCY` varchar(3) NOT NULL COMMENT '币种|币种',
  `COMPANY` varchar(20) DEFAULT NULL COMMENT '法人|法人',
  `TRAN_TIMESTAMP` varchar(26) NOT NULL COMMENT '交易时间戳|交易时间戳',
  PRIMARY KEY (`BRANCH`,`CCY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='机构币种表|机构币种表'
CREATE TABLE `userInfo` (
  `customerId` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `createTime` varchar(255) DEFAULT NULL,
  `iseffective` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`customerId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE `work_log` (
  `id` varchar(50) NOT NULL,
  `customerid` varchar(50) DEFAULT NULL,
  `create_time` varchar(50) DEFAULT NULL,
  `work_context` text,
  `username` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
