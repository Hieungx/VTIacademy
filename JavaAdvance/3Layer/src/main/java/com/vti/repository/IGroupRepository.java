package com.vti.repository;

import java.util.List;

import com.vti.entity.Group;
import com.vti.filter.FilterGroup;
import com.vti.utils.Paging;
import com.vti.utils.Sorting;

public interface IGroupRepository {

	public List<Group> getAllGroups(Paging paging, Sorting sorting, FilterGroup filter,String search);

	public Group getGroupByID(short id);

	public Group getGroupByName(String name);

	public void createGroup(Group group);

	public void updateGroup(short id, String newName, short newMember, String newCreator);

	public void updateGroup(Group group);

	public void deleteGroup(short id);

	public boolean isGroupExistsByID(short id);

	public boolean isGroupExistsByName(String name);

}
