package com.vti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DepartmentDTO;
import com.vti.dto.GroupDTO;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.filter.FilterDepartment;
import com.vti.filter.FilterGroup;
import com.vti.service.IDepartmentService;
import com.vti.service.IGroupService;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class GroupController {

	@Autowired
	private IGroupService service;

	@GetMapping()
	public ResponseEntity<?> getAllGroups(Paging paging, Sorting sorting, FilterGroup filter, String search) {

		// set default
		if (paging == null) {
			paging = new Paging(1, 10);
		}

		if (sorting == null || sorting.getSortField() == null || sorting.getSortType() == null) {
			sorting = new Sorting("id", "ASC");
		}

		// get data
		List<Group> entities = service.getAllGroups(paging, sorting, filter, search);

//		List<String> dtos = new ArrayList<>();
//
//		// convert entity to dto
//		for (Department entity : entities) {
//			dtos.add(entity.getName());
//		}

//		return dtos;
		return new ResponseEntity<List<Group>>(entities, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getGroupByID(@PathVariable(name = "id") short id) {
		return new ResponseEntity<Group>(service.getGroupByID(id), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createGroup(@RequestBody GroupDTO dto) {
		service.createGroup(dto.toEntity());
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateGroup(@PathVariable(name = "id") short id, @RequestBody GroupDTO dto) {
		Group group = dto.toEntity();
		group.setId(id);
		service.updateGroup(group);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteGroup(@PathVariable(name = "id") short id) {
		service.deleteGroup(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}
}
