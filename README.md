# Distributed Payment Gateway

A Kubernetes-based distributed payment gateway inspired by Razorpay/Stripe, supporting order creation, payment authorization, bank callback simulation, settlement, and webhook delivery.

## Features

- Order creation and payment processing
- Card, UPI, Net Banking, and Wallet support
- Idempotency using Redis
- Transactional Outbox with Kafka
- Distributed locking using ShedLock
- Resilience4J Circuit Breaker and Retry
- Secure card tokenization and encryption
- Webhook delivery with retry and DLQ
- Merchant settlement processing
- Rate limiting using Redis
- Kubernetes-based deployment and scaling
- Prometheus, Grafana, and Zipkin observability

## Architecture

The platform consists of 7 microservices:

- API Gateway
- Payment Service
- Merchant Service
- Operations Service
- Vault Service
- Config Service
- Discovery Service

Infrastructure:

- PostgreSQL
- Redis
- Apache Kafka
- Kubernetes
- Prometheus
- Grafana
- Zipkin

<img width="900" alt="Distributed Payment Gateway Architecture" src="https://github.com/user-attachments/assets/4faabe78-a19f-43ee-a52e-9d71df805288" />

## Design Patterns

- **Idempotency** — prevents duplicate orders and payments during retries
- **Transactional Outbox** — reliable database-to-Kafka event publishing
- **SAGA** — handles distributed payment workflows
- **Circuit Breaker** — prevents cascading failures
- **Distributed Locking** — prevents duplicate scheduled-job execution
- **Stateless Services** — enables horizontal scaling

## Load Testing

Load tested using Apache JMeter.

| Metric | Result |
|---|---:|
| Total Requests | 40,201 |
| Error Rate | 0.00% |
| Average Response Time | 424.72 ms |
| Median Response Time | 280 ms |
| P90 Latency | 983 ms |
| P95 Latency | 1,499.95 ms |
| P99 Latency | 2,210.99 ms |
| Throughput | 308.58 transactions/sec |

### Create Order

- 20,000 requests
- 0% errors
- Average: 426.78 ms
- P99: 2,230.99 ms
- Throughput: 177.30 TPS

### Init Payment

- 20,000 requests
- 0% errors
- Average: 426.14 ms
- P99: 2,257.99 ms
- Throughput: 177.85 TPS

<img width="900" height="451" alt="JMeter Load Test Results" src="https://github.com/user-attachments/assets/8e1f5d6c-65ca-40d5-8dba-5cb35acba7bf" />


## Observability

- **Prometheus** — service metrics
- **Grafana** — CPU and JVM memory dashboards
- **Zipkin** — distributed request tracing

<img width="900" height="561" alt="Grafana Dashboard" src="https://github.com/user-attachments/assets/bc9850ff-1e6b-4925-aaa7-8e3f4624a35d" />


## Kubernetes

Deployed using Kubernetes Deployments, StatefulSets, Services, ConfigMaps, and Secrets, with support for horizontal scaling.

## Tech Stack

**Java | Spring Boot | Spring Cloud | PostgreSQL | Redis | Kafka | Kubernetes | Docker | Resilience4J | Prometheus | Grafana | Zipkin | JMeter**
