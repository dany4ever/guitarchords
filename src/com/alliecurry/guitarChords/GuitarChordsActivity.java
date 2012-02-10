/* GUITAR CHORDS
 * 		Android Application
 * 
 * Code: Allie Curry
 * Graphics: David Seitz
 * 
 * v. 1.0.0
 */

package com.alliecurry.guitarChords;

import android.app.Activity;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;

public class GuitarChordsActivity extends Activity {
	
	private static Typeface fontHelvetica;
	private static Typeface fontHelveticaBold;
	
	//IDs corresponding to the 16 chords (buttons)
	private int[] ID_BUTTON = {R.id.button_A, R.id.button_A7, R.id.button_Am, R.id.button_B,
				R.id.button_B7, R.id.button_C, R.id.button_C7, R.id.button_D,
				R.id.button_D7, R.id.button_Dm, R.id.button_E, R.id.button_E7,
				R.id.button_Em, R.id.button_F, R.id.button_G, R.id.button_G7 };
	
	//IDs corresponding to the 16 chords (sounds)
	private int[] ID_SOUND = {R.raw.sound_a, R.raw.sound_a7, R.raw.sound_am, R.raw.sound_b,
				R.raw.sound_b7, R.raw.sound_c, R.raw.sound_c7, R.raw.sound_d,
				R.raw.sound_d7, R.raw.sound_dm, R.raw.sound_e, R.raw.sound_e7,
				R.raw.sound_em, R.raw.sound_f, R.raw.sound_g, R.raw.sound_g7 };
	
	//IDs corresponding to the 16 chords (diagrams)
	private int[] ID_DIAGRAM = {R.drawable.chord_a, R.drawable.chord_a7, R.drawable.chord_am, R.drawable.chord_b,
			R.drawable.chord_b7, R.drawable.chord_c, R.drawable.chord_c7, R.drawable.chord_d,
			R.drawable.chord_d7, R.drawable.chord_dm, R.drawable.chord_e, R.drawable.chord_e7,
			R.drawable.chord_em, R.drawable.chord_f, R.drawable.chord_g, R.drawable.chord_g7 };

	private Button LEARN, LISTEN;
	private boolean TITLE_HIDE = false;	//True when title image is hidden.
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //Initialize Fonts
        fontHelvetica = Typeface.createFromAsset(getAssets(), "HelveticaNeueLT.ttf"); 
        fontHelveticaBold = Typeface.createFromAsset(getAssets(), "HelveticaNeueLTBold.ttf"); 
        
        //Initialize main two Navigation Buttons, Set their font, and Listeners
        LEARN = (Button) findViewById(R.id.button_learn);
        	LEARN.setTypeface(fontHelveticaBold);
        LISTEN = (Button) findViewById(R.id.button_listen);
        	LISTEN.setTypeface(fontHelveticaBold);
        	
        createListeners();
    }
    
    private void createListeners() {
    	//Go to Learn Mode
    	LEARN.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		hideTitle();
	    		setLearnMode();
	    	}
    	});
    	
    	//Go to Listen Mode
    	LISTEN.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		hideTitle();
	    		setListenMode();
	    	}
    	});
    }
    
    private void setLearnMode() {
    	LISTEN.setBackgroundResource(R.drawable.button_deselected);	
    	LEARN.setBackgroundResource(R.drawable.button_selected); //"Selected" button
    	
    	makeChordListVisible();
    	
    	//Import Buttons (one for each chord) and Set Listeners
    	Button chordButton;	
    	
    	for(int x=0; x<ID_BUTTON.length; ++x) {
    		chordButton = (Button) findViewById(ID_BUTTON[x]);
        	setDiagramListener(chordButton, x);
    	}
    }
    
    private void setListenMode() {
    	LISTEN.setBackgroundResource(R.drawable.button_selected);	//"Selected" button
    	LEARN.setBackgroundResource(R.drawable.button_deselected);
    	
    	makeChordListVisible();
    	
    	//Import Buttons (one for each chord) and Set Listeners
    	Button chordButton;	
    	
    	for(int x=0; x<ID_BUTTON.length; ++x) {
    		chordButton = (Button) findViewById(ID_BUTTON[x]);
    		setSoundListener(chordButton, ID_SOUND[x]);
    	}
    
  
    }
    
    private void setDiagramListener(Button b, final int index) {
    	b.setTypeface(fontHelvetica);

    	b.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		setDiagramImage(index);
	    		
	    		LISTEN.setBackgroundResource(R.drawable.button_deselected);	
	        	LEARN.setBackgroundResource(R.drawable.button_deselected);
	    	}
    	});
    }
    
    private void setSoundListener(Button b, final int id) {
    	b.setTypeface(fontHelvetica);
    	
    	b.setOnClickListener(new View.OnClickListener(){	
	    	public void onClick(View v){
	    		MediaPlayer mp = MediaPlayer.create(getBaseContext(), id);
                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {
 
                    public void onCompletion(MediaPlayer mp) {
                        mp.release();
                    }
                });
	    	}
    	});
    }
    
 
    private void setDiagramImage(int index) {
    	if(index < 0)
    		return;
    	
    	//Hide Chord List Background
    	TableLayout chordTable = (TableLayout) findViewById(R.id.chordTable);
    	chordTable.setBackgroundDrawable(null);
    	
    	//Set Background for Diagram
    	ImageView diagramBack = (ImageView) findViewById(R.id.diagramBackground);
    	diagramBack.setImageResource(R.drawable.background_paper);
    	
    	ImageView diagram = (ImageView) findViewById(R.id.chordDiagram);
    	final int soundID = ID_SOUND[index];	//Resource ID for chord chart
    	
    	diagram.setImageResource(ID_DIAGRAM[index]);
    	
    	diagram.setOnTouchListener(new OnTouchListener() {	 
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {	//Play chord sound on click
                MediaPlayer mp = MediaPlayer.create(getBaseContext(),
                        soundID);
                mp.start();
                mp.setOnCompletionListener(new OnCompletionListener() {
 
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
    
    private void showTitle() {
    	ImageView title = (ImageView) findViewById(R.id.title);
    	ImageView titleBackground = (ImageView) findViewById(R.id.titleBackground);
    	
    	//Show title
    	title.setImageResource(R.drawable.title);
    	titleBackground.setImageResource(R.drawable.background);
    	
    	//Both navigation buttons become "deselected"
    	LISTEN.setBackgroundResource(R.drawable.button_deselected);	
    	LEARN.setBackgroundResource(R.drawable.button_deselected);
    	
    	TITLE_HIDE = false;
    }

    private void hideTitle() {
    	ImageView title = (ImageView) findViewById(R.id.title);
    	ImageView titleBackground = (ImageView) findViewById(R.id.titleBackground);
    	
    	//Remove title image
    	title.setImageDrawable(null);
    	titleBackground.setImageDrawable(null);
    	
    	TITLE_HIDE = true;
    }
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK && TITLE_HIDE)) {
            showTitle();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}