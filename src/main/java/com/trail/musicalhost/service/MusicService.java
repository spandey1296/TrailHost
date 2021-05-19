package com.trail.musicalhost.service;

import com.trail.musicalhost.model.Music;
import com.trail.musicalhost.repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    @Autowired
    MusicRepository musicRepository;

    public List<Music> getAllMusic(){
        return (List<Music>) musicRepository.findAll();
    }

    public Music getMusic(Integer id){
        Optional<Music> music = musicRepository.findById(id);
        if(music.isPresent()){
            return music.get();
        }else{
            return null;
        }
    }

    public List<Music> getPostByUserID(Integer id){
        return this.musicRepository.findAllMusicByUserId(id);
    }

    public void deleteMusic(Integer id){
        this.musicRepository.deleteById(id);
    }

    // Method to add a post
    public void addMusic(Music music){
        this.musicRepository.save(music);
    }

    public boolean updateMusic(Integer id, Music music){

        if(this.musicRepository.existsById(id)){
            Optional<Music> existMusic = musicRepository.findById(id);
            Music music1 = existMusic.get();
            music1.setMusic(music.getMusic());
            music1.setDescription(music.getDescription());
            music1.setName(music.getName());
            this.musicRepository.save(music1);
            return true;
        }else {
            return false;
        }
    }

}
