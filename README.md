# Rate Limiter (SpringBoot + Resilience4j)

![Banner](banner.png)

A simple Spring Boot application demonstrating knowledge in **Rate Limiting** and implemented using **Resilience4j**. This project simulates a Weather API service with two endpoints — each protected by its own rate limiter instance.

## What is a Rate Limiter
In a network system, a rate limiter is used to control the rate of traffic sent by a client or a service. In the HTTP world, a rate limiter limits the number of client requests allowed to be sent over a specified period. If the API request count exceeds the threshold defined by the rate limiter, all the excess calls are blocked. Here are a few examples:

- A user can write no more than 2 posts per second.
- You can create a maximum of 10 accounts per day from the same IP address.
- You can claim rewards no more than 5 times per week from the same device.

## Benefits of using an API Rate Limiter

- **Prevent resource starvation caused by Denial of Service (DoS) attack** . Almost all APIs published by large tech companies enforce some form of rate limiting. For example, Twitter limits the number of tweets to 300 per 3 hours . Google docs APIs have the following default limit: 300 per user per 60 seconds for read requests. A rate limiter prevents DoS attacks, either intentional or unintentional, by blocking the excess calls.
  
- **Reduce cost** Limiting excess requests means **fewer servers and allocating more resources to high priority APIs**. Rate limiting is extremely important for companies that use paid third party APIs. For example, you are charged on a per-call basis for the following external APIs: check credit, make a payment, retrieve health records, etc. Limiting the number of calls is essential to reduce costs.
  
- Prevent servers from being overloaded. To reduce server load, a rate limiter is used to filter out excess requests caused by bots or users’ misbehavior.


## Algorithms for Rate Limiting
Rate limiting can be implemented using different algorithms, and each of them has distinct pros and cons. Even though this chapter does not focus on algorithms, understanding them at high-level helps to choose the right algorithm or combination of algorithms to fit our use cases. Here is a list of popular algorithms:

- Token bucket
- Leaking bucket
- Fixed window counter
- Sliding window log
- Sliding window counter


## 🧩 Tech Stack
- Spring Boot 3
- Resilience4j
- Spring AOP: Enables Spring AOP (Aspect-Oriented Programming). Required for Resilience4j annotations like `@RateLimiter` to work, as it uses AOP proxies to wrap your methods and apply the rate limiting logic.
- Postman (for testing)


## Key Concepts
| Concept                         | Description                                                                                            |
| ------------------------------- | ------------------------------------------------------------------------------------------------------ |
| **Instance-Level Rate Limiter** | Each limiter (e.g., `rateLimiter`, `rateLimiter1`) is independently configured and applied per method. |
| **AOP Integration**             | `spring-boot-starter-aop` enables the `@RateLimiter` annotation to intercept method calls.             |
| **Fallback Method**             | Ensures user gets a clean, controlled response when rate limit exceeds.                                |

