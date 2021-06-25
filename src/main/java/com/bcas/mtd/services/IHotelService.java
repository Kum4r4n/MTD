package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.models.response.HotelResponseModel;

import java.util.List;

public interface IHotelService {
    List<HotelResponseModel> GetAll();
    HotelResponseModel Update(HotelRequestModel hotelRequestModel) throws BadRequestException, Exception;
    HotelResponseModel Create(HotelRequestModel hotelRequestModel) throws BadRequestException, Exception;
    void Delelte(Long id) throws BadRequestException;
    HotelResponseModel Get(Long id);

}
