package com.khanzadi.constans;

public class UriConstants {
    public static final String MS_REGISTER_USER = "/users/register/{identity}"; //post
    public static final String MS_EDIT_USER = "/users/edit/{identity}"; //put
    public static final String MS_DELETE_USER = "/users/delete/{identity}"; //delete
    public static final String MS_FIND_USER = "/users/find/{identity}"; //get

    public static final String MS_ADD_CONTACT = "/users/contact/find/{identity}"; //post
    public static final String MS_EDIT_CONTACT = "/users/contact/find/{identity}"; //put
    public static final String MS_DELETE_CONTACT = "/users/contact/find/{identity}"; //delete
    public static final String MS_FIND_CONTACT = "/users/{identity}/contact/find/one"; //GET ONE
    public static final String MS_FIND_ALL_CONTACTS = "/users/{identity}/contact/find/all"; //GET ALL

}
