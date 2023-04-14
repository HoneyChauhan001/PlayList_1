import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Album {
    private String title;
    private String artist;
    private List<Song> songs;

    public Album(String title, String artist, List<Song> songs) {
        this.title = title;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Optional<Song> findSong(Song songToSearch){
        for(Song song : songs){
            if(songToSearch.getTitle().equals(song.getTitle()) && songToSearch.getArtist().equals(song.getArtist()))
                return Optional.of(song);
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(String title){
        for(Song song : songs){
            if(title.equals(song.getTitle()))return Optional.of(song);
        }
        return Optional.empty();
    }

    public Optional<Song> findSong(int trackNo){
        if(trackNo>=0 && trackNo<=songs.size()){
            return Optional.of(songs.get(trackNo-1));
        }
        return Optional.empty();
    }
    public String addSong(Song song){
        Optional<Song> optionalSong = findSong(song);
        if(optionalSong.isPresent()){//!optional.isEmpty();
            return "Song already exists in album";
        }
        songs.add(song);
        return "Song added to album";
    }
}
