server:
  port: {{ .Env.PORT }}

org:
  quantil:
    gateway:
      error-mitigation-service:
        uri: {{ .Env.ERROR_MITIGATION_SERVICE_URI }}
      objective-evaluation-service:
        uri: {{ .Env.OBJECTIVE_EVALUATION_SERVICE_URI }}
      quantum-circuit-generation:
        uri: {{ .Env.QUANTUM_CIRCUIT_GENERATION_URI }}
      optimization-service:
        uri: {{ .Env.OPTIMIZATION_SERVICE_URI }}
      circuit-execution-service:
        uri: {{ .Env.CIRCUIT_EXECUTION_SERVICE_URI }}
      circuit-cutting-service:
        uri: {{ .Env.CIRCUIT_CUTTING_SERVICE_URI }}
      warm-starting-service:
        uri: {{ .Env.WARM_STARTING_SERVICE_URI }}

logging:
  level:
    org.springframework.cloud.gateway: {{ .Env.LOGGING_LEVEL }}
    org.quantil.gateway: {{ .Env.LOGGING_LEVEL }}
