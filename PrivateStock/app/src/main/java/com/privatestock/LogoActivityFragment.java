package com.privatestock;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A placeholder fragment containing a simple view.
 */
public class LogoActivityFragment extends Fragment implements View.OnClickListener {

    public LogoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logo, container, false);

        ImageView logoImageView = (ImageView) view.findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.logoImageView) {
            Intent pinIntent = new Intent(getActivity().getApplicationContext(), PINActivity.class);
            startActivity(pinIntent);
        }
    }
}
