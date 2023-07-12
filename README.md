# TDengineInsight

TDengineInsight is a visual tool that provides capabilities to design, query, and interact with your TDengine data.
> NOTE: TDengine 2.x version untested

# Preview

![screenshot preview](./.github/tdengineinsight_preview.gif)

# Get started

## Usage

```shell
docker run -d --name tdengineinsight -p 3210:3210 -v tdengineinsight:/opt/TDengineInsight/data slothsio/tdengineinsight:1.0.0-rc1
```
Open [http:://localhost:3210](http:://localhost:3210) in your browser

## Build from source

```shell
git clone --recursive https://github.com/slothsclub/TDengineInsight
cd web
npm install
VITE_OUT_DIR=../src/main/resources/static VITE_ROUTE_MODE=hash VITE_API_BASE_URL=/api npm run build

cd ..
./gradle build
docker build .
```

# Feedback

* File a [bug](https://github.com/slothsclub/TDengineInsight/issues)

