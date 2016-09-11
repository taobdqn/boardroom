package cn.bd.impdao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import cn.bd.dao.Dao;
import cn.bd.dao.DestineinfoDao;
import cn.bd.entity.destineinfo;

public class ImpDao extends Dao implements DestineinfoDao{

	public int addDinfo(destineinfo destineinfo) {
		
		String sql="insert destineinfo values(?,?,?)";
		Object [] parm={destineinfo.getRoom_name(),destineinfo.getDestine_name(),destineinfo.getDestine_time()};
		
		return exceuteUpdate(sql, parm);
	}

	public int deleteDinfo(destineinfo destineinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateDinfo(destineinfo destineinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<destineinfo> queryDinfo() {
		// TODO Auto-generated method stub
		String sql="select * from destineinfo";
		List<destineinfo> list=new ArrayList<destineinfo>();
		
		Object [] parm={}; //?????????必需要,不然运行不了
		ResultSet rs=exceuteQuery(sql,parm);
		try {
			while(rs.next()){
				destineinfo d=new destineinfo();
				d.setId(rs.getInt(1));
				d.setRoom_name(rs.getString(2));
				d.setDestine_name(rs.getString(3));
				d.setDestine_time(rs.getString(4));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
