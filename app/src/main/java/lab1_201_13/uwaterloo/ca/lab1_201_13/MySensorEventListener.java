package lab1_201_13.uwaterloo.ca.lab1_201_13;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import ca.uwaterloo.sensortoy.LineGraphView;

/**
 * Created by ywt on 5/18/16.
 */
abstract public class MySensorEventListener implements SensorEventListener {
    protected TextView output;
    protected TextView maxOutput;
    protected double[] maxValue;

    protected LineGraphView graph;
    public MySensorEventListener(TextView outputView, TextView max, LineGraphView lineGraph){
        output = outputView;
        maxOutput = max;
        graph = lineGraph;
        maxValue = new double[3];

    }





    public void onAccuracyChanged(Sensor s, int i) {}
    abstract public void onSensorChanged(SensorEvent se);

}
