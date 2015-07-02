package com.privatestock;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.privatestock.task.ImageDownloader;


/**
 * A placeholder fragment containing a simple view.
 */
public class SearchActivityFragment extends Fragment implements View.OnClickListener {

    private EditText searchEditText;
    private Button searchButton;
    View view;

    public SearchActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_search, container, false);

        searchEditText = (EditText) view.findViewById(R.id.searchQuery);
        searchButton = (Button) view.findViewById(R.id.searchButton);


        searchButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.searchButton)
            searchForImage();
    }

    private void searchForImage() {
        String query = this.searchEditText.getText().toString();

        ImageDownloader imageDownloader = new ImageDownloader(view, getActivity().getApplicationContext());
        imageDownloader.setImageName(query);
        imageDownloader.execute();

        hideKeyboard();
    }

    public void hideKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager)
                getActivity().getSystemService(
                        getActivity().getApplicationContext().INPUT_METHOD_SERVICE);

        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }
}
