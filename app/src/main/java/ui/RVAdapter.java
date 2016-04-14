package ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ru.uraljournal.udevs.ural.ArticleActivity;
import ru.uraljournal.udevs.ural.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ArticleViewHolder> {
Context ctx;
    String genre;
    int pos=0;
    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView author;
       // ImageView personPhoto;
        // ImageView personPhoto;

        ArticleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.person_name);
            author = (TextView)itemView.findViewById(R.id.person_age);
          //  personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

   // List<Person> persons;

  /*  public RVAdapter(List<Person> persons){
        this.persons = persons;
    }*/
    public RVAdapter(Context ctx,String genre){this.ctx=ctx;this.genre = genre;}


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ArticleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder personViewHolder, int i) {
      //  personViewHolder.personName.setText(persons.get(i).name);
      //  personViewHolder.personAge.setText(persons.get(i).age);
      //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
        ArrayList<Article> sortArt = new ArrayList<Article>();
        for(Article str : Article.Articles){
            if(str.Genre.equals(genre))
            sortArt.add(str);
        }
        personViewHolder.title.setText(Article.Articles.get(i).Title);
        personViewHolder.author.setText(Article.Articles.get(i).Author);
        pos =i;
        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implement onClick
                Intent intent = new Intent(ctx,ArticleActivity.class);
                intent.putExtra("id", pos);
                ctx.startActivity(intent);
                //Toast.makeText(v.getContext(),"HELLO? my name journal!!!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Article.Articles.size();
    }
}