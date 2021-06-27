package com.bcas.mtd.controllers;

import com.bcas.mtd.configurations.BadRequestException;
import com.bcas.mtd.configurations.BaseController;
import com.bcas.mtd.models.request.ActivityRequestModel;
import com.bcas.mtd.models.request.HotelRequestModel;
import com.bcas.mtd.services.IActivitiesService;
import com.bcas.mtd.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.1/activities")
public class ActivitiesController extends BaseController {
    private IActivitiesService _iActivitiesService;

    @Autowired
    public ActivitiesController(IActivitiesService iActivitiesService) {
        this._iActivitiesService = iActivitiesService;
    }

    @GetMapping
    public ResponseEntity<Object> GetAll(){

        try {

            return Ok(_iActivitiesService.GetAll());

        }catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @PostMapping
    public ResponseEntity<Object> Create( @RequestBody ActivityRequestModel activityRequestModel){

        try {

            var result = _iActivitiesService.Create(activityRequestModel);
            return Ok(result);

        }
        catch (BadRequestException ex){
            return BadRequest(ex.getMessage());
        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }

    @PutMapping
    public ResponseEntity<Object> Update(@RequestBody ActivityRequestModel activityRequestModel){

        try {

            var result = _iActivitiesService.Update(activityRequestModel);
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

            _iActivitiesService.Delelte(id);
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

            var result = _iActivitiesService.Get(id);
            return Ok( result);

        }
        catch (Exception ex){

            return InternalServerError(ex);
        }

    }
}
