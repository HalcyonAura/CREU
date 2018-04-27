package creu.neighborhoodsustainability;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SocialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SocialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SocialFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    //private OnFragmentInteractionListener mListener;

    public SocialFragment() {
        // Required empty public constructor
    }


    public static SocialFragment newInstance() {
        SocialFragment fragment = new SocialFragment();
        Bundle args = new Bundle();
        args.putString("Title", "Social");
        /*args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_social, container, false);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.listView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Education");
        listDataHeader.add("Health Care");

        // Adding child data
        List<String> education = new ArrayList<String>();
        education.add("Percent without HS diploma");
        education.add("Percent with tertiary education");

        List<String> health = new ArrayList<String>();
        health.add("Obesity");
        health.add("Suicide rate");
        health.add("Life expectancy");

        listDataChild.put(listDataHeader.get(0), education); // Header, Child data
        listDataChild.put(listDataHeader.get(1), health);
    }
}
