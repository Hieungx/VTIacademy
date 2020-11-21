package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.Group;
import com.vti.filter.FilterGroup;
import com.vti.repository.IGroupRepository;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

@Service
public class GroupService implements IGroupService {

	@Autowired
	private IGroupRepository repository;

	public List<Group> getAllGroups(Paging paging, Sorting sorting, FilterGroup filter,String search) {
		return repository.getAllGroups(paging, sorting, filter,search);
	}

	public Group getGroupByID(short id) {
		return repository.getGroupByID(id);
	}

	public Group getGroupByName(String name) {
		return repository.getGroupByName(name);
	}

	public void createGroup(Group Group) {
		repository.createGroup(Group);
	}

	public void updateGroup(short id, String newName, short newMember, String newCreator) {
		repository.updateGroup(id, newName,newMember,newCreator);
	}

	public void updateGroup(Group Group) {
		repository.updateGroup(Group);
	}

	public void deleteGroup(short id) {
		repository.deleteGroup(id);
	}

	public boolean isGroupExistsByID(short id) {
		return repository.isGroupExistsByID(id);
	}

	public boolean isGroupExistsByName(String name) {
		return repository.isGroupExistsByName(name);
	}
}
