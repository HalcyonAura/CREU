package creu.neighborhoodsustainability;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

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
public class OntologyFragment extends Fragment {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    //private OnFragmentInteractionListener mListener;

    public OntologyFragment() {
        // Required empty public constructor
    }


    public static OntologyFragment newInstance() {
        OntologyFragment fragment = new OntologyFragment();
        Bundle args = new Bundle();
        args.putString("Title", "Ontology");
        /*args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ontology, container, false);
        // get the listview
        expListView = (ExpandableListView) view.findViewById(R.id.listView);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(getActivity(), IndicatorData.class);
                startActivity(intent);

                // TODO Auto-generated method stub
                /*Toast.makeText(
                        getActivity().getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();*/
                return false;
            }
        });
        return view;
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Factor1");
        listDataHeader.add("Factor2");

        // Adding child data
        List<String> one = new ArrayList<String>();
        one.add("Indicator 1");
        one.add("Indicator 2");
        one.add("Indicator 3");
        one.add("Indicator 4");
        one.add("Indicator 5");

        List<String> two = new ArrayList<String>();
        two.add("Indicator 1");
        two.add("Indicator 2");
        two.add("Indicator 3");
        two.add("Indicator 4");

        listDataChild.put(listDataHeader.get(0), one); // Header, Child data
        listDataChild.put(listDataHeader.get(1), two);
    }
}
