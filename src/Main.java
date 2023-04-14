public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("samSmithAlbum","samSmith");
        album1.addSong(new Song("unholy","samsmith",2.14));
        album1.addSong(new Song("Perfect","samsmith",3.24));
        album1.addSong(new Song("Gloria","samsmith",2.56));

        Album album2 = new Album("Honestly, Nevermind","Drake");
        album2.addSong(new Song("Her loss","Drake",3.42));
        album2.addSong(new Song("Views","Drake",3.33));
        album2.addSong(new Song("Take care","Drake",3.56));

        Playlist myPlaylist  = new Playlist("myPlayList");
        myPlaylist.addSongFromAlbum(album1,2);//perfect
        myPlaylist.addSongFromAlbum(album1,"Gloria");//gloria
        myPlaylist.addSongFromAlbum(album2,2);//views
        myPlaylist.addSongFromAlbum(album2,3);//take care
        myPlaylist.addSongFromAlbum(album2,1);//her loss

        System.out.println(myPlaylist.playCurrent());
        System.out.println(myPlaylist.playNext());
        System.out.println(myPlaylist.playNext());
        System.out.println(myPlaylist.playNext());
        System.out.println(myPlaylist.playNext());
        System.out.println(myPlaylist.playCurrent());
        System.out.println(myPlaylist.playPrevious());
        System.out.println(myPlaylist.playPrevious());
        System.out.println(myPlaylist.playPrevious());
        System.out.println(myPlaylist.playPrevious());
        System.out.println(myPlaylist.playPrevious());
        System.out.println(myPlaylist.playPrevious());



    }
}