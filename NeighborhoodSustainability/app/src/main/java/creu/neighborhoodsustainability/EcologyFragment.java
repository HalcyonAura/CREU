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
 * {@link EcologyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EcologyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EcologyFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public EcologyFragment() {
        // Required empty public constructor
    }


    public static EcologyFragment newInstance() {
        EcologyFragment fragment = new EcologyFragment();
        Bundle args = new Bundle();
        args.putString("Title", "Economy");
        /*args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);*/
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ecology, container, false);
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
        listDataHeader.add("Pollution");
        listDataHeader.add("Waste Management");

        // Adding child data
        List<String> pollution = new ArrayList<String>();
        pollution.add("Air quality index");
        pollution.add("Water quality index");

        List<String> waste = new ArrayList<String>();
        waste.add("Percent waste to landfills");
        waste.add("Percent waste redirected from landfills");

        listDataChild.put(listDataHeader.get(0), pollution); // Header, Child data
        listDataChild.put(listDataHeader.get(1), waste);
    }
}
