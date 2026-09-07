# FinGuard AI

FinGuard AI is a fintech risk assessment platform designed to evaluate financial transactions and identify potentially risky activities before approval.

The project simulates how modern banks, payment gateways, and fintech companies perform transaction risk analysis using configurable business rules.

---

## Real-Time Transaction Risk Assessment

FinGuard is designed to simulate a real-time transaction risk assessment system used in modern fintech and banking environments.

In real-world payment systems, millions of transactions can be generated through channels such as UPI, credit cards, debit cards, net banking, wallets, and QR payments. Each transaction may need to be evaluated for potential risk based on factors such as transaction amount, device, location, merchant risk, and customer behavior.

FinGuard follows a similar approach by evaluating a transaction as it is received and generating a risk score, risk level, risk flags, and a recommended decision.

```text
Transaction Received
        ↓
Transaction Validation
        ↓
Risk Assessment
        ↓
Risk Score + Risk Flags
        ↓
Risk Level
        ↓
Decision
```

The current implementation uses a rule-based risk assessment engine. Future versions will extend this architecture with transaction history, customer and merchant risk profiles, Redis caching, Kafka-based event processing, and additional risk signals to support a more realistic real-time risk assessment workflow.

> Note: FinGuard is an educational/simulation project and does not process real financial transactions or move real money.


## Overview

The system manages:

* Customers
* Merchants
* Transactions
* Risk Assessment Engine

When a transaction is created, the system evaluates multiple risk factors and generates:

* Risk Score
* Risk Level
* Risk Flags
* Decision (Approve / Review)

---

## Current Features

### Customer Management

* Create Customer
* Get Customer by ID
* Customer Validation

### Merchant Management

* Create Merchant
* Get Merchant by ID
* Merchant Validation

### Transaction Management

* Create Transaction
* Get Transaction by ID
* Customer Verification
* Merchant Verification

### Risk Assessment Engine

Implemented Risk Rules:

* High Transaction Amount
* New Device Detection
* Unusual Location Detection
* High Risk Merchant Detection

Generated Output:

* Risk Score
* Risk Level
* Risk Flags
* Risk Decision

---

## Architecture

```text
Customer
    │
    ▼
Transaction ◄──── Merchant
    │
    ▼
Risk Assessment Engine
    │
    ├── HighAmountRule
    ├── NewDeviceRule
    ├── UnusualLocationRule
    └── HighRiskMerchantRule
    │
    ▼
Risk Result
```

---

## Technology Stack

### Backend

* Java 17
* Spring Boot 4
* Spring Web MVC
* Spring Validation

### Data Layer

* Spring Data JPA
* PostgreSQL (Planned)

### Build Tool

* Maven

### DevOps

* Git
* GitHub
* Docker

---

## Project Structure

```text
com.finguard
│
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── risk
    ├── RiskAssessmentService
    ├── RiskAssessmentServiceImpl
    ├── RiskRule
    ├── RiskResult
    └── rules
```

---

## APIs

### Customer APIs

* POST /api/v1/customers
* GET /api/v1/customers/{id}

### Merchant APIs

* POST /api/v1/merchants
* GET /api/v1/merchants/{id}

### Transaction APIs

* POST /api/v1/transactions
* GET /api/v1/transactions/{id}

---

## Docker Support

Dockerfile and Docker configuration are available for containerized deployment.

---

## Planned Enhancements

### Functional

* Transaction History
* Customer Risk Profile
* Merchant Risk Profile
* Fraud Investigation APIs
* Risk Assessment Persistence

### Security

* Spring Security
* JWT Authentication
* Role-Based Access Control

### Performance

* Redis Caching
* Rate Limiting

### Event Driven Architecture

* Apache Kafka
* Transaction Event Streaming

### Cloud & DevOps

* GitHub Actions CI/CD
* Branch Protection Rules
* Docker Hub Integration
* AWS Deployment
* Kubernetes Deployment

### Observability

* Spring Actuator
* Prometheus
* Grafana

---

## Learning Objectives

This project is being built to gain hands-on experience with:

* Spring Boot
* Microservice Design Principles
* Fintech Domain Concepts
* Risk Assessment Systems
* CI/CD Pipelines
* Docker
* Cloud Deployment
* Production-Ready Backend Development
