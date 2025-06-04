- 레디스 설치
```shell
$ helm -n infra install redis oci://registry-1.docker.io/bitnamicharts/redis --set architecture=standalone --set auth.enabled=false --set master.persistence.enabled=false
```

- 레디스 삭제
```shell
$ helm -n infra uninstall redis
```

- 레디스 중지
```shell
$ kubectl -n infra scale statefulset redis-master --replicas=0
```

- 레디스 복구
```shell
$ kubectl -n infra scale statefulset redis-master --replicas=1
```


```shell
-set master.persistence.enabled=false
Pulled: registry-1.docker.io/bitnamicharts/redis:21.1.11
Digest: sha256:a6fa363f7698b02ebec9be1c101a44e4dc5ad68d3e94b78d52e65ceef598d18d
NAME: redis
LAST DEPLOYED: Wed Jun  4 18:20:49 2025
NAMESPACE: infra
STATUS: deployed
REVISION: 1
TEST SUITE: None
NOTES:
CHART NAME: redis
CHART VERSION: 21.1.11
APP VERSION: 8.0.2

Did you know there are enterprise versions of the Bitnami catalog? For enhanced secure software supply chain features, unlimited pulls from Docker, LTS support, or application customization, see Bitnami Premium or Tanzu Application Catalog. See https://www.arrow.com/globalecs/na/vendors/bitnami for more information.

** Please be patient while the chart is being deployed **

Redis&reg; can be accessed via port 6379 on the following DNS name from within your cluster:

    redis-master.infra.svc.cluster.local



To connect to your Redis&reg; server:

1. Run a Redis&reg; pod that you can use as a client:

   kubectl run --namespace infra redis-client --restart='Never'  --image docker.io/bitnami/redis:8.0.2-debian-12-r3 --command -- sleep infinity

   Use the following command to attach to the pod:

   kubectl exec --tty -i redis-client \
   --namespace infra -- bash

2. Connect using the Redis&reg; CLI:
   redis-cli -h redis-master

To connect to your database from outside the cluster execute the following commands:

    kubectl port-forward --namespace infra svc/redis-master 6379:6379 &
    redis-cli -h 127.0.0.1 -p 6379

WARNING: There are "resources" sections in the chart not set. Using "resourcesPreset" is not recommended for production. For production installations, please set the following values according to your workload needs:
  - replica.resources
  - master.resources
+info https://kubernetes.io/docs/concepts/configuration/manage-resources-containers/
yikiyoung@liki-MacBookPro timeline-sersver % 

```

