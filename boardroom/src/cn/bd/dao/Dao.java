package cn.bd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	private String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url="jdbc:sqlserver://localhost:1433;DatabaseName=boardroom";
	
	
	private Connection conn=null;
	private PreparedStatement pstm;
	private ResultSet rs;
	
	public Connection getConnection(){
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,"sa","123");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeAll(Connection conn,PreparedStatement pstm,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(pstm!=null){
			try {
				pstm.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//增删改的操作
	public int exceuteUpdate(String sql,Object...parm){
		int result=0;
		pstm=null;
		conn=this.getConnection();
		try {
			pstm=conn.prepareStatement(sql);
			if(parm!=null){
				for(int i=0;i<parm.length;i++){
					pstm.setObject(i+1, parm[i]);
				}
			}
			result=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeAll(conn, pstm, rs);
		}
		
		return result;
	}
	
	//查询的操作
	public ResultSet exceuteQuery(String sql,Object...parm){
		pstm=null;
		rs=null;
		
		conn=this.getConnection();
		
		try {
			pstm=conn.prepareStatement(sql);
			if(parm!=null){
				for(int i=0;i<parm.length;i++){
					pstm.setObject(i+1, parm[i]);
				}
			}
			rs=pstm.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
