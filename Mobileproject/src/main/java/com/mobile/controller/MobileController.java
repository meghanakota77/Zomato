package com.mobile.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.entities.Mobile;
import com.mobile.service.MobileService;

@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Autowired
    private MobileService mobileService;

    @PostMapping("/")
    public Mobile addMobile(@RequestBody Mobile mobile) {
        return mobileService.add(mobile);
    }

    @GetMapping("/")
    public List<Mobile> getAllMobiles() {
        return mobileService.getAllMobiles();
    }

    @GetMapping("/{id}")
    public Mobile getMobileById(@PathVariable Integer id) {
        return mobileService.getMobileById(id);
    }

    @GetMapping("/employee/{employeeId}")
    public List<Mobile> getMobilesByEmployeeId(@PathVariable Integer employeeId) {
        return mobileService.getMobilesByEmployeeId(employeeId);
    }
}

