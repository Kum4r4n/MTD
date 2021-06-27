package com.bcas.mtd.controllers;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.BaseController;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.models.request.PackageRequestModel;
import com.bcas.mtd.services.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/package")
public class PackageController extends BaseController {

    private IPackageService _iPackageService;

    @Autowired
    public PackageController(IPackageService iPackageService){
            _iPackageService = iPackageService;
    }

    @GetMapping
    public ResponseEntity<Object> GetAll(){

        try {

            return Ok(_iPackageService.GetAll());

        }catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @PostMapping
    public ResponseEntity<Object> Create(@RequestBody  PackageRequestModel packageRequestModel){

        try {

            var result = _iPackageService.Create(packageRequestModel);
            return Ok(result);
        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @PutMapping
    public ResponseEntity<Object> Update(@RequestBody PackageRequestModel packageRequestModel){

        try {

            var result = _iPackageService.Update(packageRequestModel);
            return Ok(result);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> Delete(@PathVariable Long id){

        try {

            _iPackageService.Delelte(id);
            return Ok( null);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @GetMapping("{id}")
    public ResponseEntity<Object> Get(@PathVariable Long id){

        try {

            var result = _iPackageService.Get(id);
            return Ok( result);

        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }
}
