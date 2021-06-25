package com.bcas.mtd.controllers;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.BaseController;
import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.1/hotel")
public class HotelController extends BaseController {

    private IHotelService _iHotelService;

    @Autowired
    public HotelController(IHotelService _iHotelService) {
        this._iHotelService = _iHotelService;
    }

    @GetMapping
    public ResponseEntity<Object> GetAllHotels(){

        try {

            return Ok(_iHotelService.GetAll());

        }catch (Exception ex){

            throw ex;
        }
    }

    @PostMapping
    public ResponseEntity<Object> Create( @RequestBody  HotelRequestModel hotelRequestModel){

        try {

            var result = _iHotelService.Create(hotelRequestModel);
            return Ok(result);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InterlServerError(ex);
        }

    }

    @PutMapping
    public ResponseEntity<Object> Update(@RequestBody HotelRequestModel hotelRequestModel){

        try {

            var result = _iHotelService.Update(hotelRequestModel);
            return Ok(result);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InterlServerError(ex);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id){

        try {

            _iHotelService.Delelte(id);
            return Ok( null);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InterlServerError(ex);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> Get(@PathVariable Long id){

        try {

            var result = _iHotelService.Get(id);
            return Ok( result);

        }
        catch (Exception ex){

            return InterlServerError(ex);
        }

    }




}
