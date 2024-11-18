package AP.Stream.movieexercise;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MoviesApp {
    public static List<Movie> readMovies(String filename) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (Scanner in = new Scanner(new File(filename))) {
            while (in.hasNextLine()) {
                String nameLine = in.nextLine();
                String yearLine = in.nextLine();
                String directorsLine = in.nextLine();
                String producersLine = in.nextLine();
                String actorsLine = in.nextLine();
                movies.add(new Movie(getString(nameLine),
                        Integer.parseInt(getString(yearLine)),
                        getList(directorsLine), getList(producersLine),
                        getList(actorsLine)));
            }
        }
        return movies;
    }

    private static String getString(String line) {
        int colon = line.indexOf(":");
        return line.substring(colon + 1).trim();
    }

    private static List<String> getList(String line) {
        return Stream.of(getString(line).split(", "))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        List<Movie> movieList = readMovies("C:\\Users\\denni\\OneDrive\\Skrivebord\\3Semester\\src\\AP\\Stream\\filer\\movies.txt");
//        for (Movie m : movieList) {
//            System.out.println(m.getTitle());
//        }

        movieList.stream().forEach(e -> System.out.println(e.getTitle()));
        System.out.println("Number of movies: " +movieList.size());

        //  The numer of movies starting with "H"
        System.out.println(movieList.stream().filter(m -> m.getTitle().startsWith("H")).count());

        // The title of the movies starting with "X"
        System.out.println(movieList.stream().filter(m -> m.getTitle().startsWith("X")).map(title -> title.getTitle()).toList());

        // The number of films where the director is also an actor
        System.out.println(movieList.stream().filter(movie -> movie.getActors().contains(movie.getDirectors())).count());

        //The number of actors in the film with the most actors
        System.out.println(movieList.stream().mapToInt(movie -> movie.getActors().size()).max());

        // The title of the film with the most actors
        System.out.println(movieList.stream().reduce((m1,m2) -> m1.getActors().size() > m2.getActors().size() ? m1:m2).map(movie -> movie.getTitle()));
        //Number of films divided by first letter in the film title
        // TODO Opgave

        // Number of movies whose title starts with "The "
        System.out.println(movieList.stream().filter(m -> m.getTitle().startsWith("The")).count());


//
    }


}

