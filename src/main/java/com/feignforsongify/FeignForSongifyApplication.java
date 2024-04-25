package com.feignforsongify;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@Log4j2
public class FeignForSongifyApplication {

    private final SongifyProxy songifyProxy;

    public FeignForSongifyApplication(SongifyProxy songifyProxy) {
        this.songifyProxy = songifyProxy;
    }

    public static void main(String[] args) {
        SpringApplication.run(FeignForSongifyApplication.class, args);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequest() {
        log.info("---------------");
        log.info(songifyProxy.showAllSongs());

        log.info(songifyProxy.getById(2));

        CreateNewSongDto createNewSongDto = new CreateNewSongDto("song5", "Pelson");
        songifyProxy.addSong(createNewSongDto);
        log.info("You added new song, songName: " + createNewSongDto.songName() + ", artist: " + createNewSongDto.artist());
        log.info("---------------");
        log.info(songifyProxy.showAllSongs());

        songifyProxy.deleteSongByPathVariable(2);
        log.info("---------------");
        log.info(songifyProxy.showAllSongs());

        songifyProxy.deleteByQueryParam(3);
        log.info("---------------");
        log.info(songifyProxy.showAllSongs());

//        songifyProxy.putSongById(5, new PutSongByIdDto("song6", "Zawiałow"));
//        log.info("---------------");
//        log.info(songifyProxy.showAllSongs());

//        songifyProxy.patchSongById(4, new PatchSongByIdDto(null, "U2"));
        songifyProxy.partiallyUpdateSong(4, new PartiallyUpdateSongRequestDto("asasas", "mnmnmn"));
        log.info("---------------");
        log.info(songifyProxy.showAllSongs());
    }
}
