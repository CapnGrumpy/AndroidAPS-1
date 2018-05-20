package info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.record;

import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.PumpModel;
import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.PumpTimeStamp;
import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.TimeFormat;
import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.TimeStampedRecord;

public class Sara6EPumpEvent extends TimeStampedRecord {
    public Sara6EPumpEvent() {
    }

    @Override
    public int getLength() {
        return 52;
    }

    @Override
    public String getShortTypeName() {
        return "Sara6E";
    }

    @Override
    public boolean parseFrom(byte[] data, PumpModel model) {
        // We don't understand this event...
        // Minimum 16 characters? date components?
        if (16 > data.length) {
            return false;
        }
        try {
            timestamp = new PumpTimeStamp(TimeFormat.parse2ByteDate(data, 1));
        } catch (org.joda.time.IllegalFieldValueException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAAPSRelevant() {
        return false;
    }

}
