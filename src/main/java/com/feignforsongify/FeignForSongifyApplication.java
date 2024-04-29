package com.feignforsongify;

import feign.FeignException;
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
        try {
            log.info("---------------");
            log.info(songifyProxy.showAllSongs());
            log.info(songifyProxy.getById(1));
            CreateNewSongDto createNewSongDto = new CreateNewSongDto("song5", "Pelson");
            songifyProxy.addSong(createNewSongDto);
            log.info("You added new song, songName: " + createNewSongDto.songName() + ", artist: " +
                     createNewSongDto.artist());
            songifyProxy.deleteSongByPathVariable(2);
            songifyProxy.deleteByQueryParam(3);
            songifyProxy.putSongById(1, new PutSongByIdDto("song6", "Zawiałow"));
            songifyProxy.patchSongById(4, new PatchSongByIdDto("song7", "U2"));
            log.info("---------------");
            log.info(songifyProxy.showAllSongs());
        } catch (FeignException feignException) {
            log.error(feignException.status() + " " + feignException.getMessage());
        } catch (Exception e) {
            log.error("An unexpected exception occurred: " + e.getMessage());
        }
    }
}
