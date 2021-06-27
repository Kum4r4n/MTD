package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.models.request.ActivityRequestModel;
import com.bcas.mtd.models.response.ActivityResponseModel;

import java.util.List;

public interface IActivitiesService {

    ActivityResponseModel Update(ActivityRequestModel activityRequestModel) throws BadRequestException, Exception;
    ActivityResponseModel Create(ActivityRequestModel activityRequestModel) throws BadRequestException, Exception;
    void Delelte(Long id) throws BadRequestException;
    ActivityResponseModel Get(Long id);
    List<ActivityResponseModel> GetAll();
}
