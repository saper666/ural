package ru.uraljournal.udevs.ural;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.TextView;

import ui.Article;

public class ArticleActivity extends ActionBarActivity {

    TextView title,description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        int pos = getIntent().getIntExtra("id",0);
        title = (TextView)findViewById(R.id.title);
        description =(TextView)findViewById(R.id.description);
        Article art = Article.Articles.get(pos);
        title.setText(art.Title);
        description.setText(art.Description);

    }
}
