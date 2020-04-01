package com.anil.rocky.springdemo;

import java.util.ArrayList;
import java.util.List;

import com.anil.rocky.springdemo.dao.OrganizationDao;
import com.anil.rocky.springdemo.domain.Organization;

public class DaoUtils {

	public static final String createOperation= "CREATE";
	public static final String readOperation = "READ";
	public static final String updateOperation = "UPDATE";
	public static final String deleteOperation = "DELETE";
	public static final String cleanupOperation = "TRUNCATE";
	
	
	public static void printOrganizations(List<Organization> orgs,String operation)
	{
		System.out.println("\n *********************printing organizations after"+operation+"operation*********");
		for(Organization o1: orgs) {
			System.out.println(o1);
		}
	}
	
	public  static void printSuccessFailure(String operation,boolean param)
	{
		if(param)
		{
			System.out.println("\n Operation"+operation+"Successful");
		}
		else
		{
			System.out.println("\n Operation"+operation+"Failed");
		}
	}
	
	
	public static void createSeedData(OrganizationDao dao)
	{
		Organization org1= new Organization("Anil",2020 ,"533001", 55555,"Anil's Slogan");
		Organization org2= new Organization("Rocky",2021 ,"533001",66666,"Rocky's Slogan");
		Organization org3= new Organization("Daisy",2022 ,"533001",77777,"Daisy's Slogan");
		
		
		
		List<Organization> orgs= new ArrayList<Organization>();
		orgs.add(org1);
		orgs.add(org2);
		orgs.add(org3);
		int createCount=0;
		for(Organization o1:orgs)
		{
			boolean isCreated=dao.Create(o1);
			if(isCreated)
			{
				createCount+=1;
			}
		}
		System.out.println("Created"+createCount+" organizations");
	}
	
	
	public static void printOrganizationCount(List<Organization> orgs,String operation)
	{
		System.out.println("\n *********************Currently we have "+orgs.size()+"organizations after"+operation+"operation");
		
	}
}
