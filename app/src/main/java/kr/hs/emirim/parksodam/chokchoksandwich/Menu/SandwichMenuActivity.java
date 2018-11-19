package kr.hs.emirim.parksodam.chokchoksandwich.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import kr.hs.emirim.parksodam.chokchoksandwich.Adapter.SandwichAdapter;
import kr.hs.emirim.parksodam.chokchoksandwich.Adapter.SandwichItem;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class SandwichMenuActivity extends AppCompatActivity {
    private ImageView backImage;
    RecyclerView mRecyclerView;
    LinearLayoutManager mLayoutManager;
    SandwichAdapter mSandwichAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwich_menu);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ArrayList<SandwichItem> sandwichItems = new ArrayList<>();
        sandwichItems.add(new SandwichItem("테스트","300원","400원"));
        
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        mSandwichAdapter = new SandwichAdapter(sandwichItems);
        mRecyclerView.setAdapter(mSandwichAdapter);
        backImage = (ImageView) findViewById(R.id.back);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
