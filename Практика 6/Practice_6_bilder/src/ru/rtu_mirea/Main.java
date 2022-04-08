package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
	    Director director = new Director();

        Pink_Floyd_Album_Builder pink_floyd = new Pink_Floyd_Album_Builder();
        director.Add_Pink_Floyd_Album(pink_floyd);
        System.out.println(pink_floyd.Shop());

        Rammstein_Album_Builder rammstein = new Rammstein_Album_Builder();
        director.Add_Rammstein_Album(rammstein);
        System.out.println(rammstein.Shop());
    }
}
