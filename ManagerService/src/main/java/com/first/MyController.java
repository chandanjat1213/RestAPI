package com.first;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	@Autowired
	public ManagerService service;
	
	@PostMapping("/manager")
	public Manager addManager(@RequestBody Manager m)
	{
		return this.service.addManager(m);
	}
	
	@GetMapping("/manager/{id}")
	public Manager getManagerById(@PathVariable("id") int id)
	{
		return this.service.getManagerById(id);
	}
	
	@PostMapping("/addEmpByManager")
	public Emp addEmpByManager(@RequestBody Emp e)
	{
		return this.service.addEmp(e);
	}
	
	@DeleteMapping("/deleteEmpByManager/{id}")
	public String deleteEmpByManager(@PathVariable("id") int id)
	{
		return this.service.deleteEmp(id);
	}
	
	@PutMapping("/updateEmpByManager/{id}")
	public String updateEmpByManager(@RequestBody Emp e,@PathVariable("id") int id)
	{
		return this.service.updateEmp(e,id);
	}
	
	@GetMapping("/manager")
	public List<Manager> showAllManager()
	{
		return this.service.showAll();
	}
	
	@DeleteMapping("/manager/{id}")
	public String deleteManager(@PathVariable("id") int id)
	{
		return this.service.deleteManager(id);
	}
	
	@PutMapping("/manager/{id}")
	public String updateManager(@RequestBody Manager m,@PathVariable("id") int id)
	{
		return this.service.updateManager(m, id);
	}
}
