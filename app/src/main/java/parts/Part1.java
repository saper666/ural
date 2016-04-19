package parts;

import android.app.Fragment;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import ru.uraljournal.udevs.ural.R;
import ui.Article;

public class Part1 extends Fragment {
    Menu menu;
    WebView Rt;
    int pos = 0;
    public int defFontSize = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_task, container, false);


        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
      //  setSupportActionBar(toolbar);
      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.inflateMenu(R.menu.main_menu);


       // int pos = getIntent().getIntExtra("id",0);
        Article art = Article.Articles.get(pos);

        Rt = (WebView)rootView.findViewById(R.id.Wv);

        String htmlText = "<html><body>"+  // background = \"file:///android_asset/bgi.jpg\">" +
                "<br>" +
                //  "<img width=\"100%\" src=\"file:///android_asset/"+mDrawableName +".jpg\">" +
                "<br>" +
                "<h1 align=\"center\"><font size=\"12\" color=\"black\">"+art.Title+"</font></h1>" +
                "<br>" +
                "<p align=\"justify\"><font size=\"10\" color=\"black\">"+art.Description+"</font></p>" +
                "</body></html>";

        //  Rt.setBackgroundResource(R.drawable.bgi);
        Rt.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        Rt.setBackgroundColor(0x00000000);
        Rt.getSettings().setLoadWithOverviewMode(true);
        Rt.getSettings().setUseWideViewPort(true);

        defFontSize = 12;
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        //int height = size.y;
        if (width<=240) defFontSize=12;
        if (width>240 && width<=320) defFontSize=14;
        if (width>320 && width<=480) defFontSize=15;
        if (width>480) defFontSize=16;
        Rt.getSettings().setDefaultFontSize(defFontSize);

        Rt.loadDataWithBaseURL(null,htmlText, "text/html", "UTF-8",null);
        return rootView;


    }
public void setPos(int pos)
{
    this.pos = pos;
}


}