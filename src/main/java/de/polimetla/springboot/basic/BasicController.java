package de.polimetla.springboot.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @RequestMapping("")
    public String welcome() {
        return "This is a home page. Append /employees to the path to access the API";
    }
}
