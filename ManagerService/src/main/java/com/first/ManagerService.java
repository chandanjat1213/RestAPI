package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ManagerService {

	@Autowired
	public Repo repo;
	
	@Autowired
    public ManagerServiceApplication ap; 
	
	public Manager addManager(Manager m)
	{
		return repo.save(m);
	}
	
	public Manager getManagerById(int id)
	{
		Manager m = repo.findById(id).orElse(new Manager());
		if(m==null)
		{
			return null;
		}
		else {
		RestTemplate template=ap.getRestTemplate();
		List l=template.getForObject("http://emp-service/emps/"+id, List.class);
		m.setEmps(l);
		return m;
		}
	}
	
	public Emp addEmp(Emp e)
	{
		RestTemplate template = ap.getRestTemplate();
		return template.postForObject("http://emp-service/emps", e, Emp.class);
	}
	
	public String deleteEmp(int id)
	{
		RestTemplate template = ap.getRestTemplate();
		template.delete("http://emp-service/emps/"+id);
		return "deleted";
	}
	
	public String updateEmp(Emp e,int id)
	{
		RestTemplate template = ap.getRestTemplate();
		template.put("http://emp-service/emps/"+id, e);
		return "updated";
	}
	
	public List<Manager> showAll()
	{
		return repo.findAll();
	}
	
	public String deleteManager(int id)
	{
		Manager m = repo.findById(id).orElse(new Manager());
		if(m==null)
		{
			return "not avalible manager";
		}
		else
		{
			repo.delete(m);
			return "deleted";
		}
	}
	
	public String updateManager(Manager m,int id)
	{
		Manager m1 = repo.findById(id).orElse(null);
		if(m1==null)
		{
			return "not avalible instance";
		}
		else
		{
			m1.setId(m.getId());
			m1.setName(m.getName());
			repo.save(m1);
			return "updated";
		}
	}
}

