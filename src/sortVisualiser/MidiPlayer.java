package sortVisualiser;

import java.util.ArrayList;
import javax.sound.midi.*;

public class MidiPlayer {

    private final ArrayList<Integer> notes;
    private Synthesizer synth;
    private final MidiChannel chan;

    public MidiPlayer(){
        try {
            synth = MidiSystem.getSynthesizer();
            synth.open();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }

        chan = synth.getChannels()[0];

        Instrument[] instruments = synth.getDefaultSoundbank().getInstruments();

            for (int index = 0; index < instruments.length; index++) {
                Instrument i = instruments[index];
                System.out.println(index + ": " + i.getName());

            }

        /*
        Good ones include: 139, 151 (laser gun),

         */
        chan.programChange(instruments[151].getPatch().getProgram());

        notes = new ArrayList<>();
        for (int i = 50; i <= 100; i += 1) {
            notes.add(i);
        }
    }


    public void play(int value) {
        System.out.println(value);
        int index = (int)((float)value/100 * (float) notes.size());
        int note = notes.get(index);
        chan.noteOn(note, 25);
    }
}