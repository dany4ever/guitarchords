package com.alliecurry.guitarChords;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuitarChordsActivity extends Activity {
	
	public static Typeface fontHelvetica;
	public static Typeface fontHelveticaBold;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        fontHelvetica = Typeface.createFromAsset(getAssets(), "HelveticaNeueLT.ttf"); 
        fontHelveticaBold = Typeface.createFromAsset(getAssets(), "HelveticaNeueLTBold.ttf"); 
        createListeners();
    }
    
    private void createListeners() {
    	//Import Buttons
    	Button b_learn = (Button) findViewById(R.id.button_learn);
    	Button b_listen = (Button) findViewById(R.id.button_listen);
    	b_learn.setTypeface(fontHelveticaBold);
    	b_listen.setTypeface(fontHelveticaBold);
    	
    	//Go to LearnActivity
    	b_learn.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), ChordListActivity.class);
	    		i.putExtra("mode", 0);
	    		startActivity(i);
	    	}
    	});
    	
    	//Go to ListenActivity
    	b_listen.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), ChordListActivity.class);
	    		i.putExtra("mode", 1);
	    		startActivity(i);
	    	}
    	});
    }
}