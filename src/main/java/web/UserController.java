package web;
//
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public @ResponseBody SessionStatus addUser(@RequestBody User user, SessionStatus status)
    {
        userService.persistUser(user);
        //TODO Fix some better response handling
        status.setComplete();
        return status;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public @ResponseBody User findUserById(@PathVariable int id) {
        User user = userService.findUserById(id);
        return user;
    }
}
