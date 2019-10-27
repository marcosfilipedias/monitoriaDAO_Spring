package com.java.modular.monitoria.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.java.modular.monitoria.dao.StudentDao;
import com.java.modular.monitoria.models.Student;

@RestController
@RequestMapping("student")
public class StudentController {
	StudentDao student = new StudentDao();
	
	@RequestMapping(method = RequestMethod.GET, path  ="/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") int id){
		return new ResponseEntity<>(student.get(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Student s){
		student.create(s);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, path  ="/list")
	public ResponseEntity<?> getAll() throws NumberFormatException, FileNotFoundException, IOException{
		return new ResponseEntity<>(student.read(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@RequestBody Student s) throws NumberFormatException, IOException{
		student.delete(s);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody Student s) throws NumberFormatException, IOException{
		student.update(s);;
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
