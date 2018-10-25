package info.news.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.news.model.Headlines;

@Repository
public class HeadlinesDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Headlines> getAllHeadlines(String enterText) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Headlines> HeadlinesList = session.createQuery("from Headlines where news like '"+enterText+"%'").list();
		return HeadlinesList;
	}
	
	

}
