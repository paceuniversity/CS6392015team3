package com.privatestock;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import android.content.Intent;
import android.app.Activity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{
    EditText pin;
    Button okbtn;
    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        pin = (EditText) rootView.findViewById(R.id.editText);

        pin.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER))
                {
                    if(pin.getText().toString().equals("1234"))
                    {
                        Intent i = new Intent(getActivity(), MainActivity2Activity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Toast.makeText(getActivity(), "Enter correct PIN", Toast.LENGTH_SHORT).show();
                    }
                }
                return false;
            }
        });

        return rootView;
    }
}
