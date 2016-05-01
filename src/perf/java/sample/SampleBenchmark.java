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
     public void JCublasSampleBenchmark10() {
    	String[] args = {};
		JCublasSample10.main(args );
    }
    @Benchmark
    public void JCublasSampleBenchmark100() {
   	String[] args = {};
		JCublasSample100.main(args );
   }
    @Benchmark
    public void JCublasSampleBenchmark1000() {
   	String[] args = {};
		JCublasSample1000.main(args );
   }
    @Benchmark
    public void JCublasSampleBenchmark1500() {
   	String[] args = {};
		JCublasSample1500.main(args );
   }
    @Benchmark
    public void JCublasSampleBenchmark2000(){
    	String [] args = {};
    	JavaSample2000.main(args);
    }
    @Benchmark
    public void JCublasSampleBenchmark2500() {
   	String[] args = {};
		JCublasSample2500.main(args );
   }
    @Benchmark
    public void JCublasSampleBenchmark3000() {
   	String[] args = {};
		JCublasSample3000.main(args );
   }
    @Benchmark
    public void JavaSample10(){
    	String[] args = {};
    	JavaSample10.main(args);
    }
    @Benchmark
    public void JavaSample100(){
    	String[] args = {};
    	JavaSample100.main(args);
    }
    @Benchmark
    public void JavaSample1000(){
    	String[] args = {};
    	JavaSample1000.main(args);
    }
    @Benchmark
    public void JavaSample1500(){
    	String[] args = {};
    	JavaSample1500.main(args);
    }
    @Benchmark
    public void JavaSample2000(){
    	String[] args = {};
    	JavaSample2000.main(args);
    }
    @Benchmark
    public void JavaSample2500(){
    	String[] args = {};
    	JavaSample2500.main(args);
    }
    @Benchmark
    public void JavaSample3000(){
    	String[] args = {};
    	JavaSample3000.main(args);
    }
}