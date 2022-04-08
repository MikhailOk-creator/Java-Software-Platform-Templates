package ru.rtu_mirea;

public class Pink_Floyd_Album_Builder implements Builder{
    private String albumName;
    private String albumGenre;
    private int albumYear;

    @Override
    public void SetName(String name) {
        this.albumName = name;
    }

    @Override
    public void SetGenre(String genre) {
        this.albumGenre = genre;
    }

    @Override
    public void SetYear(int year) {
        this.albumYear = year;
    }

    public Pink_Floyd_Album Shop(){
        return new Pink_Floyd_Album(albumName, albumGenre, albumYear);
    }
}
