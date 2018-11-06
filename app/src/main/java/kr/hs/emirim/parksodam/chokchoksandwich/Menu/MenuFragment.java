package kr.hs.emirim.parksodam.chokchoksandwich.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kr.hs.emirim.parksodam.chokchoksandwich.BaseFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class MenuFragment extends BaseFragment {

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    @Override
    public String getTitle() {
        return "Menu";
    }
}
