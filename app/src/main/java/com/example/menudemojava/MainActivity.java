package com.example.menudemojava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Элементы экрана
    TextView tv;
    CheckBox chb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим элементы
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    // обновление меню
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
        // пункты меню с ID группы = 1 видны, если в CheckBox стоит галка
        menu.setGroupVisible(R.id.group1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    // обработка нажатий
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        StringBuilder sb = new StringBuilder();

        // Выведем в TextView информацию о нажатом пункте меню
        sb.append("Item Menu");
        sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
        sb.append("\r\n order: " + String.valueOf(item.getOrder()));
        sb.append("\r\n title: " + item.getTitle());
        tv.setText(sb.toString());


        String msg = "";
        switch (item.getItemId()) {
            case R.id.menu_Dugushkina:
                msg = "name clicked";
                break;
            case R.id.menu_Help:
                msg = "help clicked";
                break;
            case R.id.menu_add:
                item.setChecked(true);
                msg = "add clicked";
                break;
            case R.id.menu_edit:
                item.setChecked(true);
                msg = "edit clicked";
                break;
            case R.id.menu_delete:
                msg = "delete clicked";
                break;
            case R.id.menu_copy:
                msg = "copy clicked";
                break;
            case R.id.menu_paste:
                msg = "paste clicked";
                break;
            case R.id.menu_exit:
                msg = "exit clicked";
                finish();
            default:
                super.onOptionsItemSelected(item);
        }
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        return true;
    }

}
