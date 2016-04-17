package org.luksze;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ApplicationUserController {

    @Autowired
    private ApplicationUserRepository repository;

    @Autowired
    private ApplicationUserTransactionalRepository transactionalRepository;

    @Transactional
    @RequestMapping(value = "/username/verify", method = RequestMethod.POST)
    public void username(@RequestBody @Valid UserName userName) {
        if (repository.checkUserExist(userName)) {
            throw new UserAlreadyExistInDatabaseException();
        }
    }

    @RequestMapping(value = "/password/verify", method = RequestMethod.POST)
    public void password(@RequestBody @Valid Password password) {}

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public void user(@RequestBody @Valid ApplicationUser user) {
        transactionalRepository.persistWithinTransaction(user);
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User with this name already exist in database.")
    public class UserAlreadyExistInDatabaseException extends RuntimeException { }
}
