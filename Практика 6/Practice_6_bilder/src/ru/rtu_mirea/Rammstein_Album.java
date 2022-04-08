package ru.rtu_mirea;

public class Rammstein_Album {
    private String albumName;
    private String albumGenre;
    private int albumYear;

    public Rammstein_Album(String name, String genre, int albumYear) {
        this.albumName = name;
        this.albumGenre = genre;
        this.albumYear = albumYear;
    }

    @Override
    public String toString() {
        return "Rammstein Album: " +
                "Name='" + albumName + '\'' +
                ", Genre='" + albumGenre + '\'' +
                ", Year=" + albumYear;
    }
}
