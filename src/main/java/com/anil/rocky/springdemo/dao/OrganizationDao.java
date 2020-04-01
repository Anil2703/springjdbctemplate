package com.anil.rocky.springdemo.dao;

import java.util.List;

import javax.sql.DataSource;

import com.anil.rocky.springdemo.domain.Organization;

public interface OrganizationDao {

	// Set the data source that will be required to create a connection the database
	public void setDataSource(DataSource datasource);
	
	//Create a record in the organization table
	public boolean Create(Organization org);
	
	//Retreive a Single Organization
	public Organization getOrganization(Integer id);
	
	//Retreive all organizations from the table
	public List<Organization> getAllOrganizations();
	
	
	//Delete a specific organization from the table
	public boolean delete(Organization org);
	
	//Update an existing organization
	public boolean update(Organization org);
	
	
	public void cleanUp();
	
}
