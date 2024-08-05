package com.practice1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MovieComparatorUsage implements Comparable<MovieComparatorUsage>{
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year
    public int compareTo(MovieComparatorUsage m)
    {
        return this.year - m.year;
    }

    // Constructor
    public MovieComparatorUsage(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName() { return name; }
    public int getYear() { return year; }
}

// Class to compare Movies by ratings
class RatingCompare implements Comparator<MovieComparatorUsage> {
    public int compare(MovieComparatorUsage m1, MovieComparatorUsage m2)
    {
        if (m1.getRating() < m2.getRating())
            return -1;
        if (m1.getRating() > m2.getRating())
            return 1;
        else
            return 0;
    }
}

// Class to compare Movies by name
class NameCompare implements Comparator<MovieComparatorUsage> {
    public int compare(MovieComparatorUsage m1, MovieComparatorUsage m2)
    {
        return m1.getName().compareTo(m2.getName());
    }
}

class Main1 {
    public static void main(String[] args)
    {
        ArrayList<MovieComparatorUsage> list = new ArrayList<MovieComparatorUsage>();
        list.add(new MovieComparatorUsage("Force Awakens", 8.3, 2015));
        list.add(new MovieComparatorUsage("Star Wars", 8.7, 1977));
        list.add(
                new MovieComparatorUsage("Empire Strikes Back", 8.8, 1980));
        list.add(
                new MovieComparatorUsage("Return of the Jedi", 8.4, 1983));

        // Sort by rating : (1) Create an object of
        // ratingCompare
        //                  (2) Call Collections.sort
        //                  (3) Print Sorted list
        System.out.println("Sorted by rating");
        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        for (MovieComparatorUsage movie : list)
            System.out.println(movie.getRating() + " "
                    + movie.getName() + " "
                    + movie.getYear());

        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        NameCompare nameCompare = new NameCompare();
        Collections.sort(list, nameCompare);
        for (MovieComparatorUsage movie : list)
            System.out.println(movie.getName() + " "
                    + movie.getRating() + " "
                    + movie.getYear());

        // Uses Comparable to sort by year
        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (MovieComparatorUsage movie : list)
            System.out.println(movie.getYear() + " "
                    + movie.getRating() + " "
                    + movie.getName() + " ");
    }
}
