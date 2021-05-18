package com.trail.musicalhost.repository;

import com.trail.musicalhost.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music,Integer> {
}
