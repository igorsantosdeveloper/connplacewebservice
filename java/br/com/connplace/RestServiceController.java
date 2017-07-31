package br.com.connplace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class RestServiceController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value="/user",
            method = RequestMethod.POST,
            consumes= MediaType.APPLICATION_JSON_VALUE,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody boolean newUser(@RequestBody User user){

        return this.repository.newUser(user);
    }

    @RequestMapping(value="/user/authenticateUser",
            method = RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody User selecionar(@RequestParam("nameUser") String nameUser,
                                         @RequestParam("passwordUser") String passwordUser){

        return this.repository.authenticateUser(nameUser,passwordUser);
    }
}
