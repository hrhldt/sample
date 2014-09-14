package service;

import model.Place;

public interface PlaceService {

    void persistPlace(Place place);

    Place findPlaceById(int id);

    void updatePlace(Place place);

    void deletePlace(Place place);
}
