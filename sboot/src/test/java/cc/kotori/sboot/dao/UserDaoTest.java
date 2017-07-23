package cc.kotori.sboot.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cc.kotori.sboot.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserDaoTest {

	@Autowired
	private UserDao userDao;
	@Test
	public void testFindByUsernameLike()
	{
		List<User> findByUsernameLike = userDao.findByUsernameLike("%a%");
		System.out.println(findByUsernameLike.toString());
	}
	@Test
	public void testFindByAddressOrPassword()
	{
		List<User> findByAddressOrPassword = userDao.findByAddressOrPassword("aaa", "bbb");
		System.out.println(findByAddressOrPassword.toString());
	}
	
	@Test
	public void testCountByUsernameLike()
	{
		Long countByUsernameLike = userDao.countByUsernameLike("%a%");
		System.out.println(countByUsernameLike);
	}
	@Test
	public void testFindByUsernameLikeOrderByRegisteTimeDesc()
	{
		List<User> findByUsernameLike = userDao.findByUsernameLikeOrderByRegisteTimeDesc("%a%");
		System.out.println(findByUsernameLike.toString());
	}
	@Test
	public void testFindByRegisteTimeBetweenOrderByIdAsc()
	{
		Calendar c = Calendar.getInstance();
		c.set(2016, 1, 1);
		Date a = c.getTime();
		c.set(2018, 2, 2);
		Date b = c.getTime();
		List<User> findByUsernameLike = userDao.findByRegisteTimeBetweenOrderByIdAsc(
				a,
				b);
		System.out.println(findByUsernameLike.size());
	}
	@Test
	public void testFindByRegisteTimeAfter()
	{
		List<User> findByUsernameLike = userDao.findByRegisteTimeAfter(new Date());
		System.out.println(findByUsernameLike.size());
	}
	@Test
	public void testFindByIdLessThanEqual()
	{
		List<User> findByUsernameLike = userDao.findByIdLessThanEqual(3);
		System.out.println(findByUsernameLike.size());
	}
	@Test
	public void testFindByUsername()
	{
		Page<User> findByUsernameLike = userDao.findByUsernameLike("%a%", new PageRequest(0, 1));
		System.out.println(findByUsernameLike.getContent().toString());
	}
	
	@Test
	public void testfindFirst2ByUsername()
	{
		Sort sort = new Sort(Direction.DESC, "id");
		List<User> findFirst2By = userDao.findFirst2By(sort);
		System.out.println(findFirst2By.toString());
	}
}
