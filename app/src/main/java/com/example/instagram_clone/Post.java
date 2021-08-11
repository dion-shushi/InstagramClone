package com.example.instagram_clone;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Post")
public class Post extends ParseObject {

    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_USER = "user";
    public static final String KEY_IMAGE = "image";

    public String getKeyDescription(){
        return getString(KEY_DESCRIPTION);
    }

    public void setKeyDescription(String description){
        put(KEY_DESCRIPTION, description);
    }

    public ParseUser getKeyUser(){
        return getParseUser(KEY_USER);
    }

    public void setKeyUser(ParseUser user){
        put(KEY_USER, user);
    }

    public ParseFile getKeyImage(){
        return getParseFile(KEY_IMAGE);
    }

    public void setKeyImage(ParseFile parseFile){
        put(KEY_IMAGE, parseFile);
    }
}
