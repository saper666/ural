package ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.MediaController;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import parts.PartVideo;
import ru.uraljournal.udevs.ural.R;
import ru.uraljournal.udevs.ural.VideoActivity;

public class RVAdapterVideo extends RecyclerView.Adapter<RVAdapterVideo.ArticleViewHolder> {
    Context ctx;
    public static final String API_KEY = "AIzaSyDxEBRlsXfHuqra7pqB6Ud7tVylWXZQxQM";
    public static final String videoID = "xOVswSEXsYk";

    public static class ArticleViewHolder extends  RecyclerView.ViewHolder implements YouTubePlayer.OnInitializedListener {
        CardView cv;
        TextView title;
       // VideoView vv;
        Context ctx;

        //  TextView author;
       // ImageView personPhoto;

        ArticleViewHolder(View itemView,Context ctx) {
            super(itemView);
            this.ctx = ctx;
            cv = (CardView)itemView.findViewById(R.id.cv);
            title = (TextView)itemView.findViewById(R.id.title);
          //  vv = (VideoView) itemView.findViewById(R.id.video);
           // YouTubePlayerView youTubeView = (YouTubePlayerView)
          //          findViewById(R.id.videoView1);
          //  youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);
         //   author = (TextView)itemView.findViewById(R.id.person_age);
          //  personPhoto = (ImageView)itemView.findViewById(R.id.person_photo);
            YouTubePlayerView youTubeView = (YouTubePlayerView)itemView.findViewById(R.id.vvv);

        }

        @Override
        public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
            youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
            youTubePlayer.setPlaybackEventListener(playbackEventListener);
            if (!b) youTubePlayer.cueVideo(videoID); // your video to play
        }

        @Override
        public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

        }

        private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {

            @Override
            public void onAdStarted() {
            }

            @Override
            public void onError(YouTubePlayer.ErrorReason arg0) {
            }

            @Override
            public void onLoaded(String arg0) {
            }

            @Override
            public void onLoading() {
            }

            @Override
            public void onVideoEnded() {
            }

            @Override
            public void onVideoStarted() {
            }
        };


        private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {

            @Override
            public void onBuffering(boolean arg0) {
            }

            @Override
            public void onPaused() {
            }

            @Override
            public void onPlaying() {
            }

            @Override
            public void onSeekTo(int arg0) {
            }

            @Override
            public void onStopped() {
            }

        };
    }

   // List<Person> persons;

  /*  public RVAdapter(List<Person> persons){
        this.persons = persons;
    }*/
    public RVAdapterVideo(Context ctx){this.ctx = ctx;}


    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new ArticleViewHolder(v,ctx);
    }

    @Override
    public void onBindViewHolder(final ArticleViewHolder personViewHolder, int i) {
      //  personViewHolder.personName.setText(persons.get(i).name);
      //  personViewHolder.personAge.setText(persons.get(i).age);
      //  personViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
        personViewHolder.title.setText(Article.Articles.get(i).Title);

      //  String sour = "https://www.youtube.com/watch?v=Fdtq7g-6qmg";
      //  Uri r = Uri.parse(sour);
      // Uri uri=Uri.parse("rtsp://r2---sn-a5m7zu76.c.youtube.com/Ck0LENy73wIaRAnTmlo5oUgpQhMYESARFEgGUg5yZWNvbW1lbmRhdGlvbnIhAWL2kyn64K6aQtkZVJdTxRoO88HsQjpE1a8d1GxQnGDmDA==/0/0/0/video.3gp");

        //personViewHolder.vv.setVideoURI(uri);
       // personViewHolder.vv.setVideoPath(sour);
       // personViewHolder.vv.setMediaController(new MediaController(ctx));
       // personViewHolder.vv.requestFocus(0);

        // personViewHolder.author.setText(Article.Articles.get(i).Author);
        personViewHolder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PartVideo myFragment = PartVideo.newInstance("video_id");
              //  FragmentTransaction ftrans = ctx.getFragmentManager().beginTransaction();

               // ftrans.beginTransaction().replace(R.id.vvv, myFragment).commit();
                Intent i = new Intent(ctx, VideoActivity.class);
                ctx.startActivity(i);
                //implement onClick
              //  Toast.makeText(v.getContext(), "HELLO? my name journal!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Article.Articles.size();
    }
}