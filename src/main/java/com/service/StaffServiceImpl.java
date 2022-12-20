package com.service;

import com.dao.StaffDao;
import com.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffDao staffDao;

    @Override
    @Transactional
    public List<Staff> getAll() {
        return staffDao.getAll();
    }
    @Override
    @Transactional
    public Staff getById(int id) {
        return staffDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Staff staff) {
        staffDao.save(staff);
    }

    @Override
    @Transactional
    public void delete(int id) {
        staffDao.delete(id);
    }
}
