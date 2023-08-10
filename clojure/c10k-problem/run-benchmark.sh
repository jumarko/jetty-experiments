#!/usr/bin/env -S bash -Eeuxo pipefail


# ulimit -n 65535 # you may need this
echo ------------------------ concurrency = 1k  ------------------------------------
wrk --latency --timeout 1m -d 2s -c 1000 -t 1000 'http://localhost:3000/api'

echo ------------------------ concurrency = 10k  ------------------------------------
wrk --latency --timeout 1m -d 2s -c 10000 -t 1000 'http://localhost:3000/api'
