package com.bcas.mtd.services;

import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.repositories.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService implements IHotelService {

    private IHotelRepository _iHotelRepository;

    @Autowired
    public HotelService(IHotelRepository _iHotelRepository) {
        this._iHotelRepository = _iHotelRepository;
    }

    public List<Hotel> GetAll(){
        return _iHotelRepository.findAll();
    }
}
