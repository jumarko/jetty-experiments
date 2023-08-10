#!/usr/bin/env -S bash -Eeuxo pipefail 

exec clojure -J-Xmx1g -J-Xms1g -M: -m main $@
