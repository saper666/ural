package parts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import ru.uraljournal.udevs.ural.R;

import java.util.ArrayList;
import java.util.List;

public class Part2 extends Fragment {

    private List<Person> persons;
    private RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.recyclerview_activity, container, false);
        rv=(RecyclerView)rootView.findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();



        return rootView;
    }

    private void initializeData(){
        //TEST DATA
        persons = new ArrayList<>();
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Emma Wilson", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lavery Maiss", "25 years old", R.drawable.ic_launcher));
        persons.add(new Person("Lillie Watts", "35 years old", R.drawable.ic_launcher));
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
