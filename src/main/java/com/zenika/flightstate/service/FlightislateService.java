package com.zenika.flightstate.service;

import com.zenika.flightstate.config.ApplicationProperties;
import com.zenika.flightstate.domain.FlightPrediction;
import com.zenika.flightstate.domain.FlightView;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.linalg.DenseVector;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.types.DataTypes.*;

@Service
public class FlightislateService {

    private final Logger log = LoggerFactory.getLogger(FlightislateService.class);
    private final SparkSession spark;
    private final PipelineModel model;

    @Autowired
    public FlightislateService(ApplicationProperties properties) {
        log.info("Loading model at {}", properties.getModelLocation());
        spark = SparkSession.builder().appName("Airplane Predict").master("local[1]").getOrCreate();
        model = PipelineModel.load(properties.getModelLocation());
    }

    public FlightPrediction predictFlight(FlightView flightView) {
        //'Year', 'Month', 'DayOfMonth', 'DayOfWeek', 'DepTime', 'UniqueCarrierIndex', 'FlightNumIndex', 'OriginIndex', 'DestIndex'
        Dataset<Row> flightDf = spark.createDataFrame(Collections.singletonList(RowFactory.create(
            flightView.getMonth(),
            flightView.getDayOfWeek(),
            flightView.getDepTime(),
            flightView.getUniqueCarrier(),
            flightView.getFlightNum(),
            flightView.getOrigin(),
            flightView.getDest())),
            createStructType(Arrays.asList(
                createStructField("Month", StringType, true),
                createStructField("DayOfWeek", StringType, true),
                createStructField("DepTime", IntegerType, true),
                createStructField("UniqueCarrier", StringType, true),
                createStructField("FlightNum", StringType, true),
                createStructField("Origin", StringType, true),
                createStructField("Dest", StringType, true)
            )));
        flightDf.show();
        model.transform(flightDf).show();
        Row rawPrediction = model.transform(flightDf).select(col("prediction").cast(IntegerType),
                col("probability")).first();

        FlightPrediction result = new FlightPrediction();
        result.setLate(rawPrediction.getInt(0) == 1);
        result.setConfidence((float) rawPrediction.<DenseVector>getAs(1).values()[result.getLate() ? 1 : 0]);
        return result;
    }
}
