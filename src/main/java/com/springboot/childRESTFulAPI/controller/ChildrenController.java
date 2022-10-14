package com.springboot.childRESTFulAPI.controller;


import com.springboot.childRESTFulAPI.payload.ChildDTO;
import com.springboot.childRESTFulAPI.payload.ChildResponse;
import com.springboot.childRESTFulAPI.service.ChildService;
import com.springboot.childRESTFulAPI.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class ChildrenController {

    private ChildService childService ;


    public ChildrenController(ChildService childService ) {
        this.childService = childService;
    }


    // create child rest api
    @PostMapping("/addChild")
    public ResponseEntity<ChildDTO> createChild(@Valid @RequestBody ChildDTO childDTO ){
        return new ResponseEntity<>(childService.createChild(childDTO), HttpStatus.CREATED);
    }

    // get all children rest api
    @GetMapping("/children")
    public ChildResponse getAllChildren(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return childService.getAllChildren(pageNo, pageSize, sortBy, sortDir);
    }

    // get child by id
    @GetMapping(value = "/child/{name}")
    public ResponseEntity<ChildDTO> getChildById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(childService.getChildById(id));
    }

    // update child by id rest api
    @PutMapping("/editChild/{id}")
    public ResponseEntity<ChildDTO> updateChild(@Valid @RequestBody ChildDTO childDTO, @PathVariable(name = "id") long id){

        ChildDTO childResponse = childService.updateChild(childDTO, id);

        return new ResponseEntity<>(childResponse, HttpStatus.OK);
    }


    // delete child rest api
    @DeleteMapping("/api/child/{id}")
    public ResponseEntity<String> deleteChild(@PathVariable(name = "id") long id){

       childService.deleteChildById(id);

        return new ResponseEntity<>("child entity deleted successfully.", HttpStatus.OK);
    }
}
