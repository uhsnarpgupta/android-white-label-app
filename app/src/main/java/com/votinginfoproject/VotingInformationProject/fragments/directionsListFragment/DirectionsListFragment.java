package com.votinginfoproject.VotingInformationProject.fragments.directionsListFragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.votinginfoproject.VotingInformationProject.R;

/**
 * Created by max on 4/22/16.
 */
public class DirectionsListFragment extends Fragment implements  DirectionsListView {
    private DirectionsListViewPresenter mPresenter;

    private static final String ARG_TRANSIT_MODE = "transit_mode";
    private static final String ARG_ORIGIN_COORDINATES = "origin_coordinates";
    private static final String ARG_DESTINATION_COORDINATES = "destination_coordinates";

    public static DirectionsListFragment newInstance(String transitMode, String originCoordinates, String destinationCoordinates) {
        DirectionsListFragment fragment = new DirectionsListFragment();

        Bundle args = new Bundle();
        args.putString(ARG_TRANSIT_MODE, transitMode);
        args.putString(ARG_ORIGIN_COORDINATES, originCoordinates);
        args.putString(ARG_DESTINATION_COORDINATES, destinationCoordinates);

        fragment.setArguments(args);

        return  fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_directions2, container, false);

        Bundle args = getArguments();
        String transitMode = args.getString(ARG_TRANSIT_MODE);
        String originCoordinates = args.getString(ARG_ORIGIN_COORDINATES);
        String destinationCoordinates = args.getString(ARG_DESTINATION_COORDINATES);

        mPresenter = new DirectionsListViewPresenterImpl(rootView.getContext(), transitMode, originCoordinates, destinationCoordinates);

        ((TextView) rootView.findViewById(R.id.section_label)).setText(transitMode);

        return rootView;
    }
}
