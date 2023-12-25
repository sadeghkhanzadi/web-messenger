package com.khanzadi.webMessenger.controlers;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.dto.contacts.UserContactsDto;
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

    //--------------------------------------------------------------------------------
    //--------------------------------------USERS-------------------------------------
    //--------------------------------------------------------------------------------
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
    //--------------------------------------------------------------------------------
    //-------------------------------------contact------------------------------------
    //--------------------------------------------------------------------------------
    //addContact
    @PostMapping(MS_ADD_CONTACT)
    public ResponseEntity<ResultsServiceDto> addContactToUserContactList(@PathVariable(value = "identity") String identity ,
                                                             @RequestParam(
                                                                     value = "idenityType" ,
                                                                     defaultValue = "PHONE_NUMBER"
                                                             ) IdentityType identityType ,
                                                             @RequestBody UserContactsDto contacts) throws MessengerException{
        return ResponseEntity.status(200).body(service.addContactToUserContactList(identity, identityType, contacts));
    }
    //editeContact
    @PutMapping(MS_EDIT_CONTACT)
    public ResponseEntity<ResultsServiceDto> editContactAtUserContactList(@PathVariable(value = "identity") String identity ,
                                                             @RequestParam(
                                                                     value = "idenityType" ,
                                                                     defaultValue = "PHONE_NUMBER"
                                                             ) IdentityType identityType ,
                                                             @RequestBody UserContactsDto contacts) throws MessengerException{
        return ResponseEntity.status(200).body(service.editContactAtUserContactList());
    }
    //deleteContact
    @DeleteMapping(MS_DELETE_CONTACT)
    public ResponseEntity<ResultsServiceDto> deleteContactAtUserContactList(@PathVariable(value = "identity") String identity ,
                                                             @RequestParam(
                                                                     value = "idenityType" ,
                                                                     defaultValue = "PHONE_NUMBER"
                                                             ) IdentityType identityType ,
                                                             @PathVariable(value = "identityC") String identityC ,
                                                             @RequestParam(
                                                                     value = "idenityTypeC" ,
                                                                     defaultValue = "PHONE_NUMBER"
                                                             ) IdentityType identityTypeC ){
        return ResponseEntity.status(200).body(service.deleteContactAtUserContactList());
    }
    //Find One Contact's user
    @GetMapping(MS_FIND_CONTACT)
    public ResponseEntity<ResultsServiceDto> findContactAtUserContactList(){
        return ResponseEntity.status(200).body(service.findContactAtUserContactList());
    }
    //Find All OF Contacts User
    @GetMapping(MS_FIND_ALL_CONTACTS)
    public ResponseEntity<ResultsServiceDto> findAllContactAtContactList(){
        return ResponseEntity.status(200).body(service.findAllContactAtContactList());
    }
}
