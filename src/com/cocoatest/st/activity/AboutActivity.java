package com.cocoatest.st.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cocoatest.st.R;

public class AboutActivity extends BaseActivity {

	private static final String LOG_TAG = "Emmagee-" + AboutActivity.class.getSimpleName();

	private TextView appVersion;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		Log.d(LOG_TAG, "onCreate");
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);

		appVersion = (TextView) findViewById(R.id.app_version);
		appVersion.setText(getVersion());

		TextView title = (TextView) findViewById(R.id.nb_title);
		title.setText(R.string.about);

		ImageView btnSave = (ImageView) findViewById(R.id.btn_set);
		btnSave.setVisibility(View.INVISIBLE);

		LinearLayout layGoBack = (LinearLayout) findViewById(R.id.lay_go_back);

		layGoBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				AboutActivity.this.finish();
			}
		});
	}

	/**
	 * get app version
	 * 
	 * @return app version
	 */
	public String getVersion() {
		try {
			PackageManager manager = this.getPackageManager();
			PackageInfo info = manager.getPackageInfo(this.getPackageName(), 0);
			String version = info.versionName;
			return version;
		} catch (Exception e) {
			e.printStackTrace();
			return "-";
		}
	}

	@Override
	public void finish() {
		super.finish();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
