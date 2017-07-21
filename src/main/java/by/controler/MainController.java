package by.controler;

import by.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Роман on 21.07.2017.
 */
@Controller
public class MainController {
    @Autowired
    @Qualifier("serviceUser")
    private UserService userService;
@RequestMapping(value = "/",method = RequestMethod.GET)
    public String main(){
    return "index";
}
}

