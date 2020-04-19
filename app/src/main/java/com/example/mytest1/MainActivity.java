package com.example.mytest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    AutoCompleteTextView selectedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the AutoCompleteTextView in the layout
        final AutoCompleteTextView selectionsText = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        String[] rotemTextOptions = getResources().getStringArray(R.array.selection_options);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, rotemTextOptions);
        selectionsText.setThreshold(1);
        selectionsText.setAdapter(adapter);

        btn = findViewById(R.id.buttonSend);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectionMade = selectionsText.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("myValue", selectionMade);
                startActivity(intent);
                finish();
            }
        });
    }
}
