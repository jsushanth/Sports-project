package com.cg.sports.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.sports.bean.SportsBean;
import com.cg.sports.exception.SportsException;

public interface ISportsService {


	public String  addSports(SportsBean sports) throws SportsException, ClassNotFoundException, IOException, SQLException;
	public SportsBean searchSportsKit(String sportsId) throws SportsException, ClassNotFoundException, IOException, SQLException;
	public List<SportsBean> retrieveAll()throws SportsException, ClassNotFoundException, IOException, SQLException;
	
}
