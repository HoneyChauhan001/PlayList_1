import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

public class Playlist {
    private String title;
    private List<Song> songs;
    private ListIterator<Song> itr;
    private boolean isNext;


    public Playlist(String title, List<Song> songs) {
        this.title = title;
        this.songs = songs;
        itr = this.songs.listIterator();
    }

    public Playlist(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
        itr = songs.listIterator();
    }

    public Optional<Song> findSong(Song songToSearch){
        for(Song song : songs){
            if(songToSearch.getTitle().equals(song.getTitle()) && songToSearch.getArtist().equals(song.getArtist()))
                return Optional.of(song);
        }
        return Optional.empty();
    }
    public Optional<Song> findSong(String songTitle){
        for(Song song : songs){
            if(songTitle.equals(song.getTitle())){
                return Optional.of(song);
            }
        }
        return Optional.empty();
    }

//    public Optional<Song> findSong(int trackNo){
//        if(trackNo>=0 && trackNo<=songs.size()){
//            return Optional.of(songs.get(trackNo-1));
//        }
//        return Optional.empty();
//    }

    public String addSongFromAlbum(Album album,String songTitle){
        Optional<Song> optionalSongInPlaylist = findSong(songTitle);
        if(optionalSongInPlaylist.isPresent()){
            return "Song already present in album";
        }
        else{
            Optional<Song> optionalSongInAlbum = album.findSong(songTitle);
             if(optionalSongInAlbum.isPresent()){
                songs.add(optionalSongInAlbum.get());
                itr = songs.listIterator();
                return "Song added to Playlist";
            }
            else {
                return "Song not found in Album";
            }
        }
    }

    public String addSongFromAlbum(Album album,Song song){
        Optional<Song> optionalSongInPlaylist = findSong(song);
        if(optionalSongInPlaylist.isPresent()){//checking in playlist
            return "Song already present in album";
        }
        else{
            Optional<Song> optionalSongInAlbum = album.findSong(song);//else find in album and add
            if(optionalSongInAlbum.isPresent()){
                songs.add(optionalSongInAlbum.get());
                itr = songs.listIterator();
                return "Song added to Playlist";
            }
            else {
                return "Song not found in Album";
            }
        }
    }

    public String addSongFromAlbum(Album album,int trackNo){
        Optional<Song> optionalSongInAlbum = album.findSong(trackNo);//finding song in album by trackno
        if(optionalSongInAlbum.isEmpty()){
            return "Song not found in Album";
        }
        Optional<Song> optionalSongInPlaylist = findSong(optionalSongInAlbum.get().getTitle());//checking in playlist
        if (optionalSongInPlaylist.isPresent()) {//if already present
            return "Song already present in album";
        } else {
            songs.add(optionalSongInAlbum.get());//else add
            itr = songs.listIterator();
            return "Song added to Playlist";
        }

    }

    public String playCurrent(){
        if(isNext){
            isNext = false;
            return "Current song is: " + itr.previous();
        }
        else {
            isNext = true;
            return "Current song is: " + itr.next();
        }
    }

    public String playNext(){
        if(!isNext){//if coming from previous
            itr.next();
            isNext = true;
        }
        if(itr.hasNext()){
            isNext = true;
            return "Next song to play is: "+ itr.next();
        }
        return "You have reached end of playlist";
    }

    public String playPrevious(){
        if(isNext){//if coming from next
            itr.previous();
            isNext = false;
        }
        if(itr.hasPrevious()){
            isNext = false;
            return "Previous song to play is: "+ itr.previous();
        }
        return "You have reached start of playlist. There no song before this";
    }
}
