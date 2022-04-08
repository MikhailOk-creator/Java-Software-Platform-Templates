package ru.rtu_mirea;

public class Director {
    public void Add_Rammstein_Album(Builder album) {
        album.SetName("Mutter");
        album.SetGenre("Industrial Metal");
        album.SetYear(2001);
    }
    public void Add_Pink_Floyd_Album(Builder album) {
        album.SetName("The Wall");
        album.SetGenre("Progressive Rock");
        album.SetYear(1979);
    }
}
