

import javax.sound.midi.*;

import java.io.File;
import java.io.IOException;

public class Sound {

	String path = new String("E:/IdeaProjects/box/source/music/");
	String file = new String("nor.mid");
	Sequence seq;
	Sequencer midi;
	boolean sign;
	public void loadSound(){
		try {
			seq = MidiSystem.getSequence(new File(path+file));
			midi = MidiSystem.getSequencer();
			midi.open();
			midi.setSequence(seq);
			midi.start();
			midi.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		sign = true;
	}
	
	public Sound(){
		
	}
	

	
	void mystop(){midi.stop();midi.close();sign=false;}
	boolean isplay(){return sign;}
	void setMusic(String e){file=e;}
	
}
