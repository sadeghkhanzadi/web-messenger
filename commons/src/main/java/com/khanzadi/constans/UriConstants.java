package com.khanzadi.constans;

public class UriConstants {
    public static final String MS_REGISTER_USER = "/users/register/{identity}"; //post
    public static final String MS_EDIT_USER = "/users/edit/{identity}"; //put
    public static final String MS_EDIT_PASSWORD = "/users/edit/password/{identity}"; //put
    public static final String MS_DELETE_USER = "/users/delete/{identity}"; //delete
    public static final String MS_FIND_USER = "/users/find/{identity}"; //get

    public static final String MS_ADD_CONTACT = "/users/{identity}/contact/add"; //post
    public static final String MS_EDIT_CONTACT = "/users/{identity}/contact/edit"; //put
    public static final String MS_DELETE_CONTACT = "/users/{identity}/contact/{identityC}/delete"; //delete
    public static final String MS_FIND_CONTACT = "/users/{identity}/contact/{identityC}/find/one"; //GET ONE
    public static final String MS_FIND_ALL_CONTACTS = "/users/{identity}/contact/find/all"; //GET ALL

    //broker uri
    //Messages
    public static final String MS_RECEIVER_MESSAGE = "/queue/srv/message/get";
    public static final String MS_SENDER_MESSAGE = "/queue/srv/message/send";


}
