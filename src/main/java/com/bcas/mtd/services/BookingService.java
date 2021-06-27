package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.Mapper;
import com.bcas.mtd.entities.*;
import com.bcas.mtd.entities.Package;
import com.bcas.mtd.helper.Extenstions;
import com.bcas.mtd.helper.ItemType;
import com.bcas.mtd.models.common.Activity;
import com.bcas.mtd.models.common.HotelModel;
import com.bcas.mtd.models.request.BookingRequestModel;
import com.bcas.mtd.models.response.BookingResponseModel;
import com.bcas.mtd.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService implements IBookingService{

    private final IBookingRepository _iBookingRepository;
    private final IPacakgeRepository _iPacakgeRepository;
    private final IHotelRepository _iHotelRepository;
    private final IActivitiesRepository _iActivitiesRepository;
    private final IBookingItemRepositories _iBookingItemRepositories;
    private final Mapper _mapper;

    //set user identity
    private final IMUserRepository _imUserRepository;

    @Autowired
    public BookingService(IActivitiesRepository iActivitiesRepository, IHotelRepository iHotelRepository, IBookingRepository iBookingRepository, IPacakgeRepository iPacakgeRepository, IBookingItemRepositories iBookingItemRepositories, Mapper mapper, IMUserRepository imUserRepository){
        _iBookingRepository = iBookingRepository;
        _iPacakgeRepository = iPacakgeRepository;
        _iHotelRepository = iHotelRepository;
        _iActivitiesRepository = iActivitiesRepository;
        _iBookingItemRepositories = iBookingItemRepositories;
        _mapper = mapper;
        _imUserRepository = imUserRepository;
    }

    public BookingResponseModel Create(BookingRequestModel bookingRequestModel) throws BadRequestException {

        Long packageId = bookingRequestModel.getPackageId();
        Package apackage = _iPacakgeRepository.findById(packageId).get();
        if(apackage == null){
            throw new BadRequestException("There are no package for requested id");
        }

        Booking booking = _mapper.map(bookingRequestModel, Booking.class);
        booking.setBookingReference(Extenstions.generateInt(0,5));
        booking.setPackage(apackage);

        List<BookingItems> bookingItems = new ArrayList<>();

        List<Long> hotelIds = bookingRequestModel.getHotelIds();
        List<Long> activitiesIds = bookingRequestModel.getActivitiesIds();

        if(hotelIds != null && hotelIds.size() > 0){

            List<Hotel> hotels = _iHotelRepository.findAllById(hotelIds);
            for (Hotel hotel : hotels) {

                BookingItems bookingItem = new BookingItems();
                bookingItem.setBooking(booking);
                bookingItem.setItemType(ItemType.Hotel);
                bookingItem.setItemId(hotel.getId());
                bookingItem.setItemPrice(hotel.getPrice());

                bookingItems.add(bookingItem);

            }

        }

        if(activitiesIds != null && activitiesIds.size() > 0){

            List<Activities> activities = _iActivitiesRepository.findAllById(activitiesIds);
            for (Activities activity : activities) {

                BookingItems bookingItem = new BookingItems();
                bookingItem.setBooking(booking);
                bookingItem.setItemType(ItemType.Activities);
                bookingItem.setItemId(activity.getId());
                bookingItem.setItemPrice(activity.getPrice());

                bookingItems.add(bookingItem);

            }

        }

        booking.setAmount(apackage.getPrice());
        booking.setPaid(bookingRequestModel.getIsPaid());
        //temp user set
        booking.setUser( _imUserRepository.findAll().get(0));
        Booking data = _iBookingRepository.save(booking);
        List<BookingItems>  bookedItems = _iBookingItemRepositories.saveAll(bookingItems);

        BookingResponseModel responseModel = _mapper.map(data, BookingResponseModel.class);
        List<BookingItems>  bookedHotelItems = _iBookingItemRepositories.getBookingItemsByItemTypeAndBooking(ItemType.Hotel, data );
        List<Long> hotelItemsIds = bookedHotelItems.stream().map(BookingItems::getItemId).collect(Collectors.toList());

        List<BookingItems> bookedActivitiesItems = _iBookingItemRepositories.getBookingItemsByItemTypeAndBooking(ItemType.Activities, data );
        List<Long> activitiesItemsIds = bookedActivitiesItems.stream().map(BookingItems::getItemId).collect(Collectors.toList());

        responseModel.setHotels( _mapper.map(_iHotelRepository.findAllById(hotelItemsIds), HotelModel.class));
        responseModel.setActivities( _mapper.map(_iActivitiesRepository.findAllById(activitiesItemsIds), Activity.class));
        responseModel.setPrice(data.getAmount());
        responseModel.setIsPaid(data.isPaid());
        return responseModel;

    }
}
