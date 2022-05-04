package com.groupproject.boomerang.controller;

import com.groupproject.boomerang.model.ResponseBody.TouristAttractionsResponse;
import com.groupproject.boomerang.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 1. control search place

 */

@RestController
@RequestMapping("/api")
public class PlaceController {

    @Autowired
    PlaceService placeService; // 注入servcie 真正干活的小弟

    @RequestMapping(value= "/place/touristAttractions", method = RequestMethod.GET)
    public TouristAttractionsResponse getTouristAttractions(
            @RequestParam(value ="type", defaultValue = "tourist_attraction") String type,
            @RequestParam(value ="city", defaultValue = "new york") String cityName,
            @RequestParam(value ="pagetoken", required = false ) String pageToken
            ) throws UnsupportedEncodingException {
        placeService.getTouristAttractions(type,cityName,pageToken);


        return null;// *** 先返回个null吧
    }
}
