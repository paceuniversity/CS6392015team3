package com.privatestock;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A placeholder fragment containing a simple view.
 */
public class PINActivityFragment extends Fragment {

    private static final String CORRECT_PIN = "1234";
    private static final String INCORRECT_PIN_MESSAGE = "Please Try Again.";

    private EditText pinEditText;

    public PINActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pin, container, false);

        pinEditText = (EditText) view.findViewById(R.id.pinEditText);
        pinEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        pinEditText.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                handlePinEntry(s.toString());
            }
        });

        return view;
    }

    private void handlePinEntry(String pin) {
        if (pin.length() == 4) {
            if (pin.equalsIgnoreCase(CORRECT_PIN)) {
                Intent homeIntent = new Intent(getActivity(), HomeActivity.class);
                startActivity(homeIntent);
            } else {
                Context context = getActivity().getApplicationContext();
                CharSequence text = INCORRECT_PIN_MESSAGE;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                ((EditText) getActivity().findViewById(R.id.pinEditText)).setText("");
            }
        }
    }
}
