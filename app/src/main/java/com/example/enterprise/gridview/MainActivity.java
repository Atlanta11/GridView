package com.example.enterprise.gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//Initialize a String Array
        final String[] numbersArray = new String[]{
                "One","Two","Three","Four",
                "Five","Six","Seven","Eight",
                "Nine","Ten","Eleven","Twelve",
                "Thirteen"
        };

        //Get widgets reference from XML layout
        GridView gView = (GridView) findViewById(R.id.gv);

        //Initialize an ArrayAdapter and data bind with a String Array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1,numbersArray);

        //Data bind GridView with ArrayAdapter
        gView.setAdapter(adapter);

        //Set an Item Click Listener for GridView items
        gView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            //onItemClick() callback method
            public void onItemClick(AdapterView<?> parent, View v, int position, long id){
                //Get GridView clicked item's corresponded Array element value
                String clickedItemValue = Arrays.asList(numbersArray).get(position);

                //Generate a Toast message
                String toastMessage = "Position : "+position + " || Value : " + clickedItemValue;

                //Do something in response to the GridView item click
                Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
