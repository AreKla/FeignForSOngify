package com.feignforsongify;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

@FeignClient("songify-client")
@Component
public interface SongifyProxy {

    @GetMapping("/songs/{id}")
    Song getById(@PathVariable Integer id);

    @GetMapping("/songs")
    SongList showAllSongs();

    //    @GetMapping("/api/{id}")
    //    QuoteExample getById(@PathVariable("id") long id);
    //
    //    @GetMapping("/api/random")
    //    QuoteExample getRandomQuote();
    //
    //    @GetMapping("/apiWithRequestParam")
    //    QuoteExample getByParam(@RequestParam("id") long id);
    //
    //    @GetMapping("/apiWithHeader")
    //    List<QuoteExample> getAllWithHeader();
    //
    //    @RequestMapping(method = RequestMethod.POST, value = "/api/quote")
    //    ResponseEntity<QuoteExample> addQuote(@RequestBody QuoteValue quote);
    //
    //    @DeleteMapping("/api/quote/{id}")
    //    Marker deleteById(@PathVariable("id") long id);
}
