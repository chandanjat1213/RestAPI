package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService {

	@Autowired
	public Repo repo;
	
	public List<Emp> getListByMid(int mid)
	{
		return repo.getListByMid(mid);
	}
	
	public Emp addEmp(Emp e)
	{
		return repo.save(e);
	}
	
	public List<Emp> showAll()
	{
		return repo.findAll();
	}
	
	public String delete(int id)
	{
	   repo.deleteById(id);
	   return "deleted";
	}
	
	public Emp update(Emp e,int id)
	{
		Emp e1 = repo.findById(id).orElse(new Emp());
		if(e1==null)
		{
			return null;
		}
		else
		{
			e1.setId(e.getId());
			e1.setName(e.getName());
			e1.setSal(e.getSal());
			e1.setMid(e.getMid());
			return repo.save(e1);
		}
	}
}
