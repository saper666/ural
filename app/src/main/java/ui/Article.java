package ui;

import java.util.ArrayList;

public class Article {
    public String Author;
    public String Title;
    public String Genre;
    public String Description;
    public static ArrayList<Article> Articles = new ArrayList<>();
    public static ArrayList<Article> sortArt  = new ArrayList<>();

    public Article(String A,String T, String G, String D){
        Author = A;
        Title = T;
        Genre = G;
        Description = D;
    }

    public static void sort(String genre)
    {
        sortArt.clear();
      //  ArrayList<Article> sortArt = new ArrayList<Article>();
        for (Article str : Article.Articles) {
            if (str.Genre.equals(genre))
                sortArt.add(str);
        }
    }

}
