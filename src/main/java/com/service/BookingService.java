package com.service;

import com.entity.Booking;
import java.util.List;

public interface BookingService {
    List<Booking> getAll();
    Booking getById(int id);
    void save(Booking booking);
    void delete(int id);
}
