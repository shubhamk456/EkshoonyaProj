package com.example.ekshoonaya;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link step_1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link step_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class step_1 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public step_1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment step_1.
     */
    // TODO: Rename and change types and number of parameters
    public static step_1 newInstance(String param1, String param2) {
        step_1 fragment = new step_1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_step_1, container, false);
    }



    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
    private Button nextBT;
    private EditText ageText;
    //******************************
    RadioGroup group;
    RadioButton genbut;
    EditText firstN;
    EditText lastN;
    EditText mobileN;
    EditText altMobileN;
    EditText email;
    EditText dob;
    EditText education;
    String value="Male";

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nextBT = view.findViewById(R.id.nextBT);
        ageText = view.findViewById(R.id.ageET);

        group=(RadioGroup) view.findViewById(R.id.gender);

        genbut=view.findViewById(group.getCheckedRadioButtonId());


        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId) {
                    case R.id.male:
                        value="Male";
                        break;
                    case R.id.female:
                        // Fragment 2
                        value="Female";
                        break;
                }

            }
        });

        firstN = view.findViewById(R.id.firstNameET);
        lastN = view.findViewById(R.id.LastNameET);
        mobileN = view.findViewById(R.id.mobileNumberET);
        altMobileN = view.findViewById(R.id.alternateNumberET);
        email = view.findViewById(R.id.emailET);
        dob = view.findViewById(R.id.ageET);
        education = view.findViewById(R.id.EducationET);






    }


    @Override
    public void onResume() {
        super.onResume();
        nextBT.setOnClickListener(this);
        ageText.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        nextBT.setOnClickListener(null);
        Registration m1= (Registration) getActivity();
        String gen= (String) genbut.getText();
        String fN=firstN.getText().toString();
        String lN=lastN.getText().toString();
        String mN=mobileN.getText().toString();
        String amn=altMobileN.getText().toString();
        String emailid=email.getText().toString();
        String dobi=dob.getText().toString();
        String edu=education.getText().toString();
        m1.getFromStep1(value,fN,lN,mN,amn,emailid,dobi,edu);
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        nextBT = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextBT:
                if (mListener != null) {
                    Registration m1= (Registration) getActivity();
                    String fN=firstN.getText().toString();
                    String lN=lastN.getText().toString();
                    String mN=mobileN.getText().toString();
                    String amn=altMobileN.getText().toString();
                    String emailid=email.getText().toString();
                    String dobi=dob.getText().toString();
                    String edu=education.getText().toString();
                    m1.getFromStep1(value,fN,lN,mN,amn,emailid,dobi,edu);

                    mListener.onNextPressed(this);
                    break;
                }
            case R.id.ageET:
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);

                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                final int cy = year;
                final int cd = day;
                final int cm = month + 1;
                // Log.d("cy", year + " " + month + 1 + " " + day);
                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_Holo_Light_Dialog_MinWidth, mOnDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        //  Log.d("Date", "onDateset :mm/dd/yyyy: " + month + "/" + day + "/" + year);
                        String date = month + "/" + dayOfMonth + "/" + year;

                        if (month > 12 || dayOfMonth > 31 || year > cy) {
                            Toast.makeText(getContext(),"Enter Valid Date Of Birth",Toast.LENGTH_SHORT).show();
                            ageText.setText(null);

                        } else if (month == cm && dayOfMonth == cd && year == cy) {
                            Toast.makeText(getContext(),"Enter Valid Date Of Birth",Toast.LENGTH_SHORT).show();
                            ageText.setText(null);
                        } else if (year == cy && month > cm || year == cy && month == cm && dayOfMonth > cd) {
                            Toast.makeText(getContext(),"Enter Valid Date Of Birth",Toast.LENGTH_SHORT).show();
                            ageText.setText(null);
                        } else {

                            ageText.setText(date);
                        }
                    }
                };

                break;

        }
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNextPressed(Fragment fragment);
    }
}
