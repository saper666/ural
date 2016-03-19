package parts;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import ru.uraljournal.udevs.ural.R;

public class Part1 extends ListFragment {

    String data[] = new String[] { "one", "two", "three", "four","one", "two", "three","one", "two", "three",
            "one", "two", "three","one", "two", "three","one", "two", "three","one", "two", "three","one", "two", "sex"};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.f1, container, false);
        return rootView;
    }
}
