
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class EffectSound implements Runnable {

  public void setup() {
    try {
        Sequencer sequencer = MidiSystem.getSequencer();         
        sequencer.open();
       
        Sequence seq = new Sequence(Sequence.PPQ, 4);
        Track track = seq.createTrack();     
        track.add(makeEvent(144,1,60,100,10));
        sequencer.setSequence(seq); 
        sequencer.start();
        sequencer.setTempoInBPM(120);
    }
    catch (Exception e)
    {
      // a special way i'm handling logging in this application
      System.out.println(e);
    }
  }
  public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
    MidiEvent event = null;
    try {
      ShortMessage a = new ShortMessage();
      a.setMessage(comd, chan, one, two);
      event = new MidiEvent(a, tick);
      
    } catch(Exception e) { }
    return event;
 }


  @Override
  public void run() {
    setup();
  }
  
}