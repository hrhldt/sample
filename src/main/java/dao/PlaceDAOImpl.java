package dao;

import model.Place;
import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import javax.persistence.EntityManager;

@Repository //("placeDAO")
public class PlaceDAOImpl implements PlaceDAO {

    @Autowired
    private EntityManager em;

    @Override
    public void persistPlace(Place place) {
        em.persist(place);
    }

    @Override
    public Place findPlaceById(int id) {
        return (Place)em.find(Place.class, id);
    }

    @Override
    public void updatePlace(Place place) {
        em.merge(place);
    }

    @Override
    public void deletePlace(Place place) {
        em.remove(place);
    }
}
