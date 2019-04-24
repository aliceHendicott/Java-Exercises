package coll.Movies;

public class Main {

    public static void main(String[] args){
        Movie movie = new Movie("this is a movie", 2018);

        String title = movie.title();
        int year = movie.year();

        movie.addRating(10);
        movie.addRating(8);
        movie.addRating(7);
        double avgRating = movie.rating();

        System.out.println("Movie title: " + title);
        System.out.println("Released in year: " + year);
        System.out.println("Average rating of: " + avgRating);

    }

}
