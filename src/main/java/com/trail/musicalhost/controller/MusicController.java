package com.trail.musicalhost.controller;

import com.trail.musicalhost.model.Music;
import com.trail.musicalhost.model.User;
import com.trail.musicalhost.service.MusicService;
import com.trail.musicalhost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    @Autowired
    MusicService musicService;
    @Autowired
    UserService userService;

    @RequestMapping("/post")
    public List<Music> getAllPost()
    {
        return this.musicService.getAllMusic();
    }

    // Method to get post by id
    // Url - localhost:8080/posts/id(some value ex- 1)
    // return the post of that id
    @RequestMapping("/getpostbyid/{id}")
    public Music getPost(@PathVariable Integer id)
    {

        return this.musicService.getMusic(id);
    }

    //Method to add a post
    // Url - localhost:8080/posts
    @RequestMapping(method = RequestMethod.POST, value = "/post/create")
    public String addPost(@RequestBody Music music)
    {

        User user = userService.getCurrentLoggedINUser();
        music.setUser(user);
        this.musicService.addMusic(music);
        String response = "{\"success\" : true, \"message\" : \"Post added Successfully\"}";
        return response;
    }

    //Method to delete a post by id
    //Url - localhost:8080/posts/id(some value ex-1)
    @DeleteMapping("/post/delete/{id}")
    public String deletePost(@PathVariable Integer id)
    {

        this.musicService.deleteMusic(id);
        String response = "{\"success\" : true, \"message\" : \"Post Deleted Successfully\"}";
        return response;
    }

    //Method to update a post by id
    //Url- localhost:8080/post/id
    @RequestMapping(method = RequestMethod.PUT, value = "/post/update/{id}")

    public String updatePost(@PathVariable Integer id, @RequestBody Music music)
    {

        String response ="";
        if(this.musicService.updateMusic(id,music)) {
            response = "{\"success\" : true, \"message\" : \"Post updated Successfully\"}";
        }
        else{
            response = "{\"success\" : true, \"message\" : \"Post Cannot be updated\"}";
        }

        return response;
    }
}
