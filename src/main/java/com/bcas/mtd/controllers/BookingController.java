package com.bcas.mtd.controllers;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.BaseController;
import com.bcas.mtd.models.request.BookingRequestModel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.services.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.1/booking")
public class BookingController extends BaseController {

    private final IBookingService _iBookingService;

    @Autowired
    public BookingController(IBookingService iBookingService) {
        _iBookingService = iBookingService;
    }

    @PostMapping
    public ResponseEntity<Object> Create(@RequestBody BookingRequestModel bookingRequestModel){

        try {

            var result = _iBookingService.Create(bookingRequestModel);
            return Ok(result);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }
}
