package com.karbar.service;

import java.util.Timer;
import java.util.TimerTask;

import dbPack.DbMethods;


import android.content.Intent;
import android.database.Cursor;
import android.os.IBinder;
import android.app.Service;
import android.util.Log;
import android.widget.Toast;

public class Execute extends Service{
	private static final String TAG = "MyService";
	DbMethods dbMethods;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
		 dbMethods = new DbMethods(getApplicationContext());
	}
	

	

	@Override
	public void onDestroy() {
		Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
		dbMethods.setServiceRunning(false);
		Log.d("kkams", "onDestroy");
		
	}
	
	@Override
	public void onStart(Intent intent, int startid) {
		Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
		Log.d("kkams", "onStart");
		okresowewykonywanie();
	}
	private void okresowewykonywanie() {

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			public void run() {

				Log.d("kkams", "service isRun? "+ dbMethods.isServiceRunning());
				/*int idWarunku = 0;
				int idWiersza;
				int warunek = 0;
				boolean trigger = true;
				Cursor c = mDbHelper.fetchAllDiy();
				if (c.moveToFirst()) {
					do {
						trigger = true;
						idWiersza = c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ROWID));
						System.out.println("Jestem w p�tli, w wierszu "+idWiersza);
						if((c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ENABLED))==1)){
							
						

						System.out.println("DIYa aktywna "+idWiersza);
						
					
									warunek = c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_TRIGGER_DATE));
								if(warunek == 1)
								{	
									System.out.println("Jestem w sprawdzaniu triggera");
									if(!tr.dzienIGodzina(idWiersza))
										trigger = false;
								}
							

							System.out.println("Jestem za pierwszym ifem, zwr�ci�: "+warunek+" a trigger "+trigger);
							
							System.out.println("Jestem za pierwszym ifem, zwr�ci�: "+warunek+" a trigger "+trigger);
							warunek = c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_TRIGGER_LOCATION));	
							if(warunek == 1)
								{
									if(!tr.czyWDanymMiejscu(idWiersza))
										trigger = false;
								}
						
							System.out.println("Jestem za drugim ifem, zwr�ci�: "+warunek);
							
							warunek = c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_TRIGGER_WIFI));	
							if(warunek == 1)
								{
									if(!tr.czyWifiWlaczone(idWiersza))
										trigger = false;
								}
							
							System.out.println("Jestem za trzecim ifem, zwr�ci�: "+warunek);
							System.out.println("Trigger " + trigger);
							
							if(trigger){
								System.out.println("ala0.7");
								if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_WIFI)) == 1)
								{
									System.out.println("ala1");
									if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_WIFI_PARAM_TURN_ON)) == 1)
									{
										System.out.println("ala2");
										if(!c.getString(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_WIFI_PARAM_SSID)).equals("")){
											System.out.println("ala3");
											ac.podlaczWifiDoDanejSieci(idWiersza);
										}
										else{
											System.out.println("ala4");
											ac.wlaczWifi(idWiersza);
										}
										
									}
									else if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_WIFI_PARAM_TURN_OFF)) == 1)
									{
										System.out.println("ala5");
										ac.wylaczWifi(idWiersza);
									}
								}
								System.out.println("ala5.7");
								if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_NOTIFICATION)) == 1){
									System.out.println("ala6");
									ac.wyswietlPowiadomienie(idWiersza);
								}
								System.out.println("ala6.7");
								if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_SOUNDPROFILE)) == 1)
								{
									System.out.println("ala7");
									if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_SOUNDPROFILE_PARAM_PROFILE_SOUND)) == 1)
									{
										System.out.println("ala8");
										ac.glosnoscDzwiek(idWiersza);
									}
									else if(c.getInt(c.getColumnIndexOrThrow(DiyDbAdapter.KEY_ACTION_SOUNDPROFILE_PARAM_PROFILE_VIBRATIONS)) == 1)
									{
										System.out.println("ala9");
										ac.glosnoscWibracje(idWiersza);
									}
								}
								
								System.out.println("ala10");
							}
							System.out.println("ala11");
							System.out.println("Jestem za trzecim ifem, zwr�ci�: "+warunek);
							System.out.println("Ko�cowy wynik: " + trigger);
							
						}
					} while (c.moveToNext());
				}
				
				System.out.println("ala12");
				*/
			}
		
		};
		timer.scheduleAtFixedRate(timerTask, 100, 6000);
	}
}
