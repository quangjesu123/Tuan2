package com.example.tuan2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nhapten;
    EditText cmnd;
    RadioGroup bangcap;
    RadioButton trungcap;
    RadioButton caodang;
    RadioButton daihoc;
    CheckBox docbao;
    CheckBox docsach;
    CheckBox doccode;
    EditText thongtin;
    Button gui;
    String bangcapp="";
    String sothich="";
    String s1="";
    String s2="";
    String s3="";
    String sothich1="";
    String c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bangcap = findViewById(R.id.rg_bangcap);
        
        nhapten = findViewById(R.id.et_nhapten);
        cmnd = findViewById(R.id.et_cmnd);
        trungcap = findViewById(R.id.bt_trungcap);
        bangcap.check(R.id.bt_trungcap);
        caodang = findViewById(R.id.bt_caodang);
        daihoc = findViewById(R.id.bt_daihoc);
        docbao = findViewById(R.id.cb_db);
        docsach = findViewById(R.id.cb_ds);
        doccode = findViewById(R.id.cb_dc);
        thongtin=findViewById(R.id.tv_nhapthongtin);

        RadioButton radioButton = findViewById(R.id.bt_trungcap);
        bangcapp = radioButton.getText().toString();

        gui = findViewById(R.id.bt_gui);
        nhapten.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (nhapten.getText().toString().length() <= 3) {
                    Toast.makeText(MainActivity.this, "Phải nhập tên trên 3 ký tự", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cmnd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (cmnd.getText().toString().length() < 9) {
                    Toast.makeText(MainActivity.this, "CMND phải nhập đủ 9 số", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bangcap.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            // bắt sự kiện thay đổi trong groupradio lấy sự kiện con.

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                bangcapp = radioButton.getText().toString();
            }
        });

        docbao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              if(isChecked){
                  s1=docbao.getText().toString()+"\n";

              }else s1="";
            }
        });
        docsach.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    s2=docsach.getText().toString()+"\n";

                }else s2="";

            }
        });
        doccode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    s3=doccode.getText().toString()+"\n";

                }else s3="";


            }
        });
        sothich=s1=s2=s3;
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nhapten.getText().toString().equals("") && cmnd.getText().toString().equals("")&&sothich.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhập đủ thông tin", Toast.LENGTH_SHORT).show();

                }
                if (!nhapten.getText().toString().equals("")&&cmnd.getText().toString().equals("")&&s1.isEmpty()&&s2.isEmpty()&&s3.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Nhập CMND", Toast.LENGTH_SHORT).show();

                }
                if (!nhapten.getText().toString().equals("")&&!cmnd.getText().toString().equals("")&&s1.isEmpty()&&s2.isEmpty()&&s3.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Sở thích trống", Toast.LENGTH_SHORT).show();

                }



                if (!nhapten.getText().toString().equals("")&&!cmnd.getText().toString().equals("")&&(!s1.isEmpty()||!s2.isEmpty()||!s3.isEmpty())) {
                    String str = nhapten.getText().toString() + "\n" + cmnd.getText().toString() + "\n"
                            + bangcapp +"\n"+s1+s2+s3
                            + "-------------------\n"
                            +"Thông tin bổ sung:\n "
                            + thongtin.getText().toString()
                            + "\n-------------------";

//                    Log.d("Mesage", str);
//                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();

                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Thông tin");
                    alert.setMessage(str);
                    final TextView input = new TextView(MainActivity.this);
                    alert.setView(input);

//                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int whichButton) {
//                        input.setText("hi");
//                        // Do something with value!
//                    }
//                });

                    alert.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            // Canceled.
                        }
                    });
                    alert.show();
                }
            }
        });
//        gui.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                if(nhapten.getText().toString().length()<=3){
////                    Toast.makeText(MainActivity.this, "Phải nhập tên trên 3 ký tự", Toast.LENGTH_SHORT).show();
////                }
////                if(cmnd.getText().toString().length()<9){
////                    Toast.makeText(MainActivity.this, "CMND phải nhập đủ 9 số", Toast.LENGTH_SHORT).show();
////                }
//
//            }
//        });
//
//
    }
}
