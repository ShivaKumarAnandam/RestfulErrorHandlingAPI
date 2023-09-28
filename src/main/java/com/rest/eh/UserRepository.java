package com.rest.eh;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	@Query("select u from user_info u where u.age BETWEEN ?1 AND?2")
	List<UserEntity> getUserByAge(Integer min,Integer max);

}
