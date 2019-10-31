package com.example.program1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //登录框的按钮操作
        Button login = (Button) this.findViewById(R.id.Button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View layoutView = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(layoutView);
                builder.setTitle("Login");
                builder.setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText username = layoutView.findViewById(R.id.account);
                        EditText password = layoutView.findViewById(R.id.password);
                        if(username.getText().toString().equals("abc")  &&
                            password.getText().toString().equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功！",
                                    Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(MainActivity.this,
                                    "输入错误！", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(MainActivity.this,"点击了取消按钮",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


        //提示框的按钮操作
        Button btn = (Button) this.findViewById(R.id.Button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这只是一个普通的对话框").setTitle("Title!");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了确认键",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了取消键",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略键",
                                Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });


    }
}
