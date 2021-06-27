package com.bcas.mtd.services;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.models.request.PackageRequestModel;
import com.bcas.mtd.models.response.PackageResponseModel;

import java.util.List;

public interface IPackageService {
    PackageResponseModel Create(PackageRequestModel packageRequestModel);
    List<PackageResponseModel> GetAll();
    PackageResponseModel Update(PackageRequestModel packageRequestModel) throws Exception;
    void Delelte(Long id) throws BadRequestException;
    PackageResponseModel Get(Long id);
}
