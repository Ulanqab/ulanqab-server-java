DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS user_detail;
DROP TABLE IF EXISTS feed;
DROP TABLE IF EXISTS category;

CREATE TABLE user (
  uid       BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  thirdId   VARCHAR(255) NOT NULL,
  nickName  VARCHAR(255) NOT NULL,
  avatar    VARCHAR(255),
  role      INT DEFAULT 1 COMMENT '1 user 2 admin 3 super admin',
  loginAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  expiresAt TIMESTAMP,
  isLocked  BOOLEAN   DEFAULT FALSE
);


CREATE TABLE user_detail (
  uid        BIGINT,
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


CREATE TABLE category (
  id        INTEGER UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  name      VARCHAR(255) NOT NULL,
  code      VARCHAR(255) NOT NULL,
  createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) AUTO_INCREMENT = 0;

CREATE TABLE feed (
  id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  uid         BIGINT NOT NULL,
--   FOREIGN KEY (uid) REFERENCES user(uid),
  categoryId  INTEGER NOT NULL,
--   FOREIGN KEY (categoryId) REFERENCES category(id),
  nickName    VARCHAR(255) NOT NULL,
  avatar      VARCHAR(255),
  title       VARCHAR(255),
  images      VARCHAR(255),
  video       VARCHAR(255),
  content     VARCHAR(255) NOT NULL,
  likeCount   INTEGER   DEFAULT 0,
  viewCount   INTEGER   DEFAULT 0,
  createAt    TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updatedAt   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  publishAt   TIMESTAMP,
  status      INTEGER   DEFAULT 0
  COMMENT '0 created, 1 published 2  expired 3 deleted'
);