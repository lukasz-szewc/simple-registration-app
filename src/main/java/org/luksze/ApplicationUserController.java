package org.luksze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ApplicationUserController {

    @Autowired
    private ApplicationUserRepository repository;

    @Transactional
    @RequestMapping(value = "/username/verify", method = RequestMethod.POST)
    public void username(@RequestBody @Valid UserName userName) {
        if (repository.checkUserExist(userName)) {
            throw new RuntimeException();
        }
    }

    @RequestMapping(value = "/password/verify", method = RequestMethod.POST)
    public void password(@RequestBody @Valid Password password) {}

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public void user(@RequestBody @Valid ApplicationUser user) {}

}
