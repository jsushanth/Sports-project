package com.cg.sports.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.sports.exception.SportsException;
import com.cg.sports.bean.SportsBean;
import com.cg.sports.exception.SportsException;

public interface ISportsDAO {
	
	public String  addSports(SportsBean sports) throws SportsException, IOException, ClassNotFoundException, SQLException;
	public SportsBean searchSportsKit(String sportsId) throws SportsException, IOException, ClassNotFoundException, SQLException;
	public List<SportsBean> retrieveAll()throws SportsException, IOException, ClassNotFoundException, SQLException;

}
