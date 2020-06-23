package com.kodilla.testing.forum.statistics;
import java.util.*;

class ClassStatistics {
    List<String> listU = new ArrayList<>();
    private int postsCount;
    private int commentsCount;
    private int usersCount;
    private double postsUserAverage;
    private double commentsUserAverage;
    private double commentsPostAverage;

    public void calculateAdvStatistics(Statistics statistics){
        listU = statistics.usersNames();
        usersCount = listU.size();

        postsCount = statistics.postsCount();

        commentsCount = statistics.commentsCount();

        postsUserAverage = (double)postsCount/(double)usersCount;
        commentsUserAverage = (double)commentsCount/(double)usersCount;
        commentsPostAverage = (double)commentsCount/(double)postsCount;

    }
    public double postsUserAve(){
        return postsUserAverage;
    }
    public double commentsUserAve(){
        return commentsUserAverage;
    }
    public double commentsPostAve(){
        return commentsPostAverage;
    }
}
