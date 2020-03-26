## Username for the SONAR server.
SONAR_USERNAME?=admin

## Password for the SONAR server.
SONAR_PASSWORD?=admin

## Port for the SONAR server (if running on LocalHost)
SONAR_PORT?=9000

## URL for the SONAR server
SONAR_HOST?=http://localhost:$(SONAR_PORT)/

.PHONY: all
## Builds and tests everything.
# Sonar is run separately because it depends on the SonarQube server.
all:
	./mvnw verify

.PHONY: mutation
## Runs the mutation tests.
mutation:
	./mvn org.pitest:pitest-maven:mutationCoverage

.PHONY: sonar
## Performs static code analysis with SonarQube.
sonar:
	./mvnw verify sonar:sonar -Dsonar.host.uri="$(SONAR_HOST)" -Dsonar.login="$(SONAR_USERNAME)" -Dsonar.password="$(SONAR_PASSWORD)"

.PHONY: updates
## Displays which dependencies can be updated to newer versions.
updates:
	./mvnw versions:display-dependency-updates | grep -- '->' | sort -u

.PHONY: sonard
## Runs a Sonar server locally.
sonard:
	docker start sonarqube || docker run -d --name sonarqube -p $(SONAR_PORT):9000 sonarqube

.PHONY: clean
## Removes all auto-generated files.
clean:
	./mvnw clean

-include ~/.makehelp/include/makehelp/Help.mk

ifeq "help" "$(filter help,$(MAKECMDGOALS))"
~/.makehelp/include/makehelp/Help.mk:
	git clone --depth=1 https://github.com/christianhujer/makehelp.git ~/.makehelp
endif

-include ~/.User.mk
-include .User.mk
