package com.xyy.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 限流算法
 * <p>
 *
 * </p>
 * User: xuyuanye Date: 2016/10/18 Project: JavaTest
 */
public class RateLimiterTest {

    public static void main(String[] args) {
       /* RateLimiter  limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());*/

        RateLimiter limiter2 = RateLimiter.create(5);
        System.out.println(limiter2.acquire(5));
        System.out.println(limiter2.acquire(1));
        System.out.println(limiter2.acquire(1));
    }
}
