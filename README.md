# Distributed Payment Gateway

A Kubernetes-native distributed payment platform built with Java and Spring Boot.

The system implements payment processing, order management, merchant operations,
webhook delivery, settlement workflows, and multiple payment methods using a
microservice architecture.

## Engineering Focus

This project explores reliability and scalability problems commonly found in
distributed payment systems:

- Idempotent payment and order requests
- Reliable database-to-Kafka event publishing
- Distributed payment workflows
- Fault tolerance and downstream failure handling
- Webhook retries and dead-letter processing
- Distributed job locking
- Horizontal scaling with Kubernetes
- Metrics, dashboards, and distributed tracing

## Key Features

- Order creation and payment processing
- Card, UPI, Net Banking, and Wallet support
- Redis-based idempotency
- Transactional Outbox with Kafka
- SAGA-based distributed workflows
- Resilience4J Circuit Breaker and Retry
- Secure card tokenization and encryption
- Webhook delivery with retry and DLQ
- Merchant settlement processing
- Redis-based rate limiting
- Kubernetes deployment and scaling
- Prometheus, Grafana, and Zipkin observability
## Architecture

The platform uses a microservice architecture deployed within a private
Kubernetes network.

Client requests enter through the API Gateway, which handles authentication,
rate limiting, and routing to the business services.

The Payment Service manages order, payment, and refund workflows.
The Merchant Service handles merchant authorization, keys, and KYC.
The Operations Service manages webhooks, settlement, and analytics.
The Vault Service provides isolated payment credential tokenization.

PostgreSQL provides service-specific persistence, Redis handles caching,
counters and idempotency-related operations, while Kafka provides asynchronous
event communication through the transactional outbox flow.

Prometheus, Grafana, and Zipkin provide metrics, dashboards, and distributed
tracing.

<img width="900" alt="Distributed Payment Gateway Architecture" src="https://github.com/user-attachments/assets/4faabe78-a19f-43ee-a52e-9d71df805288" />

## Payment Flows

The payment lifecycle is implemented as a sequence of interactions between
the merchant, gateway, payment processor, payment-method adapter, and
downstream banking systems.

The flows cover multiple payment methods and include authentication,
payment authorization, balance validation, transaction processing,
webhook delivery, and settlement.

### Payment Flow Overview
<img width="1200" height="814" alt="Payment Flow Diagrams" src="https://github.com/user-attachments/assets/cc0c8ac1-9bb5-404e-9c19-1aa1c01500cf" />

## Design Patterns

The system uses several patterns to address reliability, extensibility, and
distributed transaction challenges.

| Pattern | Purpose |
|---|---|
| Strategy Pattern | Supports multiple payment methods through a pluggable adapter layer |
| Transactional Outbox | Reliably publishes domain events after database transactions |
| Saga Pattern | Coordinates multi-step payment workflows across services |
| Idempotency | Prevents duplicate payment operations during request retries |
| Circuit Breaker | Limits cascading failures when downstream services are unavailable |
| Retry | Handles transient failures between distributed components |
| Distributed Lock | Prevents concurrent execution of scheduled operations |
| API Gateway | Provides a single entry point for routing, authentication, and rate limiting |

## Load Testing

Load testing was performed using Apache JMeter against the payment APIs.

### Benchmark Results

| Metric | Result |
|---|---:|
| Total Requests | 40,201 |
| Error Rate | 0.00% |
| Throughput | 308.58 TPS |
| Average Response Time | 424.72 ms |
| Median Response Time | 280 ms |
| P90 Latency | 983 ms |
| P95 Latency | 1,499.95 ms |
| P99 Latency | 2,210.99 ms |

### Create Order

| Metric | Result |
|---|---:|
| Requests | 20,000 |
| Error Rate | 0.00% |
| Throughput | 177.30 TPS |
| Average Response Time | 426.78 ms |
| P99 Latency | 2,230.99 ms |

### Init Payment

| Metric | Result |
|---|---:|
| Requests | 20,000 |
| Error Rate | 0.00% |
| Throughput | 177.85 TPS |
| Average Response Time | 426.14 ms |
| P99 Latency | 2,257.99 ms |
> **Note:** These results represent the recorded JMeter benchmark for this
> test configuration. Throughput and latency depend on the deployment,
> infrastructure, workload, and test configuration.

<img width="900" height="451" alt="JMeter Load Test Results" src="https://github.com/user-attachments/assets/8e1f5d6c-65ca-40d5-8dba-5cb35acba7bf" />


## Observability

The system includes metrics, dashboards, and distributed tracing to monitor
service behavior across the microservice architecture.

- **Prometheus** — collects application and service metrics
- **Grafana** — visualizes metrics through dashboards
- **Zipkin** — provides distributed request tracing across services

### Grafana Dashboard

The dashboard tracks CPU usage and JVM memory consumption across the
microservices over time.
<img width="1200" height="748" alt="Grafana Dashboard" src="https://github.com/user-attachments/assets/bc9850ff-1e6b-4925-aaa7-8e3f4624a35d" />


## Kubernetes

Deployed using Kubernetes Deployments, StatefulSets, Services, ConfigMaps, and Secrets, with support for horizontal scaling.

## Tech Stack

**Java | Spring Boot | Spring Cloud | PostgreSQL | Redis | Kafka | Kubernetes | Docker | Resilience4J | Prometheus | Grafana | Zipkin | JMeter**
