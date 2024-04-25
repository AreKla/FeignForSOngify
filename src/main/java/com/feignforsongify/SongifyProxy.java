package com.feignforsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient("songify-client")
@Component
public interface SongifyProxy {

    @GetMapping("/songs")
    SongList showAllSongs();

    @GetMapping("/songs/{id}")
    Map<String, Song> getById(@PathVariable("id") Integer id);

    @PostMapping("/songs")
    Song addSong(@RequestBody CreateNewSongDto song);

    //    @RequestMapping(method = RequestMethod.POST, value = "/api/quote")
    //    ResponseEntity<QuoteExample> addQuote(@RequestBody QuoteValue quote);
    //
    //    @DeleteMapping("/api/quote/{id}")
    //    Marker deleteById(@PathVariable("id") long id);
}
