package com.feignforsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "songify-client", configuration = FeignClientConfiguration.class)
//@FeignClient(name = "songify-client")

@Component
public interface SongifyProxy {

    @GetMapping("/songs")
    SongList showAllSongs();

    @GetMapping("/songs/{id}")
    Map<String, Song> getById(@PathVariable("id") Integer id);

    @PostMapping("/songs")
    Song addSong(@RequestBody CreateNewSongDto song);

    @DeleteMapping("/songs/{id}")
    void deleteSongByPathVariable(@PathVariable("id") long id);

    @DeleteMapping("/songs")
    void deleteByQueryParam(@RequestParam("id") long id);

    @PutMapping("/songs/{id}")
    Song putSongById(@PathVariable("id") long id, @RequestBody PutSongByIdDto song);

    @PatchMapping("/songs/{id}")
    Song patchSongById(@PathVariable("id") long id, @RequestBody PatchSongByIdDto song);
}
