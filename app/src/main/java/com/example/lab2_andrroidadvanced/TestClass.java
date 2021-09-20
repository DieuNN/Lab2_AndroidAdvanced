package com.example.lab2_andrroidadvanced;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_andrroidadvanced.activity.Bai1;
import com.example.lab2_andrroidadvanced.broadcast.BroadcastBai1;

public class TestClass extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(this, BroadcastBai1.class);
    }
}
