package net.codejava.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import net.codejava.contact.model.Contact;

class ContactDAOTest {
	private DriverManagerDataSource dataSource;
	private ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("tatasky1");
		
		dao= new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		
		
		Contact contact= new Contact("Bill gates", "bill@microsoft.com", "redmon, CA", "12313234234");
		int result= dao.save(contact);
		
		assertTrue(result> 0);
				
	}

	@Test
	void testUpdate() {
		Contact contact= new Contact(2, "Bill gates", "bill.gates@microsoft.com", "redmon, CA", "12313234234");
		int result= dao.update(contact);
		
		assertTrue(result> 0);
	}

	@Test
	void testGet() {
		
		Integer id=1;
		
		Contact contact= dao.get(id);
		
		if(contact!= null) {
			System.out.println(contact);
		}
		
		assertNotNull(contact);
		
	}

	@Test
	void testDelete() {
		
		Integer id=2;
		int result= dao.delete(id);
		
		assertTrue(result>0);
	}

	@Test
	void testList() {
		List<Contact> listContacts= dao.list();
		
		for(Contact aContact: listContacts) {
			System.out.println(aContact);
		}
		
		assertTrue(!listContacts.isEmpty());
	}

}
