package sample;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.uncommons.maths.Maths;

import java.util.concurrent.ThreadLocalRandom;

public class SampleBenchmark {

    @State(Scope.Thread)
    public static class Point {

        private static final double MAX_VALUE = 10_000;
        public final double a, b;

        public Point() {
            a = ThreadLocalRandom.current().nextDouble(MAX_VALUE);
            b = ThreadLocalRandom.current().nextDouble(MAX_VALUE);
        }
    }

    @Benchmark
     public void JCublasSampleBenchmark() {
    	String[] args = {};
		JCublasSample.main(args );
    }
    
    @Benchmark
    public void JavaSampleBenchmark(){
    	String [] args = {};
    	JavaSample.main(args);
    }
    

}