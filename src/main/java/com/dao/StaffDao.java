package com.dao;

import com.entity.Staff;

import java.util.List;

public interface StaffDao {
    List<Staff> getAll();
    Staff getById(int id);
    void save(Staff staff);
    void delete(int id);
}
