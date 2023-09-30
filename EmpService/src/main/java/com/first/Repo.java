package com.first;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Repo extends JpaRepository<Emp, Integer>{

	@Query("from Emp where mid=?1")
	public List<Emp> getListByMid(int mid);
}
