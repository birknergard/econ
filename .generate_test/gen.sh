#!/bin/bash
SERVER_URL=http://localhost:8080/swagger.json
GENERATE_DIR=./lib/
SOURCE_DIR=./lib/Sources/OpenAPIClient/*
TARGET_DIR=../ios/ios/Generated

echo 'Generating api services for iOS app'

rm -r ${GENERATE_DIR}/* # WARN: VOLATILE

openapi-generator-cli generate -i ${SERVER_URL} -g swift5 -o ${GENERATE_DIR} --skip-validate-spec
cp -r ${SOURCE_DIR} ${TARGET_DIR}
