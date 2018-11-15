package kr.hs.emirim.parksodam.chokchoksandwich.User;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.regex.Pattern;

import kr.hs.emirim.parksodam.chokchoksandwich.BarActivity;
import kr.hs.emirim.parksodam.chokchoksandwich.R;

import static android.widget.Toast.makeText;
import static kr.hs.emirim.parksodam.chokchoksandwich.R.drawable.user;
import static kr.hs.emirim.parksodam.chokchoksandwich.R.id.userID;
import static kr.hs.emirim.parksodam.chokchoksandwich.R.id.userName;

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference mUserDatabase;
    EditText userID;
    EditText userPW;
    int check=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView logoImage = (ImageView) findViewById(R.id.logoImage);
        ImageView titleImage = (ImageView) findViewById(R.id.titleImage);
        ImageView login_btn = (ImageView) findViewById(R.id.login_btn);
        TextView register_text = (TextView) findViewById(R.id.register);

        userID = (EditText) findViewById(R.id.userID);
        userPW = (EditText) findViewById(R.id.userPW);
        //파이어베이스 데이타베이스 객체 참조
        mUserDatabase = FirebaseDatabase.getInstance().getReference("users");

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

        register_text.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent register_intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(register_intent);
            }
        });

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 공백체크
                if (userID.getText().toString().equals("")) {
                    makeText(getApplicationContext(), "아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    userID.requestFocus();
                    return;
                } else {
                    if(!Pattern.matches("^[a-zA-Z]+[a-zA-Z0-9]{6,16}$", userID.getText().toString())){
                        Toast.makeText(getApplicationContext(),"아이디 형식을 지켜주세요.(6자이상 16자 이내, 영어+숫자 특수문자 제외)",Toast.LENGTH_SHORT).show();
                        userID.requestFocus();
                        return;
                    }
                }
                if (userPW.getText().toString().equals("")) {
                    makeText(getApplicationContext(), "비밀번호를 입력해주세요!", Toast.LENGTH_SHORT).show();
                    userPW.requestFocus();
                    return;
                }
                else {
                    if(!Pattern.matches("^[a-zA-Z]+[a-zA-Z0-9]{8,20}$", userID.getText().toString())){
                        Toast.makeText(getApplicationContext(),"비밀번호 형식을 지켜주세요.(8자이상 20자 이하, 영어+숫자 특수문자 제외)",Toast.LENGTH_SHORT).show();
                        userID.requestFocus();
                        return;
                    }
                }
                loginUser(userID.getText().toString(), userPW.getText().toString());
            }
        });
    }
    //로그인 함수
    private void loginUser(final String id, final String pw) {

        mUserDatabase.addValueEventListener(new ValueEventListener() {
            Toast toast;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userid : dataSnapshot.getChildren()) { //모든 유저 정보 가져오기
                    if (userid.getKey().equals(id)) { //회원정보가 있으면 로그인 토스트 띄우고 홈화면으로 이동
                        Toast toast = Toast.makeText(getApplicationContext(), "로그인!", Toast.LENGTH_SHORT);
                        Intent start_intent = new Intent(getApplicationContext(), BarActivity.class);
                        startActivity(start_intent);
                        if(check==0){ // 회원정보가 있을 때만 토스트 띄워주기
                            toast.show();
                        } else toast.cancel();

                        return;
                    }
                }
                toast = Toast.makeText(getApplicationContext(), "회원정보가 없습니다! 다시 로그인해주세요!", Toast.LENGTH_SHORT);
                toast.show();
                check++;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
