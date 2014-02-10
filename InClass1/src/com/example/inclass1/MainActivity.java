package com.example.inclass1;

/*InclassAssignment1
 Rajashekar reddy Peta
 800836279
 */
import com.example.inclass1.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

public class MainActivity extends Activity implements OnClickListener {
	public int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button b = (Button) findViewById(R.id.Gray);
		b.setOnClickListener(this);
		b = (Button) findViewById(R.id.Cyan);
		b.setOnClickListener(this);
		b = (Button) findViewById(R.id.DkGray);
		b.setOnClickListener(this);
		b = (Button) findViewById(R.id.Magenta);
		b.setOnClickListener(this);
		b = (Button) findViewById(R.id.Yellow);
		b.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		TableLayout lay;
		count++;
		EditText txt = (EditText) findViewById(R.id.editText1);
		txt.setText("      # Count : " + count);
		switch (v.getId()) {
		case R.id.Gray:
			lay = (TableLayout) findViewById(R.id.TableLayout1);
			lay.setBackgroundColor(Color.GRAY);
			break;
		case R.id.Cyan:
			lay = (TableLayout) findViewById(R.id.TableLayout1);
			lay.setBackgroundColor(Color.CYAN);
			break;
		case R.id.DkGray:
			lay = (TableLayout) findViewById(R.id.TableLayout1);
			lay.setBackgroundColor(Color.DKGRAY);
			break;
		case R.id.Magenta:
			lay = (TableLayout) findViewById(R.id.TableLayout1);
			lay.setBackgroundColor(Color.MAGENTA);
			break;
		case R.id.Yellow:
			lay = (TableLayout) findViewById(R.id.TableLayout1);
			lay.setBackgroundColor(Color.YELLOW);
			break;

		}

	}

}
