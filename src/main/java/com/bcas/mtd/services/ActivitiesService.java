package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.Mapper;
import com.bcas.mtd.entities.Activities;
import com.bcas.mtd.entities.Hotel;
import com.bcas.mtd.models.request.ActivityRequestModel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.models.response.ActivityResponseModel;
import com.bcas.mtd.models.response.HotelResponseModel;
import com.bcas.mtd.repositories.IActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitiesService implements IActivitiesService {

    private IActivitiesRepository _iActivitiesRepository;
    private Mapper _mapper;

    @Autowired
    public ActivitiesService(IActivitiesRepository iActivitiesRepository,Mapper mapper){
        _iActivitiesRepository = iActivitiesRepository;
        this._mapper = mapper;
    }

    public List<ActivityResponseModel> GetAll(){

        List<ActivityResponseModel> responseModel = _mapper.map(_iActivitiesRepository.findAll(), ActivityResponseModel.class);
        return responseModel;
    }

    public ActivityResponseModel Get(Long id){

        ActivityResponseModel responseModel = _mapper.map(_iActivitiesRepository.findById(id).get(), ActivityResponseModel.class);
        return responseModel;
    }

    public void Delelte(Long id) throws BadRequestException {
        boolean isExist = _iActivitiesRepository.existsById(id);
        if (!isExist){
            throw new BadRequestException("There are no hotel for requested id");
        }
        _iActivitiesRepository.deleteById(id);
    }

    public ActivityResponseModel Create(ActivityRequestModel activityRequestModel) throws Exception{

        Activities activities = _mapper.map(activityRequestModel, Activities.class);
        Activities data = _iActivitiesRepository.save(activities);
        ActivityResponseModel responseModel = _mapper.map(data, ActivityResponseModel.class);
        return responseModel;

    }

    public ActivityResponseModel Update(ActivityRequestModel activityRequestModel) throws Exception {

        if(activityRequestModel.getId() == null){
            throw new BadRequestException("Id is must");
        }

        boolean isExist = _iActivitiesRepository.existsById(activityRequestModel.getId());
        if (!isExist){
            throw new BadRequestException("There are no activity for requested id");
        }

        Activities activities = _mapper.map(activityRequestModel, Activities.class);
        Activities data = _iActivitiesRepository.save(activities);
        ActivityResponseModel responseModel = _mapper.map(data, ActivityResponseModel.class);
        return responseModel;

    }
}
