package com.example.apptoancau;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView txtThongTin;
    Button btnXacNhan;
    EditText edtTen, edtEmail, edtSDT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        AnhXa();

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten = edtTen.getText().toString();
                String email = edtEmail.getText().toString();
                String soDT = edtSDT.getText().toString();

                if (isValidEmail(email) && isValidPhoneNumber(soDT)) {
                    String textChaoBan = getResources().getString(R.string.text_Chao);
                    String textEmail = getResources().getString(R.string.text_Email);
                    String textSoDT = getResources().getString(R.string.text_SoDT);

                    txtThongTin.setText(textChaoBan + ":" + hoten + "\n" + textEmail + ":" + email + "\n" + textSoDT + ":" + soDT);
                }else {
                    Toast.makeText(MainActivity.this, "Email hoặc số điện thoại không đúng định dạng", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void AnhXa() {
        btnXacNhan = (Button) findViewById(R.id.btnXacNhan);
        txtThongTin = (TextView) findViewById(R.id.textViewThongTin);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtTen = (EditText) findViewById(R.id.edtTen);
        edtSDT = (EditText) findViewById(R.id.edtSDT);
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String phonePattern = "^[0-9]{10,11}$";
        Pattern pattern = Pattern.compile(phonePattern);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

}