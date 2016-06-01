package lab1_201_13.uwaterloo.ca.lab1_201_13;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by ywt on 5/18/16.
 */
public class LightSensorEventListener extends MySensorEventListener {
    public LightSensorEventListener(TextView outputView, TextView max, LineGraphView lineGraph) {
        super(outputView, max, lineGraph);
    }



    @Override
    public void onSensorChanged(SensorEvent se) {
        if (se.sensor.getType() == Sensor.TYPE_LIGHT) {

            if (se.values[0] > maxValue[0]) {
                maxValue[0] = se.values[0];
            }
            String s = String.format("Light:\n %f", se.values[0]);
            output.setText(s);
            String sm = String.format("Max: %f", maxValue[0]);
            maxOutput.setText(sm);


        }
    }
}
