echo "Building..."
gradle clean build -Pspring.profiles.active=gcp -x test
echo "Building Docker image..."
docker build -t eu.gcr.io/esl-project-293913/esl-project:latest .
echo "Pushing Docker image..."
docker push eu.gcr.io/esl-project-293913/esl-project:latest
echo "Deploying Docker image..."
gcloud run deploy esl-project --platform managed --region europe-west4 --project esl-project-293913 --image eu.gcr.io/esl-project-293913/esl-project:latest
echo "Migrate traffic..."
gcloud run services --platform managed --region europe-west4 update-traffic esl-project --to-latest