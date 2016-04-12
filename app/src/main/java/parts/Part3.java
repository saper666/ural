package parts;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ru.uraljournal.udevs.ural.R;
import ui.Person;

public class Part3 extends Fragment {

    public List<Person> persons;
    public RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.full_text, container, false);
        return rootView;
    }

}
