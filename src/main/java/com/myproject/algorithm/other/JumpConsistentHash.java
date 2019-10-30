package com.myproject.algorithm.other;

//int32_t JumpConsistentHash(uint64_t key, int32_t num_buckets) {
//    int64_t b=0,j=0;
//    while(j<num_buckets){
//        b=j;
//        key=key*2862933555777941757ULL+1;
//        j=(b+1)*(double(1LL<<31)/double((key>>33)+1));
//    }
//    return b;
//}
public class JumpConsistentHash {
    public static int consistentHash(long key, int buckets) {
        LinearCongruentialGenerator generator = new LinearCongruentialGenerator(key);
        int b = -1;                 // 我自己看了下按照c++一样的写的
        int j = 0;
        while (j >= 0 && j < buckets) {
            b = j;
            j = (int) ((b + 1) / generator.nextDouble());
        }
        return b;
//        int candidate = 0;        // google java 写法
//        int next;
//        while (true) {
//            next = (int) ((candidate + 1) / generator.nextDouble());
//            if (next >= 0 && next < buckets) {
//                candidate = next;
//            } else {
//                return candidate;
//            }
//        }
    }
    private static final class LinearCongruentialGenerator {
        private long state;
        public LinearCongruentialGenerator(long state) {
            this.state = state;
        }
        public double nextDouble() {
            state = 2862933555777941757L * state + 1;
            int tmpInt = (int) (state >>> 33) + 1;
            double tmpDouble = (double) tmpInt;
            return tmpDouble / (0x1.0p31); // 1L << 31 === 0x1.0p31
        }
    }
}