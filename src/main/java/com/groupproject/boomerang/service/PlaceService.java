package com.groupproject.boomerang.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.JSONObject;
import com.groupproject.boomerang.Constants;
import com.groupproject.boomerang.utils.BoomerangException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * to do
 *   1. HttpRequest Parser Helper
 *


 */

@Service
public class PlaceService {

    // HttpRequest Parser Helper
    private static final String GET_RECOMMENDED_TOURIST_ATTRACTIONS = "https://maps.googleapis.com/maps/api/place/textsearch/json?query=%s+in+%s&key=%s";
    private final String PAGE_TOKEN_QUERRY = "&pagetoken=";

    // public 景点Responsebody , String next_page_token
    public void getTouristAttractions (String type, String city,String pageToken) throws UnsupportedEncodingException {

        type  = encode(type);
        city = encode(city);
        String url = String.format(GET_RECOMMENDED_TOURIST_ATTRACTIONS,type, city, Constants.GOOGLE_MAP_API_KEY);

        // if (next_page_token!=null)

        // make a request

        /** {照twitch抄}**/
        CloseableHttpClient httpclient = HttpClients.createDefault();
        //ObjectMapper mapper = new ObjectMapper();

        ResponseHandler<String> responseHandler = response -> {
            int responseCode = response.getStatusLine().getStatusCode();
            if (responseCode != 200) {
                System.out.println("Response status: " + response.getStatusLine().getReasonPhrase());
                throw new BoomerangException("Failed to get result from Twitch API");
            }
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                throw new BoomerangException("Failed to get result from Twitch API");
            }
            System.out.println(EntityUtils.toString(entity));
            //JSONObject object = new JSONObject(EntityUtils.toString(entity));
//            JSONPObject obj = new JSONObject(EntityUtils.toString(entity));
//            return obj.getJSONArray("data").toString();

            return null;
        };

        try {
            HttpGet request = new HttpGet(url);

            httpclient.execute(request, responseHandler);

            // return             httpclient.execute(request, responseHandler);
        } catch (IOException e) {
            e.printStackTrace();
            throw new BoomerangException("Failed to get result from Twitch API");
        } finally {
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    private String encode(String param) throws UnsupportedEncodingException
    {
        return URLEncoder.encode(param, "UTF-8");
    }


}
