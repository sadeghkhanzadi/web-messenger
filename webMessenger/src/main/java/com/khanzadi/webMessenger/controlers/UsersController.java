package com.khanzadi.webMessenger.controlers;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.enums.IdentityType;
import com.khanzadi.exeption.MessengerException;
import com.khanzadi.webMessenger.modules.sql.users.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.khanzadi.constans.UriConstants.*;

@RestController
@RequestMapping("/api/v1")
public class UsersController {
    private final UsersService service;

    @Autowired
    public UsersController(UsersService service) {
        this.service = service;
    }

    //registerUser
    @PostMapping(MS_REGISTER_USER)
    public ResponseEntity<ResultsServiceDto> registerUser(@PathVariable(value = "identity") String identity ,
                                                          @RequestParam(
                                                                  value = "idenityType" ,
                                                                  defaultValue = "PHONE_NUMBER"
                                                          ) IdentityType identityType ,
                                                          @RequestBody UsersDto users) throws MessengerException {
        return ResponseEntity.status(200).body(service.registerUser(identity,identityType,users));
    }

    //editUser @FormParam @PathParam
    @PutMapping(MS_EDIT_USER)
    public ResponseEntity<ResultsServiceDto> editUser(@PathVariable(value = "identity") String identity ,
                                                      @RequestParam(
                                                              value = "idenityType" ,
                                                              defaultValue = "PHONE_NUMBER"
                                                      ) IdentityType identityType ,
                                                      @RequestBody UsersDto users) throws MessengerException {
        return ResponseEntity.status(200).body(service.editUser(identity,identityType,users));
    }

    //deleteUser @FormParam @PathParam
    @DeleteMapping(MS_DELETE_USER)
    public ResponseEntity<ResultsServiceDto> deleteUser(@PathVariable(value = "identity") String identity ,
                                                        @RequestParam(
                                                                value = "idenityType" ,
                                                                defaultValue = "PHONE_NUMBER"
                                                        ) IdentityType identityType) throws MessengerException {
        return ResponseEntity.status(200).body(service.deleteUser(identity,identityType));
    }

    //findUser @QueryParam
    @GetMapping(MS_FIND_USER)
    public ResponseEntity<ResultsServiceDto> findOneUser(@PathVariable(value = "identity") String identity ,
                                                         @RequestParam(
                                                                 value = "idenityType" ,
                                                                 defaultValue = "PHONE_NUMBER"
                                                         ) IdentityType identityType) throws MessengerException {
        return ResponseEntity.status(200).body(service.findUser(identity,identityType));
    }

    //addContact
    //editeContact
    //deleteContact
    //Find One Contact's user
    //Find All OF Contacts User
}
