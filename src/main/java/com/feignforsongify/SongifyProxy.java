package com.feignforsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("songify-client")
@Component
public interface SongifyProxy {

    @GetMapping("/songs")
    SongList showAllSongs();
}
