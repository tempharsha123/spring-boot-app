package org.sri.springexample.controller;


import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.sri.springexample.entity.User;
import org.sri.springexample.exception.BadRequestException;
import org.sri.springexample.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
@Api(tags="users")
public class UserController {

        @Autowired
        UserService userService;

        @RequestMapping(value = "/create",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.POST)
        @ApiOperation(value = "Create a User",notes = "Creates a User")
        @ApiResponses({
                @ApiResponse(code = 200,message = "Success"),
                @ApiResponse(code = 500,message = "Internal Server Error"),
        })
        public User createUser(@RequestBody User user){
            if(user!=null)
                return userService.createUser(user);
            else
                return null;
        }


    @RequestMapping(value = "/{emailID}/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    @ApiOperation(value = "Find one user by Email ID",notes = "Returns the user with Email ID")
    @ApiResponses({
            @ApiResponse(code = 200,message = "Success"),
            @ApiResponse(code = 404,message = "Resource Not Found"),
            @ApiResponse(code = 500,message = "Internal Server Error"),
    })
    public User findUser(@PathVariable("emailID") String emailID){
        return userService.findByEmailID(emailID);
    }

    @RequestMapping(value = "/update/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.PUT)
    @ApiOperation(value = "Update a user",notes = "Updates a user")
    @ApiResponses({
            @ApiResponse(code = 200,message = "Success"),
            @ApiResponse(code = 400,message = "Bad Request"),
            @ApiResponse(code = 500,message = "Internal Server Error"),
    })
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @RequestMapping(value = "",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.GET)
    @ApiOperation(value = "Find All Users",notes = "Returns all the users")
    public List<User> getAllUsers(){
        return userService.findAll();
    }


    @RequestMapping(value = "/delete/{emailID}/",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,method = RequestMethod.DELETE)
   @ApiOperation(value = "Deletes an user",notes = "Deletes a user")
    public void deleteUser(@PathVariable("emailID") String emailId){
        userService.deleteUserByEmailID(emailId);
    }






}
