package labyrinth;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

	Sound(){
		
	}
	
	static void soundAbspielen(String URI) {

		File Sound = new File(URI);
		
		try {
			Clip audioClip = AudioSystem.getClip();
			audioClip.open(AudioSystem.getAudioInputStream(Sound));
			audioClip.start();
			Thread.sleep(audioClip.getMicrosecondLength()/1000);	
		}catch(Exception e)
		{
		}
	}
}
