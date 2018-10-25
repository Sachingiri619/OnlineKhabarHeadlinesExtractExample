package info.news.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.news.dao.HeadlinesDAO;
import info.news.model.Headlines;

@Service
public class HeadlinesService {
	
	@Autowired
	HeadlinesDAO headlinesDao;
	
	@Transactional
	public List<Headlines> getAllHeadlines(String enterText) {
		return headlinesDao.getAllHeadlines(enterText);
	}
	
	

}
