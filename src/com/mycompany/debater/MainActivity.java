package com.mycompany.debater;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.media.*;
import java.io.*;
import java.util.Random;

import com.mycompany.debater.Topics;
import android.widget.ArrayAdapter;
import android.app.ListActivity;

public class MainActivity extends ListActivity
{
	
	//ArrayAdapter<Topics> local_voiceouts_adapter = (ArrayAdapter<Topics>) getListAdapter();
	private ListView local_voiceouts = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        local_voiceouts = (ListView) findViewById (R.id.list2);
        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
            "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
            "Linux", "OS/2" };
        MySimpleArrayAdapter topics_adapter = new MySimpleArrayAdapter(this, values);
        MySimpleArrayAdapter local_voiceouts_adapter = new MySimpleArrayAdapter(this, values);
        local_voiceouts.setAdapter(local_voiceouts_adapter);
        setListAdapter(topics_adapter);
	
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        // Get the item that was clicked
        Object o = this.getListAdapter().getItem(position);
        String keyword = o.toString();
        Toast.makeText(this, "You selected: " + keyword, Toast.LENGTH_SHORT)
            .show();

      }
    public void onClick(View view) {
        @SuppressWarnings("unchecked")
        
        Topics topic = null;
        switch (view.getId()) {
        case R.id.record:
        	new CountDownTimer(30000, 1000) {

        	     private Toast mTextField;

				public void onTick(long millisUntilFinished) {
        	    	 mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
        	    	 mTextField.show();
        	     }

        	     public void onFinish() {
        	         mTextField.setText("done!");
        	         mTextField.show();
        	     }
        	  }.start();
        	/*MediaRecorder mediaRecorder = new MediaRecorder();
        	// Set the audio source.
        	mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        	// Set the output format.
        	mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
        	// Set the audio encoders to use.
        	mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
        	
        	mediaRecorder.setOutputFile("myoutputfile.mp4");
        	try{
        	mediaRecorder.prepare();
        	mediaRecorder.start();
        	}
        	catch(IOException e){}
        	*/
        	break;
        case R.id.play_back_btn:
        	String media_file_path="";
    		MediaPlayer mpfile=new MediaPlayer();
    		try{
    			mpfile.setDataSource(media_file_path);
    			mpfile.prepare();
    			mpfile.start();
    		}
    		catch(IllegalArgumentException e){}
    		catch(IllegalStateException e){}
    		catch(IOException e){}
    		break;
        case R.id.upload_btn:
        	break;
        case R.id.save_local_btn:
          
         // voiceouts_adapter.add(comment);
          break;
        //case R.id.delete:

        //  break;
        }
        
      }
} 
