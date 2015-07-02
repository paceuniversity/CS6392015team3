package com.privatestock;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String[] images = {"stock1", "stock2", "stock3"};
        List<String> imagesAL = new ArrayList<>(Arrays.asList(images));

        ArrayAdapter<String> imagesAdapter = new ArrayAdapter<>(
                getActivity(),
                R.layout.listview_img_item,
                R.id.hiddenTextView,
                imagesAL);

        ListView lv = (ListView) view.findViewById(R.id.imageFeedListView);
        lv.setAdapter(imagesAdapter);

        return view;
    }
}