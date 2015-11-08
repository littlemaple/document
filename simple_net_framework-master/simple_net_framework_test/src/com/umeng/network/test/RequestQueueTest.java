/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 Umeng, Inc
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.umeng.network.test;

import android.test.AndroidTestCase;

import org.simple.net.base.Request.HttpMethod;
import org.simple.net.base.Request.RequestListener;
import org.simple.net.core.RequestQueue;
import org.simple.net.core.SimpleNet;
import org.simple.net.requests.StringRequest;

public class RequestQueueTest extends AndroidTestCase {

    RequestQueue mQueue = SimpleNet.newRequestQueue();

    protected void setUp() throws Exception {
        super.setUp();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        mQueue.clear();
    }

    public void testMultiRequests() {

        for (int i = 0; i < 10; i++) {
            StringRequest request = new StringRequest(HttpMethod.GET, "http://myhost.com", null);
            mQueue.addRequest(request);
        }

        assertEquals(1, mQueue.getAllRequests().size());

    }

    public void testMultiRequestsWithListeners() {
        // 添加lisener
        for (int i = 0; i < 10; i++) {
            StringRequest request = new StringRequest(HttpMethod.GET, "http://myhost.com",
                    new RequestListener<String>() {

                        @Override
                        public void onComplete(int stCode, String response, String errMsg) {

                        }
                    });
            mQueue.addRequest(request);
        }

        assertEquals(1, mQueue.getAllRequests().size());
    }

}
