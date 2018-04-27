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
 * {@link EconomyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EconomyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EconomyFragment extends Fragment {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    public EconomyFragment() {
        // Required empty public constructor
    }

    public static EconomyFragment newInstance() {
        EconomyFragment fragment = new EconomyFragment();
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
        View view = inflater.inflate(R.layout.fragment_economy, container, false);
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
        listDataHeader.add("Income");
        listDataHeader.add("Affordability");

        // Adding child data
        List<String> income = new ArrayList<String>();
        income.add("Rent as percentage of income");
        income.add("Home owner costs with mortgage as percentage of income");
        income.add("Home owner costs without mortgage as percentage of income");

        List<String> affordability = new ArrayList<String>();
        affordability.add("Individuals in poverty");
        affordability.add("Families in poverty");
        affordability.add("Per capita income");

        listDataChild.put(listDataHeader.get(0), income); // Header, Child data
        listDataChild.put(listDataHeader.get(1), affordability);
    }
}
