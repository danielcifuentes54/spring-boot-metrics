FROM grafana/grafana:6.5.3

COPY datasource-prometheus.yaml /etc/grafana/provisioning/datasources/
COPY dashboard-provider.yaml /etc/grafana/provisioning/dashboards/
COPY java_metrics.json /var/lib/grafana/dashboards/