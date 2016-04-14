package ru.uraljournal.udevs.ural;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
{

    public static final String API_KEY = "AIzaSyDxEBRlsXfHuqra7pqB6Ud7tVylWXZQxQM";
    public static final String videoID = "xOVswSEXsYk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        YouTubePlayerView youTubeView = (YouTubePlayerView)findViewById(R.id.vvv);
        youTubeView.initialize(API_KEY, this);
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

    public class DeveloperKey {
        /**
         * Please replace this with a valid API key which is enabled for the
         * YouTube Data API v3 service. Go to the
         * <a href=”https://code.google.com/apis/console/“>Google APIs Console</a> to
         * register a new developer key.
         */
        public static final String DEVELOPER_KEY = "AIzaSyDxEBRlsXfHuqra7pqB6Ud7tVylWXZQxQM";
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
