package com.first;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@Autowired
	public EmpService service;
	
	   @PostMapping("/emps")
	   public Emp addEmp(@RequestBody Emp e)
	   {
		   return service.addEmp(e);
	   }
	   
	   @GetMapping("/emps/{mid}")
	   public List<Emp> showById(@PathVariable("mid") int mid)
	   {
		  return service.getListByMid(mid);
	   }
	   
	   @GetMapping("/emps")
	   public List<Emp> showAllEmp()
	   {
		   return service.showAll();
	   }
	   
	   @DeleteMapping("/emps/{id}")
	   public String delete(@PathVariable("id") int id)
	   {
		   return this.service.delete(id);
		   
	   }
	   
	   @PutMapping("/emps/{id}")
	   public Emp update(@RequestBody Emp e,@PathVariable("id") int id)
	   {
		   return this.service.update(e, id);
	   }
}
