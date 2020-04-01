package com.anil.rocky.springdemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anil.rocky.springdemo.dao.OrganizationDao;
import com.anil.rocky.springdemo.daoImpl.OrganizationDaoImpl;
import com.anil.rocky.springdemo.domain.Organization;
import com.mysql.fabric.xmlrpc.base.Array;

public class JdbcTemplateClassicApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans-cp.xml");
		OrganizationDao orgdao = (OrganizationDaoImpl) context.getBean("orgDao");

		DaoUtils.createSeedData(orgdao);

		DaoUtils.printOrganizations(orgdao.getAllOrganizations(), DaoUtils.readOperation);
		
		

		Organization org = new Organization("General Electric", 1994, "455203", 56246, "Imagination At Work");
		boolean isCreated = orgdao.Create(org);

		DaoUtils.printSuccessFailure(DaoUtils.createOperation, isCreated);

		DaoUtils.printOrganizations(orgdao.getAllOrganizations(), DaoUtils.readOperation);
		DaoUtils.printOrganizationCount(orgdao.getAllOrganizations(), DaoUtils.readOperation);
		
		
	/*	Organization o1=orgdao.getOrganization(3);
		List<Organization> al = new ArrayList<Organization>();
		al.add(o1);
		DaoUtils.printOrganizations(al,DaoUtils.readOperation);*/

		/*orgdao.cleanUp();
		DaoUtils.printOrganizationCount(orgdao.getAllOrganizations(), DaoUtils.cleanupOperation);
*/
	}

}
