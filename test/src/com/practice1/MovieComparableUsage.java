package com.practice1;

import java.util.ArrayList;
import java.util.Collections;

//Can only have one way of sorting
public class MovieComparableUsage implements Comparable<MovieComparableUsage>{
    private double rating;
    private String name;
    private int year;

    // Used to sort movies by year
    //public int compareTo(MovieComparableUsage m)
    public int compareTo(MovieComparableUsage m)
    {
        //return this.year - m.year;
        if(this.rating==m.rating ){
            return 0;
        }
        else {
            return this.rating > m.rating ? -1 : 1;
        }
    }

    // Constructor
    public MovieComparableUsage(String nm, double rt, int yr)
    {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }

    // Getter methods for accessing private data
    public double getRating() { return rating; }
    public String getName()   {  return name; }
    public int getYear()      {  return year;  }
}
class Main
{
    public static void main(String[] args)
    {
        ArrayList<MovieComparableUsage> list = new ArrayList<MovieComparableUsage>();
        list.add(new MovieComparableUsage("Force Awakens", 8.3, 2015));
        list.add(new MovieComparableUsage("Star Wars", 8.7, 1977));
        list.add(new MovieComparableUsage("Empire Strikes Back", 8.8, 1980));
        list.add(new MovieComparableUsage("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);

        System.out.println("Movies after sorting : ");
        for (MovieComparableUsage movie: list)
        {
            System.out.println(movie.getName() + " " +
                    movie.getRating() + " " +
                    movie.getYear());
        }
    }
}