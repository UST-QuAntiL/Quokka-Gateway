server:
  port: {{ .Env.PORT }}

org:
  quantil:
    gateway:
      error-mitigation-service:
        uri: {{ .Env.ERROR_MITIGATION_SERVICE_URI }}
      objective-function-service:
        uri: {{ .Env.OBJECTIVE_FUNCTION_SERVICE_URI }}
      quantum-circuit-generator:
        uri: {{ .Env.QUANTUM_CIRCUIT_GENERATOR_URI }}
      optimization-service:
        uri: {{ .Env.OPTIMIZATION_SERVICE_URI }}
      circuit-execution-service:
        uri: {{ .Env.CIRCUIT_EXECUTION_SERVICE_URI }}

logging:
  level:
    org.springframework.cloud.gateway: {{ .Env.LOGGING_LEVEL }}
    org.quantil.gateway: {{ .Env.LOGGING_LEVEL }}
