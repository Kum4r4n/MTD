package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.models.request.BookingRequestModel;
import com.bcas.mtd.models.response.BookingResponseModel;

public interface IBookingService {

    BookingResponseModel Create(BookingRequestModel bookingRequestModel) throws BadRequestException;
}
