package com.service;

import com.dao.BookingDao;
import com.entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingDao bookingDao;

    @Override
    @Transactional
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }
    @Override
    @Transactional
    public Booking getById(int id) {
        return bookingDao.getById(id);
    }

    @Override
    @Transactional
    public void save(Booking booking) {
        bookingDao.save(booking);
    }

    @Override
    @Transactional
    public void delete(int id) {
        bookingDao.delete(id);
    }
}
