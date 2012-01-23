package com.alliecurry.guitarChords;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuitarChordsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        createListeners();
    }
    
    private void createListeners() {
    	//Import Buttons
    	Button b_learn = (Button) findViewById(R.id.button_learn);
    	Button b_listen = (Button) findViewById(R.id.button_listen);
    	
    	//Go to LearnActivity
    	b_learn.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		Intent i = new Intent(getApplicationContext(), LearnActivity.class);
	    		startActivity(i);
	    	}
    	});
    	
    	//Go to ListenActivity
    	b_listen.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    	}
    	});
    }
}