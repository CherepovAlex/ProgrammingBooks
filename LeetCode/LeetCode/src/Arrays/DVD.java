package Arrays;

public class DVD {
    public String name;
    public int releaseYear;
    public String director;

    public DVD(String name, int releaseYear, String director) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.director = director;
    }

    public String toString() {
        return this.name + ", directed by " + this.director + ", released in " + this.releaseYear;
    }

    public static void main(String[] args) {
        DVD[] dvdCollection = new DVD[15];

        DVD avengersDVD = new DVD("Avengers", 2012, "Joss Whedon");
        dvdCollection[7] = avengersDVD;

        DVD incrediblesDVD = new DVD("The Incredibles", 2004, "Brad Bird");
        DVD findingDoryDVD = new DVD("Finding Dory", 2016, "Andrew Stanton");
        DVD lionKingDVD = new DVD("The Lion King", 2019, "Jon Favreau");
        dvdCollection[3] = incrediblesDVD;
        dvdCollection[9] = findingDoryDVD;
        dvdCollection[2] = lionKingDVD;

        DVD starWarsDVD = new DVD("Star Wars", 1977, "George Lucas");
        dvdCollection[3] = starWarsDVD;

        System.out.println(dvdCollection[7]);
        System.out.println(dvdCollection[10]);
        System.out.println(dvdCollection[3]);

    }
}