package ru.uraljournal.udevs.ural;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import parts.Part2;
import ui.Article;
import ui.ParseTask;

public class GeneralActivity extends ActionBarActivity {
    //
    RelativeLayout backgroundImageGeneral;
    RelativeLayout backgroundColorGeneral;
    Fragment part1;
    Part2 part2;
    private Drawer.Result drawerResult = null;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        backgroundImageGeneral = (RelativeLayout)findViewById(R.id.backgroundGeneral);
        backgroundColorGeneral = (RelativeLayout)findViewById(R.id.container);
        //Init Fragments
     //   part1 = new Part1();
        part2 = new Part2();

        new ParseTask().execute();

        // Handle Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        /*toolbar.inflateMenu(R.menu.main_menu);*/

        // Инициализируем Navigation Drawer
        drawerResult = new Drawer()
                .withActivity(this)
                .withToolbar(toolbar)
                .withActionBarDrawerToggle(true)
                .withHeader(R.layout.layout)
                .addDrawerItems(
                        new SectionDrawerItem().withName(R.string.drawer_item_chapters),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p1).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p2).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p3).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p4).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p5).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p6).withIcon(FontAwesome.Icon.faw_book),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_p7).withIcon(FontAwesome.Icon.faw_book),
                        new SectionDrawerItem().withName(R.string.drawer_item_options),
                        //new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIcon(FontAwesome.Icon.faw_book).withBadge("99").withIdentifier(1),
                       // new PrimaryDrawerItem().withName(R.string.drawer_item_free_play).withIcon(FontAwesome.Icon.faw_book),
                      //  new PrimaryDrawerItem().withName(R.string.drawer_item_custom).withIcon(FontAwesome.Icon.faw_book).withBadge("6").withIdentifier(2),
                      //  new SectionDrawerItem().withName(R.string.drawer_item_settings),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_help).withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_question).setEnabled(false),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(FontAwesome.Icon.faw_github).withBadge("12+").withIdentifier(1)
                )
                .withOnDrawerListener(new Drawer.OnDrawerListener() {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Скрываем клавиатуру при открытии Navigation Drawer
                        InputMethodManager inputMethodManager = (InputMethodManager) GeneralActivity.this.getSystemService(Activity.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(GeneralActivity.this.getCurrentFocus().getWindowToken(), 0);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                    }
                })
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    // Обработка клика
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {

                        FragmentTransaction ftrans = getFragmentManager().beginTransaction();
                        if (drawerItem instanceof Nameable) {
                            switch (GeneralActivity.this.getString(((Nameable) drawerItem).getNameRes()))
                            {
                                case "Проза":
                                  //  ftrans.replace(R.id.backgroundGeneral,part1);
                                    part2.setGenre("Проза");
                                    Article.sort("Проза");
                                    ftrans.replace(R.id.backgroundGeneral, part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Поэзия":
                                    part2.setGenre("Поэзия");
                                    Article.sort("Поэзия");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Драматургия":
                                    part2.setGenre("Драматургия");
                                    Article.sort("Драматургия");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Без вымысла":
                                    part2.setGenre("Без вымысла");
                                    Article.sort("Без вымысла");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Краеведение":
                                    part2.setGenre("Краеведение");
                                    Article.sort("Краеведение");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Публицистика":
                                    part2.setGenre("Публицистика");
                                    Article.sort("Публицистика");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Критика и библиография":
                                    part2.setGenre("Критика и библиография");
                                    Article.sort("Критика и библиография");
                                    ftrans.replace(R.id.backgroundGeneral,part2);
                                    ftrans.detach(part2);
                                    ftrans.attach(part2);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                            }
                            ftrans.commit();
                          //  Toast.makeText(GeneralActivity.this, GeneralActivity.this.getString(((Nameable) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
                        if (drawerItem instanceof Badgeable) {
                            Badgeable badgeable = (Badgeable) drawerItem;
                            if (badgeable.getBadge() != null) {
                                // учтите, не делайте так, если ваш бейдж содержит символ "+"
                                try {
                                    int badge = Integer.valueOf(badgeable.getBadge());
                                    if (badge > 0) {
                                        drawerResult.updateBadge(String.valueOf(badge - 1), position);
                                    }
                                } catch (Exception e) {
                                    Log.d("test", "Не нажимайте на бейдж, содержащий плюс! :)");
                                }
                            }
                        }
                    }
                })
                .withOnDrawerItemLongClickListener(new Drawer.OnDrawerItemLongClickListener() {
                    @Override
                    // Обработка длинного клика, например, только для SecondaryDrawerItem
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        if (drawerItem instanceof SecondaryDrawerItem) {
                            Toast.makeText(GeneralActivity.this, GeneralActivity.this.getString(((SecondaryDrawerItem) drawerItem).getNameRes()), Toast.LENGTH_SHORT).show();
                        }
                        return false;
                    }
                })
                .build();
    }

    @Override
        public boolean onCreateOptionsMenu(Menu menu) {
               getMenuInflater().inflate(R.menu.main_menu, menu);
               return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        CharSequence message;

        switch (item.getItemId()) {
            case R.id.action_edit:
               //message = "Выбран пункт шрифт";
                ShowDialog();
                break;
            default:
                return false;
        }
        // выводим уведомление о выбранном пункте меню
        //Toast toast = Toast.makeText(this, message, Toast.LENGTH_LONG);

        //toast.setGravity(Gravity.CENTER, 0, 0);
        //toast.show();
        return true;
    }

    public void ShowDialog()
    {
        final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
        final SeekBar seek = new SeekBar(this);
        final TextView tw = new TextView(this);
        seek.setMax(100);

        popDialog.setIcon(android.R.drawable.ic_media_ff);
        popDialog.setTitle("Выберите размер шрифта ");
        popDialog.setView(seek);



        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                //Do something here with new value
//                Part1 p1 = new Part1();
//                p1.defFontSize += progress/10;

            }

            public void onStartTrackingTouch(SeekBar arg0) {
                // TODO Auto-generated method stub

            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub

            }
        });


        // Button OK
        popDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }

                });


        popDialog.create();
        popDialog.show();

    }

    @Override
    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
