
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

-- test data feed

INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) values (2,'空格',1,18647489192,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'(旧区)出租出售','因工作调动出售瑞宁名苑B区13号楼1单元10楼东户120平米，地暖，水电设施，地砖，墙砖都是精选精装，暖气费，物业费都已交清，价格面议');
INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) values (2,'空格',1,15848461340,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'(新区)急售','学府花园8号楼1单元6楼86平米（阁楼）精装修，带全套家俱，格局好，售价面议');
INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) values (2,'空格',0,18647482911,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'(新区)售学区房','集宁一中南800米，哈佛阳光高层复式楼北区3楼114平米，毛坯，3室2厅2卫，上下层，最高10层，低于市场价出售。');
INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,content) values (2,'空格',0,15540019919,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'(新区)售房','新区水岸雅苑（学区房）6楼100平米，精装，全带，价格面议');
INSERT INTO feed(uid,nickName,isTop,cellphone,avatar,categoryId,title,status,content) values (2,'空格',1,18647489192,'https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIVlAAF0ibvKmXia7AyB9jgMTMjvFksUV3It4YfJgYosYP2HYic2dblwH1A5sLk8Ow3qEs6MXR6rZ9qA/132',2,'(旧区)出租出售',1,'因工作调动出售瑞宁名苑B区13号楼1单元10楼东户120平米，地暖，水电设施，地砖，墙砖都是精选精装，暖气费，物业费都已交清，价格面议');
