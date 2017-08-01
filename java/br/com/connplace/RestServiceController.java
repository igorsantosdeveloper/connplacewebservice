package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class RestServiceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LocationRepository locationRepository;

    //User
    @RequestMapping(value="/user",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean newUser(@RequestBody User user){

        return this.userRepository.newUser(user);
    }

    @RequestMapping(value="/user/authenticateUser",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User authenticateUser(@RequestParam("nameUser") String nameUser,
                                         @RequestParam("passwordUser") String passwordUser){

        return this.userRepository.authenticateUser(nameUser,passwordUser);
    }

    @RequestMapping(value="/user/checkNameUser",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User checkNameUser(@RequestParam("nameUser") String nameUser){

        return this.userRepository.checkNameUser(nameUser);
    }
    //End User

    //Location
    @RequestMapping(value="/location",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean newLocation(@RequestBody Location location){

        return this.locationRepository.newLocation(location);
    }

    @RequestMapping(value="/location/overlapLocation",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean overlapLocation(@RequestBody Location location){

        return this.locationRepository.overlapLocation(location);
    }

    @RequestMapping(value="/location/bringsLocations",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Location> bringsLocations(){

        return this.locationRepository.bringsLocations();

    }

    @RequestMapping(value="/location/forwardListOfUsers",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> forwardListOfUsers(@RequestBody DynamicQuery dynamicQuery){

        return this.locationRepository.forwardListOfUsers(dynamicQuery.getForwardListOfUsers());
    }
    //End Location
}
//SELECT user_name FROM ccp_user WHERE user_id = 1 OR user_id = 2