package cc.kotori.sboot.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import cc.kotori.sboot.domain.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	//注意属性名
	List<User> findByUsernameLike(String username);
	
	List<User> findByAddressOrPassword(String address, String password);
	
	Long countByUsernameLike(String username);
	
	List<User> findByUsernameLikeOrderByRegisteTimeDesc(String username);
	
	List<User> findByRegisteTimeBetweenOrderByIdAsc(Date a, Date b);
	
	List<User> findByRegisteTimeAfter(Date date);
	
	List<User> findByIdLessThanEqual(Integer id);
	
	Page<User> findByUsernameLike(String username, Pageable pageable);
	
	//取前多少个
	User findTopByOrderByRegisteTimeDesc();
	List<User> findFirst2By(Sort sort);
	
	/*这种写法错List<User> findLast2By(Sort sort);*/
}
