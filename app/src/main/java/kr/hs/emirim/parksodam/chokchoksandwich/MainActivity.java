package kr.hs.emirim.parksodam.chokchoksandwich;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import kr.hs.emirim.parksodam.chokchoksandwich.User.LoginActivity;
import kr.hs.emirim.parksodam.chokchoksandwich.User.RegisterActivity;


public class MainActivity extends AppCompatActivity {
    SignInButton googleLogin;
    private static final int RC_SIGN_IN = 1000;
    private FirebaseAuth mAuth;
    private GoogleApiClient mGoogleApiClient;
    final public static String TAG = "촉촉샌드위치:LoginAct";
    String uId;
    SharedPreferences sp;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage);
        ImageButton login_btn = (ImageButton) findViewById(R.id.login_btn);
        ImageButton register_btn = (ImageButton) findViewById(R.id.register_btn);

        Glide.with(this) //로고 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Flogo.jpg?alt=media&token=51133882-f4f8-469f-8774-480ef5f95103")
                .override(350, 450)
                .into(logoImage);

        Glide.with(this) //타이틀 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Ftitle.png?alt=media&token=357cf5d2-ed57-47d5-af1b-d54358cc4a67")
                .override(360, 250)
                .into(titleImage);

        Glide.with(this) //로그인 버튼 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/images%2Flogin_btn.png?alt=media&token=6654ab6a-ba8b-4627-b1d2-842f55359186")
                .override(650, 150)
                .into(login_btn);

        Glide.with(this) //회원가입 버튼 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/images%2Fregister_btn.png?alt=media&token=47b0c7fc-d5c1-4125-86e3-707489aca086")
                .override(650, 150)
                .into(register_btn);

        //로그인 이미지 클릭시 로그인 화면으로 이동
        login_btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login_intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login_intent);
            }
        });

        //회원가입 이미지 클릭시 회원가입 화면으로 이동
        register_btn.setOnClickListener(new ImageButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register_intent);
            }
        });
    }
}
