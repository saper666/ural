package ui;

import java.util.ArrayList;

/**
 * Created by Saper on 24.03.2016.
 */
public class Article {
    public String Author;
    public String Title;
    public String Genre;
    public String Description;
    public static ArrayList<Article> Articles = new ArrayList<>();

    public Article(String A,String T, String G, String D){
        Author = A;
        Title = T;
        Genre = G;
        Description = D;
    }
}
