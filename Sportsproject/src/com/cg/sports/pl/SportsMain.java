package com.cg.sports.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.sports.bean.SportsBean;
import com.cg.sports.exception.SportsException;
import com.cg.sports.service.ISportsService;
import com.cg.sports.service.SportsServiceImpl;




public class SportsMain {

	
	static Scanner scan=new Scanner(System.in);
	static ISportsService sportsService=null;
	static SportsServiceImpl sportsServiceImpl=null;
	public static void main(String[] args) {

		SportsBean sportsBean=null;
		String sportsId=null;
		int option=0;
		while(true){
			
			System.out.println("Sports Management System");
			System.out.println("--------------------------------");
			System.out.println("1.Add Sports");
			System.out.println("2.Search Sports kit");
			System.out.println("3.RetrieveAll sportskit details");
			System.out.println("4.Exit");
			System.out.println("Select your choice");
			try {
				option=scan.nextInt();
				switch (option) {
				case 1:
					while(sportsBean==null){
						sportsBean=populateSportsBean();
						
					}
					try {
						sportsService=new SportsServiceImpl();
						sportsId=sportsService.addSports(sportsBean);
						System.out.println("sports details has been successfully added");
						System.out.println("book id is"+sportsId );
					} catch (SportsException sportsException) {
						System.out.println("error"+sportsException.getMessage());
						
					}
					
					finally{
						sportsId=null;
						sportsService=null;
						sportsBean=null;
						
					}
					break;
				case 2:
					
					try {
						sportsService=new SportsServiceImpl();
						System.out.println("Enter sports id:");
						System.out.println(sportsService.searchSportsKit(scan.next()));
						
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					break;
				case 3:
					sportsService=new SportsServiceImpl();
					System.out.println("total number of books in the data base are:");
					if(sportsService.retrieveAll()!=null){
						System.out.println(sportsService.retrieveAll());
					}
					break;
					
				case 4:
					System.out.println("Your out of the page please try again");
					System.exit(0);
					break;
				default:
					break;
				}
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			       }
		}
		}
	
	private static SportsBean populateSportsBean(){
		SportsBean sportsBean=new SportsBean();
		System.out.println("\n Enter the details");
		System.out.println("Enter the Sports name");
		sportsBean.setSportsName(scan.next());
		System.out.println("Enter the Sportsbrand");
		sportsBean.setSportsBrand(scan.next());
		System.out.println("Enter the sports quantity");
		sportsBean.setSportsQuantity(scan.nextInt());
		System.out.println("Enter the cost of the Sportskit");
		try {
			sportsBean.setSportsCost(scan.nextFloat());
		} catch (InputMismatchException ime) {
			scan.nextLine();
			System.out.println("Please enter the numeric value for the sportskit cost");
			// TODO: handle exception
		}
		sportsServiceImpl=new SportsServiceImpl();
		try {
			sportsServiceImpl.validateSports(sportsBean);
			return sportsBean;
		} catch (SportsException librarianException) {
			System.out.println("invalid data");
			System.out.println(librarianException.getMessage()+"\n try again");
			System.exit(0);
			// TODO: handle exception
		}
		return null;
	}
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
					
					
			  		
			
			
			

	

