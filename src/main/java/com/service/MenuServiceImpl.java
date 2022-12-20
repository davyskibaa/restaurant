package com.service;

import com.dao.MenuDao;
import com.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuDao menuDao;

    @Override
    @Transactional
    public List<Menu> getAll() {
        return menuDao.getAll();
    }
    @Override
    @Transactional
    public Menu getById(int id) {
        return menuDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Menu menu) {
        menuDao.save(menu);
    }

    @Override
    @Transactional
    public void delete(int id) {
        menuDao.delete(id);
    }
}
