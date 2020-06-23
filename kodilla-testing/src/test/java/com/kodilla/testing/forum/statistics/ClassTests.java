package com.kodilla.testing.forum.statistics;
import java.util.*;
import org.junit.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.lang.*;

public class ClassTests {
    List<String> mocklist = mock(List.class);
    @Test
    public void test1(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();

        when(forumMock.postsCount()).thenReturn(0);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(0);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.postsUserAve();
        Assert.assertEquals(Double.NaN, temp, 0 );
    }
    @Test
    public void test2(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();

        when(forumMock.postsCount()).thenReturn(0);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(100);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.postsUserAve();

        Assert.assertEquals(0.0,temp, 1);
    }
    @Test
    public void test3(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();

        when(forumMock.postsCount()).thenReturn(1000);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(100);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.postsUserAve();

        Assert.assertEquals(10.0,temp, 1);
    }
    @Test
    public void test4(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();


        when(forumMock.commentsCount()).thenReturn(0);
        when(forumMock.postsCount()).thenReturn(100);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(100);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.commentsUserAve();

        Assert.assertEquals(0.0, temp, 1);
    }
    @Test
    public void test5(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();

        when(forumMock.commentsCount()).thenReturn(10);
        when(forumMock.postsCount()).thenReturn(9);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(100);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.commentsPostAve();

        Assert.assertTrue(temp > 1);
    }
    @Test
    public void test6(){
        Statistics forumMock = mock(Statistics.class);
        ClassStatistics stati = new ClassStatistics();


        when(forumMock.commentsCount()).thenReturn(2);
        when(forumMock.postsCount()).thenReturn(9);
        when(forumMock.usersNames()).thenReturn(mocklist);
        when(mocklist.size()).thenReturn(100);

        stati.calculateAdvStatistics(forumMock);
        double temp = stati.commentsPostAve();

        Assert.assertTrue(temp < 1);
    }
}
