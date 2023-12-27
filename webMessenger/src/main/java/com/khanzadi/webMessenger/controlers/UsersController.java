package com.khanzadi.webMessenger.controlers;

import com.khanzadi.dto.ResultsServiceDto;
import com.khanzadi.dto.Users.UsersAddDto;
import com.khanzadi.dto.Users.UsersDto;
import com.khanzadi.dto.Users.UsersEditDto;
import com.khanzadi.dto.Users.UsersEditPasswordDto;
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
                                                          @RequestBody UsersAddDto users) throws MessengerException {
        return ResponseEntity.status(200).body(service.registerUser(identity,identityType,UsersAddDto.convertToUsersDto(users)));
    }

    //editUser @FormParam @PathParam
    @PutMapping(MS_EDIT_USER)
    public ResponseEntity<ResultsServiceDto> editUser(@PathVariable(value = "identity") String identity ,
                                                      @RequestParam(
                                                              value = "idenityType" ,
                                                              defaultValue = "PHONE_NUMBER"
                                                      ) IdentityType identityType ,
                                                      @RequestBody UsersEditDto users) throws MessengerException {
        return ResponseEntity.status(200).body(service.editUser(identity,identityType,UsersEditDto.convertToUsersDto(users)));
    }

    //Edit Password
    @PutMapping(MS_EDIT_PASSWORD)
    public ResponseEntity<ResultsServiceDto> editPassword(@PathVariable(value = "identity") String identity ,
                                                      @RequestParam(
                                                              value = "idenityType" ,
                                                              defaultValue = "PHONE_NUMBER"
                                                      ) IdentityType identityType ,
                                                      @RequestBody UsersEditPasswordDto users) throws MessengerException {
        return ResponseEntity.status(200).body(service.editPassword(identity,identityType,UsersEditPasswordDto.convertToUsersDto(users)));
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
    //TODO editeContact

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
                                                             ) IdentityType identityTypeC ) throws MessengerException {
        return ResponseEntity.status(200).body(service.deleteContactAtUserContactList(identity, identityType, identityC , identityTypeC));
    }
    //Find One Contact's user
    @GetMapping(MS_FIND_CONTACT)
    public ResponseEntity<ResultsServiceDto> findContactAtUserContactList(@PathVariable(value = "identity") String identity ,
                                                                          @RequestParam(
                                                                                  value = "idenityType" ,
                                                                                  defaultValue = "PHONE_NUMBER"
                                                                          ) IdentityType identityType ,
                                                                          @PathVariable(value = "identityC") String identityC ,
                                                                          @RequestParam(
                                                                                  value = "idenityTypeC" ,
                                                                                  defaultValue = "PHONE_NUMBER"
                                                                          ) IdentityType identityTypeC ) throws MessengerException {
        return ResponseEntity.status(200).body(service.findContactAtUserContactList(identity, identityType, identityC , identityTypeC));
    }
    //Find All OF Contacts User
    @GetMapping(MS_FIND_ALL_CONTACTS)
    public ResponseEntity<ResultsServiceDto> findAllContactAtContactList(@PathVariable(value = "identity") String identity ,
                                                                         @RequestParam(
                                                                                 value = "idenityType" ,
                                                                                 defaultValue = "PHONE_NUMBER"
                                                                         ) IdentityType identityType ) throws MessengerException {
        return ResponseEntity.status(200).body(service.findAllContactAtContactList(identity, identityType));
    }
}
