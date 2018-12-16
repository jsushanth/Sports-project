package com.cg.sports.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.sports.util.DBConnection;
import com.cg.sports.bean.SportsBean;
import com.cg.sports.exception.SportsException;

public class ISportsDAOImpl implements ISportsDAO {

	@Override
	public String addSports(SportsBean sports) throws SportsException, IOException, ClassNotFoundException, SQLException {
          
		Connection connection=DBConnection.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		String sportsId=null;
		int queryResult=0;
		try {
			preparedStatement=connection.prepareStatement("insert into Sports_details values(sports_id_sequence.nextval,?,?,?,?)");
			
			preparedStatement.setString(1,sports.getSportsName());
			preparedStatement.setInt(2, sports.getSportsQuantity());
			preparedStatement.setString(3,sports.getSportsBrand());
			preparedStatement.setFloat(4, sports.getSportsCost());
			preparedStatement.executeUpdate();
			Statement st=connection.createStatement();
			resultSet=st.executeQuery("select max(sports_id) from Sports_details");
			
			if(resultSet.next()){
				sportsId=resultSet.getString(1);
				
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
        
		return sportsId;
	}

	@Override
	public SportsBean searchSportsKit(String sportsId) throws SportsException, IOException, ClassNotFoundException, SQLException {
		Connection connection=DBConnection.getConnection();
		SportsBean bean=null;
		try {
			Statement st=connection.createStatement();
			
				
			ResultSet rs=st.executeQuery("select * from Sports_details where sports_id='"+sportsId+"'");
			bean=new SportsBean();
			while(rs.next()){
				bean.setSportsId(rs.getInt(1));
				bean.setSportsName(rs.getString(2));
				bean.setSportsQuantity(rs.getInt(3));
				bean.setSportsBrand(rs.getString(4));
				bean.setSportsCost(rs.getFloat(5));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return bean;
	}

	@Override
	public List<SportsBean> retrieveAll() throws SportsException, IOException, ClassNotFoundException, SQLException {
			Connection connection=DBConnection.getConnection();
			List<SportsBean>li=new ArrayList<>();
			try {
				Statement st=connection.createStatement();
				ResultSet rs=st.executeQuery("select * from sports_details");
				while(rs.next()){
					SportsBean bean=new SportsBean();
					bean.setSportsId(rs.getInt(1));
					bean.setSportsName(rs.getString(2));
					bean.setSportsQuantity(rs.getInt(3));
					bean.setSportsBrand(rs.getString(4));
					bean.setSportsCost(rs.getFloat(5));
				li.add(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			// TODO Auto-generated method stub
			return li;
		}
       
		
	}


