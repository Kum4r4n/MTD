package com.bcas.mtd.controllers;

import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1.1/hotel")
public class HotelController {

    private IHotelService _iHotelService;

    @Autowired
    public HotelController(IHotelService _iHotelService) {
        this._iHotelService = _iHotelService;
    }

    @GetMapping
    public ResponseEntity<Object> GetAllHotels(){

        return new ResponseEntity<Object>(_iHotelService.GetAll(), HttpStatus.OK);
    }


}
