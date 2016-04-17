package org.luksze;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SimpleRestController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String example() {
        return "ok";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String password(@RequestBody @Valid Password password) {
        return "ok";
    }

}
