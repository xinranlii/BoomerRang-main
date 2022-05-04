package com.groupproject.boomerang.model.ResponseBody;

import com.groupproject.boomerang.model.entity.TouristAttractions;

import java.util.List;

public class TouristAttractionsResponseBody {

    public String nextPageToken;
    public List<TouristAttractions> result; // all fetched tourist attractions
}
