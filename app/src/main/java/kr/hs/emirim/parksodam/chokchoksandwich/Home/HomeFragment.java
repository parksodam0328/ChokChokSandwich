package kr.hs.emirim.parksodam.chokchoksandwich.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import kr.hs.emirim.parksodam.chokchoksandwich.BaseFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class HomeFragment extends BaseFragment {

    public HomeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView titleImage = (ImageView) view.findViewById(R.id.titleImage);
        ImageView recommend1 = (ImageView) view.findViewById(R.id.recommend1);
        ImageView recommend2 = (ImageView) view.findViewById(R.id.recommend2);
        ImageView recommend3 = (ImageView) view.findViewById(R.id.recommend3);
        ImageView recommend4 = (ImageView) view.findViewById(R.id.recommend4);


        Glide.with(this) //타이틀 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Ftitle.png?alt=media&token=357cf5d2-ed57-47d5-af1b-d54358cc4a67")
                .override(400,290)
                .into(titleImage);

        // 추천 샌드위치 이미지
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/subway%2Fsandwich%2Fblt.jpg?alt=media&token=3f51858d-9ac3-41fa-9d68-a192f58091fc")
                .override(130,80)
                .into(recommend1);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/subway%2Fsandwich%2Fbmt.jpg?alt=media&token=d3824ae5-a3b3-4dc6-81ec-ea0e59578296")
                .override(130,80)
                .into(recommend2);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/subway%2Fsandwich%2Fegg.jpg?alt=media&token=3b5b6009-c5de-4c14-b293-27e12c3088fd")
                .override(130,80)
                .into(recommend3);
        Glide.with(this)
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/subway%2Fsandwich%2Fham.jpg?alt=media&token=63fcce93-8a72-4398-8955-fbe2a01342cb")
                .override(130,80)
                .into(recommend4);
        return view;
    }

    @Override
    public String getTitle() {
        return "Home";
    }
}
