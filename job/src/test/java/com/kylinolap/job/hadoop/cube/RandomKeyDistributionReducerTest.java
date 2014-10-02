/*
 * Copyright 2013-2014 eBay Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kylinolap.job.hadoop.cube;

import com.kylinolap.job.constant.BatchConstants;
import com.kylinolap.job.hadoop.invertedindex.RandomKeyDistributionReducer;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author ysong1
 */
public class RandomKeyDistributionReducerTest {
    ReduceDriver<Text, LongWritable, Text, LongWritable> reduceDriver;

    @Before
    public void setUp() {
        RandomKeyDistributionReducer reducer = new RandomKeyDistributionReducer();
        reduceDriver = ReduceDriver.newReduceDriver(reducer);
    }

    @Test
    public void test() throws IOException {
        List<Text> data = new ArrayList<Text>();
        for (int i = 0; i < 1001; i++) {
            data.add(new Text(String.valueOf(i)));
        }
        for (Text t : data) {
            reduceDriver.addInput(t, new ArrayList<LongWritable>());
        }

        reduceDriver.getConfiguration().set(BatchConstants.REGION_NUMBER, "2");
        List<Pair<Text, LongWritable>> result = reduceDriver.run();

        assertEquals(2, result.size());

        for (Pair<Text, LongWritable> p : result) {
            System.out.println(p.getFirst());
        }
    }

}
