package info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.record;

import android.os.Bundle;

import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.PumpModel;
import info.nightscout.androidaps.plugins.PumpMedtronic.comm.data.history.TimeStampedRecord;

public class TempBasalDurationPumpEvent extends TimeStampedRecord {
    private int durationMinutes = 0;

    public TempBasalDurationPumpEvent() {
    }

    @Override
    public String getShortTypeName() {
        return "Temp Basal Duration";
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    @Override
    public boolean parseFrom(byte[] data, PumpModel model) {
        if (!simpleParse(data, 2)) {
            return false;
        }
        durationMinutes = asUINT8(data[1]) * 30;
        return true;
    }

    @Override
    public boolean readFromBundle(Bundle in) {
        durationMinutes = in.getInt("durationMinutes", 0);
        return super.readFromBundle(in);
    }

    @Override
    public void writeToBundle(Bundle in) {
        super.writeToBundle(in);
        in.putInt("durationMinutes", durationMinutes);
    }

    @Override
    public boolean isAAPSRelevant() {
        return true;
    }


}
