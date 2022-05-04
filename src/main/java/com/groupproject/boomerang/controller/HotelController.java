package com.groupproject.boomerang.controller;

import com.groupproject.boomerang.model.ResponseBody.hotelResponse;
import com.groupproject.boomerang.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * 1. control search hotel

 */

@RestController
@RequestMapping("/api")
public class HotelController {

    @Autowired
    HotelService hotelService; // 注入servcie 真正干活的小弟


    @RequestMapping(value= "/swapHotel", method = RequestMethod.PUT)
    public hotelResponse swapHotel(
            @RequestParam(value ="type", defaultValue = "romantic") String type,
            @RequestParam(value ="price", defaultValue = "budget") String price,
            @RequestParam(value ="style", defaultValue = "family") String style,
            @RequestParam(value ="area", defaultValue = "Manhattan") String area,
            @RequestParam(value ="city", defaultValue = "new york") String city,
            @RequestParam(value ="pagetoken", required = false ) String pageToken
    ) throws UnsupportedEncodingException {
        hotelService.getHotel(type,price, style,area, city,pageToken);


        return null;// *** 先返回个null吧
    }


    @RequestMapping(value= "/getHotel", method = RequestMethod.GET)
    public hotelResponse getHotel(
            @RequestParam(value ="type", defaultValue = "romantic") String type,
            @RequestParam(value ="price", defaultValue = "budget") String price,
            @RequestParam(value ="style", defaultValue = "family") String style,
            @RequestParam(value ="area", defaultValue = "Manhattan") String area,
            @RequestParam(value ="city", defaultValue = "new york") String city,
            @RequestParam(value ="pagetoken", required = false ) String pageToken
    ) throws UnsupportedEncodingException {
        hotelService.getHotel(type,price, style,area, city,pageToken);


        return null;// *** 先返回个null吧
    }
}
