package kr.hs.emirim.parksodam.chokchoksandwich.Menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kr.hs.emirim.parksodam.chokchoksandwich.BaseFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class MenuFragment extends BaseFragment {
    ImageView titleImage = null;
    Button mSide = null;
    Button mDrink = null;
    Button mSandwidh = null;

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
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        titleImage = (ImageView) view.findViewById(R.id.titleImage);
        mSide = (Button) view.findViewById(R.id.side);
        mDrink = (Button) view.findViewById(R.id.drink);
        mSandwidh = (Button) view.findViewById(R.id.sandwich);

        Glide.with(this) //타이틀 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Ftitle.png?alt=media&token=357cf5d2-ed57-47d5-af1b-d54358cc4a67")
                .error(R.drawable.title)
                .override(360, 250)
                .into(titleImage);

        mSide.setOnClickListener(new View.OnClickListener() { // 사이드 메뉴로 이동
            @Override
            public void onClick(View v) {
                Intent sideMenu = new Intent(getActivity(), SideMenuActivity.class);
                startActivity(sideMenu);
            }
        });

        mDrink.setOnClickListener(new View.OnClickListener() { // 음료 메뉴로 이동
            @Override
            public void onClick(View v) {
                Intent drinkMenu = new Intent(getActivity(), DrinkMenuActivity.class);
                startActivity(drinkMenu);
            }
        });

        mSandwidh.setOnClickListener(new View.OnClickListener() { // 음료 메뉴로 이동
            @Override
            public void onClick(View v) {
                Intent sandwichMenu = new Intent(getActivity(), SandwichMenuActivity.class);
                startActivity(sandwichMenu);
            }
        });
        return view;

    }

    @Override
    public String getTitle() {
        return "Menu";
    }
}
