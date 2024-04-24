package com.feignforsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "songify-client", url = "http://localhost:8080")
public interface SongifyProxy {

    @GetMapping("/songs")
    SongList showAllSongs();

    @GetMapping("/songs/{id}")
    Song getById(@PathVariable("id") Integer id);
}
