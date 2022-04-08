package ru.rtu_mirea;

public class Pink_Floyd_Album {
    private String albumName;
    private String albumGenre;
    private int albumYear;

    public Pink_Floyd_Album(String albumName, String albumGenre, int albumYear) {
        this.albumName = albumName;
        this.albumGenre = albumGenre;
        this.albumYear = albumYear;
    }

    @Override
    public String toString() {
        return "Pink Floyd Album: " +
                "Name='" + albumName + '\'' +
                ", Genre='" + albumGenre + '\'' +
                ", Year=" + albumYear;
    }
}
