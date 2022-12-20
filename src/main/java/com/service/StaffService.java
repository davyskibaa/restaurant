package com.service;

import com.entity.Staff;

import java.util.List;

public interface StaffService {
    List<Staff> getAll();
    Staff getById(int id);
    void save(Staff staff);
    void delete(int id);
}
