# Payment Service

The Payment Service is the core payment-processing component of the distributed payment platform.

It handles payment initiation, payment state transitions, payment gateway interaction, transactional event publishing, and distributed payment workflows.

## Responsibilities

- Payment creation and processing
- Payment state management
- Integration with payment gateways
- Payment method processing
- Idempotent payment handling
- Transactional Outbox event publishing
- SAGA-based distributed workflows
- Retry and failure handling
- Payment persistence and transaction management

## Architecture

The service is organized into separate layers for API handling, business logic, payment processing, gateway integration, persistence, event publishing, and distributed workflow management.

### Package Structure

- `api` — API contracts and interfaces
- `client` — communication with external/internal services
- `config` — service configuration
- `controller` — REST endpoints
- `dto` — request and response objects
- `entity` — persistence entities
- `gateway` — payment gateway integration
- `mapper` — DTO/entity mapping
- `outbox` — transactional outbox implementation
- `processor` — payment processing logic
- `repository` — database access
- `saga` — distributed payment workflow coordination
- `service` — core business logic
- `simulator` — payment gateway simulation/testing
- `statemachine` — payment lifecycle state management

## Payment Reliability

The service uses several patterns to handle distributed-system failure scenarios:

### Idempotency

Prevents duplicate payment operations when clients retry requests.

### Transactional Outbox

Payment state changes and corresponding events are persisted reliably before events are published to Kafka.

### SAGA

Coordinates distributed payment workflows and handles compensation when downstream operations fail.

### State Machine

Controls valid payment state transitions and prevents invalid lifecycle changes.

### Retry & Fault Handling

Transient failures are handled using retry and resilience mechanisms when communicating with downstream components.

## Payment Flow

```text
Client
  |
  v
API Gateway
  |
  v
Payment Service
  |
  +----> Payment State Machine
  |
  +----> Payment Processor
  |
  +----> Payment Gateway
  |
  +----> Payment Database
  |
  +----> Transactional Outbox
              |
              v
            Kafka
