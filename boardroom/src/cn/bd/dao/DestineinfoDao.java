package cn.bd.dao;


import java.util.List;

import cn.bd.entity.destineinfo;

public interface DestineinfoDao {
	
	int addDinfo(destineinfo destineinfo);
	int deleteDinfo(destineinfo destineinfo);
	int updateDinfo(destineinfo destineinfo);
	
	
	List<destineinfo> queryDinfo();
}
