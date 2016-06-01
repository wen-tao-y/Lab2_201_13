package lab1_201_13.uwaterloo.ca.lab1_201_13;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

import ca.uwaterloo.sensortoy.LineGraphView;


public class Lab1_201_13 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lab1_201_13);
        TextView tv1 = (TextView) findViewById(R.id.label1);
        TextView tv2 = (TextView) findViewById(R.id.label2);
        TextView tv3 = (TextView) findViewById(R.id.label3);
        TextView tv4 = (TextView) findViewById(R.id.label4);
        TextView tv5 = (TextView) findViewById(R.id.label5);
        TextView tv6 = (TextView) findViewById(R.id.label6);
        TextView tv7 = (TextView) findViewById(R.id.label7);
        TextView tv8 = (TextView) findViewById(R.id.label8);
        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        ll.setOrientation(LinearLayout.VERTICAL);

        LineGraphView graph = new LineGraphView(getApplicationContext(),
                100,
                Arrays.asList("x", "y", "z"));
        ll.addView(graph); graph.setVisibility(View.VISIBLE);


        SensorManager sensorManager =
                (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor lightSensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        LightSensorEventListener l = new LightSensorEventListener(tv1, tv2,graph);

        Sensor rotationSensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR);
        RotationVectorSensorEventListener rv = new RotationVectorSensorEventListener(tv3,tv4,graph);

        Sensor accelerometerSensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        AccelerometerSensorEventListener a = new AccelerometerSensorEventListener(tv5,tv6,graph);

        Sensor magneticFieldSensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        MagneticFieldSensorEventListener m = new MagneticFieldSensorEventListener(tv7,tv8,graph);




        sensorManager.registerListener(l, lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(rv, rotationSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(a, accelerometerSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(m, magneticFieldSensor,
                sensorManager.SENSOR_DELAY_NORMAL);





    }
}
