package space.vtility.blogger;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;



public class AddActivity extends AppCompatActivity {

    private EditText editText;
    private EditText name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editText = (EditText) findViewById(R.id.editText);
        name2 = (EditText) findViewById(R.id.name);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               switch (view.getId()){
                   case R.id.fab:
                       String inputText = editText.getText().toString();
                       String name;
                       SharedPreferences numList = getSharedPreferences("list",MODE_PRIVATE);
                       int num = numList.getInt("num",MODE_PRIVATE);
                       num ++;
                       name = num + "";
                       SharedPreferences.Editor editor = getSharedPreferences(name,MODE_PRIVATE).edit();
                       editor.putString("domain",inputText);
                       editor.apply();
                       SharedPreferences.Editor numEdit = getSharedPreferences("list",MODE_PRIVATE).edit();
                       numEdit.putInt("num",num);
                       numEdit.apply();
                       Intent intent = new Intent(AddActivity.this, MainActivity.class);
                       startActivity(intent);
                       break;
                   default:
                       break;



        }
    };



});}}
