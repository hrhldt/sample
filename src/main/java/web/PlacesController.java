package web;

import model.Place;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import service.PlaceService;
import service.UserService;

//
//
@Controller
@RequestMapping("/places")
public class PlacesController {
//    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
//    public String getGreeting(@PathVariable String name) {
//        String result="Hello "+name;
//        return result;
//    }
@Autowired
private PlaceService placeService;

    public void setPlaceService(PlaceService placeService) {
        this.placeService = placeService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody
    SessionStatus addUser(@RequestBody Place place, SessionStatus status)
    {
        placeService.persistPlace(place);
        status.setComplete();
        return status;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody Place findPlaceById(@PathVariable int id) {
        Place place = placeService.findPlaceById(id);
        return place;
    }
}
