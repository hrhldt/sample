package service;

import dao.PlaceDAO;
import dao.UserDAO;
import model.Place;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceDAO placeDAO;

    @Override
    @Transactional
    public void persistPlace(Place place) {
        placeDAO.persistPlace(place);
    }

    @Override
    @Transactional
    public void updatePlace(Place place) {
        placeDAO.updatePlace(place);

    }
    @Override
    @Transactional
    public Place findPlaceById(int id) {
        return placeDAO.findPlaceById(id);
    }

    @Override
    @Transactional
    public void deletePlace(Place place) {
        placeDAO.deletePlace(place);

    }

}