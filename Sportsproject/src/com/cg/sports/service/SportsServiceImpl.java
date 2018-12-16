package com.cg.sports.service;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sports.bean.SportsBean;
import com.cg.sports.dao.ISportsDAO;
import com.cg.sports.dao.ISportsDAOImpl;
import com.cg.sports.exception.SportsException;

public class SportsServiceImpl implements ISportsService {
	ISportsDAO sportsdao=new ISportsDAOImpl();
	@Override
	public String addSports(SportsBean sports) throws SportsException, ClassNotFoundException, IOException, SQLException {
		String sportsSeq;
		sportsSeq=sportsdao.addSports(sports);
		return sportsSeq;
	}

	@Override
	public SportsBean searchSportsKit(String sportsId) throws SportsException, ClassNotFoundException, IOException, SQLException {
		String b=sportsId;
		SportsBean a=sportsdao.searchSportsKit(sportsId);
		return a;
	}

	@Override
	public List<SportsBean> retrieveAll() throws SportsException, ClassNotFoundException, IOException, SQLException {

		List<SportsBean> li=new ArrayList<>();
		li=sportsdao.retrieveAll();
		return li;
	}
	

	public void validateSports(SportsBean spbean) throws SportsException{
		List<String> validationErrors=new ArrayList<String>();
		
		
		if(!(isValidSportsName(spbean.getSportsName())))
		{
			validationErrors.add("\n sports name should be in alphabets and should have minimum 3 characerts:");
		}
		
		if(!(isValidSportsBrand(spbean.getSportsBrand()))) {
			validationErrors.add("\n sports brand  should have characters and  have minimum 3  characters");
		}


		if(!(isValidSportsCost(spbean.getSportsCost()))) {
			validationErrors.add("\n amount should be positive number");
		}
		if(!validationErrors.isEmpty()) {
			throw new SportsException(validationErrors +" ");
		}
	
	

}

	private boolean isValidSportsCost(float sportsCost) {
		// TODO Auto-generated method stub
		return sportsCost>0;
	}

	private boolean isValidSportsBrand(String sportsBrand) {
		// TODO Auto-generated method stub
		Pattern namePattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(sportsBrand);
		return nameMatcher.matches();
	}

	private boolean isValidSportsName(String sportsName) {
		// TODO Auto-generated method stub
		Pattern namePattern=Pattern.compile("^[A-Z][a-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(sportsName);
		return nameMatcher.matches();
	}
}
