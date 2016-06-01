package lab1_201_13.uwaterloo.ca.lab1_201_13;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by ywt on 5/18/16.
 */
public class AccelerometerSensorEventListener extends MySensorEventListener {
    public AccelerometerSensorEventListener(TextView outputView, TextView max, LineGraphView lineGraph) {
        super(outputView, max, lineGraph);
    }

    @Override
    public void onSensorChanged(SensorEvent se) {
        if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            for(int i=0;i<3;i++){
                if(maxValue[i]<Math.abs(se.values[i])){
                    maxValue[i]=Math.abs(se.values[i]);
                }
            }
            graph.addPoint(se.values);
            String s = String.format("Accelerometer: \nx: %f, y: %f, z:%f", se.values[0],se.values[1],se.values[2]);
            output.setText(s);
            String sm = String.format("Max: \nx: %f, y: %f, z: %f", maxValue[0],maxValue[1],maxValue[2]);
            maxOutput.setText(sm);
        }
    }
}