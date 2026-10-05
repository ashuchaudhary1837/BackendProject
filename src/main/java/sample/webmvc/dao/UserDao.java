package sample.webmvc.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import sample.webmvc.entity.User;

@Repository
public class UserDao {

	@Autowired
	 HibernateTemplate hibernateTemplate;
	

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public void saveUser(User user) {
		hibernateTemplate.save(user);
		System.out.println("UserDao.saveUser()");
	}

	public User getUserById(int id) {
		System.out.println("UserDao.getUserById()");
		
		return hibernateTemplate.get(User.class, id);
	}
	
	
	@Transactional
	public void updateUser(User user) {

	    User existingUser = hibernateTemplate.get(User.class, user.getId());

	    if (existingUser != null) {

	   
	        existingUser.setName(user.getName());
	        existingUser.setGender(user.getGender());
	        existingUser.setAddress(user.getAddress());

	        System.out.println("User updated successfully");

	    } else {
	        System.out.println("User not found with id: " + user.getId());
	    }
	}
	
	@Transactional
	public void deleteuser(int id) {

	    User user = hibernateTemplate.get(User.class, id);

	    if (user != null) {
	        hibernateTemplate.delete(user);
	        System.out.println("UserDao.deleteUser()");
	    } else {
	        System.out.println("User not found with id: " + id);
	    }
	}
	
}