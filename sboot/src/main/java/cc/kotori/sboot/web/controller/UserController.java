package cc.kotori.sboot.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cc.kotori.sboot.dao.UserDao;
import cc.kotori.sboot.domain.User;
import cc.kotori.sboot.utils.KotoriProperties;

@RestController
@RequestMapping("/user")
public class UserController 
{
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Resource
	KotoriProperties p;
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping("/info")
	public String userInfo(@RequestParam("id") Integer id)
	{
		ModelAndView model = new ModelAndView("/userInfo.html");
		logger.info("id : " + id);
		return "success: id = " + id + "; p= " + p.getAuthor();
	}
	
	@RequestMapping("/one")
	public User getUser()
	{
		User q = new User();
		q.setUsername("a");
		q.setPassword("b");
		User findOne = userDao.findOne(Example.of(q));
		return findOne;
	}
	
	@RequestMapping("/all")
	public List<User> getAll()
	{
		//这里是类里的属性名
		Sort sort = new Sort(Direction.ASC, "registeTime");
		Pageable p = new PageRequest(0,2,sort);
		Page<User> findAll = userDao.findAll(p);
		return findAll.getContent();
	}
	
}
