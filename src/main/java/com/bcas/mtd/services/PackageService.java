package com.bcas.mtd.services;

import com.bcas.mtd.configurations.Mapper;
import com.bcas.mtd.entities.Activities;
import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.entities.Package;
import com.bcas.mtd.models.request.PackageRequestModel;
import com.bcas.mtd.models.response.HotelResponseModel;
import com.bcas.mtd.models.response.PackageResponseModel;
import com.bcas.mtd.repositories.IPacakgeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PackageService implements  IPackageService{

    private IPacakgeRepository _iPacakgeRepository;
    private Mapper _mapper;

    public PackageService(Mapper mapper , IPacakgeRepository iPacakgeRepository){
            this._iPacakgeRepository = iPacakgeRepository;
            this._mapper = mapper;
    }

    public  List<PackageResponseModel> GetAll(){
        var data = _iPacakgeRepository.findAll();
        List<PackageResponseModel> responseModel = _mapper.map(_iPacakgeRepository.findAll(), PackageResponseModel.class);
        return responseModel;
    }

    public PackageResponseModel Create(PackageRequestModel packageRequestModel) {

        Package apackage = _mapper.map(packageRequestModel, Package.class);
        if (packageRequestModel.getHotels() != null && packageRequestModel.getHotels().size() > 0) {

            List<Hotel> hotels = _mapper.map(packageRequestModel.getHotels(), Hotel.class);
            apackage.setHotels(Set.copyOf(hotels));

        }

        if(packageRequestModel.getActivities() != null && packageRequestModel.getActivities().size() > 0){

            List<Activities> activities = _mapper.map(packageRequestModel.getActivities(), Activities.class);
            apackage.setActivities(Set.copyOf(activities));

        }

        Package data = _iPacakgeRepository.save(apackage);
        PackageResponseModel responseModel = _mapper.map(data, PackageResponseModel.class);
        return responseModel;

    }
}
