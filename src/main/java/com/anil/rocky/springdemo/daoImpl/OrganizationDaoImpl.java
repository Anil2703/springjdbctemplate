package com.anil.rocky.springdemo.daoImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.anil.rocky.springdemo.dao.OrganizationDao;
import com.anil.rocky.springdemo.domain.Organization;

@Repository("orgDao")
public class OrganizationDaoImpl implements OrganizationDao {

	
	
	private JdbcTemplate jdbcTemplate;
	// DataSource datasource;

	//@Resource(name="datasource")
	@Autowired
	@Qualifier("datasource")
	public void setDataSource(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);

	}

	public boolean Create(Organization org) {
		String sqlQuery = "insert into organization(company_name,year_of_incorporation,postal_code,employee_count,slogan)"
				+ "values(?,?,?,?,?)";
		Object[] args = new Object[] { org.getCompanyName(), org.getYearOfIncorporation(), org.getPostalCode(),
				org.getEmployeeCount(), org.getSlogan() };

		return jdbcTemplate.update(sqlQuery, args) == 1;
	}

	public Organization getOrganization(Integer id) {
	
		String sqlQuery="select * from organization where id=?";
		Object[] args = new Object[] {id};
		Organization org=jdbcTemplate.queryForObject(sqlQuery, args,new OrganizationRowMapper());
		return org;
	}

	public List<Organization> getAllOrganizations() {
		String sqlQuery = "select * from Organization";
		List<Organization> orgList = jdbcTemplate.query(sqlQuery, new OrganizationRowMapper());
		return orgList;
	}

	public boolean delete(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(Organization org) {
		// TODO Auto-generated method stub
		return false;
	}

	public void cleanUp() {
		String sqlQuery="Truncate Table organization";
		jdbcTemplate.execute(sqlQuery);
	}
	
	

}
