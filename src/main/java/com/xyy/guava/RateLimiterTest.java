package com.xyy.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * 限流算法
 * <p>
 * <p>
 * </p>
 * User: xuyuanye Date: 2016/10/18 Project: JavaTest
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        /**
         *1、RateLimiter.create(5) 表示桶容量为5且每秒新增5个令牌，即每隔200毫秒新增一个令牌；
         2、limiter.acquire()表示消费一个令牌，
         如果当前桶中有足够令牌则成功（返回值为0），
         如果桶中没有令牌则暂停一段时间，
         比如发令牌间隔是200毫秒，则等待200毫秒后再去消费令牌（如上测试用例返回的为0.198239，差不多等待了200毫秒桶中才有令牌可用）
         ，这种实现将突发请求速率平均为了固定请求速率。
         0.0
         0.195719
         0.193782
         0.199749
         0.198122
         0.183767
         */
        RateLimiter limiter = RateLimiter.create(5);
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println("*********************************************************");

        /**
         * limiter.acquire(5)表示桶的容量为5且每秒新增5个令牌，令牌桶算法允许一定程度的突发，所以可以一次性消费5个令牌，
         * 但接下来的limiter.acquire(1)将等待差不多1秒桶中才能有令牌，且接下来的请求也整形为固定速率了。
         * 0.0
         0.99993
         0.199836
         */
        RateLimiter limiter2 = RateLimiter.create(5);
        System.out.println(limiter2.acquire(5));
        System.out.println(limiter2.acquire(1));
        System.out.println(limiter2.acquire(1));
        System.out.println("*********************************************************");

        /**
         * 同上边的例子类似，第一秒突发了10个请求，令牌桶算法也允许了这种突发（允许消费未来的令牌），
         * 但接下来的limiter.acquire(1)将等待差不多2秒桶中才能有令牌，且接下来的请求也整形为固定速率了。
         * 0.0
         1.999907
         0.200089
         */
        RateLimiter limiter3 = RateLimiter.create(5);
        System.out.println(limiter3.acquire(10));
        System.out.println(limiter3.acquire(1));
        System.out.println(limiter3.acquire(1));
        System.out.println("*********************************************************");
    }
}
