package ru.rtu_mirea;

public class Rammstein_Album_Builder implements Builder{
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

    public Rammstein_Album Shop() {
        return new Rammstein_Album(albumName, albumGenre, albumYear);
    }
}
