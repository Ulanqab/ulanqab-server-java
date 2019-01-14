DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_detail;

CREATE TABLE user (
  uid       BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nickName  VARCHAR(255) NOT NULL,
  avatar    VARCHAR(255),
  role      INT DEFAULT 1 COMMENT '1 user 2 admin 3 super admin',
  loginAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  expiresAt TIMESTAMP,
  isLocked  BOOLEAN   DEFAULT FALSE
);


CREATE TABLE user_detail (
  uid        IDENTITY,
  mobile     VARCHAR(255),
  username   VARCHAR(255) NOT NULL,
  avatar     VARCHAR(255),
  location   VARCHAR(255),
  unionId    VARCHAR(255),
  city       VARCHAR(255),
  country    VARCHAR(255),
  province   VARCHAR(255),
  age        INTEGER      DEFAULT 0,

  gender     INT          DEFAULT 0
  COMMENT '0 unknown 1 male 2 female',

  role       INT          DEFAULT 1
  COMMENT '1 user 2 admin 3 super admin',

  registerAt TIMESTAMP    DEFAULT CURRENT_TIMESTAMP
  COMMENT 'use first insert timestamp',

  updatedAt  TIMESTAMP AS CURRENT_TIMESTAMP
  COMMENT 'update as current time each time row updated',

  FOREIGN KEY (uid) REFERENCES user (uid),
);

CREATE TABLE feed (
  id        BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nickName  VARCHAR(255) NOT NULL,
  avatar    VARCHAR(255),
  title     INT DEFAULT 1,
  createAt  TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  publishAt TIMESTAMP
);