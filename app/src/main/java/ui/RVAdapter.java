package ui;

import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


import parts.Part1;
import ru.uraljournal.udevs.ural.R;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ArticleViewHolder> {
    Context ctx;
    String genre;
    int pos = 0;
    Part1 part1;

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView title;
        TextView author;
        // ImageView personPhoto;
        // ImageView personPhoto;

        ArticleViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cv);
            title = (TextView) itemView.findViewById(R.id.person_name);
            author = (TextView) itemView.findViewById(R.id.person_age);
            //  personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
        }
    }

    // List<Person> persons;

    /*  public RVAdapter(List<Person> persons){
          this.persons = persons;
      }*/
    public RVAdapter(Context ctx, String genre) {
        this.ctx = ctx;
        this.genre = genre;
        part1 = new Part1();
    }


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
       // ArrayList<Article> sortArt = new ArrayList<Article>();
       // for (Article str : Article.Articles) {
       //     if (str.Genre.equals(genre))
       //         sortArt.add(str);
       // }
      //  personViewHolder.title.setText(Article.Articles.get(i).Title);
      //  personViewHolder.author.setText(Article.Articles.get(i).Author);

        personViewHolder.title.setText(Article.sortArt.get(i).Title);
        personViewHolder.author.setText(Article.sortArt.get(i).Author);
        pos = i;
        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implement onClick
              //  Intent intent = new Intent(ctx, ArticleActivity.class);
           //**     Intent intent = new Intent(ctx, TaskActivity.class);

              //**  intent.putExtra("id", pos);
                //**ctx.startActivity(intent);

                ActionBarActivity aba= (ActionBarActivity)ctx;
                FragmentTransaction ftrans = aba.getFragmentManager().beginTransaction();
                part1.setPos(pos);
                ftrans.replace(R.id.backgroundGeneral, part1);
                ftrans.commit();
                //Toast.makeText(v.getContext(),"HELLO? my name journal!!!",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Article.sortArt.size();
    }
}