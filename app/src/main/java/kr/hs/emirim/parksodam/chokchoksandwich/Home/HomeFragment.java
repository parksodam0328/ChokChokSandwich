package kr.hs.emirim.parksodam.chokchoksandwich.Home;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

import kr.hs.emirim.parksodam.chokchoksandwich.BaseFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class HomeFragment extends BaseFragment {
    private DatabaseReference mRecommendSandwich;
    private DatabaseReference mEvent;
    int i,j;
    final public static String TAG = "촉촉샌드위치:Home";
    ArrayList<ImageView> eventImage = null;
    ArrayList<ImageView> sandwichImage = null;
    ArrayList<TextView> sandwichText = null;
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
        mRecommendSandwich = FirebaseDatabase.getInstance().getReference("subway/recommend");
        mEvent = FirebaseDatabase.getInstance().getReference("subway/event");
        eventImage = new ArrayList<ImageView>();
        sandwichImage = new ArrayList<ImageView>();
        sandwichText = new ArrayList<TextView>();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ImageView titleImage = (ImageView) view.findViewById(R.id.titleImage);
        ImageView recommend1 = (ImageView) view.findViewById(R.id.recommend1);
        ImageView recommend2 = (ImageView) view.findViewById(R.id.recommend2);
        ImageView recommend3 = (ImageView) view.findViewById(R.id.recommend3);
        ImageView recommend4 = (ImageView) view.findViewById(R.id.recommend4);

        final ImageView event1 = (ImageView) view.findViewById(R.id.event1);
        ImageView event2 = (ImageView) view.findViewById(R.id.event2);
        ImageView event3 = (ImageView) view.findViewById(R.id.event3);

        TextView recommendText1 = (TextView) view.findViewById(R.id.text1);
        TextView recommendText2 = (TextView) view.findViewById(R.id.text2);
        TextView recommendText3 = (TextView) view.findViewById(R.id.text3);
        TextView recommendText4 = (TextView) view.findViewById(R.id.text4);

        eventImage.add(event1); eventImage.add(event2); eventImage.add(event3);
        sandwichImage.add(recommend1); sandwichImage.add(recommend2); sandwichImage.add(recommend3); sandwichImage.add(recommend4);
        sandwichText.add(recommendText1); sandwichText.add(recommendText2); sandwichText.add(recommendText3); sandwichText.add(recommendText4);

        mRecommendSandwich.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                i=0;
                for (DataSnapshot recommend : dataSnapshot.getChildren()) { //모든 유저 정보 가져오기
                    Log.e(TAG,recommend.getValue().toString());
                    //추천샌드위치 이미지
                    Glide.with(getActivity())
                            .load(recommend.getValue().toString())
                            .override(130,80)
                            .into(sandwichImage.get(i));
                    sandwichText.get(i).setText(recommend.getKey());
                    i++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        mEvent.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                j=0;
                for (DataSnapshot event : dataSnapshot.getChildren()) { //모든 유저 정보 가져오기
                    //추천샌드위치 이미지
                    Glide.with(getActivity())
                            .load(event.getValue().toString())
                            .override(130,80)
                            .into(eventImage.get(j));
                    j++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        Glide.with(this) //타이틀 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Ftitle.png?alt=media&token=357cf5d2-ed57-47d5-af1b-d54358cc4a67")
                .override(430,320)
                .into(titleImage);

        return view;
    }

    @Override
    public String getTitle() {
        return "Home";
    }
}
