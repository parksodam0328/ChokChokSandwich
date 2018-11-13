package kr.hs.emirim.parksodam.chokchoksandwich.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import kr.hs.emirim.parksodam.chokchoksandwich.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage);
        ImageView login_btn = (ImageView) findViewById(R.id.login_btn);
        TextView register_text = (TextView) findViewById(R.id.register);

        Glide.with(this) //로고 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Flogo.jpg?alt=media&token=51133882-f4f8-469f-8774-480ef5f95103")
                .override(400,290)
                .into(logoImage);

        Glide.with(this) //타이틀 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/logo%2Ftitle.png?alt=media&token=357cf5d2-ed57-47d5-af1b-d54358cc4a67")
                .override(360,250)
                .into(titleImage);

        Glide.with(this) //회원가입 버튼 이미지
                .load("https://firebasestorage.googleapis.com/v0/b/chokchoksandwich-246bf.appspot.com/o/images%2Flogin_btn.png?alt=media&token=6654ab6a-ba8b-4627-b1d2-842f55359186")
                .override(730, 150)
                .into(login_btn);

        register_text.setOnClickListener(new TextView.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register_intent);
            }
        });
    }
}
