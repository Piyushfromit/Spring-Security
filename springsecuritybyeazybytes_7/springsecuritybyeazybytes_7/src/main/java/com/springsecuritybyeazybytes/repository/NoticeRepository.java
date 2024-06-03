package com.springsecuritybyeazybytes.repository;

import java.util.List;

import com.springsecuritybyeazybytes.model.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;



@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
	
	@Query(value = "from Notice n where CURDATE() BETWEEN noticBegDt AND noticEndDt")
	List<Notice> findAllActiveNotices();

}
