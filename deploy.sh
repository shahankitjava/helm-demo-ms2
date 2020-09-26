docker build -t shahankitturn/demo-ms2:latest -t shahankitturn/demo-ms2:$SHA .
docker push shahankitturn/demo-ms2:latest
docker push shahankitturn/demo-ms2:$SHA

kubectl apply -f k8s/helm-demo-ms2-service.yml
kubectl apply -f k8s/helm-demo-ms2-deployment.yml
kubectl apply -f k8s/helm-ms2-ingress-service.yml

kubectl set image deployment/helm-demo-ms2-deployment helm-demo-ms2-container=shahankitturn/demo-ms2:$SHA