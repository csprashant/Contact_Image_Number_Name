package com.example.readcontancts_number_name_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.readcontancts_number_name_image.adaptor.RecyclerPhoneAdapter;
import com.example.readcontancts_number_name_image.model.PhoneContacts;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn;
    RecyclerView view;
    private static final Integer LOAD_CODE=101;
    List<PhoneContacts> phoneContactsList=new ArrayList<PhoneContacts>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        view=findViewById(R.id.rView);
    }
    public void getContact(View view){
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS)== PackageManager.PERMISSION_GRANTED)
            loadContacts();
        else
            ActivityCompat.requestPermissions(this,new String [] {Manifest.permission.READ_CONTACTS},LOAD_CODE);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==LOAD_CODE && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED)
            loadContacts();
    }
    public void loadContacts() {
        Cursor cur =getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone.CONTACT_ID},null,null,null,null);
        if(cur!=null && cur.getCount()>0){
            while(cur.moveToNext()){
                PhoneContacts phone=new PhoneContacts();
                phone.setName(cur.getString(0));
                phone.setPhoneNumber(cur.getString(1));
                long id=cur.getLong(2);
                Uri imageuri=Uri.withAppendedPath( ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI,id), ContactsContract.Contacts.Photo.CONTENT_DIRECTORY);
                phone.setImageUrl(imageuri);
                phoneContactsList.add(phone);
            }
        }
    view.setAdapter(new RecyclerPhoneAdapter(phoneContactsList));
    }

}