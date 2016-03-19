package ru.uraljournal.udevs.ural;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Badgeable;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;

import parts.Part1;
import parts.Part2;
import ui.ParseTask;

public class GeneralActivity extends ActionBarActivity {
    //
    RelativeLayout backgroundImageGeneral;
    RelativeLayout backgroundColorGeneral;
    Fragment part1;
    Fragment part2;
    private Drawer.Result drawerResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        backgroundImageGeneral = (RelativeLayout)findViewById(R.id.backgroundGeneral);
        backgroundColorGeneral = (RelativeLayout)findViewById(R.id.container);
        //Init Fragments
        part1 = new Part1();
        part2 = new Part2();

        new ParseTask().execute();

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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
                                    ftrans.replace(R.id.backgroundGeneral,part1);
                                    backgroundColorGeneral.setBackgroundColor(Color.WHITE);
                                    backgroundImageGeneral.setBackgroundResource(0);
                                    break;
                                case "Поэзия":
                                    ftrans.replace(R.id.backgroundGeneral,part2);
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
    public void onBackPressed() {
        // Закрываем Navigation Drawer по нажатию системной кнопки "Назад" если он открыт
        if (drawerResult.isDrawerOpen()) {
            drawerResult.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }


}
