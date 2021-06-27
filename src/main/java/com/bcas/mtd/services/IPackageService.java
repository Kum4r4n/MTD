package com.bcas.mtd.services;

import com.bcas.mtd.models.request.PackageRequestModel;
import com.bcas.mtd.models.response.PackageResponseModel;

import java.util.List;

public interface IPackageService {
    PackageResponseModel Create(PackageRequestModel packageRequestModel);
    List<PackageResponseModel> GetAll();
}
