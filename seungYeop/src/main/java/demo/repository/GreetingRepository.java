package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.Friends;

public interface GreetingRepository extends JpaRepository<Friends, Long> {
//	public Friends findOne(Long id);
	public Friends findByUserId(String userId);
}
