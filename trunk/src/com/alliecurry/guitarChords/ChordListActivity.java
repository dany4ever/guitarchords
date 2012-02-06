package com.alliecurry.guitarChords;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

public class ChordListActivity extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);
        
        Bundle extras = getIntent().getExtras();
        int mode = extras.getInt("mode");
        
        setNavigation(mode);	//Update navigation buttons
        
        switch (mode) {
        	case 1:		setListenMode();	break;	//User has selected "Listen" mode
        	default:	setLearnMode(); 	break;	//User has selected "Learn" mode
        }
        
    }
    
    private void setNavigation(int mode) {
    	Button b_listen 	= (Button) findViewById(R.id.button_listen2);
    	Button b_learn		= (Button) findViewById(R.id.button_learn2);
    	
    	//Set Font to Helvetica Bold
    	b_learn.setTypeface(GuitarChordsActivity.fontHelveticaBold);
    	b_listen.setTypeface(GuitarChordsActivity.fontHelveticaBold);
    	
    	b_listen.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){	
	        	setListenMode(); //Switch to "Listen" mode
	    	}
    	});
    	
    	b_learn.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	        	setLearnMode(); //Switch to "Learn" mode
	    	}
    	});
    }
    
    private void setLearnMode() {
    	Button b_listen 	= (Button) findViewById(R.id.button_listen2);
    	Button b_learn		= (Button) findViewById(R.id.button_learn2);
		b_listen.setBackgroundResource(R.drawable.button_learn);	
    	b_learn.setBackgroundResource(R.drawable.button_learn2); //"Selected" button
    	
    	makeChordListVisible();
    	
    	//Import Buttons (one for each chord) and Set Listeners
    	Button chordButton;	
    	
    	chordButton = (Button) findViewById(R.id.button_A);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_A7);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_Am);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_B);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_B7);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_C);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_C7);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_D);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_D7);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_Dm);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_E);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_E7);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_Em);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_F);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_G);
    	setDiagramListener(chordButton);
    	
    	chordButton = (Button) findViewById(R.id.button_G7);
    	setDiagramListener(chordButton);
    }
    
    private void setListenMode() {
    	Button b_listen 	= (Button) findViewById(R.id.button_listen2);
    	Button b_learn		= (Button) findViewById(R.id.button_learn2);
		b_listen.setBackgroundResource(R.drawable.button_learn2);	//"Selected" button
    	b_learn.setBackgroundResource(R.drawable.button_learn);
    	
    	makeChordListVisible();
    	
    	//Import Buttons (one for each chord) and Set Listeners
    	Button chordButton;	
    	
    	chordButton = (Button) findViewById(R.id.button_A);
    	setSoundListener(chordButton, R.raw.sound_a);
    	
    	chordButton = (Button) findViewById(R.id.button_A7);
    	setSoundListener(chordButton, R.raw.sound_a7);
    	
    	chordButton = (Button) findViewById(R.id.button_Am);
    	setSoundListener(chordButton, R.raw.sound_am);
    	
    	chordButton = (Button) findViewById(R.id.button_B);
    	setSoundListener(chordButton, R.raw.sound_b);
    	
    	chordButton = (Button) findViewById(R.id.button_B7);
    	setSoundListener(chordButton, R.raw.sound_b7);
    	
    	chordButton = (Button) findViewById(R.id.button_C);
    	setSoundListener(chordButton, R.raw.sound_c);
    	
    	chordButton = (Button) findViewById(R.id.button_C7);
    	setSoundListener(chordButton, R.raw.sound_c7);
    	
    	chordButton = (Button) findViewById(R.id.button_D);
    	setSoundListener(chordButton, R.raw.sound_d);
    	
    	chordButton = (Button) findViewById(R.id.button_D7);
    	setSoundListener(chordButton, R.raw.sound_d7);
    	
    	chordButton = (Button) findViewById(R.id.button_Dm);
    	setSoundListener(chordButton, R.raw.sound_dm);
    	
    	chordButton = (Button) findViewById(R.id.button_E);
    	setSoundListener(chordButton, R.raw.sound_e);
    	
    	chordButton = (Button) findViewById(R.id.button_E7);
    	setSoundListener(chordButton, R.raw.sound_e7);
    	
    	chordButton = (Button) findViewById(R.id.button_Em);
    	setSoundListener(chordButton, R.raw.sound_em);
    	
    	chordButton = (Button) findViewById(R.id.button_F);
    	setSoundListener(chordButton, R.raw.sound_f);
    	
    	chordButton = (Button) findViewById(R.id.button_G);
    	setSoundListener(chordButton, R.raw.sound_g);
    	
    	chordButton = (Button) findViewById(R.id.button_G7);
    	setSoundListener(chordButton, R.raw.sound_g7);
    }
    
    private void setDiagramListener(Button b) {
    	final String name = (String) b.getText();
    	b.setTypeface(GuitarChordsActivity.fontHelvetica);

    	b.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		setDiagramImage(name);
	    		
	    		Button b_listen 	= (Button) findViewById(R.id.button_listen2);
	        	Button b_learn		= (Button) findViewById(R.id.button_learn2);

	    		b_listen.setBackgroundResource(R.drawable.button_learn);	
	        	b_learn.setBackgroundResource(R.drawable.button_learn);
	    	}
    	});
    }
    
    private void setSoundListener(Button b, final int id) {
    	b.setTypeface(GuitarChordsActivity.fontHelvetica);
    	
    	b.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		MediaPlayer mp = MediaPlayer.create(getBaseContext(), id);
                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {
 
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
	    	}
    	});
    }
    
    private void setDiagramImage(String chordName) {
    	if(chordName == null)
    		return;
    	
    	//Set background
    	ImageView diagramBack = (ImageView) findViewById(R.id.diagramBackground);
    	diagramBack.setImageResource(R.drawable.background_paper);
    	
    	TableLayout chordTable = (TableLayout) findViewById(R.id.chordTable);
    	chordTable.setBackgroundDrawable(null);
    	
    	ImageView diagram = (ImageView) findViewById(R.id.chordDiagram);
    	final int soundID;
    	
    	if(chordName.equals("A")) {
    		diagram.setImageResource(R.drawable.chord_a);
    		soundID = R.raw.sound_a;	}
    	else if(chordName.equals("A7")) {
    		diagram.setImageResource(R.drawable.chord_a7);
    		soundID = R.raw.sound_a7;	}
    	else if(chordName.equals("Am")) {
    		diagram.setImageResource(R.drawable.chord_am);
    		soundID = R.raw.sound_am;	}
    	else if(chordName.equals("B")) {
    		diagram.setImageResource(R.drawable.chord_b);
    		soundID = R.raw.sound_b;	}
    	
    	else if(chordName.equals("B7")) {
    		diagram.setImageResource(R.drawable.chord_b7);
    		soundID = R.raw.sound_b7;	}
    	else if(chordName.equals("C")) {
    		diagram.setImageResource(R.drawable.chord_c);
    		soundID = R.raw.sound_c;	}
    	else if(chordName.equals("C7")) {
    		diagram.setImageResource(R.drawable.chord_c7);
    		soundID = R.raw.sound_c7;	}
    	else if(chordName.equals("D")) {
    		diagram.setImageResource(R.drawable.chord_d);
    		soundID = R.raw.sound_d;	}
    	
    	else if(chordName.equals("D7")) {
    		diagram.setImageResource(R.drawable.chord_d7);
    		soundID = R.raw.sound_d7;	}
    	else if(chordName.equals("Dm")) {
    		diagram.setImageResource(R.drawable.chord_dm);
    		soundID = R.raw.sound_dm;	}
    	else if(chordName.equals("E")) {
    		diagram.setImageResource(R.drawable.chord_e);
    		soundID = R.raw.sound_e;	}
    	else if(chordName.equals("E7")) {
    		diagram.setImageResource(R.drawable.chord_e7);
    		soundID = R.raw.sound_e7;	}
    	
    	else if(chordName.equals("Em")) {
    		diagram.setImageResource(R.drawable.chord_em);
    		soundID = R.raw.sound_em;	}
    	else if(chordName.equals("F")) {
    		diagram.setImageResource(R.drawable.chord_f);
    		soundID = R.raw.sound_f;	}
    	else if(chordName.equals("G")) {
    		diagram.setImageResource(R.drawable.chord_g);
    		soundID = R.raw.sound_g;	}
    	else { //G7
    		diagram.setImageResource(R.drawable.chord_g7);
    		soundID = R.raw.sound_g7;	}
    	
    	diagram.setOnTouchListener(new OnTouchListener() {	 
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                MediaPlayer mp = MediaPlayer.create(getBaseContext(),
                        soundID);
                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {
 
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
            };
            return true;
        }});
    }

    
    private void makeChordListVisible() {
    	ImageView diagram = (ImageView) findViewById(R.id.chordDiagram);
    	ImageView diagramBack = (ImageView) findViewById(R.id.diagramBackground);
    	
    	diagram.setImageDrawable(null);
    	diagramBack.setImageDrawable(null);
    	
    	TableLayout chordTable = (TableLayout) findViewById(R.id.chordTable);
    	chordTable.setBackgroundResource(R.drawable.background_paper);
    }
}
