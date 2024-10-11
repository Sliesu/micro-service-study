<img src="/doc/img/rbc-logo.png" style="width: 40%;margin-bottom: -60px" alt="RBC Logo"/>


### Spring Cloud Alibaba 学习项目

![Spring Boot 3.2.4](https://img.shields.io/badge/Spring%20Boot-3.2.4-brightgreen.svg)
![Spring Cloud 2023.0.1](https://img.shields.io/badge/Spring%20Cloud-2023.0.1-blue.svg)
![Spring Cloud Alibaba 2023.0.1.0](https://img.shields.io/badge/Spring%20Cloud%20Alibaba-2023.0.1.0-brightgreen.svg)
![JDK 17](https://img.shields.io/badge/JDK-17-brightgreen.svg)
![Maven](https://img.shields.io/badge/Maven-3.9.6-yellowgreen.svg)


@RainbowCloud_CrispShark


**1. Nacos 服务注册与发现**

![Nacos 2.3.2](https://img.shields.io/badge/Nacos-2.3.2-red.svg)

模块名称：`order-service`、`product-service`、`user-service`

模块描述：  
本模块学习如何使用 Spring Cloud Alibaba 集成 Nacos 进行服务注册与发现。Nacos 是一个易于使用的动态服务发现、配置管理与服务管理平台。在本模块中，学习如何使用 Nacos 将微服务注册到注册中心，并使用 RestTemplate 实现服务之间的调用。

------

**2. OpenFeign 服务调用与Loadbalancer负载均衡**

模块名称：`user-service`、`order-service`

模块描述：  
本模块介绍如何使用 OpenFeign 进行微服务间的调用。OpenFeign 是一个声明式 HTTP 客户端，通过注解定义 REST 接口，简化了服务调用。与 Spring Cloud 集成，支持 Nacos 和负载均衡，使用动态代理实现服务间的 HTTP 通信。  
场景示例：`user-service` 调用 `order-service` 获取用户订单信息，通过 @FeignClient 注解定义服务接口，自动生成 HTTP 请求。

------

3. Sentinel 服务容错与流量控制

![Sentinel 1.8.6](https://img.shields.io/badge/Sentinel-1.8.6-red.svg)

微服务：`order-service`

模块描述：
本模块学习如何使用 Sentinel 进行服务的容错和流量控制。Sentinel 是一个轻量级的流量控制组件，提供熔断、降级、流量控制等功能，以保障微服务的高可用性。在本模块中，学习如何通过 Sentinel 配置流量控制规则，包括限流、熔断策略和降级处理，确保在下游服务不稳定时，系统能够优雅地处理请求，并避免系统崩溃。通过集成 Sentinel 的实时监控功能，可以实时查看服务的调用情况及性能指标，优化服务之间的调用链。