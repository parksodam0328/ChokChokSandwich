package kr.hs.emirim.parksodam.chokchoksandwich;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import kr.hs.emirim.parksodam.chokchoksandwich.Adapter.FragmentPagerAdapter;
import kr.hs.emirim.parksodam.chokchoksandwich.Favorite.FavoriteFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.Home.HomeFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.Menu.MenuFragment;
import kr.hs.emirim.parksodam.chokchoksandwich.Profile.ProfileFragment;


public class BarActivity extends AppCompatActivity {

    public ViewPager vp;
    public TabLayout layout;
    private String TAG ="myreceiver : ";
    private Toolbar toolbar;
    private TextView myTitleText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        //툴바 설정
        //FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());


        vp = (ViewPager) findViewById(R.id.vp_main);
        setupViewPager(vp);
        layout = (TabLayout) findViewById(R.id.tl_main);
        layout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF")); // 밑줄색
        vp.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(layout));

        layout.setupWithViewPager(vp);

        for (int i = 0; i < layout.getTabCount(); i++) {
                if(i==0) {
                    layout.getTabAt(i).setIcon(R.drawable.home).setText("home");
                }
            else if(i==1) {
                    layout.getTabAt(i).setIcon(R.drawable.menu_off).setText("menu");
                }
            else if(i==2) {
                    layout.getTabAt(i).setIcon(R.drawable.star_off).setText("favorite");
                }
                else if(i==3) {
                    layout.getTabAt(i).setIcon(R.drawable.user_off).setText("profile");
                }
        }
        layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if(tab.getPosition()==0) {
                    tab.setIcon(R.drawable.home);
                    layout.setTabTextColors(Color.parseColor("#666666"), Color.parseColor("#91DC5A"));
                }

                else if(tab.getPosition()==1) {
                    tab.setIcon(R.drawable.menu);
                    layout.setTabTextColors(Color.parseColor("#666666"), Color.parseColor("#91DC5A"));
                }
                else if(tab.getPosition()==2) {
                    tab.setIcon(R.drawable.star);
                    layout.setTabTextColors(Color.parseColor("#666666"), Color.parseColor("#91DC5A"));
                }
                else if(tab.getPosition()==3) {
                    tab.setIcon(R.drawable.user);
                    layout.setTabTextColors(Color.parseColor("#666666"), Color.parseColor("#91DC5A"));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if(tab.getPosition()==0) {
                    tab.setIcon(R.drawable.home_off);
                    layout.setTabTextColors(Color.parseColor("#91DC5A"), Color.parseColor("#666666"));
                }
                else if(tab.getPosition()==1) {
                    tab.setIcon(R.drawable.menu_off);
                    layout.setTabTextColors(Color.parseColor("#91DC5A"), Color.parseColor("#666666"));
                }
                else if(tab.getPosition()==2) {
                    tab.setIcon(R.drawable.star_off);
                    layout.setTabTextColors(Color.parseColor("#91DC5A"), Color.parseColor("#666666"));
                }
                else if(tab.getPosition()==3) {
                    tab.setIcon(R.drawable.user_off);
                    layout.setTabTextColors(Color.parseColor("#91DC5A"), Color.parseColor("#666666"));
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition() != vp.getCurrentItem()) {
                    vp.setCurrentItem(tab.getPosition());
                }
            }
        });


    }

    private void setupViewPager(ViewPager vp) {
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomeFragment(), "home");
        adapter.addFragment(new MenuFragment(), "menu");
        adapter.addFragment(new FavoriteFragment(), "favorite");
        adapter.addFragment(new ProfileFragment(), "profile");
        vp.setAdapter(adapter);
    }
}
