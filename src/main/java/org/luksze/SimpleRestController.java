package org.luksze;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleRestController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String example() {
        return "ok";
    }
}
