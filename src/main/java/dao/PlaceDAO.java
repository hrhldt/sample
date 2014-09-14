package dao;

import model.Place;

public interface PlaceDAO {

    void persistPlace(Place place);

    Place findPlaceById(int id);

    void updatePlace(Place place);

    void deletePlace(Place place);
}
