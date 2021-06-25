package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.Mapper;
import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.models.response.HotelResponseModel;
import com.bcas.mtd.repositories.IHotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService implements IHotelService {

    private IHotelRepository _iHotelRepository;
    private Mapper _mapper;

    @Autowired
    public HotelService(Mapper mapper , IHotelRepository iHotelRepository) {
        this._iHotelRepository = iHotelRepository;
        this._mapper = mapper;
    }

    public List<HotelResponseModel> GetAll(){

        List<HotelResponseModel> responseModel = _mapper.map(_iHotelRepository.findAll(), HotelResponseModel.class);
        return responseModel;
    }

    public HotelResponseModel Get(Long id){

        HotelResponseModel responseModel = _mapper.map(_iHotelRepository.findById(id), HotelResponseModel.class);
        return responseModel;
    }

    public void Delelte(Long id) throws BadRequestException {
        boolean isExist = _iHotelRepository.existsById(id);
        if (!isExist){
            throw new BadRequestException("There are no hotel for requested id");
        }
         _iHotelRepository.deleteById(id);
    }

    public HotelResponseModel Create(HotelRequestModel hotelRequestModel) throws Exception{

        Hotel hotel = _mapper.map(hotelRequestModel, Hotel.class);
        Hotel data = _iHotelRepository.save(hotel);
        HotelResponseModel responseModel = _mapper.map(data, HotelResponseModel.class);
        return responseModel;

    }

    public HotelResponseModel Update(HotelRequestModel hotelRequestModel) throws Exception {

        if(hotelRequestModel.getId() == null){
            throw new BadRequestException("Id is must");
        }

        boolean isExist = _iHotelRepository.existsById(hotelRequestModel.getId());
        if (!isExist){
            throw new BadRequestException("There are no hotel for requested id");
        }

        Hotel hotel = _mapper.map(hotelRequestModel, Hotel.class);
        Hotel data = _iHotelRepository.save(hotel);
        HotelResponseModel responseModel = _mapper.map(data, HotelResponseModel.class);
        return responseModel;

    }


}
