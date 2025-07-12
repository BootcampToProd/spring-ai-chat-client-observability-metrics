# 📊 Spring AI Observability: Metrics and Logging Deep Dive

This repository contains the source code for the "An AI-Powered Customer Support Assistant" application, demonstrating how to implement and monitor **observability** in a **Spring AI** project. It provides a hands-on guide to tracking application performance, cost (token usage), and behavior through **Chat Client Metrics** and structured **Prompt/Response Logging**.

📖 **Dive Deeper**: For a complete walkthrough, detailed explanations of each metric, and step-by-step instructions for building this example, read our comprehensive blog post.<br>
👉 **[Spring AI Observability: A Deep Dive into Chat Client Metrics and Prompt Logging](https://bootcamptoprod.com/spring-ai-chat-client-metrics-guide/)**

🎥 **Visual Learning**: Prefer video tutorials? Watch our step-by-step implementation guide on YouTube.<br>
👉 **YouTube Tutorial - Coming Soon!**

---

## 📦 Environment Variables

Make sure to provide this Java environment variable when running the application:

-   `OPENROUTER_API_KEY`: Your secret API key from the OpenRouter.

---

## 💡 About This Project

This project implements a simple **An AI-Powered Customer Support Assistant** to demonstrate the ease of enabling and interpreting observability features in Spring AI. It showcases how to:

*   Configure Spring Boot Actuator to expose critical AI metrics.
*   Enable structured logging for prompts, AI responses, and errors in `application.yaml`.
*   Monitor performance with `spring.ai.chat.client` metrics to track request counts, latency, and success/error rates.
*   Track costs by monitoring `gen_ai.client.token.usage` for input, output, and total tokens.
*   Debug AI interactions effectively by inspecting detailed console logs for the exact prompts and responses.

The application exposes a REST endpoint that takes a customer query, sends it to the configured AI model, and returns a response, all while generating a rich set of logs and metrics.

---