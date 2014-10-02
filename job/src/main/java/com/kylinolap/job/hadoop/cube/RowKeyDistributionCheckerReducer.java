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

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author ysong1
 */
public class RowKeyDistributionCheckerReducer extends Reducer<Text, LongWritable, Text, LongWritable> {

    LongWritable outputKey = new LongWritable(0L);

    @Override
    public void reduce(Text key, Iterable<LongWritable> values, Context context) throws IOException,
            InterruptedException {

        long length = 0;
        for (LongWritable v : values) {
            length += v.get();
        }

        outputKey.set(length);
        context.write(key, outputKey);
    }
}
