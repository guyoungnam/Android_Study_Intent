package org.techtown.sampleintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101; //새 액티비티를 띄울 때 보낼 요청 코드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent,REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 첫번째 파라미터 액티비티로부터 응답을 받은 것인지 구분할 수 있다.
        // 두붠째 파라미터 새 액티비티로 부터 전달 된 응답 코드, 처리한 결과가 정상인지 아닌지 구분
        // 세번째 파라미터 새 액티비티로 전달 받은 인텐트

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_MENU){
            Toast.makeText(getApplicationContext(),"onAcitivityResult 메서드 호출됨. 요청 코드:"+requestCode+
                    ", 결과코드"+ resultCode, Toast.LENGTH_LONG).show();

            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(getApplicationContext(),"응답으로 전달된 name:"+name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
