
-- init data category

INSERT INTO category(name, code) VALUES('推荐', 'Recommend');
INSERT INTO category(name, code) VALUES('房产出售', 'SaleProperty');
INSERT INTO category(name, code) VALUES('房屋出租', 'HouseRent');
INSERT INTO category(name, code) VALUES('转租转让', 'SubleaseTransfer');
INSERT INTO category(name, code) VALUES('本地服务', 'LocalServer');
INSERT INTO category(name, code) VALUES('汽车信息', 'CarsInfo');
INSERT INTO category(name, code) VALUES('人才招聘', 'Recruitment');
INSERT INTO category(name, code) VALUES('其他栏目', 'Others');
INSERT INTO category(name, code) VALUES('教育培训', 'Education');

CREATE TABLE feed (
  id          BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  uid         BIGINT NOT NULL,
--   FOREIGN KEY (uid) REFERENCES user(uid),
  categoryId  INTEGER NOT NULL,
--   FOREIGN KEY (categoryId) REFERENCES category(id),
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
-- test data feed

INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
INSERT INTO feed(uid,nickName,avatar,categoryId,title,content) values (2,'空格','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'周1测试日','天凉凉天凉凉天凉凉');
